# Balanced Binary Tree

**Date:** 2025-03-24  
**Difficulty:** Easy  
**Category:** Binary Tree, Depth-First Search, Recursion  
**LeetCode Link:** [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

## Problem Description

Given a binary tree, return `true` if it is **height-balanced** and `false` otherwise.

A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

### Example 1:
```
Input: root = [1,2,3,null,null,4]
Output: true
```

### Example 2:
```
Input: root = [1,2,3,null,null,4,null,5]
Output: false
```

### Example 3:
```
Input: root = []
Output: true
```

### Constraints:
* The number of nodes in the tree is in the range [0, 1000].
* -1000 <= Node.val <= 1000

## Approach

To determine if a binary tree is height-balanced, I need to check if the heights of the left and right subtrees of every node differ by at most 1.

My approach uses a bottom-up recursion strategy with the following steps:

1. Define a helper function `getHeight` that calculates the height of a subtree and simultaneously checks if it's balanced:
   - If the subtree is balanced, it returns the actual height
   - If the subtree is not balanced, it returns -1 as a signal

2. For each node in the bottom-up traversal:
   - Check if the left subtree is balanced (not returning -1)
   - Check if the right subtree is balanced (not returning -1)
   - Verify that the height difference between left and right subtrees is at most 1
   - If any of these conditions fail, propagate -1 upward
   - Otherwise, return the height of the current subtree (max of left and right + 1)

3. The main function simply checks if the helper function returns -1

This approach efficiently combines height calculation and balance checking in a single post-order traversal, avoiding redundant calculations.

### Time and Space Complexity:
- **Time Complexity:** O(n) where n is the number of nodes in the tree, as we visit each node exactly once.
- **Space Complexity:** O(h) where h is the height of the tree, due to the recursion stack. In the worst case of a skewed tree, this could be O(n).