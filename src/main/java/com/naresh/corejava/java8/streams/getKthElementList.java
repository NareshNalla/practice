package com.naresh.corejava.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class getKthElementList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d","e","f");
        Optional<String> res = list.stream().skip(4).findFirst();
        System.out.println(res.get());
    }
}
