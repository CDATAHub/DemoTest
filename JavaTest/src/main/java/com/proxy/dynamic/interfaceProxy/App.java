package com.proxy.dynamic.interfaceProxy;

import com.proxy.IUserDao;
import com.proxy.UserDao;

public class App {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
