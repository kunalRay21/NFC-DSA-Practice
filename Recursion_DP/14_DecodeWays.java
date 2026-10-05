/**
 * Problem: Decode Ways (LeetCode 91)
 * Difficulty: Medium
 * Pattern: 1D DP
 *
 * Input Format:
 * Line 1: String s containing digits ('0'-'9').
 *
 * Output Format:
 * A single integer representing the total number of valid decodings.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int n = s.length();
        long prev2 = 1; // dp[i-2]
        long prev1 = 1; // dp[i-1]

        for (int i = 1; i < n; i++) {
            long current = 0;
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            // Single digit decoding (1-9)
            if (currChar != '0') {
                current += prev1;
            }

            // Two digit decoding (10-26)
            int twoDigit = (prevChar - '0') * 10 + (currChar - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}
