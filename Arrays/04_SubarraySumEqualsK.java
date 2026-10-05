/**
 * Problem: Subarray Sum Equals K (LeetCode 560)
 * Difficulty: Medium
 * Pattern: Prefix sum + HashMap
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated integers.
 * Line 3: An integer k denoting the target sum.
 *
 * Output Format:
 * A single integer representing the total number of continuous subarrays whose sum equals k.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine().trim());

        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);

        long currentSum = 0;
        long totalCount = 0;

        for (int num : nums) {
            currentSum += num;
            long complement = currentSum - k;
            if (prefixCount.containsKey(complement)) {
                totalCount += prefixCount.get(complement);
            }
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        System.out.println(totalCount);
    }
}
