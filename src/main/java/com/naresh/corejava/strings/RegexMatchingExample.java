package com.naresh.corejava.strings;

public class RegexMatchingExample
{
    public static void main(String[] args)
    {
        String regex = ".@.";
        RegexMatchingExample.compare("Hacker@Earth.com", regex);
        RegexMatchingExample.compare("a@N", regex);
        RegexMatchingExample.compare("Java@Program", regex);
    }
    public static void compare(String str, String regex)
    {
        if (str.matches(regex))
        {
            System.out.println(str + " matches");
        }
        else
        {
            System.out.println(str + " does not match");
        }
    }
}