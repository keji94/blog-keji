package com.keji.blog.codeLibrary.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\file.txt");
        //创建一个字节输入流对象,必须明确数据源，其实就是创建字节读取流和数据源相关联。
        FileInputStream fis = new FileInputStream(file);
        //读取数据。使用 read();一次读一个字节。
        int ch = 0;
        while((ch=fis.read())!=-1) {
            System.out.println("ch=" + (char) ch);

            // 关闭资源。
            fis.close();
        }
    }

    /**
       * 演示第二个读取方法， read(byte[]);
       */
    public void demo2() throws Exception{
        File file = new File("c:\\file.txt");
        // 创建一个字节输入流对象,必须明确数据源，其实就是创建字节读取流和数据源相关联。
        FileInputStream fis = new FileInputStream(file);
        //创建一个字节数组。
        byte[] buf = new byte[1024];//长度可以定义成1024的整数倍。
        int len = 0;
        while((len=fis.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        fis.close();

    }

}
