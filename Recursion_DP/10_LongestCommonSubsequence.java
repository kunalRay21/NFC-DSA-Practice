/**
 * Problem: Longest Common Subsequence (LeetCode 1143)
 * Difficulty: Medium
 * Pattern: 2D DP
 *
 * Input Format:
 * Line 1: String text1.
 * Line 2: String text2.
 *
 * Output Format:
 * A single integer representing the length of their longest common subsequence.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text1 = br.readLine();
        String text2 = br.readLine();

        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            System.out.println(0);
            return;
        }

        int m = text1.length();
        int n = text2.length();

        // Space optimized DP (using 2 rows)
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        System.out.println(prev[n]);
    }
}
