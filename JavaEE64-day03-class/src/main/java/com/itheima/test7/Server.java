package com.itheima.test7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10056);
        System.out.println("服务器启动成功：" + serverSocket.getLocalSocketAddress());

        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("收到新连接：" + socket.getInetAddress());

            // 启动一个新的线程来处理该客户端的请求
            executorService.execute(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();

                    // 读取文件名
                    byte[] fileNameBytes = new byte[1024];
                    int fileNameLength = inputStream.read(fileNameBytes);
                    String fileName = new String(fileNameBytes, 0, fileNameLength).trim();
                    System.out.println(fileName.length() + " " + fileName);

                    // 读取文件内容并保存到本地
                    File file = new File("JavaEE64-day03-class/src/main/resources/download/" + fileName);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] fileContentBytes = new byte[1024];

                    int len;
                    while ((len = inputStream.read(fileContentBytes)) != -1) {
                        fileOutputStream.write(fileContentBytes, 0, len);
                    }
                    fileOutputStream.close();

                    // 关闭套接字
                    socket.close();
                    System.out.println("文件 " + fileName + " 接收完成");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}