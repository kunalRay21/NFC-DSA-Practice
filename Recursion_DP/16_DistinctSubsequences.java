/**
 * Problem: Distinct Subsequences (LeetCode 115)
 * Difficulty: Hard
 * Pattern: 2D string DP
 *
 * Input Format:
 * Line 1: String s.
 * Line 2: String t.
 *
 * Output Format:
 * A single integer (or long) representing the number of distinct subsequences of s that equal t.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        if (s == null || t == null || s.length() < t.length()) {
            System.out.println(0);
            return;
        }

        int m = s.length();
        int n = t.length();

        // dp[j] is the number of distinct subsequences of s matching t[0..j-1]
        long[] dp = new long[n + 1];
        dp[0] = 1; // An empty t is a subsequence of any prefix of s exactly once

        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = n; j >= 1; j--) {
                char tc = t.charAt(j - 1);
                if (sc == tc) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
