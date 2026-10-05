/**
 * Problem: Rotting Oranges (LeetCode 994)
 * Difficulty: Medium
 * Pattern: Multi-source BFS
 *
 * Input Format:
 * Line 1: Two integers rows and cols.
 * Following rows lines: cols space-separated integers (0: empty, 1: fresh orange, 2: rotten orange).
 *
 * Output Format:
 * A single integer representing the minimum number of minutes until no fresh orange remains, or -1 if impossible.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
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

        int[][] grid = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            String rowStr = br.readLine().trim();
            StringTokenizer rowTokens = new StringTokenizer(rowStr);
            for (int c = 0; c < cols; c++) {
                grid[r][c] = Integer.parseInt(rowTokens.nextToken());
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            System.out.println(0);
            return;
        }

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && freshCount > 0) {
            int levelSize = queue.size();
            minutes++;

            for (int i = 0; i < levelSize; i++) {
                int[] curr = queue.poll();
                int cr = curr[0];
                int cc = curr[1];

                for (int[] d : dirs) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Rots
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        System.out.println(freshCount == 0 ? minutes : -1);
    }
}
