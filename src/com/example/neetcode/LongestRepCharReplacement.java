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

public class LongestRepCharReplacement {

    public static void main(String[] args) {

        String str = "AABABBA";
        int k=1;
        // Call the completed implementation
        System.out.println(characterReplacementSubmitted(str , k));
    }

    public static int characterReplacementSubmitted(String s, int k) {
        int[] count = new int[26]; // Count array for characters A-Z
        int maxCount = 0; // Maximum frequency of any character in current window
        int maxLength = 0; // Maximum length of valid substring found so far
        int left = 0; // Left pointer of sliding window

        // Right pointer of sliding window (expanding)
        for (int right = 0; right < s.length(); right++) {
            // Add current character to window
            char rightChar = s.charAt(right);
            count[rightChar - 'A']++;

            // Update maximum frequency in current window
            maxCount = Math.max(maxCount, count[rightChar - 'A']);

            // Check if current window is valid
            // Window size - most frequent character count should be <= k
            int windowSize = right - left + 1;
            if (windowSize - maxCount > k) {
                // Window is invalid, shrink from left
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            // Update maximum length (window is always valid here)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }
}
