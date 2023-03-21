package com.itheima.test1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");

        String hostName = address.getHostName();
        System.out.println(hostName);
    }
}
