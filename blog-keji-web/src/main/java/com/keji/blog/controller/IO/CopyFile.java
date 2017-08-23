package com.keji.blog.controller.IO;

import java.io.*;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        //1,明确源和目的。
        File srcFile = new File("c:\\YesDir\test.JPG");
        File destFile = new File("copyTest.JPG");

        //2,明确字节流 输入流和源相关联，输出流和目的关联。
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        //3, 使用输入流的读取方法读取字节，并将字节写入到目的中。
        int ch = 0;
        while((ch=fis.read())!=-1){
            fos.write(ch);
        }
        //4,关闭资源。
        fos.close();
        fis.close();
    }

    public void copyFileByBuffer() throws Exception{
        File srcFile = new File("c:\\YesDir\test.JPG");
        File destFile = new File("copyTest.JPG");
        // 明确字节流 输入流和源相关联，输出流和目的关联。
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        //定义一个缓冲区。
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf, 0, len);// 将数组中的指定长度的数据写入到输出流中。
        }
        // 关闭资源。
        fos.close();
        fis.close();

    }

    public void copyFileByBuffered() throws Exception{
        //1，指定数据源， 是数据源中读数据，采用输入流
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));
        //2,指定目的地，是把数据写入目的地，采用输出流
        BufferedWriter out = new BufferedWriter(new FileWriter("copyFile.txt"));
        //3,读数据
        String line = null;
        while ( (line = in.readLine()) != null ) {
            //4，写数据
            out.write(line);
            //写入换行符号
            out.newLine();
        }
        //5，关闭流
        out.close();
        in.close();
    }

}
