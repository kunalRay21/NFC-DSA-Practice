/**
 * Problem: Serialize and Deserialize Binary Tree (LeetCode 297)
 * Difficulty: Hard
 * Pattern: DFS/BFS serialization
 *
 * Input Format:
 * Line 1: An integer n denoting the number of tokens in the initial level-order tree.
 * Line 2: n space-separated tokens (use "null", "#", or "-1" for empty nodes).
 *
 * Output Format:
 * Line 1: The serialized string representation.
 * Line 2: The level-order traversal of the deserialized binary tree.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
            System.out.println("null");
            System.out.println("[]");
            return;
        }

        String[] tokens = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tokens[i] = st.nextToken();
        }

        TreeNode originalRoot = buildTree(tokens);

        // Serialize
        String serialized = serialize(originalRoot);
        System.out.println(serialized);

        // Deserialize
        TreeNode deserializedRoot = deserialize(serialized);

        // Print level order of deserialized tree to verify correctness
        System.out.println(levelOrderList(deserializedRoot));
    }

    // Encodes a tree to a single string using preorder traversal
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTreeFromQueue(nodes);
    }

    private static TreeNode buildTreeFromQueue(Queue<String> nodes) {
        if (nodes.isEmpty()) return null;
        String val = nodes.poll();
        if ("null".equals(val) || val.isEmpty()) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTreeFromQueue(nodes);
        node.right = buildTreeFromQueue(nodes);
        return node;
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

    private static List<Integer> levelOrderList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return list;
    }
}
