package com.example.aop.demo;

/**
 * @author chang qi
 * @date 2025/1/1
 */
public class StringConcat {
    public static void main(String[] args) {
        String str = "abc";
        for (int i = 0; i < 10; i++) {
            str += i;
        }
        System.out.println(str);
    }
}
