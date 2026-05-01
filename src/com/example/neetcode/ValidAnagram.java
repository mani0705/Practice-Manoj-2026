package com.example.neetcode;

/*
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
* */


public class ValidAnagram {
    public static void main(String[] args) {

        String s = "ggii";
        String t = "eekk";

        System.out.println("Is Anagram: " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        int[] alphabets = new int[26];
        if(s.length()!=t.length())
            return false;
        int i=0;
        while(i<t.length()){
            alphabets[s.charAt(i)-'a']++;
            alphabets[t.charAt(i)-'a']--;
            i++;
        }
        int counter = 0;
        for(int k=0;k< alphabets.length;k++){
            if(alphabets[k]!=0)
                counter++;
        }
        return counter <= 0;
    }

}
