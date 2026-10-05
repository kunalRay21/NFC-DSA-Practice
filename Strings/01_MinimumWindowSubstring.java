/**
 * Problem: Minimum Window Substring (LeetCode 76)
 * Difficulty: Hard
 * Pattern: Sliding window + frequency map
 *
 * Input Format:
 * Line 1: String s.
 * Line 2: String t.
 *
 * Output Format:
 * A single string representing the minimum window substring of s containing all characters in t.
 * If no such window exists, prints an empty string or empty line.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            System.out.println("");
            return;
        }

        int[] targetMap = new int[128];
        int requiredUnique = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (targetMap[c] == 0) {
                requiredUnique++;
            }
            targetMap[c]++;
        }

        int[] windowMap = new int[128];
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap[c]++;

            if (targetMap[c] > 0 && windowMap[c] == targetMap[c]) {
                formed++;
            }

            while (left <= right && formed == requiredUnique) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowMap[leftChar]--;
                if (targetMap[leftChar] > 0 && windowMap[leftChar] < targetMap[leftChar]) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println("");
        } else {
            System.out.println(s.substring(minLeft, minLeft + minLen));
        }
    }
}
