/**
 * Problem: House Robber II (LeetCode 213)
 * Difficulty: Medium
 * Pattern: Circular DP
 *
 * Input Format:
 * Line 1: An integer n denoting the number of houses arranged in a circle.
 * Line 2: n space-separated integers representing the amount of money in each house.
 *
 * Output Format:
 * A single integer representing the maximum money that can be robbed from the circular arrangement.
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

        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }

        // Two scenarios: rob house 0 to n-2, or rob house 1 to n-1
        long max1 = robLinear(nums, 0, n - 2);
        long max2 = robLinear(nums, 1, n - 1);

        System.out.println(Math.max(max1, max2));
    }

    private static long robLinear(int[] nums, int start, int end) {
        long prev2 = 0;
        long prev1 = 0;

        for (int i = start; i <= end; i++) {
            long current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
