package com.itheima.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8976);
        System.out.println("服务器已启动，等待客户端连接...");
        Socket accept = serverSocket.accept();
        System.out.println("客户端已连接：" + accept.getInetAddress());

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        byte[] bytes = new byte[1024];
        int len;
        while (true) {
            // 接收消息
            len = inputStream.read(bytes);
            if (len == -1) {
                break;
            }
            String receivedMessage = new String(bytes, 0, len);
            System.out.println("收到消息：" + receivedMessage);

            // 发送消息
            System.out.print("请输入要发送的消息：");
            String sendMessage = scanner.nextLine();
            outputStream.write(sendMessage.getBytes());
            outputStream.flush();
        }

        accept.close();
        serverSocket.close();
    }
}
