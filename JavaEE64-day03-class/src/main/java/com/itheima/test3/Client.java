package com.itheima.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8976);
        System.out.println("连接服务器成功：" + socket.getInetAddress());

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        byte[] bytes = new byte[1024];
        int len;
        while (true) {
            // 发送消息
            System.out.print("请输入要发送的消息：");
            String sendMessage = scanner.nextLine();
            outputStream.write(sendMessage.getBytes());
            outputStream.flush();

            // 接收消息
            len = inputStream.read(bytes);
            if (len == -1) {
                break;
            }
            String receivedMessage = new String(bytes, 0, len);
            System.out.println("收到消息：" + receivedMessage);
        }

        socket.close();
    }
}
