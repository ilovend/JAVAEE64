package com.itheima.test4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // 连接服务器
        Socket socket = new Socket("192.168.22.25", 8976);
        System.out.println("连接服务器成功：" + socket.getRemoteSocketAddress());

        // 获取输入输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 循环发送消息
        while (true) {
            System.out.print("请输入要发送的消息：");
            String message = scanner.nextLine();

            // 发送消息到套接字
            outputStream.write(message.getBytes());
            outputStream.flush();

            // 接收确认消息
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            String receivedMessage = new String(bytes, 0, len);
            System.out.println(receivedMessage);
        }
    }
}
