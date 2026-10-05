/**
 * Demonstrates: Building a Binary Tree directly from LeetCode-style Bracketed Strings
 *
 * Examples supported:
 * 1. "[1, 2, 3, null, null, 4, 5]"
 * 2. "root = [3, 9, 20, null, null, 15, 7]"
 * 3. "[10, 5, -1, 3, null]"
 *
 * Compile and run:
 *   java 03_TreeInputFromBracketedString.java
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter LeetCode-style tree string (or press Enter for demo):");

        String input = "";
        if (sc.hasNextLine()) {
            input = sc.nextLine().trim();
        }
        sc.close();

        if (input.isEmpty()) {
            input = "root = [3, 9, 20, null, null, 15, 7]";
            System.out.println("Running with default sample: " + input);
        }

        TreeNode root = buildTreeFromLeetCodeString(input);
        System.out.println("\nConstructed Tree (Level Order):");
        printLevelOrder(root);
    }

    /**
     * Converts a string like "[1, 2, 3, null, null, 4, 5]" into a TreeNode root.
     */
    public static TreeNode buildTreeFromLeetCodeString(String str) {
        if (str == null || str.trim().isEmpty()) return null;

        // 1. Strip variable assignment like "root = "
        int eqIndex = str.indexOf('=');
        if (eqIndex != -1) {
            str = str.substring(eqIndex + 1);
        }

        // 2. Replace brackets and commas with spaces
        String clean = str.replace("[", " ")
                          .replace("]", " ")
                          .replace(",", " ")
                          .trim();

        if (clean.isEmpty()) return null;

        // 3. Extract tokens
        String[] tokens = clean.split("\\s+");
        if (tokens.length == 0 || isNull(tokens[0])) return null;

        // 4. Standard BFS queue construction
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.length) {
            TreeNode curr = queue.poll();

            // Left
            if (idx < tokens.length) {
                if (!isNull(tokens[idx])) {
                    curr.left = new TreeNode(Integer.parseInt(tokens[idx]));
                    queue.offer(curr.left);
                }
                idx++;
            }

            // Right
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
        return token == null || token.equals("-1") || token.equalsIgnoreCase("null") || token.equals("#");
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Empty (null)");
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println(level);
        }
    }
}
