package com.sk.thread;

public class Example4 {


    public static void main(String[] args) {


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I m going for walk");
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I m going to swim");
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("I m going home");
    }
}
