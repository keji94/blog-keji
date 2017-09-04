package com.keji.blog.codeLibrary.Socket;

import java.net.InetAddress;

/**
 * Created by wb-ny291824 on 2017/8/17.
 * InetAddress类用于封装一个IP地址，并提供了一系列与IP地址相关的方法
 */
public class InetAddressDemo {

    public static void main(String[] args) throws Exception{
        InetAddress local = InetAddress.getLocalHost();
        InetAddress remote = InetAddress.getByName("www.baidu.com");
        System.out.println("Ip地址" + local.getHostAddress());
        System.out.println("百度的Ip地址" + remote.getHostAddress());
        System.out.println("百度的主机名" + remote.getHostAddress());

    }
}
