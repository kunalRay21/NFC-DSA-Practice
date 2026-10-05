/**
 * Problem: Binary Tree Maximum Path Sum (LeetCode 124)
 * Difficulty: Hard
 * Pattern: DFS + tree DP
 *
 * Input Formats Supported:
 * Format 1 (LeetCode):    [-10, 9, 20, null, null, 15, 7] or root = [-10, 9, 20, null, null, 15, 7]
 * Format 2 (Competitive): Line 1: n, Line 2: n tokens
 * Format 3 (Raw Tokens):  -10 9 20 null null 15 7
 *
 * Output Format:
 * A single integer representing the maximum path sum in the binary tree.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int globalMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> tokens = readTreeTokens(br);

        if (tokens.isEmpty()) {
            System.out.println(0);
            return;
        }

        TreeNode root = buildTree(tokens);
        maxGain(root);

        System.out.println(globalMax);
    }

    private static int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;
        globalMax = Math.max(globalMax, priceNewPath);

        return node.val + Math.max(leftGain, rightGain);
    }

    private static List<String> readTreeTokens(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return Collections.emptyList();

        if (line.contains("[") || line.contains("=")) {
            return parseTokens(line);
        }

        List<String> tokens = parseTokens(line);
        if (tokens.size() == 1) {
            try {
                Integer.parseInt(tokens.get(0));
                String nextLine = br.readLine();
                if (nextLine != null && !nextLine.trim().isEmpty()) {
                    return parseTokens(nextLine);
                }
            } catch (NumberFormatException ignored) {}
        }
        return tokens;
    }

    private static List<String> parseTokens(String text) {
        int eqIdx = text.indexOf('=');
        if (eqIdx != -1) {
            text = text.substring(eqIdx + 1);
        }
        text = text.replace("[", " ").replace("]", " ").replace(",", " ").trim();
        StringTokenizer st = new StringTokenizer(text);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        return list;
    }

    private static TreeNode buildTree(List<String> tokens) {
        if (tokens == null || tokens.isEmpty() || isNull(tokens.get(0))) return null;

        TreeNode root = new TreeNode(Integer.parseInt(tokens.get(0)));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.size()) {
            TreeNode curr = queue.poll();

            if (idx < tokens.size()) {
                if (!isNull(tokens.get(idx))) {
                    curr.left = new TreeNode(Integer.parseInt(tokens.get(idx)));
                    queue.offer(curr.left);
                }
                idx++;
            }

            if (idx < tokens.size()) {
                if (!isNull(tokens.get(idx))) {
                    curr.right = new TreeNode(Integer.parseInt(tokens.get(idx)));
                    queue.offer(curr.right);
                }
                idx++;
            }
        }

        return root;
    }

    private static boolean isNull(String token) {
        return "null".equalsIgnoreCase(token) || "#".equals(token) || "-1".equals(token) || "nil".equalsIgnoreCase(token);
    }
}
