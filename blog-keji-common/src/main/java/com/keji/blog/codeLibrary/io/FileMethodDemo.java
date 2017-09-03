package com.keji.blog.codeLibrary.io;

import java.io.File;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class FileMethodDemo {
    public static void main(String[] args) {
        //创建文件对象
        File file = new File("Test22.java");
        //获取文件的绝对路径，即全路径
        String absPath = file.getAbsolutePath();
        //File中封装的路径是什么获取到的就是什么。
        String path = file.getPath();
        //获取文件名称
        String filename = file.getName();
        //获取文件大小
        long size = file.length();

        System.out.println("absPath="+absPath);
        System.out.println("path="+path);
        System.out.println("filename="+filename);
        System.out.println("size="+size);
    }

}
