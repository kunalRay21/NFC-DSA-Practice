/**
 * Problem: Binary Tree Level Order Traversal (LeetCode 102)
 * Difficulty: Medium
 * Pattern: BFS
 *
 * Input Format:
 * Line 1: An integer n denoting the number of tokens in the level-order representation.
 * Line 2: n space-separated tokens representing the tree in level order (use -1 or null for null nodes).
 *
 * Output Format:
 * Each level printed on a new line in list format: [val1, val2, ...]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
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

        String[] tokens = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tokens[i] = st.nextToken();
        }

        TreeNode root = buildTree(tokens);
        List<List<Integer>> levels = levelOrder(root);

        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

    private static TreeNode buildTree(String[] tokens) {
        if (tokens == null || tokens.length == 0 || isNull(tokens[0])) return null;

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.length) {
            TreeNode curr = queue.poll();

            // Left child
            if (idx < tokens.length) {
                if (!isNull(tokens[idx])) {
                    curr.left = new TreeNode(Integer.parseInt(tokens[idx]));
                    queue.offer(curr.left);
                }
                idx++;
            }

            // Right child
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
        return "-1".equals(token) || "null".equalsIgnoreCase(token);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}
