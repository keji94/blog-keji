package com.keji.blog.controller.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wb-ny291824 on 2017/8/16.
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建流
        //基本字符输出流
        FileWriter fileOut = new FileWriter("file.txt");
        //把基本的流进行包装
        BufferedWriter out = new BufferedWriter(fileOut);
        //2，写数据
        for (int i=0; i<5; i++) {
            out.write("hello");
            out.newLine();
        }
        //3,关闭流
        out.close();
    }

}
