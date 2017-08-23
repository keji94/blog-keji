package com.keji.blog.controller.IO;

import java.io.File;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class FileMethodDemo3 {
    public static void main(String[] args) {
        File dir = new File("e:\\java_code");
        //获取的是目录下的当前的文件以及文件夹的名称。
        String[] names = dir.list();
        for(String name : names){
            System.out.println(name);
        }
        //获取目录下当前文件以及文件对象，只要拿到了文件对象，那么就可以获取其中想要的信息
        File[] files = dir.listFiles();
        for(File file : files){
            System.out.println(file);
        }
    }

}
