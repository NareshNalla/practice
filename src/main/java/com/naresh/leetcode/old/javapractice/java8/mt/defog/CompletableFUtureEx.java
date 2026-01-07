package com.naresh.leetcode.old.javapractice.java8.mt.defog;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFUtureEx {
    public static void main(String[] args) {
	List<Integer> l = Arrays.asList(1, 2, 3);
	l.stream().map(num -> CompletableFuture.supplyAsync(() -> getSquare(num)).thenApplyAsync(n -> n * n))
		.map(CompletableFuture -> CompletableFuture.thenApply(n -> n * n)).map(t -> t.join())
		.forEach(System.out::println);

	/*
	 * l.stream().map(num->CompletableFuture.supplyAsync(()->getSquare(num))
	 * .exceptionally(throwable -> "canceled message"));
	 */

    }

    private static int getSquare(Integer num) {
	return num * num;
    }

}
