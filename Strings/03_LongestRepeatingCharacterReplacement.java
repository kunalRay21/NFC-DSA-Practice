/**
 * Problem: Longest Repeating Character Replacement (LeetCode 424)
 * Difficulty: Medium
 * Pattern: Sliding window + frequency
 *
 * Input Format:
 * Line 1: String s consisting of uppercase English letters.
 * Line 2: An integer k denoting the maximum number of character replacements allowed.
 *
 * Output Format:
 * A single integer representing the length of the longest substring with identical characters after replacements.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null || s.isEmpty()) {
            System.out.println(0);
            return;
        }

        String kLine = br.readLine();
        if (kLine == null || kLine.trim().isEmpty()) {
            System.out.println(s.length());
            return;
        }
        int k = Integer.parseInt(kLine.trim());

        int[] count = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int charIdx = s.charAt(right) - 'A';
            count[charIdx]++;
            maxFreq = Math.max(maxFreq, count[charIdx]);

            // Number of characters to replace = (window size) - maxFreq
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
