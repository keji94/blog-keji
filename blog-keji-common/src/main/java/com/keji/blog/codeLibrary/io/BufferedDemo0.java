package com.keji.blog.codeLibrary.io;

import java.io.*;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class BufferedDemo0 {
    public static void main(String[] args) throws IOException {
        //写数据到文件的方法
        write();
    }

    /*
     * 写数据到文件的方法
     * 1,创建流
     * 2，写数据
     * 3，关闭流
     */
    private static void write() throws IOException {
        //创建基本的字节输出流
        FileOutputStream fileOut = new FileOutputStream("abc.txt");
        //使用高效的流，把基本的流进行封装，实现速度的提升
        BufferedOutputStream out = new BufferedOutputStream(fileOut);
        //2，写数据
        out.write("hello".getBytes());
        //3，关闭流
        out.close();
    }

    /*
	 * 从文件中读取数据
	 * 1,创建缓冲流对象
	 * 2，读数据，打印
	 * 3，关闭
	 */
    private static void read() throws IOException {
        //1,创建缓冲流对象
        FileInputStream fileIn = new FileInputStream("abc.txt");
        //把基本的流包装成高效的流
        BufferedInputStream in = new BufferedInputStream(fileIn);
        //2，读数据
        int ch = -1;
        while ((ch = in.read()) != -1) {
            //打印
            System.out.print((char) ch);
        }
        //3，关闭
        in.close();
    }

    }
