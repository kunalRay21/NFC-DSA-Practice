/**
 * Problem: Palindromic Substrings (LeetCode 647)
 * Difficulty: Medium
 * Pattern: DP / expand around center
 *
 * Input Format:
 * Line 1: String s.
 *
 * Output Format:
 * A single integer representing the number of palindromic substrings.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty()) {
            System.out.println(0);
            return;
        }

        int count = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + (center % 2);

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        System.out.println(count);
    }
}
