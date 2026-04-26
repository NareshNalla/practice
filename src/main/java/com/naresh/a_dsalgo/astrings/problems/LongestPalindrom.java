package com.naresh.a_dsalgo.astrings.problems;

public class LongestPalindrom {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest Palindrome: " + longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
       int resLen = 0, resIdx = 0;
       for(int i= 0; i < s.length(); i++){
           //odd length
           int l=i , r =i;
           while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
               if(r-l +1 > resLen){
                   resIdx = l;
                   resLen = r- l +1;
               }
               l --; r ++;
           }
           //even length
           l = i;
           r = i+1;
           while( l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
               if(r - l +1 > resLen){
                resIdx = l;
                resLen = r - l +1;
               }
               l--; r++;
           }
       }
        return s.substring(resIdx, resIdx +resLen);
    }



}
