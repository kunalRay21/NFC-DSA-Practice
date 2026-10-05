/**
 * Problem: House Robber (LeetCode 198)
 * Difficulty: Medium
 * Pattern: 1D DP
 *
 * Input Format:
 * Line 1: An integer n denoting the number of houses.
 * Line 2: n space-separated integers representing the amount of money in each house.
 *
 * Output Format:
 * A single integer representing the maximum amount of money that can be robbed without alerting police.
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

        long prev2 = 0;
        long prev1 = 0;

        for (int num : nums) {
            long current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}
