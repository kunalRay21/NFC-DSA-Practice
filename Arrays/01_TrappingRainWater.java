/**
 * Problem: Trapping Rain Water (LeetCode 42)
 * Difficulty: Hard
 * Pattern: Two pointers / prefix maximum
 *
 * Input Format:
 * Line 1: An integer n denoting the number of elevation bars.
 * Line 2: n space-separated integers representing the elevation map.
 *
 * Output Format:
 * A single integer representing the total amount of trapped rain water.
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
        if (n <= 2) {
            System.out.println(0);
            return;
        }

        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        long totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        System.out.println(totalWater);
    }
}
