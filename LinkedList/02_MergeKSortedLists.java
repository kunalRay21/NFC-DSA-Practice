/**
 * Problem: Merge k Sorted Lists (LeetCode 23)
 * Difficulty: Hard
 * Pattern: PriorityQueue / divide and conquer
 *
 * Input Format:
 * Line 1: An integer k denoting the number of sorted linked lists.
 * For each of the k lists:
 *   Line A: An integer m denoting the number of nodes in this list.
 *   Line B: m space-separated integers (present only if m > 0).
 *
 * Output Format:
 * Space-separated integers representing the merged sorted linked list.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
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

        int k = Integer.parseInt(line.trim());
        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            String mLine = br.readLine();
            while (mLine != null && mLine.trim().isEmpty()) {
                mLine = br.readLine();
            }
            if (mLine == null) break;

            int m = Integer.parseInt(mLine.trim());
            if (m > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ListNode dummy = new ListNode(0);
                ListNode curr = dummy;
                for (int j = 0; j < m; j++) {
                    curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                    curr = curr.next;
                }
                lists[i] = dummy.next;
            } else {
                lists[i] = null;
            }
        }

        ListNode mergedHead = mergeKLists(lists);

        StringBuilder sb = new StringBuilder();
        ListNode curr = mergedHead;
        boolean first = true;
        while (curr != null) {
            if (!first) sb.append(" ");
            sb.append(curr.val);
            first = false;
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
