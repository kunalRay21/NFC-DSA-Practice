/**
 * Problem: Find the Duplicate Number (LeetCode 287)
 * Difficulty: Medium
 * Pattern: Floyd's cycle detection
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array (containing numbers in range [1, n-1]).
 * Line 2: n space-separated integers.
 *
 * Output Format:
 * A single integer representing the duplicate number.
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
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Phase 1: Finding the intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle (the duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        System.out.println(slow);
    }
}
