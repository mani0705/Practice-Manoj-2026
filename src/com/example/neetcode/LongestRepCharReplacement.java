package com.example.neetcode;

/*You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

*/

import java.util.Arrays;

public class LongestRepCharReplacement {

    public static void main(String[] args) {

        String str = "AABABBA";
        int k=1;
        System.out.println(characterReplacement(str , k));
    }

    public static int characterReplacement(String s, int n) {

        int longestRep = 0;
        int repeating = 0;
        int[] temp = new int[26];
        for(int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                temp[s.charAt(j)-'A']++;
                System.out.print(s.charAt(j));
            }
            System.out.println();
            System.out.println(Arrays.toString(temp));
            
            Arrays.fill(temp, 0);
        }
        return 0;
    }
}
