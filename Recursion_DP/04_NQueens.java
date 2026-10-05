/**
 * Problem: N-Queens (LeetCode 51)
 * Difficulty: Hard
 * Pattern: Backtracking
 *
 * Input Format:
 * Line 1: An integer n denoting the board dimension (n x n).
 *
 * Output Format:
 * All distinct board configurations printed. Each solution is printed row by row, separated by an empty line.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());
        List<List<String>> solutions = solveNQueens(n);

        for (int i = 0; i < solutions.size(); i++) {
            if (i > 0) System.out.println();
            for (String row : solutions.get(i)) {
                System.out.println(row);
            }
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // r + c
        boolean[] diag2 = new boolean[2 * n]; // r - c + n

        backtrack(board, 0, n, cols, diag1, diag2, result);
        return result;
    }

    private static void backtrack(char[][] board, int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> result) {
        if (row == n) {
            List<String> currentBoard = new ArrayList<>(n);
            for (int r = 0; r < n; r++) {
                currentBoard.add(new String(board[r]));
            }
            result.add(currentBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(board, row + 1, n, cols, diag1, diag2, result);

            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
