package com.keji.blog.controller.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by wb-ny291824 on 2017/8/16.
 * 反射demos
 */
public class ReflectDemos {
    public static void main(String[] args) throws Exception{
        demo1();
    }

    /**
     * 获取.class字节码文件对象
     * @throws Exception
     */
    public static void demo1() throws Exception{
        // 1： 通过Object类中的getObject()方法
        // Person p1 = new Person();
        // Class c1 = p1.getClass();
        // System.out.println("c1 = "+ c1);

        // 2: 通过 类名.class 获取到字节码文件对象
        // Class c2 = Person.class;
        // System.out.println("c2 = "+ c2);

        // 3: 反射中的方法
        Class c3 = Class.forName("com.keji.blog.controller.reflect.Person");// 包名.类名
        System.out.println("c3 = " + c3);

    }

    /**
     * 通过反射获取构造方法对象Constructor
     * getConstructors() 获取公共的构造方法
     * getDeclaredConstructors() 获取公共和私有的构造方法
     * @throws Exception
     */
    public static void demo2() throws Exception{
        //获取Class对象
        Class c = Class.forName("com.keji.blog.controller.reflect.Person");//包名.类名

        //获取所有的构造方法
        //Constructor[] cons = c.getConstructors();
        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }

        System.out.println("------------------------");
        //获取一个构造方法
        //public Person()
        Constructor con1 = c.getConstructor(null);
        System.out.println(con1);

        //public Person(String name)
        Constructor con2 = c.getConstructor(String.class);
        System.out.println(con2);

        //private Person(String name, int age)
        Constructor con3 = c.getDeclaredConstructor(String.class, int.class);
        System.out.println(con3);

        //public Person(String name, int age, String address)
        Constructor con4 = c.getDeclaredConstructor(String.class, int.class, String.class);
        System.out.println(con4);
    }

    /**
     * 通过反射获取构造方法，创建对象
     * @throws Exception
     */
    public static void demo3() throws Exception{
        //1,获取到Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");//包名.类名
        //2,获取指定的构造方法
        //public Person()
        //Constructor con = c.getConstructor(null);

        //public Person(String name, int age, String address)
        Constructor con = c.getConstructor(String.class, int.class, String.class);

        //3,通过构造方法类中Constructor的方法，创建对象
        //Object obj = con.newInstance(null);
        Object obj = con.newInstance("小明", 22, "哈尔滨");
        //显示
        System.out.println(obj);

    }

    /**
     * 暴力反射获取私有构造方法创建对象
     * @throws Exception
     */
    public static void demo4() throws Exception{
        //1,获取到Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");//包名.类名

        //2,获取指定的构造方法
        //private Person(String name, int age)
        Constructor con = c.getDeclaredConstructor(String.class, int.class);

        //3,暴力反射
        con.setAccessible(true);//取消 Java 语言访问检查

        //4,通过构造方法类中的功能，创建对象
        Object obj = con.newInstance("小明", 23);
        System.out.println(obj);

    }

    /**
     * 反射获取成员变量
     * @throws Exception
     */
    public static void demo5() throws Exception{
        //获取Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");

        //获取成员变量
        //多个变量
        //Field[] fields = c.getFields();
        Field[] fields =  c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------------");
        //一个变量
        //public int age;
        Field ageField = c.getField("age");
        System.out.println(ageField);

        //private String address
        Field addressField = c.getDeclaredField("address");
        System.out.println(addressField);

    }

    /**
     * 通过反射，创建对象，获取指定的成员变量，进行赋值与获取值操作
     * @throws Exception
     */
    public static void demo6() throws Exception{
        //1,获取Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");
        //2，获取构造方法
        //public Person(String name)
        Constructor con = c.getConstructor(String.class);
        //3，通过构造方法，创建对象
        Object obj = con.newInstance("小明");
        //4，获取指定的成员变量
        //public String name;
        Field nameField = c.getField("name");
        //public int age;
        Field ageField = c.getField("age");
        //private String address;
        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true); //取消 Java 语言访问检查

        //5，通过方法，给指定对象的指定成员变量赋值或者获取值
        System.out.println("name = "+ nameField.get(obj));
        System.out.println("age = "+ ageField.get(obj));
        System.out.println("address = "+ addressField.get(obj));

        //赋值
        ageField.set(obj, 23);
        addressField.set(obj, "凯利广场");

        System.out.println("------------------------");
        System.out.println("name = "+ nameField.get(obj));
        System.out.println("age = "+ ageField.get(obj));
        System.out.println("address = "+ addressField.get(obj));

    }

    /**
     * 通过反射获取成员方法并使用
     * @throws Exception
     */
    public static void demo7() throws Exception{
        //获取Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");

        //获取多个方法
        //Method[] methods = c.getMethods();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("-----------------------");
        //获取一个方法：
        //public void method1()
        Method method = c.getMethod("method1", null);
        System.out.println(method);
        //public String method4(String name){
        method = c.getMethod("method4", String.class);
        System.out.println(method);
        //私有方法
        //private void method5()
        method = c.getDeclaredMethod("method5", null);
        System.out.println(method);

    }

    /**
     * 通过反射，创建对象，调用指定的方法
     * @throws Exception
     */
    public static void demo8() throws Exception{
        //1， 获取Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");
        //2,获取构造方法
        //public Person(String name, int age, String address){
        Constructor con = c.getConstructor(String.class, int.class, String.class);
        //3，通过构造方法，创建对象
        Object obj = con.newInstance("小明", 23, "哈尔滨");
        //4，获取指定的方法
        //public void method1()  没有返回值没有参数的方法
        //Method m1 = c.getMethod("method1", null);

        //public String method4(String name)
        Method m4 = c.getMethod("method4", String.class);

        //5，执行找到的方法
        //m1.invoke(obj, null);

        Object result = m4.invoke(obj, "itcast");
        System.out.println("result = " + result);

    }

    /**
     * 通过反射，创建对象，调用指定的private 方法
     * @throws Exception
     */
    public static void demo9() throws Exception{
        //1， 获取Class对象
        Class c = Class.forName("cn.itcast_01_Reflect.Person");
        //2,获取构造方法
        //public Person(String name, int age, String address){
        Constructor con = c.getConstructor(String.class, int.class, String.class);
        //3，通过构造方法，创建对象
        Object obj = con.newInstance("小明", 23, "哈尔滨");
        //4，获取指定的方法
        //private void method5(){
        Method m5 = c.getDeclaredMethod("method5", null);
        //5,开启暴力访问
        m5.setAccessible(true);
        //6，执行找到的方法
        m5.invoke(obj, null);

    }

    /**
     * 通过反射来避免泛型的限制。
     * 原理：编译后的class文件是没有泛型的--泛型擦除
     * @throws Exception
     */
    public static void demo10() throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>();
        //添加元素到集合
        list.add(new Integer(30));
        list.add(new Integer("12345"));
        list.add(123);
        //list.add("哈哈");//因为有泛型类型的约束
        System.out.println(list);

        //通过反射技术，实现添加任意类型的元素
        //1, 获取字节码文件对象
        //Class c = list.getClass();
        //Class c = ArrayList.class;
        Class c = Class.forName("java.util.ArrayList");

        //2, 找到add()方法
        // public boolean add(E e)
        Method addMethod = c.getMethod("add", Object.class);

        //3，  执行add()方法
        addMethod.invoke(list, "哈哈");// list.add("哈哈");
        System.out.println(list);

    }

    /**
     * 通过读取配置文件来反射方法。
     * @throws Exception
     */
    public static void demo11() throws Exception{
// 通过Properties集合从文件中读取数据
        Properties prop = new Properties();
        // 读取文件中的数据到集合中
        prop.load(new FileInputStream("properties.txt"));
        // 获取键所对应的值
        String className = prop.getProperty("className");
        System.out.println(className);

        // 1，获取Person.class 字节码文件对象
        Class c = Class.forName(className);
        // 2，获取构造方法
        // public Person(String name, int age, String address)
        Constructor con = c.getConstructor(String.class, int.class, String.class);

        // 3,创建对象
        Object obj = con.newInstance("小明", 20, "中国");
        System.out.println(obj);

        // 4，获取指定的方法
        // private void method5(){}
        String methodName = prop.getProperty("methodName");
        Method m5 = c.getDeclaredMethod(methodName, null);
        // 5,开启暴力访问
        m5.setAccessible(true);
        // 6，执行找到的方法
        m5.invoke(obj, null);

    }
}

class Person {
    //成员变量
    public String name;
    public int age;
    private String address;

    //构造方法
    public Person() {
        System.out.println("空参数构造方法");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("带有String的构造方法");
    }
    //私有的构造方法
    private Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("带有String，int的构造方法");
    }

    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("带有String, int, String的构造方法");
    }

    //成员方法
    //没有返回值没有参数的方法
    public void method1(){
        System.out.println("没有返回值没有参数的方法");
    }
    //没有返回值，有参数的方法
    public void method2(String name){
        System.out.println("没有返回值，有参数的方法 name= "+ name);
    }
    //有返回值，没有参数
    public int method3(){
        System.out.println("有返回值，没有参数的方法");
        return 123;
    }
    //有返回值，有参数的方法
    public String method4(String name){
        System.out.println("有返回值，有参数的方法");
        return "哈哈" + name;
    }
    //私有方法
    private void method5(){
        System.out.println("私有方法");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address+ "]";
    }
}

