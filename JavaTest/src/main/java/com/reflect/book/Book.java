package com.reflect.book;

public class Book {
    private String f1;

    public int f2;

    protected boolean f3;

    private void m1() {
        System.out.println("m1 invoke");
    }

    public int m2() {
        return 1;
    }

    protected boolean m3() {
        return false;
    }
}
