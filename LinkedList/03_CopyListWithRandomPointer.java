/**
 * Problem: Copy List with Random Pointer (LeetCode 138)
 * Difficulty: Medium
 * Pattern: HashMap / linked-list cloning
 *
 * Input Format:
 * Line 1: An integer n denoting the number of nodes in the linked list.
 * Following n lines: Each line contains two integers: `val random_index`,
 * where random_index is the 0-based index of the target node, or -1 if null.
 *
 * Output Format:
 * n lines representing the deep-copied list nodes in order: `val random_index` (or "null" if random is null).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
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

        List<Node> originalNodes = new ArrayList<>();
        int[] randomIndices = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int randIdx = Integer.parseInt(st.nextToken());
            originalNodes.add(new Node(val));
            randomIndices[i] = randIdx;
        }

        // Connect next and random pointers
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                originalNodes.get(i).next = originalNodes.get(i + 1);
            }
            if (randomIndices[i] != -1) {
                originalNodes.get(i).random = originalNodes.get(randomIndices[i]);
            }
        }

        Node head = originalNodes.get(0);
        Node clonedHead = copyRandomList(head);

        // Map cloned nodes to their 0-based indices for verifying output
        Map<Node, Integer> clonedIndexMap = new HashMap<>();
        Node curr = clonedHead;
        int idx = 0;
        while (curr != null) {
            clonedIndexMap.put(curr, idx++);
            curr = curr.next;
        }

        curr = clonedHead;
        while (curr != null) {
            String randStr = (curr.random == null) ? "null" : String.valueOf(clonedIndexMap.get(curr.random));
            System.out.println(curr.val + " " + randStr);
            curr = curr.next;
        }
    }

    private static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // First pass: create all cloned nodes
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next and random references
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
