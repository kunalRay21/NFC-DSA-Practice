/**
 * Problem: Reverse Nodes in k-Group (LeetCode 25)
 * Difficulty: Hard
 * Pattern: Linked-list pointer manipulation
 *
 * Input Formats Supported:
 * Format 1 (LeetCode):    Line 1: [1, 2, 3, 4, 5], Line 2: 2 (or k = 2)
 * Format 2 (Competitive): Line 1: n, Line 2: n values, Line 3: k
 * Format 3 (Raw Values):  Line 1: 1 2 3 4 5, Line 2: 2
 *
 * Output Format:
 * Space-separated integers representing node values of the modified linked list.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> values = readIntList(br);
        if (values.isEmpty()) return;

        String kLine = br.readLine();
        while (kLine != null && kLine.trim().isEmpty()) {
            kLine = br.readLine();
        }
        if (kLine == null) return;
        kLine = kLine.replaceAll("[a-zA-Z]+\\s*=", " ").trim();
        int k = Integer.parseInt(new StringTokenizer(kLine).nextToken());

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }

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

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
