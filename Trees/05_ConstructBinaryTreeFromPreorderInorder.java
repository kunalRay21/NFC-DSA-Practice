/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal (LeetCode 105)
 * Difficulty: Medium
 * Pattern: Recursion + HashMap
 *
 * Input Format:
 * Line 1: An integer n denoting the number of nodes.
 * Line 2: n space-separated integers representing preorder traversal.
 * Line 3: n space-separated integers representing inorder traversal.
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
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n == 0) {
            return;
        }

        int[] preorder = new int[n];
        StringTokenizer stPre = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preorder[i] = Integer.parseInt(stPre.nextToken());
        }

        int[] inorder = new int[n];
        StringTokenizer stIn = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(stIn.nextToken());
            inorderMap.put(inorder[i], i);
        }

        preorderIndex = 0;
        TreeNode root = buildTreeHelper(preorder, 0, n - 1);

        // Print level order traversal
        List<String> output = getLevelOrder(root);
        System.out.println(String.join(" ", output));
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
