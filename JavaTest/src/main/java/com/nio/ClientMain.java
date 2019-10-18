package com.nio;

import java.util.concurrent.FutureTask;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        final MyClient myclient = new MyClient();
        FutureTask<Integer> Task2 = new FutureTask<>(() -> {
            myclient.start();
            return 0;
        });// 用FutureTask包裹
        Thread Thread2 = new Thread(Task2);// 用Thread包裹
        Thread2.start();

        Thread.sleep(10000);
        myclient.sendMsg("time");

    }
}
