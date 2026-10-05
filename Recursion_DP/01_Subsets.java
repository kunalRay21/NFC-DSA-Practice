/**
 * Problem: Subsets (LeetCode 78)
 * Difficulty: Medium
 * Pattern: Backtracking
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated unique integers.
 *
 * Output Format:
 * Each subset printed on a new line in list format: [elem1, elem2, ...]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            System.out.println("[]");
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

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
