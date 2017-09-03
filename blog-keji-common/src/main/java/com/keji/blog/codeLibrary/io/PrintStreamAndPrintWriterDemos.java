package com.keji.blog.codeLibrary.io;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by wb-ny291824 on 2017/8/16.
 * PrintStream：字节打印流
 * PrintWriter：字符打印流
 */
public class PrintStreamAndPrintWriterDemos {
    public static void main(String[] args) {

    }

    /**
     * 把指定的数据，写入到printFile.txt文件中
     * @throws Exception
     */
    public void demo1() throws Exception{

        //创建流
        //PrintWriter out = new PrintWriter(new FileWriter("printFile.txt"));
        PrintWriter out = new PrintWriter("printFile.txt");
        //2，写数据
        for (int i=0; i<5; i++) {
            out.println("helloWorld");
        }
        //3,关闭流
        out.close();

    }

    /**
     * 把指定的数据，写入到printFile.txt文件中,自动刷新
     * @throws Exception
     */
    public void demo2() throws Exception{
        //创建流
        PrintWriter out = new PrintWriter(new FileWriter("printFile.txt"), true);
        //2，写数据
        for (int i=0; i<5; i++) {
            out.println("helloWorld");
        }
        //3,关闭流
        out.close();
    }
}
