package com.keji.blog.codeLibrary.io;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //给文件中写中文
        writeCNText();
        //读取文件中的中文
        readCNText();
    }
    //读取中文
    public static void readCNText() throws IOException {
        FileReader fr = new FileReader("D:\\test\\cn.txt");
        int ch = 0;
        while((ch = fr.read())!=-1){
            //输出的字符对应的编码值
            System.out.println(ch);
            //输出字符本身
            System.out.println((char)ch);
        }
    }
    //写中文
    public static void writeCNText() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\test\\cn.txt");
        fos.write("a传智播客欢迎你".getBytes());
        fos.close();
    }

}
