package com.reflect;


import com.reflect.book.Book;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 3种获取Class对象的方法：
 * 1:Object.getClass()
 * 2:Class.forName()
 * 3:Object.class
 *
 * 通过Class对象获取Field、Method和Constructor
 * 可修改Field的值，可调用Method方法，注意accessible的值
 */
public class ReflectTest {

    public ReflectTest() {
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Book book = new Book();
        System.out.println(book.getClass().getName());

        String classString = "com.txb.book.Book";
        Class cl = Class.forName(classString);
        System.out.println(cl.getName());

        Class cl2 = Book.class;
        System.out.println(cl2.getName());
        System.out.println(int.class.getName());
        System.out.println(void.class.getName());
        System.out.println(Double[].class.getName());
        if (cl == cl2) {
            System.out.println(true);
        }
        Book cl3 = (Book) cl.newInstance();
        if (cl == cl3.getClass()) {
            System.out.println(true);
        }

        System.out.println(cl.getClassLoader());
        Field[] fields = cl.getFields();
        Field[] decaFields = cl.getDeclaredFields();
        Field field = null;
        try {
            field = cl.getDeclaredField("f3");
            field.setAccessible(true);
            System.out.println(field.get(book));
            field.set(book,true);
            System.out.println(field.get(book));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Method[] decaMethods = cl.getDeclaredMethods();
        Method method = cl.getDeclaredMethod("m1");
        try {
            method.setAccessible(true);
            Object result = method.invoke(book, null);
            System.out.println(result);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
