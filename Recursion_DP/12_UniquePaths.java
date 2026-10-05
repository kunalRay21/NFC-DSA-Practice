/**
 * Problem: Unique Paths (LeetCode 62)
 * Difficulty: Medium
 * Pattern: Grid DP
 *
 * Input Format:
 * Line 1: Two integers m and n representing the number of rows and columns.
 *
 * Output Format:
 * A single integer representing the number of unique paths from top-left to bottom-right.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if (m <= 0 || n <= 0) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        System.out.println(dp[n - 1]);
    }
}
