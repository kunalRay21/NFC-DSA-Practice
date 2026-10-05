/**
 * Problem: Edit Distance (LeetCode 72)
 * Difficulty: Hard
 * Pattern: 2D string DP
 *
 * Input Format:
 * Line 1: String word1.
 * Line 2: String word2.
 *
 * Output Format:
 * A single integer representing the minimum number of operations to convert word1 to word2.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        if (word1 == null) word1 = "";
        if (word2 == null) word2 = "";

        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        // Base case: converting empty word1 to word2[0..j] requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prevDiag = dp[0];
            dp[0] = i; // Deleting all i characters of word1

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prevDiag;
                } else {
                    // 1 + min(insert, delete, replace)
                    dp[j] = 1 + Math.min(prevDiag, Math.min(dp[j], dp[j - 1]));
                }
                prevDiag = temp;
            }
        }

        System.out.println(dp[n]);
    }
}
