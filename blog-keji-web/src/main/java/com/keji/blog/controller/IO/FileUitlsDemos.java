package com.keji.blog.controller.IO;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Created by wb-ny291824 on 2017/8/16.
 * commons-io包中FileUitls工具类demo
 */
public class FileUitlsDemos {
    public static void main(String[] args) {

    }

    /**
     * 文件,文件夹的复制
     * @throws Exception
     */
    public void demo1() throws Exception{
        //通过Commons-IO完成了文件复制的功能
        FileUtils.copyFile(new File("D:\\test.avi"), new File("D:\\copy.avi"));

        //使用原来的方法
        //method1("D:\\test.avi", "D:\\copy.avi");

        //通过Commons-IO完成了文件夹复制的功能
        //D:\基础班 复制到 C:\\abc文件夹下
        FileUtils.copyDirectoryToDirectory(new File("D:\\基础班"), new File("C:\\abc"));

    }


    public void demo2() throws Exception{}


    //文件的复制
    private static void method1(String src, String dest) throws IOException {
        //1,指定数据源
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        //2,指定目的地
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        //3，读
        byte[] buffer = new byte[1024];
        int len = -1;
        while ( (len = in.read(buffer)) != -1) {
            //4,写
            out.write(buffer, 0, len);
        }
        //5，关闭流
        in.close();
        out.close();
    }

}
