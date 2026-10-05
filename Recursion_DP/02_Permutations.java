/**
 * Problem: Permutations (LeetCode 46)
 * Difficulty: Medium
 * Pattern: Backtracking
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated unique integers.
 *
 * Output Format:
 * Each permutation printed on a new line in list format: [elem1, elem2, ...]
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
        boolean[] used = new boolean[n];
        backtrack(nums, used, new ArrayList<>(), result);

        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
