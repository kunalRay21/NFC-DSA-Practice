/**
 * Problem: First Missing Positive (LeetCode 41)
 * Difficulty: Hard
 * Pattern: In-place array manipulation / cyclic placement
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated integers.
 *
 * Output Format:
 * A single integer representing the smallest missing positive integer.
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
            System.out.println(1);
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

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(n + 1);
    }
}
