# Sorting Day 1 - Counting and Radix Sort

## Learning Goals

By doing this assignment, you should be able to

* Understand the implementation of counting and radix sort, and why using `LinkedLists` is useful.
* Identify use cases for counting and radix sort
* Understand the runtime of the linear-in-N sorts:
  * Counting sort: O(n+k)
  * Radix sort: O(nc), where c is the "word size" of the integers in base n.

## Sorts

**Note that all sorts in this assignment are done in place (you should modify the input array)**

### Counting Sort

Fill in `countingSort(int[] A, int k)` in `CountingSort.java`. Note the runtime in the comments.

### Radix Sort

In order to radix sort, we first have to be able to sort the array according to a certain digit. Start by filling in `countingSortByDigit(int[] A, int b, int n)`. Note the helper function `getNthDigit(int number, int base, int n)`.

Fill in `radixSort(int[] A, int b, int k)` in `RadixSort.java`. Note the runtime in the comments. **Express your runtime in terms of n, b, and w.**

## Problems

### Sort numbers under 100

You are given an array of non-negative integers lower than 100. Write a function to sort them as quickly as possible. Feel free to use code you've already written.

### Sort array of `String`s

You are given an array of Strings, all with the same length. How can you sort the strings using the concepts covered in class and this homework?

You will probably find it useful to have a function that sorts the array by the character at a given index in the String. Start by filling in `countingSortByCharacter` in `CountingSort.java`. This function should be *very* similar to `countingSortByDigit`. Note the helper function `getNthCharacter(String s, int n)`.

Finally, fill in `sortStrings(String[] S, int stringLength)` and run your tests!
