/**
 * Problem: Burst Balloons (LeetCode 312)
 * Difficulty: Hard
 * Pattern: Interval DP
 *
 * Input Format:
 * Line 1: An integer n denoting the number of balloons.
 * Line 2: n space-separated integers representing balloon numbers.
 *
 * Output Format:
 * A single integer representing the maximum coins you can collect by bursting balloons wisely.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            System.out.println(0);
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Add virtual boundary balloons with value 1 at both ends
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // Interval DP: len is the length of subarray of balloons burst
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;

                // Pick k as the last balloon burst in interval [left, right]
                for (int k = left; k <= right; k++) {
                    int coins = arr[left - 1] * arr[k] * arr[right + 1]
                              + dp[left][k - 1]
                              + dp[k + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
