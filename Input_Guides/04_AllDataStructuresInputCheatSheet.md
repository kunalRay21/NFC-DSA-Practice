# 📝 All Data Structures Input Cheat Sheet (VS Code / OA Exam Edition)

When coding in VS Code or during technical interviews, you often need to write input parsing code from scratch in under 60 seconds.

Use this cheat sheet to quickly grab the exact input pattern you need.

---

## 1. 🌲 Trees (Binary Tree from Level-Order)

### Quickest Scanner Pattern (Unsized tokens or single line):
```java
Scanner sc = new Scanner(System.in);
String line = sc.nextLine().replace("[", " ").replace("]", " ").replace(",", " ").trim();
String[] tokens = line.split("\\s+");

TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
Queue<TreeNode> q = new ArrayDeque<>();
q.offer(root);
int i = 1;

while (!q.isEmpty() && i < tokens.length) {
    TreeNode curr = q.poll();
    if (i < tokens.length && !tokens[i].equals("null") && !tokens[i].equals("-1")) {
        curr.left = new TreeNode(Integer.parseInt(tokens[i]));
        q.offer(curr.left);
    }
    i++;
    if (i < tokens.length && !tokens[i].equals("null") && !tokens[i].equals("-1")) {
        curr.right = new TreeNode(Integer.parseInt(tokens[i]));
        q.offer(curr.right);
    }
    i++;
}
```

---

## 2. 🔗 Linked Lists

### Quickest Scanner Pattern:
```java
// Handles: "1 2 3 4 5" or "[1, 2, 3, 4, 5]" or "5\n1 2 3 4 5"
Scanner sc = new Scanner(System.in);
String line = sc.nextLine().replace("[", " ").replace("]", " ").replace(",", " ").trim();
String[] tokens = line.split("\\s+");

ListNode dummy = new ListNode(0);
ListNode curr = dummy;
for (String t : tokens) {
    if (!t.isEmpty()) {
        curr.next = new ListNode(Integer.parseInt(t));
        curr = curr.next;
    }
}
ListNode head = dummy.next;
```

---

## 3. 🕸️ Graphs

### Pattern A: Edge List (numNodes, numEdges followed by u v pairs)
```text
4 4
0 1
1 2
2 3
3 0
```
```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int m = sc.nextInt();

List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

for (int i = 0; i < m; i++) {
    int u = sc.nextInt();
    int v = sc.nextInt();
    adj.get(u).add(v);
    adj.get(v).add(u); // Remove if directed graph
}
```

### Pattern B: 2D Grid / Matrix
```text
3 3
1 1 0
1 1 0
0 0 1
```
```java
Scanner sc = new Scanner(System.in);
int rows = sc.nextInt();
int cols = sc.nextInt();

int[][] grid = new int[rows][cols];
for (int r = 0; r < rows; r++) {
    for (int c = 0; c < cols; c++) {
        grid[r][c] = sc.nextInt();
    }
}
```

### Pattern C: Character Grid (e.g., Number of Islands)
```java
Scanner sc = new Scanner(System.in);
int rows = sc.nextInt();
int cols = sc.nextInt();

char[][] grid = new char[rows][cols];
for (int r = 0; r < rows; r++) {
    String rowStr = sc.next(); // Reads string like "11000"
    for (int c = 0; c < cols; c++) {
        grid[r][c] = rowStr.charAt(c);
    }
}
```

---

## 4. 🔢 Arrays & Integers

### Pattern A: Count `n` followed by space-separated integers
```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] nums = new int[n];
for (int i = 0; i < n; i++) {
    nums[i] = sc.nextInt();
}
```

### Pattern B: Unknown number of integers on a single line
```java
Scanner sc = new Scanner(System.in);
String line = sc.nextLine().trim();
String[] parts = line.split("\\s+");
int[] nums = new int[parts.length];
for (int i = 0; i < parts.length; i++) {
    nums[i] = Integer.parseInt(parts[i]);
}
```

### Pattern C: LeetCode Bracket Array `[1, 2, 3, 4, 5]`
```java
Scanner sc = new Scanner(System.in);
String line = sc.nextLine().replace("[", "").replace("]", "").replace(",", " ").trim();
String[] parts = line.split("\\s+");
int[] nums = new int[parts.length];
for (int i = 0; i < parts.length; i++) {
    nums[i] = Integer.parseInt(parts[i]);
}
```

---

## 💡 Top 3 Exam Traps to Avoid

1. **`sc.nextInt()` followed by `sc.nextLine()` trap:**
   If you do `sc.nextInt()` and then `sc.nextLine()`, the `nextLine()` will consume the trailing newline character `\n` left by `nextInt()` and return an empty string!
   *Fix:* Call a dummy `sc.nextLine()` immediately after `sc.nextInt()`:
   ```java
   int n = sc.nextInt();
   sc.nextLine(); // Discard newline!
   String text = sc.nextLine();
   ```

2. **Negative values vs `-1` as null:**
   If a tree node can have a value of `-1` (like LeetCode 124 Maximum Path Sum where values can be `-10`), `-1` cannot be used to represent null.
   *Fix:* Use the literal string `"null"` or `#` as your null sentinel.

3. **Performance for $N \ge 10^5$:**
   If $N > 100,000$, `Scanner` can be slow (~1-2 seconds) because of internal regex synchronization.
   *Fix:* Switch to `BufferedReader` + `StringTokenizer`:
   ```java
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer(br.readLine());
   int x = Integer.parseInt(st.nextToken());
   ```
