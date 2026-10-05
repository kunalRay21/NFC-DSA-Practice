/**
 * Problem: Target Sum (LeetCode 494)
 * Difficulty: Medium
 * Pattern: DP / knapsack
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated non-negative integers.
 * Line 3: An integer target.
 *
 * Output Format:
 * A single integer representing the number of different ways to assign '+' and '-' symbols to evaluate to target.
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
        int[] nums = new int[n];
        int totalSum = 0;

        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                totalSum += nums[i];
            }
        }

        int target = Integer.parseInt(br.readLine().trim());

        // target + totalSum must be >= 0 and even
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            System.out.println(0);
            return;
        }

        int subsetSum = (totalSum + target) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        System.out.println(dp[subsetSum]);
    }
}
