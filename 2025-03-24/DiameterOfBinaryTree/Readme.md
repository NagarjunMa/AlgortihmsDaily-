# Diameter of Binary Tree

**Date:** 2025-03-24  
**Difficulty:** Easy  
**Category:** Binary Tree, Depth-First Search, Recursion  
**LeetCode Link:** [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

## Problem Description

The diameter of a binary tree is defined as the length of the longest path between **any two nodes** within the tree. The path does not necessarily have to pass through the root.

The length of a path between two nodes in a binary tree is the number of edges between the nodes.

Given the root of a binary tree `root`, return the **diameter** of the tree.

### Example 1:
```
Input: root = [1,null,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].
```

### Example 2:
```
Input: root = [1,2,3]
Output: 2
```

### Constraints:
* 1 <= number of nodes in the tree <= 100
* -100 <= Node.val <= 100

## Approach

To solve this problem, I need to find the longest path between any two nodes in the tree. The key insight is that the longest path (diameter) for any node must be the sum of the heights of its left and right subtrees.

My approach uses a depth-first search (DFS) with the following strategy:

1. Create a helper function that calculates the height of a subtree while also tracking the maximum diameter found.
2. For each node, calculate:
   - The height of its left subtree
   - The height of its right subtree
   - Update the global maximum diameter if the sum of these heights (left + right) is greater
3. Return the height of the current subtree (max of left or right + 1) to be used by parent nodes.

The algorithm efficiently solves the problem in a single tree traversal by simultaneously calculating heights and tracking the maximum diameter.

### Time and Space Complexity:
- **Time Complexity:** O(n) where n is the number of nodes in the tree, as we visit each node exactly once.
- **Space Complexity:** O(h) where h is the height of the tree, due to the recursion stack. In the worst case of a skewed tree, this could be O(n).