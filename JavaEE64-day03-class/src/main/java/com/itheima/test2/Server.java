package com.itheima.test2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(9527);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        while (true) {
            datagramSocket.receive(datagramPacket);
            bytes = datagramPacket.getData();
            int length = datagramPacket.getLength();
            System.out.println(new String(bytes, 0, length));
        }

    }
}
