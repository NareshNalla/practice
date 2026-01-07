package com.naresh.leetcode.old.javapractice.java8.mt;

public class ThreadException implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Run err...");
    }

    public static void main(String[] args) {
        new Thread(new ThreadException()).start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}