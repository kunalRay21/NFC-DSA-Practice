/**
 * Problem: Lowest Common Ancestor of a Binary Tree (LeetCode 236)
 * Difficulty: Medium
 * Pattern: DFS
 *
 * Input Formats Supported:
 * Format 1 (LeetCode):        Line 1: [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], Line 2: 5 1 (or p = 5, q = 1)
 * Format 2 (Competitive):     Line 1: n, Line 2: n tokens, Line 3: p q
 * Format 3 (Raw Tokens):      Line 1: 3 5 1 6 2 0 8 -1 -1 7 4, Line 2: 5 1
 *
 * Output Format:
 * A single integer representing the value of the lowest common ancestor node.
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> treeTokens = readTreeTokens(br);

        if (treeTokens.isEmpty()) {
            return;
        }

        TreeNode root = buildTree(treeTokens);

        // Read p and q
        String pqLine = br.readLine();
        while (pqLine != null && pqLine.trim().isEmpty()) {
            pqLine = br.readLine();
        }
        if (pqLine == null) return;

        List<String> pqTokens = parseTokens(pqLine);
        int pVal = Integer.parseInt(pqTokens.get(0));
        int qVal = Integer.parseInt(pqTokens.get(1));

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
        // Strip prefixes like "root = ", "p = ", etc.
        text = text.replaceAll("[a-zA-Z]+\\s*=", " ");
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
        return "-1".equals(token) || "null".equalsIgnoreCase(token) || "#".equals(token) || "nil".equalsIgnoreCase(token);
    }
}
