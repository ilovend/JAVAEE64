package com.itheima.test4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8976);
        System.out.println("服务器启动成功：" + serverSocket.getLocalSocketAddress());

        while (true) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("收到新连接：" + socket.getInetAddress());

            // 启动一个新的线程来处理该客户端的请求
            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;

                    // 获取客户端的IP地址
                    String clientIP = socket.getInetAddress().getHostAddress();

                    // 循环读取客户端发送的消息，并回复确认消息
                    while ((len = inputStream.read(bytes)) != -1) {
                        String receivedMessage = new String(bytes, 0, len);
                        System.out.println("收到" + clientIP + "的消息：" + receivedMessage);

                        String sendMessage = "确认收到消息：" + receivedMessage;
                        outputStream.write(sendMessage.getBytes());
                        outputStream.flush();
                    }

                    // 关闭套接字
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
