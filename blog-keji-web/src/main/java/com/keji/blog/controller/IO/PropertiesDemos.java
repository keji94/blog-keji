package com.keji.blog.controller.IO;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

/**
 * Created by wb-ny291824 on 2017/8/16.
 * Properties集合，它是唯一一个能与IO流交互的集合
 */
public class PropertiesDemos {
    public static void main(String[] args) {

    }

    /**
     * 向Properties集合中添加元素，并遍历
     */
    public void demo1() {
        //创建集合对象
        Properties prop = new Properties();
        //添加元素到集合
        //prop.put(key, value);
        prop.setProperty("周迅", "张学友");
        prop.setProperty("李小璐", "贾乃亮");
        prop.setProperty("杨幂", "刘恺威");

        //System.out.println(prop);//测试的使用
        //遍历集合
        Set<String> keys = prop.stringPropertyNames();
        for (String key : keys) {
            //通过键 找值
            //prop.get(key)
            String value = prop.getProperty(key);
            System.out.println(key+"==" +value);
        }
    }

    /**
     * 将Properties集合中内容存储到文件
     */
    public void demo2() throws Exception{
        //1，创建Properties集合
        Properties prop = new Properties();
        //2，添加元素到集合
        prop.setProperty("周迅", "张学友");
        prop.setProperty("李小璐", "贾乃亮");
        prop.setProperty("杨幂", "刘恺威");

        //3，创建流
        FileWriter out = new FileWriter("prop.properties");
        //4，把集合中的数据存储到流所对应的文件中
        prop.store(out, "save data");
        //5，关闭流
        out.close();

    }

    /**
     * 读取文件中的数据，并保存到集合
     */
    public void demo3() throws Exception{
        //1，创建集合
        Properties prop = new Properties();
        //2，创建流对象
        FileInputStream in = new FileInputStream("prop.properties");
        //FileReader in = new FileReader("prop.properties");
        //3,把流所对应文件中的数据 读取到集合中
        prop.load(in);
        //4,关闭流
        in.close();
        //5,显示集合中的数据
        System.out.println(prop);
    }

}

