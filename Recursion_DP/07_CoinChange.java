/**
 * Problem: Coin Change (LeetCode 322)
 * Difficulty: Medium
 * Pattern: Unbounded knapsack / 1D DP
 *
 * Input Format:
 * Line 1: An integer n denoting the number of coin denominations.
 * Line 2: n space-separated integers representing coin values.
 * Line 3: An integer amount representing the total amount of money.
 *
 * Output Format:
 * A single integer representing the fewest number of coins needed, or -1 if the amount cannot be formed.
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
        if (line == null || line.trim().isEmpty()) {
            System.out.println(0);
            return;
        }

        int n = Integer.parseInt(line.trim());
        int[] coins = new int[n];
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
        }

        int amount = Integer.parseInt(br.readLine().trim());
        if (amount < 0) {
            System.out.println(-1);
            return;
        }
        if (amount == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[amount + 1];
        int maxVal = amount + 1;
        Arrays.fill(dp, maxVal);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[amount] > amount ? -1 : dp[amount]);
    }
}
