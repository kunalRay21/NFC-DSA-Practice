/**
 * Problem: Reverse Nodes in k-Group (LeetCode 25)
 * Difficulty: Hard
 * Pattern: Linked-list pointer manipulation
 *
 * Input Format:
 * Line 1: An integer n denoting the number of nodes in the linked list.
 * Line 2: n space-separated integers representing node values.
 * Line 3: An integer k denoting the group size to reverse.
 *
 * Output Format:
 * Space-separated integers representing node values of the modified linked list.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(Integer.parseInt(st.nextToken()));
            curr = curr.next;
        }

        int k = Integer.parseInt(br.readLine().trim());
        ListNode head = reverseKGroup(dummy.next, k);

        StringBuilder sb = new StringBuilder();
        curr = head;
        boolean first = true;
        while (curr != null) {
            if (!first) sb.append(" ");
            sb.append(curr.val);
            first = false;
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        // Check if there are at least k nodes remaining
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the reversed head to the result of the rest of the list
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
