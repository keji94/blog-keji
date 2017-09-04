package com.keji.blog.codeLibrary.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //演示FileWriter 用于操作文件的便捷类。
        FileWriter fw = new FileWriter("d：\\text\\fw.txt");
        fw.write("你好谢谢再见");//这些文字都要先编码。都写入到了流的缓冲区中。
        fw.flush();
        fw.close();
    }

}
