/**
 * Problem: Partition Equal Subset Sum (LeetCode 416)
 * Difficulty: Medium
 * Pattern: 0/1 knapsack
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated positive integers.
 *
 * Output Format:
 * true if the array can be partitioned into two subsets with equal sum, false otherwise.
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
            System.out.println(false);
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n <= 1) {
            System.out.println(false);
            return;
        }

        int[] nums = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        // If total sum is odd, cannot partition into two equal integer subsets
        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if (dp[target]) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(dp[target]);
    }
}
