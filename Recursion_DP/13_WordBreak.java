/**
 * Problem: Word Break (LeetCode 139)
 * Difficulty: Medium
 * Pattern: String DP
 *
 * Input Format:
 * Line 1: String s.
 * Line 2: An integer k denoting the number of words in the dictionary.
 * Line 3: k space-separated dictionary words.
 *
 * Output Format:
 * true if s can be segmented into a space-separated sequence of dictionary words, false otherwise.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null || s.isEmpty()) {
            System.out.println(true);
            return;
        }

        String kLine = br.readLine();
        if (kLine == null || kLine.trim().isEmpty()) {
            System.out.println(false);
            return;
        }

        int k = Integer.parseInt(kLine.trim());
        Set<String> wordDict = new HashSet<>();
        int maxWordLen = 0;

        if (k > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                String word = st.nextToken();
                wordDict.add(word);
                maxWordLen = Math.max(maxWordLen, word.length());
            }
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxWordLen); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
