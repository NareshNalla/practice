package com.naresh.old.javapractice.javaapi.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortUsingJava8 {

    public static void main(String[] args) {
	List<String> l = Arrays.asList("abc", "naresh", "cba", "mounika", "ganga");

	l.stream().sorted().forEach(System.out::println);

	List<String> sorted = l.stream().sorted().collect(Collectors.toList());

	l.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	stringSort("naresh");
	System.out.println(reverseWordsInString("naresh"));
	System.out.println(reverseWordCharacters("naresh"));
	System.out.println(anotherWay("mounika"));

    }

    public static void stringSort(String st) {
	char[] ch = st.toCharArray();
	Arrays.sort(ch);
	System.out.println(new String(ch));
    }

    // not working
    public static String reverseWordsInString(String str) {
	return String.join(" ", Pattern.compile(" +").splitAsStream(str).collect(LinkedList::new, LinkedList::addLast,
		(a, b) -> a.addAll(0, b)));
    }

    public static String reverseWordCharacters(String str) {
	return Pattern.compile(" +").splitAsStream(str).map(word -> new StringBuilder(word).reverse())
		.collect(Collectors.joining(" "));
    }

    public static String anotherWay(String str) {

	return Stream.of(str.split("")).reduce("", (reversed, character) -> character + reversed);
    }
}
