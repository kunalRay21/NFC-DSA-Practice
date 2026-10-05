/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal (LeetCode 105)
 * Difficulty: Medium
 * Pattern: Recursion + HashMap
 *
 * Input Formats Supported:
 * Format 1 (LeetCode):    Line 1: [3, 9, 20, 15, 7], Line 2: [9, 3, 15, 20, 7]
 * Format 2 (Competitive): Line 1: n, Line 2: preorder, Line 3: inorder
 * Format 3 (Raw Tokens):  Line 1: 3 9 20 15 7, Line 2: 9 3 15 20 7
 *
 * Output Format:
 * Space-separated tokens representing the level-order traversal of the constructed tree (-1 for null).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private static int preorderIndex = 0;
    private static Map<Integer, Integer> inorderMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> preList = readIntList(br);
        if (preList.isEmpty()) return;

        List<Integer> inList = readIntList(br);
        if (inList.isEmpty()) return;

        int n = preList.size();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = preList.get(i);
            inorder[i] = inList.get(i);
            inorderMap.put(inorder[i], i);
        }

        preorderIndex = 0;
        TreeNode root = buildTreeHelper(preorder, 0, n - 1);

        // Print level order traversal
        List<String> output = getLevelOrder(root);
        System.out.println(String.join(" ", output));
    }

    private static List<Integer> readIntList(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return new ArrayList<>();

        if (line.contains("[") || line.contains("=")) {
            return parseIntTokens(line);
        }

        List<Integer> tokens = parseIntTokens(line);
        if (tokens.size() == 1) {
            String nextLine = br.readLine();
            if (nextLine != null && !nextLine.trim().isEmpty()) {
                return parseIntTokens(nextLine);
            }
        }
        return tokens;
    }

    private static List<Integer> parseIntTokens(String text) {
        text = text.replaceAll("[a-zA-Z]+\\s*=", " ");
        text = text.replace("[", " ").replace("]", " ").replace(",", " ").trim();
        StringTokenizer st = new StringTokenizer(text);
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            try {
                list.add(Integer.parseInt(st.nextToken()));
            } catch (NumberFormatException ignored) {}
        }
        return list;
    }

    private static TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        root.left = buildTreeHelper(preorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inIndex + 1, inEnd);

        return root;
    }

    private static List<String> getLevelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                result.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                result.add("-1");
            }
        }

        // Trim trailing -1s
        int lastNodeIdx = result.size() - 1;
        while (lastNodeIdx >= 0 && "-1".equals(result.get(lastNodeIdx))) {
            lastNodeIdx--;
        }

        return result.subList(0, lastNodeIdx + 1);
    }
}
