package com.example.aop.demo;

/**
 * @author chang qi
 * @date 2025/1/1
 */
public class StringConcat {
    public static void main(String[] args) {
        String str = "abc" + "def";
        StringBuilder sb = new StringBuilder();
        System.out.println(str);
    }
}
