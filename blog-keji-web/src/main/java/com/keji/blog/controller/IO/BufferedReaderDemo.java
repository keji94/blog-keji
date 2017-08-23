package com.keji.blog.controller.IO;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wb-ny291824 on 2017/8/16.
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //1,创建流
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));
        //2，读数据
        //一次一个字符
        //一次一个字符数组
        //一次读取文本中一行的字符串内容
        String line = null;
        while( (line = in.readLine()) != null ){
            System.out.println(line);
        }

        //3,关闭流
        in.close();
    }

}
