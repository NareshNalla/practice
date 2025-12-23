package com.naresh.old.javapractice.exam1;

import java.util.Arrays;
import java.util.List;

public class ArrayListVar {
public static void main(String[] args) {
    
    //var lst =  Arrays.asList(1, 2, 3, 4);
    List<Integer> lst =  Arrays.asList(1, 2, 3, 4);
   lst.replaceAll(x -> x + 100);
    System.out.println("-Completed-");

}
}
