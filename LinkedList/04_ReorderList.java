/**
 * Problem: Reorder List (LeetCode 143)
 * Difficulty: Medium
 * Pattern: Fast/slow + reverse + merge
 *
 * Input Format:
 * Line 1: An integer n denoting the number of nodes in the linked list.
 * Line 2: n space-separated integers.
 *
 * Output Format:
 * Space-separated integers representing the reordered linked list (L0 -> Ln -> L1 -> Ln-1 -> ...).
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

        ListNode head = dummy.next;
        reorderList(head);

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

    private static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        // Step 1: Find the middle using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = slow.next;
        slow.next = null; // Split the two halves

        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHalf = prev;

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode t1 = firstHalf.next;
            ListNode t2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = t1;

            firstHalf = t1;
            secondHalf = t2;
        }
    }
}
