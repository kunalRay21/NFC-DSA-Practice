/**
 * Problem: Maximum Product Subarray (LeetCode 152)
 * Difficulty: Medium/Hard
 * Pattern: Kadane variation / tracking minimum and maximum
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated integers.
 *
 * Output Format:
 * A single integer representing the maximum product of a contiguous subarray.
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

        long maxProd = nums[0];
        long minProd = nums[0];
        long globalMax = nums[0];

        for (int i = 1; i < n; i++) {
            int val = nums[i];
            if (val < 0) {
                long temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max((long) val, maxProd * val);
            minProd = Math.min((long) val, minProd * val);

            globalMax = Math.max(globalMax, maxProd);
        }

        System.out.println(globalMax);
    }
}
