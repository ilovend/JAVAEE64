package com.itheima.test2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author ilovend
 * @date 2023/03/20
 */
public class Client {
    /**
     * 主要
     *
     * @param args arg游戏
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        byte[] contentArr = new byte[1024]; // 准备一个字节数组来存储用户输入的内容

        InetAddress broadcastAddress = InetAddress.getByName("192.168.22.255");
        DatagramPacket datagramPacket = new DatagramPacket(contentArr, contentArr.length, broadcastAddress, 9527);

        while (true) {
            System.out.print("请输入要发送的消息：");
            String input = scanner.nextLine();
            contentArr = input.getBytes(); // 将用户输入的字符串转换为字节数组

            datagramPacket.setData(contentArr);
            datagramSocket.send(datagramPacket);
        }


    }
}
