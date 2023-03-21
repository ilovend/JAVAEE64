package com.itheima.test9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10056);
        System.out.println("服务器启动成功：" + serverSocket.getLocalSocketAddress());

        // 等待客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("收到新连接：" + socket.getRemoteSocketAddress());

        // 创建文件上传任务线程
        Thread thread = new Thread(() -> {
            try {
                // 循环接收并保存所有文件
                while (true) {
                    InputStream inputStream = socket.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(inputStream);

                    // 读取文件名
                    String fileName = dataInputStream.readUTF();
                    System.out.println("接收文件：" + fileName);

                    // 创建文件输出流并写入文件内容
                    FileOutputStream fileOutputStream = new FileOutputStream("JavaEE64-day03-class/src/main/resources/download/" + fileName);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);

                        // 判断是否到达结束标记
                        if ("finish".equals(new String(buffer, 0, len))) {
                            System.out.println("接收文件完成：" + fileName);
                            break;
                        }
                    }

                    fileOutputStream.flush();
                    fileOutputStream.close();

                    // 发送确认消息
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("文件上传成功".getBytes());
                    outputStream.flush();

                    // 判断是否到达结束标记
                    if ("finish".equals(new String(buffer, 0, len))) {
                        break;
                    }
                }

                // 关闭套接字
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 启动文件上传任务线程
        thread.start();
    }
}
