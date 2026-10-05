/**
 * Problem: Palindrome Linked List (LeetCode 234)
 * Difficulty: Easy/Medium
 * Pattern: Fast/slow + reverse
 *
 * Input Format:
 * Line 1: An integer n denoting the number of nodes in the linked list.
 * Line 2: n space-separated integers.
 *
 * Output Format:
 * true if the linked list is a palindrome, false otherwise.
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
            System.out.println(true);
            return;
        }

        int n = Integer.parseInt(line.trim());
        if (n <= 1) {
            System.out.println(true);
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
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = reverseList(slow.next);

        // Step 3: Compare first and second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore list (good practice)
        slow.next = reverseList(secondHalf);

        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
