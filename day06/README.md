
# Homework Day 6: Ch. 17-18

---
---

## Learning Goals

After completing this assignment you should be able to:
* Understand the key concepts of binary search trees
* Analyze the efficiency of common binary search tree operations
* Identify when utilizing a Tree Map is effective

## Assignment

Finish the implementation of MyTreeMap (ch. 17.5):
* Fill in the body of `findNode(Object target)`
* Fill in the body of `containsValue(Object target)`
* Fill in the body of `putHelper(Node node, K key, V value)`
* Fill in the body of `keySet()`

Draw a binary search tree using the array of nodes [17, 19, 12, 76, 9, 50, 72, 23, 54, 14, 67] in order.

Briefly explain the advantages and disadvantages of using a BST rather than a hash table.

## Challenge Problem (Optional)

Fill in the missing function declaration in BSTTest.java: Given a one dimensional array, return True if the corresponding tree is a BST.  The input array may contain null values, and the left child of each parent will be 2i+1 while the right child will be 2i+2.
For example:
```
Input: [3, 2, 5, 1, null, 4, 6]
Return: True
      3
    /  \
   2    5
 /		/\
1	   4  6
```