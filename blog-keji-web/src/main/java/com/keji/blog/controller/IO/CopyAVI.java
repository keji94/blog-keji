package com.keji.blog.controller.IO;

import java.io.*;

/**
 * Created by wb-ny291824 on 2017/8/16.
 */
public class CopyAVI {
    public static void main(String[] args) throws IOException {
        //开始计时
        long start = System.currentTimeMillis();
        //方式1： 采用基本的流，一次一个字节的方式复制
        //method1("d:\\test.avi", "d:\\copy1.avi");
        //方式2： 采用基本的流，一个多个字节的方式赋值
        //method2("d:\\test.avi", "d:\\copy2.avi");
        //方式3： 采用高效的流，一次一个字节的方式复制
        //method3("d:\\test.avi", "d:\\copy3.avi");
        //方式4： 采用高效的流，一个多个字节的方式赋值
        method4("d:\\test.avi", "d:\\copy4.avi");

        //结束计时
        long end = System.currentTimeMillis();
        //打印耗时多少毫秒
        System.out.println("共耗时 " +(end - start)+ "毫秒");
    }

    //方式4： 采用高效的流，一个多个字节的方式赋值
    private static void method4(String src, String dest) throws IOException {
        //1，指定数据源
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        //2，指定目的地
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        //3，读数据
        byte[] buffer = new byte[1024];
        int len = -1;
        while ( (len = in.read(buffer)) != -1) {
            //4,写数据
            out.write(buffer, 0, len);
        }
        //5，关闭流
        in.close();
        out.close();
    }

    //方式3： 采用高效的流，一次一个字节的方式复制
    private static void method3(String src, String dest) throws IOException {
        //1，指定数据源
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        //2，指定目的地
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        //3，读数据
        int ch = -1;
        while ((ch=in.read()) != -1) {
            //4，写数据
            out.write(ch);
        }
        //5，关闭流
        in.close();
        out.close();
    }

    //方式2： 采用基本的流，一个多个字节的方式赋值
    private static void method2(String src, String dest) throws IOException {
        //1，指定数据源
        FileInputStream in = new FileInputStream(src);
        //2，指定目的地
        FileOutputStream out = new FileOutputStream(dest);
        //3，读数据
        byte[] buffer = new byte[1024];
        int len = -1;
        while ( (len=in.read(buffer)) != -1) {
            //4，写数据
            out.write(buffer, 0, len);
        }
        //5，关闭流
        in.close();
        out.close();
    }

    //方式1： 采用基本的流，一次一个字节的方式复制
    private static void method1(String src, String dest) throws IOException {
        //1，指定数据源
        FileInputStream in = new FileInputStream(src);
        //2，指定目的地
        FileOutputStream out = new FileOutputStream(dest);
        //3，读数据
        int ch = -1;
        while (( ch=in.read()) != -1) {
            //4，写数据
            out.write(ch);
        }
        //5，关闭流
        in.close();
        out.close();
    }

}
