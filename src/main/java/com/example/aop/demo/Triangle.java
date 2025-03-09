package com.example.aop.demo;

import java.util.Scanner;

/**
 * @author chang qi
 * @date 2025/3/8
 */
public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRow = scanner.nextInt();
        for (int row = 1; row <= totalRow; row++) {
            // 打印缩进
            System.out.print(" ".repeat(totalRow - row));
            // 打印数字
            System.out.println("* ".repeat(row));
        }
    }
}
