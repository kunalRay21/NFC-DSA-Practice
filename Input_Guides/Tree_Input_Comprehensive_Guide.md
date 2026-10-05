# 🌲 The Complete Guide to Tree Inputs in Java

When preparing for technical exams in VS Code, one of the most common hurdles is: **"How do I take tree input from stdin and construct the binary tree?"**

In platforms like LeetCode, the tree is already built behind the scenes. In an actual terminal / VS Code exam, **you must read the raw input and construct the tree yourself**.

This guide covers all common scenarios you will face, including using `Scanner`, handling unsized tokens, arrays, and LeetCode-style brackets.

---

## 🧠 Core Mental Model: The BFS Queue

Binary trees are almost always serialized in **Level-Order (Breadth-First)** sequence:
```text
        1
       / \
      2   3
         / \
        4   5

Level-order: [1, 2, 3, null, null, 4, 5]
```

### Why a Queue?
A queue tracks **parents whose children haven't been assigned yet**:
1. Take the first value -> make it the `root` -> push `root` to `queue`.
2. While the queue is not empty and more values remain:
   - Pop the current parent `node = queue.poll()`.
   - The **next value** belongs to `node.left`. If not null, create `node.left` and push it to `queue`.
   - The **following value** belongs to `node.right`. If not null, create `node.right` and push it to `queue`.
3. Repeat until all input tokens are consumed.

---

## ❓ Question: "Can we do it using Scanner too? Right?"

### **YES! Absolutely.**
`Scanner` is often the **most comfortable and intuitive** choice during interviews because:
- No checked exception declarations (`throws IOException` is not required).
- It automatically splits tokens by any whitespace (spaces, tabs, newlines).
- It has convenient helper methods: `sc.hasNext()`, `sc.next()`, `sc.nextInt()`, `sc.nextLine()`.

Here is how you use `Scanner` in different exam situations:

---

## 📋 Scenario 1: Unsized Integers / Unknown Length on stdin

When the problem doesn't give you `n` (the count), and just streams tokens like:
```text
1 2 3 -1 -1 4 5
```
Or with `"null"`:
```text
1 2 3 null null 4 5
```

### Approach A: Reading line-by-line with `Scanner`
This is the safest method when input is on a single line:

```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class TreeFromLineScanner {
    public static TreeNode buildTree(String line) {
        if (line == null || line.trim().isEmpty()) return null;

        // Split line into tokens by whitespace
        String[] tokens = line.trim().split("\\s+");
        if (tokens.length == 0 || isNull(tokens[0])) return null;

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.length) {
            TreeNode curr = queue.poll();

            // Assign Left Child
            if (idx < tokens.length) {
                if (!isNull(tokens[idx])) {
                    curr.left = new TreeNode(Integer.parseInt(tokens[idx]));
                    queue.offer(curr.left);
                }
                idx++;
            }

            // Assign Right Child
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
        return token.equals("-1") || token.equalsIgnoreCase("null") || token.equals("#");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            TreeNode root = buildTree(line);
            // Now run your tree algorithm on root!
        }
        sc.close();
    }
}
```

---

## 📋 Scenario 2: When an Array is Given

In some questions, the input is already provided as an array in code or as a test harness parameter:

### Case 2A: `Integer[]` array (with actual `null` values)
```java
Integer[] arr = {1, 2, 3, null, null, 4, 5};

public static TreeNode buildTreeFromIntegerArray(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) return null;

    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int idx = 1;

    while (!queue.isEmpty() && idx < arr.length) {
        TreeNode curr = queue.poll();

        // Left child
        if (idx < arr.length) {
            if (arr[idx] != null) {
                curr.left = new TreeNode(arr[idx]);
                queue.offer(curr.left);
            }
            idx++;
        }

        // Right child
        if (idx < arr.length) {
            if (arr[idx] != null) {
                curr.right = new TreeNode(arr[idx]);
                queue.offer(curr.right);
            }
            idx++;
        }
    }
    return root;
}
```

### Case 2B: Primitive `int[]` array (using `-1` as null)
```java
int[] arr = {1, 2, 3, -1, -1, 4, 5};

public static TreeNode buildTreeFromIntArray(int[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == -1) return null;

    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int idx = 1;

    while (!queue.isEmpty() && idx < arr.length) {
        TreeNode curr = queue.poll();

        if (idx < arr.length) {
            if (arr[idx] != -1) {
                curr.left = new TreeNode(arr[idx]);
                queue.offer(curr.left);
            }
            idx++;
        }

        if (idx < arr.length) {
            if (arr[idx] != -1) {
                curr.right = new TreeNode(arr[idx]);
                queue.offer(curr.right);
            }
            idx++;
        }
    }
    return root;
}
```

---

## 📋 Scenario 3: LeetCode-Style Bracketed String

Often in exams or copy-pasting test cases, you get:
```text
[1, 2, 3, null, null, 4, 5]
```
or
```text
root = [3, 9, 20, null, null, 15, 7]
```

### The 2-Line Sanitizer Trick
Just sanitize the string into clean space-separated tokens by stripping brackets and commas:

```java
public static TreeNode buildTreeFromBracketedString(String input) {
    if (input == null || input.trim().isEmpty()) return null;

    // Strip "root = " if present
    if (input.contains("=")) {
        input = input.substring(input.indexOf('=') + 1);
    }

    // Replace [ ] and commas with spaces
    String sanitized = input.replace("[", " ")
                            .replace("]", " ")
                            .replace(",", " ")
                            .trim();

    if (sanitized.isEmpty()) return null;

    // Now it's just regular tokens!
    return buildTree(sanitized);
}
```

---

## 📋 Scenario 4: Competitive Programming Format (`n` then tokens)

```text
7
1 2 3 -1 -1 4 5
```

```java
Scanner sc = new Scanner(System.in);
if (sc.hasNextInt()) {
    int n = sc.nextInt();
    String[] tokens = new String[n];
    for (int i = 0; i < n; i++) {
        tokens[i] = sc.next();
    }
    TreeNode root = buildTreeFromTokens(tokens);
}
```

---

## ⚡ Comparison: `Scanner` vs `BufferedReader`

| Feature | `Scanner` | `BufferedReader` + `StringTokenizer` |
| :--- | :--- | :--- |
| **Speed** | Moderate (parses regex internally) | **Extremely Fast** (reads raw character blocks) |
| **Input Scale** | Up to ~50,000 integers | Easily handles 1,000,000+ integers |
| **Ease of Use** | **Very Easy** (`sc.next()`, `sc.nextInt()`) | Requires `StringTokenizer` and `readLine()` |
| **Exception** | No `throws` required | Requires `throws IOException` |
| **Best Used For** | Typical interview rounds, VS Code OAs | Strict competitive programming / huge I/O |

> **Interview Recommendation**: For an NFC / VS Code interview, `Scanner` is 100% fine and fast enough because tree test cases rarely exceed a few thousand nodes! Use whichever you write fastest under pressure.
