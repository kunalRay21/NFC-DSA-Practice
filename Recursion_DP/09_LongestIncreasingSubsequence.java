/**
 * Problem: Longest Increasing Subsequence (LeetCode 300)
 * Difficulty: Medium
 * Pattern: Subsequence DP
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated integers.
 *
 * Output Format:
 * A single integer representing the length of the longest strictly increasing subsequence.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        // tails[i] stores the smallest tail of all increasing subsequences of length i + 1
        List<Integer> tails = new ArrayList<>();

        for (int x : nums) {
            int idx = Collections.binarySearch(tails, x);
            if (idx < 0) {
                idx = -(idx + 1); // Insertion point
            }
            if (idx == tails.size()) {
                tails.add(x);
            } else {
                tails.set(idx, x);
            }
        }

        System.out.println(tails.size());
    }
}
