/**
 * Problem: Number of Islands (LeetCode 200)
 * Difficulty: Medium
 * Pattern: DFS/BFS
 *
 * Input Format:
 * Line 1: Two integers rows and cols.
 * Following rows lines: cols grid values ('1' for land, '0' for water), space-separated or contiguous characters.
 *
 * Output Format:
 * A single integer representing the number of islands.
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

        StringTokenizer st = new StringTokenizer(line);
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        char[][] grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String rowStr = br.readLine().trim();
            if (rowStr.contains(" ")) {
                StringTokenizer rowTokens = new StringTokenizer(rowStr);
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = rowTokens.nextToken().charAt(0);
                }
            } else {
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = rowStr.charAt(c);
                }
            }
        }

        int islandCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }

        System.out.println(islandCount);
    }

    private static void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0'; // Mark visited

        dfs(grid, r + 1, c, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r, c - 1, rows, cols);
    }
}
