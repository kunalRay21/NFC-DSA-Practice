/**
 * Problem: Binary Tree Level Order Traversal (LeetCode 102)
 * Difficulty: Medium
 * Pattern: BFS
 *
 * Input Formats Supported:
 * Format 1 (LeetCode Bracketed): [3, 9, 20, null, null, 15, 7] or root = [3, 9, 20, null, null, 15, 7]
 * Format 2 (Competitive Prog):    Line 1: n, Line 2: n tokens (use -1 or null)
 * Format 3 (Raw Tokens):          3 9 20 -1 -1 15 7
 *
 * Output Format:
 * Each level printed on a new line in list format: [val1, val2, ...]
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
        List<String> tokens = readTreeTokens(br);

        if (tokens.isEmpty()) {
            return;
        }

        TreeNode root = buildTree(tokens);
        List<List<Integer>> levels = levelOrder(root);

        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

    // Helper supporting multiple input formats (LeetCode brackets, CP count + line, raw stream)
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

            // Left child
            if (idx < tokens.size()) {
                if (!isNull(tokens.get(idx))) {
                    curr.left = new TreeNode(Integer.parseInt(tokens.get(idx)));
                    queue.offer(curr.left);
                }
                idx++;
            }

            // Right child
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
