package com.keji.blog.controller.IO;

import java.io.*;

/**
 * Created by wb-ny291824 on 2017/8/16.
 * ObjectOutputStream:序列化流
 * ObjectInputStreamDemos：反序列化流
 */
public class ObjectOutputStreamAndObjectInputStreamDemos {

    public static void main(String[] args) {

    }

    /**
     * 序列化
     * @throws Exception
     */
    public void demo1() throws Exception{
        //1,明确存储对象的文件。
        FileOutputStream fos = new FileOutputStream("tempfile\\obj.object");
        //2，给操作文件对象加入写入对象功能。
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //3，调用了写入对象的方法。
        oos.writeObject(new Person("wangcai",20));
        //关闭资源。
        oos.close();
    }

    /**
     * 反序列化
     * @throws Exception
     */
    public void demo2() throws Exception{
        //1,定义流对象关联存储了对象文件。
        FileInputStream fis = new FileInputStream("tempfile\\obj.object");

        //2,建立用于读取对象的功能对象。
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person obj = (Person)ois.readObject();

        System.out.println(obj.toString());

    }
}



class Person implements Serializable {
    private String name;
    private int age;
    public Person() {
        super();
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

