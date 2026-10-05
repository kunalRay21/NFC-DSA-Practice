/**
 * Problem: Binary Tree Maximum Path Sum (LeetCode 124)
 * Difficulty: Hard
 * Pattern: DFS + tree DP
 *
 * Input Format:
 * Line 1: An integer n denoting the number of tokens in the level-order representation.
 * Line 2: n space-separated tokens representing the tree in level order (use "null", "#", or "-1" for empty/null nodes).
 *
 * Output Format:
 * A single integer representing the maximum path sum in the binary tree.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
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
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            System.out.println(0);
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        String[] tokens = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tokens[i] = st.nextToken();
        }

        TreeNode root = buildTree(tokens);
        maxGain(root);

        System.out.println(globalMax);
    }

    private static int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Max sum from left and right subtrees (ignore negative sums)
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Price of the new path where `node` is the highest point (split point)
        int priceNewPath = node.val + leftGain + rightGain;

        globalMax = Math.max(globalMax, priceNewPath);

        // For recursion: return the max gain if continuing the path through node
        return node.val + Math.max(leftGain, rightGain);
    }

    private static TreeNode buildTree(String[] tokens) {
        if (tokens == null || tokens.length == 0 || isNull(tokens[0])) return null;

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.length) {
            TreeNode curr = queue.poll();

            if (idx < tokens.length) {
                if (!isNull(tokens[idx])) {
                    curr.left = new TreeNode(Integer.parseInt(tokens[idx]));
                    queue.offer(curr.left);
                }
                idx++;
            }

            if (idx < tokens.length) {
                if (!isNull(tokens[idx])) {
                    curr.right = new TreeNode(Integer.parseInt(tokens[idx]));
                    queue.offer(curr.right);
                }
                idx++;
            }
        }

        return root;
    }

    private static boolean isNull(String token) {
        return "null".equalsIgnoreCase(token) || "#".equals(token) || "-1".equals(token);
    }
}
