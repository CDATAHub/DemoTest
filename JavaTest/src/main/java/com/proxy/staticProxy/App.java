package com.proxy.staticProxy;

import com.proxy.UserDao;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
