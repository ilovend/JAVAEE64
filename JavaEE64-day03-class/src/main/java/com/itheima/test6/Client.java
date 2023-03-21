package com.itheima.test6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.22.40", 10086);
        System.out.println("连接服务器成功：" + socket.getRemoteSocketAddress());

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要发送的信息：");
            String message = scanner.nextLine(); // 获取用户输入的信息
            outputStream.write(message.getBytes()); // 发送信息到套接字
            outputStream.flush(); // 刷新输出流

            // 接收服务器的回复
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            String receivedMessage = new String(bytes, 0, len);
            System.out.println(receivedMessage);
        }
    }
}
