/**
 * Problem: Number of Provinces (LeetCode 547)
 * Difficulty: Medium
 * Pattern: DFS/BFS / DSU
 *
 * Input Format:
 * Line 1: An integer n denoting the number of cities.
 * Following n lines: n space-separated integers representing the n x n connectivity matrix (1 if connected, 0 otherwise).
 *
 * Output Format:
 * A single integer representing the total number of connected provinces.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) {
            System.out.println(0);
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[][] isConnected = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinceCount++;
                dfs(isConnected, visited, i, n);
            }
        }

        System.out.println(provinceCount);
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city, int n) {
        visited[city] = true;
        for (int j = 0; j < n; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j, n);
            }
        }
    }
}
