package com.soap.ssh.reflection;

import java.lang.reflect.Method;

public class TestReflection {

    public static void main(String[] args) throws Exception {
        Class clazz=null;
//        clazz=Person.class;
//        System.out.println("通过类名："+clazz);
//        Object obj= new Person();
//        clazz=obj.getClass();
//        System.out.println("通过getClass():："+clazz);
        clazz=Class.forName("com.soap.ssh.reflection.Person");
//        System.out.println("通过全类名获取："+clazz);
//        Object o = clazz.newInstance();
//        System.out.println(o);
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        System.out.println("系统类加载器："+systemClassLoader);
//        ClassLoader parent = systemClassLoader.getParent();
//        System.out.println("扩展类加载器："+parent);
//        ClassLoader parent1 = parent.getParent();
//        System.out.println("启动类加载器："+parent1);
//        ClassLoader classLoader = clazz.getClassLoader();
//        System.out.println("person的加载器："+classLoader);
        //1、得到clazz 对应的类中有哪些方法,不能获取private方法
        Method[] methods = clazz.getMethods();
        System.out.print("        getMethods: ");
        for (Method method : methods){
            System.out.print(method.getName() + ", ");
        }
        //2、获取所有的方法(且只获取当着类声明的方法，包括private方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("\\ngetDeclaredMethods: ");
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod.getName() + ", ");
        }
        //3、获取指定的方法
        Method method = clazz.getDeclaredMethod("setName",String.class);//第一个参数是方法名，后面的是方法里的参数
        System.out.println("\nmethod : " + method);

        Method method2 = clazz.getDeclaredMethod("setName",String.class ,int.class);//第一个参数是方法名，后面的是方法里的参数
        System.out.println("method2: " + method2);

        //4、执行方法！
        Object obj = clazz.newInstance();
        method2.invoke(obj, "changwen", 22);
    }
}
