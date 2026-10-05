/**
 * Problem: Combination Sum (LeetCode 39)
 * Difficulty: Medium
 * Pattern: Backtracking
 *
 * Input Format:
 * Line 1: An integer n denoting the size of candidates array.
 * Line 2: n space-separated distinct integers.
 * Line 3: An integer target.
 *
 * Output Format:
 * Each combination printed on a new line in list format: [elem1, elem2, ...]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        int[] candidates = new int[n];
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                candidates[i] = Integer.parseInt(st.nextToken());
            }
        }

        int target = Integer.parseInt(br.readLine().trim());
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }

    private static void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break; // Prune branch

            current.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, current, result); // Reuse same element allowed
            current.remove(current.size() - 1);
        }
    }
}
