/**
 * Problem: Longest Substring Without Repeating Characters (LeetCode 3)
 * Difficulty: Medium
 * Pattern: Sliding window + HashMap
 *
 * Input Format:
 * Line 1: String s (may be empty or contain whitespace).
 *
 * Output Format:
 * A single integer representing the length of the longest substring without repeating characters.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty()) {
            System.out.println(0);
            return;
        }

        // Stores the last seen index + 1 of each ASCII character
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, 0);

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, lastIndex[c]);
            maxLen = Math.max(maxLen, right - left + 1);
            lastIndex[c] = right + 1;
        }

        System.out.println(maxLen);
    }
}
