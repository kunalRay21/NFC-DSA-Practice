/**
 * Demonstrates: Building a Binary Tree from stdin using java.util.Scanner
 *
 * Supports:
 * 1. Unsized space-separated tokens on a single line (e.g. 1 2 3 -1 -1 4 5)
 * 2. Tokens containing "null" (e.g. 1 2 3 null null 4 5)
 * 3. Count n on line 1, followed by n tokens on line 2
 *
 * Compile and run:
 *   java 01_TreeInputUsingScanner.java
 * or:
 *   echo "1 2 3 null null 4 5" | java 01_TreeInputUsingScanner.java
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

        if (!sc.hasNextLine()) {
            System.out.println("No input provided.");
            sc.close();
            return;
        }

        String firstLine = sc.nextLine().trim();
        List<String> tokens = new ArrayList<>();

        // If the user inputs a single number n on line 1, read the tokens on line 2
        String[] firstLineTokens = firstLine.split("\\s+");
        if (firstLineTokens.length == 1 && sc.hasNextLine()) {
            try {
                // If it's a count integer, read the next line for the tree values
                Integer.parseInt(firstLineTokens[0]);
                String secondLine = sc.nextLine().trim();
                for (String token : secondLine.split("\\s+")) {
                    if (!token.isEmpty()) tokens.add(token);
                }
            } catch (NumberFormatException e) {
                // It was a single node value (e.g. "root" or single number)
                tokens.add(firstLineTokens[0]);
            }
        } else {
            for (String token : firstLineTokens) {
                if (!token.isEmpty()) tokens.add(token);
            }
        }

        sc.close();

        // Build the binary tree
        TreeNode root = buildTree(tokens);

        // Verify by printing level order
        System.out.println("Constructed Tree (Level Order Traversal):");
        printLevelOrder(root);
    }

    /**
     * Constructs a Binary Tree from a list of level-order tokens.
     */
    public static TreeNode buildTree(List<String> tokens) {
        if (tokens == null || tokens.isEmpty() || isNull(tokens.get(0))) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(tokens.get(0)));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.size()) {
            TreeNode parent = queue.poll();

            // 1. Process left child
            if (idx < tokens.size()) {
                String leftToken = tokens.get(idx);
                if (!isNull(leftToken)) {
                    parent.left = new TreeNode(Integer.parseInt(leftToken));
                    queue.offer(parent.left);
                }
                idx++;
            }

            // 2. Process right child
            if (idx < tokens.size()) {
                String rightToken = tokens.get(idx);
                if (!isNull(rightToken)) {
                    parent.right = new TreeNode(Integer.parseInt(rightToken));
                    queue.offer(parent.right);
                }
                idx++;
            }
        }

        return root;
    }

    private static boolean isNull(String token) {
        return token.equals("-1") || token.equalsIgnoreCase("null") || token.equals("#");
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree (null)");
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
