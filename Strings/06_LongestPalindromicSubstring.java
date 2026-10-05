/**
 * Problem: Longest Palindromic Substring (LeetCode 5)
 * Difficulty: Medium
 * Pattern: DP / expand around center
 *
 * Input Format:
 * Line 1: String s.
 *
 * Output Format:
 * A single string representing the longest palindromic substring in s.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty()) {
            System.out.println("");
            return;
        }

        int start = 0, maxLen = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Odd length palindromes (center at i)
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindromes (center between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        System.out.println(s.substring(start, start + maxLen));
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
