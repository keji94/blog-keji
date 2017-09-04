package com.keji.blog.codeLibrary.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class FilenameFilterDemo {
    public static void main(String[] args) {
        //获取扩展名为.java所有文件
        //创建File对象
        File file = new File("E:\\code\\day11_code");
        //获取指定扩展名的文件,由于要对所有文件进行扩展名筛选，因此调用方法需要传递过滤器
        File[] files = file.listFiles(new MyFileFilter());
        //遍历获取到的所有符合条件的文件
        for (File f : files) {
            System.out.println(f);
        }
    }
}
//定义类实现文件名称FilenameFilter过滤器
class MyFileFilter implements FilenameFilter {

    /**
     *
     * @param dir  当前文件或文件夹所在的路径
     * @param name 当前文件或文件夹对象的名称
     * @return
     */
    public boolean accept(File dir, String name) {
        return name.endsWith(".java");
    }
}

