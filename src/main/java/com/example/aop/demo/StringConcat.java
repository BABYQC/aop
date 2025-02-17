package com.example.aop.demo;

import java.util.*;

/**
 * @author chang qi
 * @date 2025/1/1
 */
public class StringConcat {
    public static void main(String[] args) {
        Set<String>[] sets = new Set[100];
        Arrays.fill(sets, new HashSet<>());
        sets[0].add("aaa");
        String str = "abc" + "def";
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.();
        Deque<Integer> stack = new LinkedList<>();
        stack.peek();
        System.out.println(sets);
    }
}
