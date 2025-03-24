# Implement Trie (Prefix Tree)

**Date:** 2025-03-24  
**Difficulty:** Medium  
**Category:** Data Structure, Trie, String  
**LeetCode Link:** [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

## Problem Description

A prefix tree (also known as a trie) is a tree data structure used to efficiently store and retrieve keys in a set of strings. Some applications of this data structure include auto-complete and spell checker systems.

Implement the PrefixTree class:

* `PrefixTree()` Initializes the prefix tree object.
* `void insert(String word)` Inserts the string `word` into the prefix tree.
* `boolean search(String word)` Returns `true` if the string `word` is in the prefix tree (i.e., was inserted before), and `false` otherwise.
* `boolean startsWith(String prefix)` Returns `true` if there is a previously inserted string `word` that has the prefix `prefix`, and `false` otherwise.

### Example 1:
```
Input: 
["Trie", "insert", "dog", "search", "dog", "search", "do", "startsWith", "do", "insert", "do", "search", "do"]

Output:
[null, null, true, false, true, null, true]

Explanation:
PrefixTree prefixTree = new PrefixTree();
prefixTree.insert("dog");
prefixTree.search("dog");    // return true
prefixTree.search("do");     // return false
prefixTree.startsWith("do"); // return true
prefixTree.insert("do");
prefixTree.search("do");     // return true
```

### Constraints:
* `1 <= word.length, prefix.length <= 1000`
* `word` and `prefix` are made up of lowercase English letters.

## Approach

I implemented the Trie data structure using the following approach:

1. **TrieNode Structure**:
   - Each node contains a map of characters to their corresponding child nodes
   - A boolean flag `endOfWord` to mark the end of a complete word

2. **Insert Operation**:
   - Start from the root node
   - For each character in the word, check if it exists in the current node's children
   - If not, create a new TrieNode for that character
   - Move to the child node and continue
   - Mark the last node as the end of a word

3. **Search Operation**:
   - Start from the root node
   - For each character in the word, check if it exists in the current node's children
   - If not, return false (word doesn't exist)
   - Move to the child node and continue
   - After processing all characters, check if the current node is marked as the end of a word

4. **StartsWith Operation**:
   - Similar to search, but we don't need to check if the last node is marked as the end of a word
   - If we can traverse the trie for all characters in the prefix, return true

### Time and Space Complexity:

- **Time Complexity**:
  - Insert: O(n) where n is the length of the word
  - Search: O(n) where n is the length of the word
  - StartsWith: O(n) where n is the length of the prefix

- **Space Complexity**:
  - O(m * n) where m is the number of words and n is the average length of the words
  - In the worst case, when there are no common prefixes, each character of each word requires a new node

## Lessons Learned

1. Tries are excellent for problems involving word dictionaries, auto-complete, or prefix matching
2. Using a HashMap at each node provides a flexible way to handle any character set
3. The endOfWord flag is crucial to distinguish between complete words and prefixes
4. Common operations like insert, search, and prefix search follow similar traversal patterns
5. When implementing a Trie, carefully consider the trade-off between memory usage and lookup speed