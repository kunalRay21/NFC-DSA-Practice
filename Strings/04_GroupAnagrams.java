/**
 * Problem: Group Anagrams (LeetCode 49)
 * Difficulty: Medium
 * Pattern: Hashing
 *
 * Input Format:
 * Line 1: An integer n denoting the number of strings.
 * Line 2: n space-separated strings.
 *
 * Output Format:
 * Each group of anagrams printed on a separate line as a list: [word1, word2, ...]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n == 0) {
            return;
        }

        String[] strs = new String[n];
        StringTokenizer st = new StringTokenizer("");
        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                String nextLine = br.readLine();
                if (nextLine == null) break;
                st = new StringTokenizer(nextLine);
            }
            if (st.hasMoreTokens()) {
                strs[i] = st.nextToken();
            } else {
                strs[i] = "";
            }
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        // Sort individual groups and list of groups for deterministic presentation
        for (List<String> group : result) {
            Collections.sort(group);
        }
        result.sort((a, b) -> {
            if (a.size() != b.size()) return Integer.compare(a.size(), b.size());
            return a.get(0).compareTo(b.get(0));
        });

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
