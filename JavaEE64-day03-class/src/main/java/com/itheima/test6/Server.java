package com.itheima.test6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    // 保存所有连接到服务器的客户端Socket
    private List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(10085);
        System.out.println("服务器启动成功：" + serverSocket.getLocalSocketAddress());

        while (true) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("收到新连接：" + socket.getInetAddress());

            // 保存客户端Socket
            clientSockets.add(socket);

            // 启动一个新的线程来处理该客户端的请求
            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;

                    // 循环读取客户端发送的消息
                    while ((len = inputStream.read(bytes)) != -1) {
                        String receivedMessage = new String(bytes, 0, len);
                        System.out.println("收到消息：" + receivedMessage);

                        // 转发消息给其他客户端
                        for (Socket clientSocket : clientSockets) {
                            if (clientSocket != socket) {
                                OutputStream outputStream = clientSocket.getOutputStream();
                                String sendMessage = "收到" + socket.getInetAddress() + "的消息：" + receivedMessage;
                                outputStream.write(sendMessage.getBytes());
                                outputStream.flush();
                            }
                        }
                    }

                    // 关闭套接字
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // 从列表中删除该客户端Socket
                    clientSockets.remove(socket);
                }
            }).start();
        }
    }
}
