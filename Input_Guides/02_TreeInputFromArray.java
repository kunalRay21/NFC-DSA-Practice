/**
 * Demonstrates: Building a Binary Tree when an Array is directly given in Java.
 *
 * Covers:
 * 1. Integer[] array with actual Java nulls: {1, 2, 3, null, null, 4, 5}
 * 2. int[] primitive array with -1 sentinels: {1, 2, 3, -1, -1, 4, 5}
 * 3. String[] array with text tokens: {"1", "2", "3", "null", "null", "4", "5"}
 *
 * Compile and run:
 *   java 02_TreeInputFromArray.java
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
        System.out.println("=== Demo 1: Integer[] with Java nulls ===");
        Integer[] arr1 = {1, 2, 3, null, null, 4, 5};
        TreeNode root1 = buildFromIntegerArray(arr1);
        printLevelOrder(root1);

        System.out.println("\n=== Demo 2: primitive int[] with -1 ===");
        int[] arr2 = {10, 5, 15, -1, 7, 12, 20};
        TreeNode root2 = buildFromIntArray(arr2);
        printLevelOrder(root2);

        System.out.println("\n=== Demo 3: String[] with 'null' text ===");
        String[] arr3 = {"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root3 = buildFromStringArray(arr3);
        printLevelOrder(root3);
    }

    /**
     * Case 1: Building from Integer[] where null indicates missing child.
     */
    public static TreeNode buildFromIntegerArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < arr.length) {
            TreeNode parent = queue.poll();

            // Left child
            if (idx < arr.length) {
                if (arr[idx] != null) {
                    parent.left = new TreeNode(arr[idx]);
                    queue.offer(parent.left);
                }
                idx++;
            }

            // Right child
            if (idx < arr.length) {
                if (arr[idx] != null) {
                    parent.right = new TreeNode(arr[idx]);
                    queue.offer(parent.right);
                }
                idx++;
            }
        }

        return root;
    }

    /**
     * Case 2: Building from primitive int[] where -1 indicates null.
     */
    public static TreeNode buildFromIntArray(int[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < arr.length) {
            TreeNode parent = queue.poll();

            if (idx < arr.length) {
                if (arr[idx] != -1) {
                    parent.left = new TreeNode(arr[idx]);
                    queue.offer(parent.left);
                }
                idx++;
            }

            if (idx < arr.length) {
                if (arr[idx] != -1) {
                    parent.right = new TreeNode(arr[idx]);
                    queue.offer(parent.right);
                }
                idx++;
            }
        }

        return root;
    }

    /**
     * Case 3: Building from String[] tokens.
     */
    public static TreeNode buildFromStringArray(String[] arr) {
        if (arr == null || arr.length == 0 || isNull(arr[0])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < arr.length) {
            TreeNode parent = queue.poll();

            if (idx < arr.length) {
                if (!isNull(arr[idx])) {
                    parent.left = new TreeNode(Integer.parseInt(arr[idx]));
                    queue.offer(parent.left);
                }
                idx++;
            }

            if (idx < arr.length) {
                if (!isNull(arr[idx])) {
                    parent.right = new TreeNode(Integer.parseInt(arr[idx]));
                    queue.offer(parent.right);
                }
                idx++;
            }
        }

        return root;
    }

    private static boolean isNull(String s) {
        return s == null || s.equals("-1") || s.equalsIgnoreCase("null") || s.equals("#");
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) return;
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
