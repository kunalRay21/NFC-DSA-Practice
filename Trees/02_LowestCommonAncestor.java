/**
 * Problem: Lowest Common Ancestor of a Binary Tree (LeetCode 236)
 * Difficulty: Medium
 * Pattern: DFS
 *
 * Input Format:
 * Line 1: An integer n denoting the number of tokens in the level-order representation.
 * Line 2: n space-separated tokens representing the tree in level order (use -1 or null for null nodes).
 * Line 3: Two space-separated integers p and q representing the node values whose LCA is to be found.
 *
 * Output Format:
 * A single integer representing the value of the lowest common ancestor node.
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

        StringTokenizer pqTokens = new StringTokenizer(br.readLine());
        int pVal = Integer.parseInt(pqTokens.nextToken());
        int qVal = Integer.parseInt(pqTokens.nextToken());

        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);

        TreeNode lca = lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println(lca.val);
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
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
        return "-1".equals(token) || "null".equalsIgnoreCase(token);
    }
}
