package com.itheima.test8;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10056);
        System.out.println("连接服务器成功：" + socket.getRemoteSocketAddress());

        // 创建一个文件上传任务线程
        Thread thread = new Thread(() -> {
            try {
                // 获取文件夹中所有文件
                File folder = new File("JavaEE64-day03-class/src/main/resources/upload");
                File[] files = folder.listFiles();

                // 循环读取并上传所有文件
                for (File file : files) {
                    System.out.println("正在上传文件：" + file.getName());

                    // 创建文件输入流并读取文件
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] buffer = new byte[8192];
                    int len;

                    // 创建输出流并发送文件名和文件内容
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    dataOutputStream.writeUTF(file.getName());
                    while ((len = fileInputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                    outputStream.flush();
                    fileInputStream.close();

                    // 等待服务端确认上传完毕
                    InputStream inputStream = socket.getInputStream();
                    byte[] receiveBuffer = new byte[1024];
                    len = inputStream.read(receiveBuffer);
                    String receivedMessage = new String(receiveBuffer, 0, len);
                    System.out.println(receivedMessage);
                }

                // 告诉服务端文件已经全部上传完毕
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("上传完成");
                outputStream.flush();

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
