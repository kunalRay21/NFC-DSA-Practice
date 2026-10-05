# NFC DSA Practice Repository

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17+" />
  <img src="https://img.shields.io/badge/Total%20Problems-45%20Completed-brightgreen?style=for-the-badge" alt="45 Problems" />
  <img src="https://img.shields.io/badge/Environment-VS%20Code%20%7C%20Terminal-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white" alt="VS Code" />
  <img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="MIT License" />
</p>

A clean, standalone Java practice repository designed for technical coding assessments and VS Code coding rounds.

Every problem is an independent, complete console application reading from `stdin` and outputting to `stdout`.

---

## 📚 Essential Input Guides & Cheat Sheets

Before coding in VS Code or an exam, check the dedicated **[`Input_Guides/`](Input_Guides/)** folder:

- 🌲 **[Tree Input Comprehensive Guide](Input_Guides/Tree_Input_Comprehensive_Guide.md)**: Detailed guide answering how to parse trees using `Scanner`, from arrays (`Integer[]` and `int[]`), unsized integers, and LeetCode-style brackets.
- 📝 **[All Data Structures Input Cheat Sheet](Input_Guides/04_AllDataStructuresInputCheatSheet.md)**: Quick-copy input templates for Trees, Graphs, Linked Lists, Arrays, and Grids.
- 💻 **Runnable Demo Programs**:
  - [`01_TreeInputUsingScanner.java`](Input_Guides/01_TreeInputUsingScanner.java) — Takes tree input using `Scanner`.
  - [`02_TreeInputFromArray.java`](Input_Guides/02_TreeInputFromArray.java) — Builds a tree from arrays.
  - [`03_TreeInputFromBracketedString.java`](Input_Guides/03_TreeInputFromBracketedString.java) — Parses `[1, 2, 3, null, null, 4, 5]`.

---

## 🛠️ How to Run in VS Code / Terminal

### Option 1: Direct Run (Java 17+)
Modern Java allows you to execute single `.java` source files directly:

```bash
# Direct run with interactive stdin
java Arrays/01_TrappingRainWater.java

# Or pipe input from a file or terminal
java Arrays/01_TrappingRainWater.java < input.txt
```

### Option 2: In VS Code Editor
- Open any `.java` file in VS Code.
- Click the **Run** button at the top-right corner (or press `F5` / `Ctrl+F5`).

---

## 📊 Complete 45-Problem Master Matrix

| # | Problem | Category | Difficulty | Pattern | Input Format (stdin) | Source File |
| :-: | :--- | :--- | :-: | :--- | :--- | :--- |
| 1 | Trapping Rain Water | Array | 🔴 Hard | Two Pointers / Prefix Max | Line 1: `n`, Line 2: array | [`Arrays/01_TrappingRainWater.java`](Arrays/01_TrappingRainWater.java) |
| 2 | First Missing Positive | Array | 🔴 Hard | Cyclic Placement | Line 1: `n`, Line 2: array | [`Arrays/02_FirstMissingPositive.java`](Arrays/02_FirstMissingPositive.java) |
| 3 | Maximum Product Subarray | Array | 🟡 Med/Hard | Kadane Min/Max | Line 1: `n`, Line 2: array | [`Arrays/03_MaximumProductSubarray.java`](Arrays/03_MaximumProductSubarray.java) |
| 4 | Subarray Sum Equals K | Array | 🟡 Medium | Prefix Sum + HashMap | Line 1: `n`, Line 2: array, Line 3: `k` | [`Arrays/04_SubarraySumEqualsK.java`](Arrays/04_SubarraySumEqualsK.java) |
| 5 | Sliding Window Maximum | Array | 🔴 Hard | Monotonic Deque | Line 1: `n`, Line 2: array, Line 3: `k` | [`Arrays/05_SlidingWindowMaximum.java`](Arrays/05_SlidingWindowMaximum.java) |
| 6 | Find Duplicate Number | Array | 🟡 Medium | Floyd's Cycle Detection | Line 1: `n`, Line 2: array | [`Arrays/06_FindDuplicateNumber.java`](Arrays/06_FindDuplicateNumber.java) |
| 7 | Search in Rotated Array II | Array | 🟡 Medium | Modified Binary Search | Line 1: `n`, Line 2: array, Line 3: `target` | [`Arrays/07_SearchInRotatedSortedArrayII.java`](Arrays/07_SearchInRotatedSortedArrayII.java) |
| 8 | Largest Rectangle in Histogram | Array | 🔴 Hard | Monotonic Stack | Line 1: `n`, Line 2: heights | [`Arrays/08_LargestRectangleInHistogram.java`](Arrays/08_LargestRectangleInHistogram.java) |
| 9 | Minimum Window Substring | String | 🔴 Hard | Sliding Window + Map | Line 1: `s`, Line 2: `t` | [`Strings/01_MinimumWindowSubstring.java`](Strings/01_MinimumWindowSubstring.java) |
| 10 | Longest Substring No Repeat | String | 🟡 Medium | Sliding Window + Map | Line 1: `s` | [`Strings/02_LongestSubstringWithoutRepeatingCharacters.java`](Strings/02_LongestSubstringWithoutRepeatingCharacters.java) |
| 11 | Longest Repeating Char Replacement | String | 🟡 Medium | Sliding Window + Freq | Line 1: `s`, Line 2: `k` | [`Strings/03_LongestRepeatingCharacterReplacement.java`](Strings/03_LongestRepeatingCharacterReplacement.java) |
| 12 | Group Anagrams | String | 🟡 Medium | Hashing / Canonical Form | Line 1: `n`, Line 2: space-separated words | [`Strings/04_GroupAnagrams.java`](Strings/04_GroupAnagrams.java) |
| 13 | Palindromic Substrings | String | 🟡 Medium | DP / Expand Around Center | Line 1: `s` | [`Strings/05_PalindromicSubstrings.java`](Strings/05_PalindromicSubstrings.java) |
| 14 | Longest Palindromic Substring | String | 🟡 Medium | DP / Expand Around Center | Line 1: `s` | [`Strings/06_LongestPalindromicSubstring.java`](Strings/06_LongestPalindromicSubstring.java) |
| 15 | Reverse Nodes in k-Group | Linked List | 🔴 Hard | Pointer Manipulation | Line 1: `n`, Line 2: values, Line 3: `k` | [`LinkedList/01_ReverseNodesInKGroup.java`](LinkedList/01_ReverseNodesInKGroup.java) |
| 16 | Merge k Sorted Lists | Linked List | 🔴 Hard | PriorityQueue / D&C | Line 1: `k`, for each list: count `m` then `m` values | [`LinkedList/02_MergeKSortedLists.java`](LinkedList/02_MergeKSortedLists.java) |
| 17 | Copy List Random Pointer | Linked List | 🟡 Medium | HashMap / Node Cloning | Line 1: `n`, next `n` lines: `val random_idx` | [`LinkedList/03_CopyListWithRandomPointer.java`](LinkedList/03_CopyListWithRandomPointer.java) |
| 18 | Reorder List | Linked List | 🟡 Medium | Fast/Slow + Reverse + Merge | Line 1: `n`, Line 2: values | [`LinkedList/04_ReorderList.java`](LinkedList/04_ReorderList.java) |
| 19 | Palindrome Linked List | Linked List | 🟢 Easy/Med | Fast/Slow + Reverse | Line 1: `n`, Line 2: values | [`LinkedList/05_PalindromeLinkedList.java`](LinkedList/05_PalindromeLinkedList.java) |
| 20 | Binary Tree Level Order | Trees | 🟡 Medium | BFS (Queue) | Line 1: `n`, Line 2: `n` tokens (`-1` or `null` for null) | [`Trees/01_LevelOrderTraversal.java`](Trees/01_LevelOrderTraversal.java) |
| 21 | Lowest Common Ancestor | Trees | 🟡 Medium | DFS Recursion | Line 1: `n`, Line 2: tokens, Line 3: `p q` | [`Trees/02_LowestCommonAncestor.java`](Trees/02_LowestCommonAncestor.java) |
| 22 | Tree Maximum Path Sum | Trees | 🔴 Hard | DFS + Tree DP | Line 1: `n`, Line 2: tokens (`null` or `-1`) | [`Trees/03_BinaryTreeMaximumPathSum.java`](Trees/03_BinaryTreeMaximumPathSum.java) |
| 23 | Serialize & Deserialize Tree | Trees | 🔴 Hard | DFS/BFS Serialization | Line 1: `n`, Line 2: tokens | [`Trees/04_SerializeDeserializeBinaryTree.java`](Trees/04_SerializeDeserializeBinaryTree.java) |
| 24 | Construct Tree (Pre & In) | Trees | 🟡 Medium | Recursion + HashMap | Line 1: `n`, Line 2: preorder, Line 3: inorder | [`Trees/05_ConstructBinaryTreeFromPreorderInorder.java`](Trees/05_ConstructBinaryTreeFromPreorderInorder.java) |
| 25 | Number of Islands | Graphs | 🟡 Medium | DFS / BFS Flood Fill | Line 1: `rows cols`, next `rows` lines: grid values | [`Graphs/01_NumberOfIslands.java`](Graphs/01_NumberOfIslands.java) |
| 26 | Course Schedule | Graphs | 🟡 Medium | TopoSort (Kahn's) | Line 1: `numCourses m`, next `m` lines: `u v` | [`Graphs/02_CourseSchedule.java`](Graphs/02_CourseSchedule.java) |
| 27 | Rotting Oranges | Graphs | 🟡 Medium | Multi-source BFS | Line 1: `rows cols`, next `rows` lines: grid values | [`Graphs/03_RottingOranges.java`](Graphs/03_RottingOranges.java) |
| 28 | Number of Provinces | Graphs | 🟡 Medium | DFS / BFS / DSU | Line 1: `n`, next `n` lines: `n x n` matrix | [`Graphs/04_NumberOfProvinces.java`](Graphs/04_NumberOfProvinces.java) |
| 29 | Subsets | Recursion | 🟡 Medium | Backtracking | Line 1: `n`, Line 2: array | [`Recursion_DP/01_Subsets.java`](Recursion_DP/01_Subsets.java) |
| 30 | Permutations | Recursion | 🟡 Medium | Backtracking | Line 1: `n`, Line 2: array | [`Recursion_DP/02_Permutations.java`](Recursion_DP/02_Permutations.java) |
| 31 | Combination Sum | Recursion | 🟡 Medium | Backtracking / Pruning | Line 1: `n`, Line 2: candidates, Line 3: `target` | [`Recursion_DP/03_CombinationSum.java`](Recursion_DP/03_CombinationSum.java) |
| 32 | N-Queens | Recursion | 🔴 Hard | Backtracking + Bitsets | Line 1: `n` | [`Recursion_DP/04_NQueens.java`](Recursion_DP/04_NQueens.java) |
| 33 | House Robber | DP | 🟡 Medium | 1D DP | Line 1: `n`, Line 2: array | [`Recursion_DP/05_HouseRobber.java`](Recursion_DP/05_HouseRobber.java) |
| 34 | House Robber II | DP | 🟡 Medium | Circular DP | Line 1: `n`, Line 2: array | [`Recursion_DP/06_HouseRobberII.java`](Recursion_DP/06_HouseRobberII.java) |
| 35 | Coin Change | DP | 🟡 Medium | Unbounded Knapsack | Line 1: `n`, Line 2: coins, Line 3: `amount` | [`Recursion_DP/07_CoinChange.java`](Recursion_DP/07_CoinChange.java) |
| 36 | Partition Equal Subset Sum | DP | 🟡 Medium | 0/1 Knapsack | Line 1: `n`, Line 2: array | [`Recursion_DP/08_PartitionEqualSubsetSum.java`](Recursion_DP/08_PartitionEqualSubsetSum.java) |
| 37 | Longest Increasing Subsequence | DP | 🟡 Medium | Subsequence DP O(N log N) | Line 1: `n`, Line 2: array | [`Recursion_DP/09_LongestIncreasingSubsequence.java`](Recursion_DP/09_LongestIncreasingSubsequence.java) |
| 38 | Longest Common Subsequence | DP | 🟡 Medium | 2D DP | Line 1: `text1`, Line 2: `text2` | [`Recursion_DP/10_LongestCommonSubsequence.java`](Recursion_DP/10_LongestCommonSubsequence.java) |
| 39 | Edit Distance | DP | 🔴 Hard | 2D String DP | Line 1: `word1`, Line 2: `word2` | [`Recursion_DP/11_EditDistance.java`](Recursion_DP/11_EditDistance.java) |
| 40 | Unique Paths | DP | 🟡 Medium | Grid DP | Line 1: `m n` | [`Recursion_DP/12_UniquePaths.java`](Recursion_DP/12_UniquePaths.java) |
| 41 | Word Break | DP | 🟡 Medium | String DP + HashSet | Line 1: `s`, Line 2: `k`, Line 3: `k` words | [`Recursion_DP/13_WordBreak.java`](Recursion_DP/13_WordBreak.java) |
| 42 | Decode Ways | DP | 🟡 Medium | 1D DP | Line 1: digits string | [`Recursion_DP/14_DecodeWays.java`](Recursion_DP/14_DecodeWays.java) |
| 43 | Target Sum | DP | 🟡 Medium | 0/1 Subset Sum DP | Line 1: `n`, Line 2: array, Line 3: `target` | [`Recursion_DP/15_TargetSum.java`](Recursion_DP/15_TargetSum.java) |
| 44 | Distinct Subsequences | DP | 🔴 Hard | 2D String DP | Line 1: `s`, Line 2: `t` | [`Recursion_DP/16_DistinctSubsequences.java`](Recursion_DP/16_DistinctSubsequences.java) |
| 45 | Burst Balloons | DP | 🔴 Hard | Interval DP | Line 1: `n`, Line 2: array | [`Recursion_DP/17_BurstBalloons.java`](Recursion_DP/17_BurstBalloons.java) |

---

## 📋 Detailed Problem Catalog & Sample I/O

---

### 🔴 ARRAYS (8 Problems)

#### 1. Trapping Rain Water (LeetCode 42)
- **Difficulty**: Hard
- **Pattern**: Two pointers / prefix maximum
- **File**: [`Arrays/01_TrappingRainWater.java`](Arrays/01_TrappingRainWater.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  12
  0 1 0 2 1 0 1 3 2 1 2 1
  ```
- **Sample Output**:
  ```text
  6
  ```

#### 2. First Missing Positive (LeetCode 41)
- **Difficulty**: Hard
- **Pattern**: In-place array manipulation / cyclic placement
- **File**: [`Arrays/02_FirstMissingPositive.java`](Arrays/02_FirstMissingPositive.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  4
  3 4 -1 1
  ```
- **Sample Output**:
  ```text
  2
  ```

#### 3. Maximum Product Subarray (LeetCode 152)
- **Difficulty**: Medium/Hard
- **Pattern**: Kadane variation / tracking minimum and maximum
- **File**: [`Arrays/03_MaximumProductSubarray.java`](Arrays/03_MaximumProductSubarray.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  4
  2 3 -2 4
  ```
- **Sample Output**:
  ```text
  6
  ```

#### 4. Subarray Sum Equals K (LeetCode 560)
- **Difficulty**: Medium
- **Pattern**: Prefix sum + HashMap
- **File**: [`Arrays/04_SubarraySumEqualsK.java`](Arrays/04_SubarraySumEqualsK.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
  - Line 3: `k`
- **Sample Input**:
  ```text
  3
  1 1 1
  2
  ```
- **Sample Output**:
  ```text
  2
  ```

#### 5. Sliding Window Maximum (LeetCode 239)
- **Difficulty**: Hard
- **Pattern**: Monotonic deque
- **File**: [`Arrays/05_SlidingWindowMaximum.java`](Arrays/05_SlidingWindowMaximum.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
  - Line 3: `k`
- **Sample Input**:
  ```text
  8
  1 3 -1 -3 5 3 6 7
  3
  ```
- **Sample Output**:
  ```text
  3 3 5 5 6 7
  ```

#### 6. Find the Duplicate Number (LeetCode 287)
- **Difficulty**: Medium
- **Pattern**: Floyd's cycle detection
- **File**: [`Arrays/06_FindDuplicateNumber.java`](Arrays/06_FindDuplicateNumber.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  5
  1 3 4 2 2
  ```
- **Sample Output**:
  ```text
  2
  ```

#### 7. Search in Rotated Sorted Array II (LeetCode 81)
- **Difficulty**: Medium
- **Pattern**: Modified binary search
- **File**: [`Arrays/07_SearchInRotatedSortedArrayII.java`](Arrays/07_SearchInRotatedSortedArrayII.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
  - Line 3: `target`
- **Sample Input**:
  ```text
  7
  2 5 6 0 0 1 2
  0
  ```
- **Sample Output**:
  ```text
  true
  ```

#### 8. Largest Rectangle in Histogram (LeetCode 84)
- **Difficulty**: Hard
- **Pattern**: Monotonic stack
- **File**: [`Arrays/08_LargestRectangleInHistogram.java`](Arrays/08_LargestRectangleInHistogram.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  6
  2 1 5 6 2 3
  ```
- **Sample Output**:
  ```text
  10
  ```

---

### 🔴 STRINGS (6 Problems)

#### 9. Minimum Window Substring (LeetCode 76)
- **Difficulty**: Hard
- **Pattern**: Sliding window + frequency map
- **File**: [`Strings/01_MinimumWindowSubstring.java`](Strings/01_MinimumWindowSubstring.java)
- **Input Format**:
  - Line 1: `s`
  - Line 2: `t`
- **Sample Input**:
  ```text
  ADOBECODEBANC
  ABC
  ```
- **Sample Output**:
  ```text
  BANC
  ```

#### 10. Longest Substring Without Repeating Characters (LeetCode 3)
- **Difficulty**: Medium
- **Pattern**: Sliding window + HashMap / frequency
- **File**: [`Strings/02_LongestSubstringWithoutRepeatingCharacters.java`](Strings/02_LongestSubstringWithoutRepeatingCharacters.java)
- **Input Format**:
  - Line 1: `s`
- **Sample Input**:
  ```text
  abcabcbb
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 11. Longest Repeating Character Replacement (LeetCode 424)
- **Difficulty**: Medium
- **Pattern**: Sliding window + frequency
- **File**: [`Strings/03_LongestRepeatingCharacterReplacement.java`](Strings/03_LongestRepeatingCharacterReplacement.java)
- **Input Format**:
  - Line 1: `s`
  - Line 2: `k`
- **Sample Input**:
  ```text
  AABABBA
  1
  ```
- **Sample Output**:
  ```text
  4
  ```

#### 12. Group Anagrams (LeetCode 49)
- **Difficulty**: Medium
- **Pattern**: Hashing
- **File**: [`Strings/04_GroupAnagrams.java`](Strings/04_GroupAnagrams.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated strings
- **Sample Input**:
  ```text
  6
  eat tea tan ate nat bat
  ```
- **Sample Output**:
  ```text
  [bat]
  [eat, tea, ate]
  [tan, nat]
  ```

#### 13. Palindromic Substrings (LeetCode 647)
- **Difficulty**: Medium
- **Pattern**: DP / expand around center
- **File**: [`Strings/05_PalindromicSubstrings.java`](Strings/05_PalindromicSubstrings.java)
- **Input Format**:
  - Line 1: `s`
- **Sample Input**:
  ```text
  aaa
  ```
- **Sample Output**:
  ```text
  6
  ```

#### 14. Longest Palindromic Substring (LeetCode 5)
- **Difficulty**: Medium
- **Pattern**: DP / expand around center
- **File**: [`Strings/06_LongestPalindromicSubstring.java`](Strings/06_LongestPalindromicSubstring.java)
- **Input Format**:
  - Line 1: `s`
- **Sample Input**:
  ```text
  babad
  ```
- **Sample Output**:
  ```text
  bab
  ```

---

### 🔴 LINKED LIST (5 Problems)

#### 15. Reverse Nodes in k-Group (LeetCode 25)
- **Difficulty**: Hard
- **Pattern**: Linked-list pointer manipulation
- **File**: [`LinkedList/01_ReverseNodesInKGroup.java`](LinkedList/01_ReverseNodesInKGroup.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
  - Line 3: `k`
- **Sample Input**:
  ```text
  5
  1 2 3 4 5
  2
  ```
- **Sample Output**:
  ```text
  2 1 4 3 5
  ```

#### 16. Merge k Sorted Lists (LeetCode 23)
- **Difficulty**: Hard
- **Pattern**: PriorityQueue / divide and conquer
- **File**: [`LinkedList/02_MergeKSortedLists.java`](LinkedList/02_MergeKSortedLists.java)
- **Input Format**:
  - Line 1: `k`
  - For each list: count `m` followed by `m` space-separated values
- **Sample Input**:
  ```text
  3
  3
  1 4 5
  3
  1 3 4
  2
  2 6
  ```
- **Sample Output**:
  ```text
  1 1 2 3 4 4 5 6
  ```

#### 17. Copy List with Random Pointer (LeetCode 138)
- **Difficulty**: Medium
- **Pattern**: HashMap / node cloning
- **File**: [`LinkedList/03_CopyListWithRandomPointer.java`](LinkedList/03_CopyListWithRandomPointer.java)
- **Input Format**:
  - Line 1: `n`
  - Next `n` lines: `val random_index` (-1 if null, 0-indexed)
- **Sample Input**:
  ```text
  5
  7 -1
  13 0
  11 4
  10 2
  1 0
  ```
- **Sample Output**:
  ```text
  7 null
  13 0
  11 4
  10 2
  1 0
  ```

#### 18. Reorder List (LeetCode 143)
- **Difficulty**: Medium
- **Pattern**: Fast/slow + reverse + merge
- **File**: [`LinkedList/04_ReorderList.java`](LinkedList/04_ReorderList.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  4
  1 2 3 4
  ```
- **Sample Output**:
  ```text
  1 4 2 3
  ```

#### 19. Palindrome Linked List (LeetCode 234)
- **Difficulty**: Easy/Medium
- **Pattern**: Fast/slow + reverse
- **File**: [`LinkedList/05_PalindromeLinkedList.java`](LinkedList/05_PalindromeLinkedList.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers
- **Sample Input**:
  ```text
  4
  1 2 2 1
  ```
- **Sample Output**:
  ```text
  true
  ```

---

### 🟡 TREES (5 Problems)

#### 20. Binary Tree Level Order Traversal (LeetCode 102)
- **Difficulty**: Medium
- **Pattern**: BFS
- **File**: [`Trees/01_LevelOrderTraversal.java`](Trees/01_LevelOrderTraversal.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated tokens (`-1` or `null` for empty)
- **Sample Input**:
  ```text
  7
  3 9 20 -1 -1 15 7
  ```
- **Sample Output**:
  ```text
  [3]
  [9, 20]
  [15, 7]
  ```

#### 21. Lowest Common Ancestor of a Binary Tree (LeetCode 236)
- **Difficulty**: Medium
- **Pattern**: DFS
- **File**: [`Trees/02_LowestCommonAncestor.java`](Trees/02_LowestCommonAncestor.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated tokens
  - Line 3: `p q`
- **Sample Input**:
  ```text
  11
  3 5 1 6 2 0 8 -1 -1 7 4
  5 1
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 22. Binary Tree Maximum Path Sum (LeetCode 124)
- **Difficulty**: Hard
- **Pattern**: DFS + tree DP
- **File**: [`Trees/03_BinaryTreeMaximumPathSum.java`](Trees/03_BinaryTreeMaximumPathSum.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated tokens (`null` or `-1`)
- **Sample Input**:
  ```text
  5
  -10 9 20 -1 -1 15 7
  ```
- **Sample Output**:
  ```text
  42
  ```

#### 23. Serialize and Deserialize Binary Tree (LeetCode 297)
- **Difficulty**: Hard
- **Pattern**: DFS/BFS serialization
- **File**: [`Trees/04_SerializeDeserializeBinaryTree.java`](Trees/04_SerializeDeserializeBinaryTree.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated tokens
- **Sample Input**:
  ```text
  5
  1 2 3 -1 -1 4 5
  ```
- **Sample Output**:
  ```text
  1,2,null,null,3,4,null,null,5,null,null
  [1, 2, 3, 4, 5]
  ```

#### 24. Construct Binary Tree from Preorder and Inorder (LeetCode 105)
- **Difficulty**: Medium
- **Pattern**: Recursion + HashMap
- **File**: [`Trees/05_ConstructBinaryTreeFromPreorderInorder.java`](Trees/05_ConstructBinaryTreeFromPreorderInorder.java)
- **Input Format**:
  - Line 1: `n`
  - Line 2: `n` space-separated integers (preorder)
  - Line 3: `n` space-separated integers (inorder)
- **Sample Input**:
  ```text
  5
  3 9 20 15 7
  9 3 15 20 7
  ```
- **Sample Output**:
  ```text
  3 9 20 -1 -1 15 7
  ```

---

### 🟡 GRAPHS (4 Problems)

#### 25. Number of Islands (LeetCode 200)
- **Difficulty**: Medium
- **Pattern**: DFS/BFS
- **File**: [`Graphs/01_NumberOfIslands.java`](Graphs/01_NumberOfIslands.java)
- **Input Format**:
  - Line 1: `rows cols`
  - Next `rows` lines: grid values (`1`/`0`)
- **Sample Input**:
  ```text
  4 5
  1 1 1 1 0
  1 1 0 1 0
  1 1 0 0 0
  0 0 0 0 0
  ```
- **Sample Output**:
  ```text
  1
  ```

#### 26. Course Schedule (LeetCode 207)
- **Difficulty**: Medium
- **Pattern**: Topological sort / cycle detection
- **File**: [`Graphs/02_CourseSchedule.java`](Graphs/02_CourseSchedule.java)
- **Input Format**:
  - Line 1: `numCourses m`
  - Next `m` lines: `u v` (course `v` required before `u`)
- **Sample Input**:
  ```text
  2 1
  1 0
  ```
- **Sample Output**:
  ```text
  true
  ```

#### 27. Rotting Oranges (LeetCode 994)
- **Difficulty**: Medium
- **Pattern**: Multi-source BFS
- **File**: [`Graphs/03_RottingOranges.java`](Graphs/03_RottingOranges.java)
- **Input Format**:
  - Line 1: `rows cols`
  - Next `rows` lines: grid values (`0`: empty, `1`: fresh, `2`: rotten)
- **Sample Input**:
  ```text
  3 3
  2 1 1
  1 1 0
  0 1 1
  ```
- **Sample Output**:
  ```text
  4
  ```

#### 28. Number of Provinces (LeetCode 547)
- **Difficulty**: Medium
- **Pattern**: DFS/BFS / DSU
- **File**: [`Graphs/04_NumberOfProvinces.java`](Graphs/04_NumberOfProvinces.java)
- **Input Format**:
  - Line 1: `n`
  - Next `n` lines: `n x n` connectivity matrix
- **Sample Input**:
  ```text
  3
  1 1 0
  1 1 0
  0 0 1
  ```
- **Sample Output**:
  ```text
  2
  ```

---

### 🔥 RECURSION & BACKTRACKING (4 Problems)

#### 29. Subsets (LeetCode 78)
- **Difficulty**: Medium
- **Pattern**: Backtracking
- **File**: [`Recursion_DP/01_Subsets.java`](Recursion_DP/01_Subsets.java)
- **Sample Input**:
  ```text
  3
  1 2 3
  ```
- **Sample Output**:
  ```text
  []
  [1]
  [1, 2]
  [1, 2, 3]
  [1, 3]
  [2]
  [2, 3]
  [3]
  ```

#### 30. Permutations (LeetCode 46)
- **Difficulty**: Medium
- **Pattern**: Backtracking
- **File**: [`Recursion_DP/02_Permutations.java`](Recursion_DP/02_Permutations.java)
- **Sample Input**:
  ```text
  3
  1 2 3
  ```
- **Sample Output**:
  ```text
  [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1]
  ```

#### 31. Combination Sum (LeetCode 39)
- **Difficulty**: Medium
- **Pattern**: Backtracking
- **File**: [`Recursion_DP/03_CombinationSum.java`](Recursion_DP/03_CombinationSum.java)
- **Sample Input**:
  ```text
  4
  2 3 6 7
  7
  ```
- **Sample Output**:
  ```text
  [2, 2, 3]
  [7]
  ```

#### 32. N-Queens (LeetCode 51)
- **Difficulty**: Hard
- **Pattern**: Backtracking
- **File**: [`Recursion_DP/04_NQueens.java`](Recursion_DP/04_NQueens.java)
- **Sample Input**:
  ```text
  4
  ```
- **Sample Output**:
  ```text
  .Q..
  ...Q
  Q...
  ..Q.

  ..Q.
  Q...
  ...Q
  .Q..
  ```

---

### ☠️ DYNAMIC PROGRAMMING (13 Problems)

#### 33. House Robber (LeetCode 198)
- **Difficulty**: Medium
- **Pattern**: 1D DP
- **File**: [`Recursion_DP/05_HouseRobber.java`](Recursion_DP/05_HouseRobber.java)
- **Sample Input**:
  ```text
  4
  1 2 3 1
  ```
- **Sample Output**:
  ```text
  4
  ```

#### 34. House Robber II (LeetCode 213)
- **Difficulty**: Medium
- **Pattern**: Circular DP
- **File**: [`Recursion_DP/06_HouseRobberII.java`](Recursion_DP/06_HouseRobberII.java)
- **Sample Input**:
  ```text
  3
  2 3 2
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 35. Coin Change (LeetCode 322)
- **Difficulty**: Medium
- **Pattern**: Unbounded knapsack
- **File**: [`Recursion_DP/07_CoinChange.java`](Recursion_DP/07_CoinChange.java)
- **Sample Input**:
  ```text
  3
  1 2 5
  11
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 36. Partition Equal Subset Sum (LeetCode 416)
- **Difficulty**: Medium
- **Pattern**: 0/1 knapsack
- **File**: [`Recursion_DP/08_PartitionEqualSubsetSum.java`](Recursion_DP/08_PartitionEqualSubsetSum.java)
- **Sample Input**:
  ```text
  4
  1 5 11 5
  ```
- **Sample Output**:
  ```text
  true
  ```

#### 37. Longest Increasing Subsequence (LeetCode 300)
- **Difficulty**: Medium
- **Pattern**: Subsequence DP O(N log N)
- **File**: [`Recursion_DP/09_LongestIncreasingSubsequence.java`](Recursion_DP/09_LongestIncreasingSubsequence.java)
- **Sample Input**:
  ```text
  8
  10 9 2 5 3 7 101 18
  ```
- **Sample Output**:
  ```text
  4
  ```

#### 38. Longest Common Subsequence (LeetCode 1143)
- **Difficulty**: Medium
- **Pattern**: 2D DP
- **File**: [`Recursion_DP/10_LongestCommonSubsequence.java`](Recursion_DP/10_LongestCommonSubsequence.java)
- **Sample Input**:
  ```text
  abcde
  ace
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 39. Edit Distance (LeetCode 72)
- **Difficulty**: Hard
- **Pattern**: 2D string DP
- **File**: [`Recursion_DP/11_EditDistance.java`](Recursion_DP/11_EditDistance.java)
- **Sample Input**:
  ```text
  horse
  ros
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 40. Unique Paths (LeetCode 62)
- **Difficulty**: Medium
- **Pattern**: Grid DP
- **File**: [`Recursion_DP/12_UniquePaths.java`](Recursion_DP/12_UniquePaths.java)
- **Sample Input**:
  ```text
  3 7
  ```
- **Sample Output**:
  ```text
  28
  ```

#### 41. Word Break (LeetCode 139)
- **Difficulty**: Medium
- **Pattern**: String DP
- **File**: [`Recursion_DP/13_WordBreak.java`](Recursion_DP/13_WordBreak.java)
- **Sample Input**:
  ```text
  leetcode
  2
  leet code
  ```
- **Sample Output**:
  ```text
  true
  ```

#### 42. Decode Ways (LeetCode 91)
- **Difficulty**: Medium
- **Pattern**: 1D DP
- **File**: [`Recursion_DP/14_DecodeWays.java`](Recursion_DP/14_DecodeWays.java)
- **Sample Input**:
  ```text
  226
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 43. Target Sum (LeetCode 494)
- **Difficulty**: Medium
- **Pattern**: DP / knapsack
- **File**: [`Recursion_DP/15_TargetSum.java`](Recursion_DP/15_TargetSum.java)
- **Sample Input**:
  ```text
  5
  1 1 1 1 1
  3
  ```
- **Sample Output**:
  ```text
  5
  ```

#### 44. Distinct Subsequences (LeetCode 115)
- **Difficulty**: Hard
- **Pattern**: 2D string DP
- **File**: [`Recursion_DP/16_DistinctSubsequences.java`](Recursion_DP/16_DistinctSubsequences.java)
- **Sample Input**:
  ```text
  rabbbit
  rabbit
  ```
- **Sample Output**:
  ```text
  3
  ```

#### 45. Burst Balloons (LeetCode 312)
- **Difficulty**: Hard
- **Pattern**: Interval DP
- **File**: [`Recursion_DP/17_BurstBalloons.java`](Recursion_DP/17_BurstBalloons.java)
- **Sample Input**:
  ```text
  4
  3 1 5 8
  ```
- **Sample Output**:
  ```text
  167
  ```

---

## 📄 License

This repository is distributed under the [MIT License](LICENSE).
