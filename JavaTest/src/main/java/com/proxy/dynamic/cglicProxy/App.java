package com.proxy.dynamic.cglicProxy;

public class App {
    public static void main(String[] args) {
        User2Dao target = new User2Dao();
        User2Dao proxy = (User2Dao) new ProxyFactory(target).getProxyInstance();
        proxy.save();
    }
}
