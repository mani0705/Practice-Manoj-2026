package com.example.neetcode;

import java.util.*;


/*
* Given an array of strings strs, group the anagrams together. You can return the answer in any
* order.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
* */
public class GroupAnagrams {

    public static void main(String[] args) {

        //String[] strs = {"eeeaat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"a"};
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> myMap = new HashMap<>();
        for(String str:strs){
            int[] temp = new int[26];
            for(char c:str.toCharArray()){
                temp[c-'a']++;
            }
            String keyString = new String();
            for(int i=0;i< temp.length;i++){
                keyString = keyString +"%"+ temp[i];
            }
            if(myMap.containsKey(keyString)){
                myMap.get(keyString).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                myMap.put(keyString, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list : myMap.values()){
            result.add(list);
        }
        return result;
    }
}