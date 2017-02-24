# Sorting Day 1 - Heaps and `HeapSort`

## Learning Goals

By doing this assignment, you should be able to

* Understand the heap sort algorithm:
  * Understand why building a heap is O(N) time
  * Understand why heap sort is worst, average and best case O(NlogN) time
  * Understand the O(1) space complexity of heap sort
* Understand how to implement a priority queue
  * How to implement it using a max-heap
  * O(1) space

## Assignment

### Heapsort

- For `HeapSort.java`, complete the methods annotated with `TODO`s so that `sort` runs; use (or not) the helper methods and method declarations we've provided for you.

- Detail the best, worst, and average case runtime complexity in the comments. Also, detail the space complexity.

### Peakfinding

If you didn't get a chance to finish the 2D peakfinding problem last week, please finish it for this week. In this project you will find a solution to the 1-D problem, as well as a helper functions for the 2D problem.

If you did it last class, copy paste your code to this class' project so all your tests run.

An element is a peak in a two dimensional array if it is not less than any of its four non-diagonal neighbors (or at least the neighbors that exist, meaning values on the edges can also be peaks).

### Running Median

For this problem, you might find it helpful to use a priority queue (PQ). Java offers an implementation of `PriorityQueue`, with the following methods:

- `isEmpty`
- `size`
- `peek`
- `offer`, which is the same as `enqueue` from the queue you implemented.
- `poll`, which is the same as `dequeue` from the queue you implemented.

**Optional**: To learn about Java's `PriorityQueue` API, in *Think Algorithms*, read section **23.7**.

#### The Problem

You are given an input stream of integers `inputStream`. Return a `double[] runningMedian`, where `runningMedian[i]` is the median of all elements in `inputStream[:i+1]`, that is, up to and including `i`.

You can think of it like you are seeing the integers one at a time, and at any given time you must output what the median of all the integers you've seen so far is.

You may find it helpful to think about the O(N^2) solution first. Maintain a sorted dynamic array `sortedArray`, and after each element comes in, find its place in the sorted array and insert it, then output the median of the sorted array. Why is this O(N^2)?

The code for the N^2 solution is provided in `Problems.java`. Can you do better? For your convenience, we provide two helper functions which initialize a maxPQ and a minPQ. Feel free to use one or both in your solution.

## Getting Checked Off

- Provide an explanation for each of the four heapsort complexities to your NINJA.
- Talk your NINJA through your solution to the peak finding problem, if you didn't finish it last time
- Talk your NINJA through your solution to your running median problem.