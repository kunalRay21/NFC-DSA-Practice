/**
 * Problem: Serialize and Deserialize Binary Tree (LeetCode 297)
 * Difficulty: Hard
 * Pattern: DFS/BFS serialization
 *
 * Input Formats Supported:
 * Format 1 (LeetCode):    [1, 2, 3, null, null, 4, 5] or root = [1, 2, 3, null, null, 4, 5]
 * Format 2 (Competitive): Line 1: n, Line 2: n tokens
 * Format 3 (Raw Tokens):  1 2 3 -1 -1 4 5
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
import java.util.Collections;
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
        List<String> tokens = readTreeTokens(br);

        if (tokens.isEmpty()) {
            System.out.println("null");
            System.out.println("[]");
            return;
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
