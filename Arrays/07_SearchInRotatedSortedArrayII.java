/**
 * Problem: Search in Rotated Sorted Array II (LeetCode 81)
 * Difficulty: Medium
 * Pattern: Modified binary search
 *
 * Input Format:
 * Line 1: An integer n denoting the size of the array.
 * Line 2: n space-separated integers (sorted rotated array, may contain duplicates).
 * Line 3: An integer target to search for.
 *
 * Output Format:
 * true if target is in the array, false otherwise.
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
            System.out.println(false);
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

        int target = Integer.parseInt(br.readLine().trim());

        int left = 0, right = n - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                found = true;
                break;
            }

            // Handle duplicates: when ends match mid, we cannot deduce which half is sorted
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(found);
    }
}
