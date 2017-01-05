# Sorting Day 1 - `MergeSort` and `HeapSort`

## Learning Goals

By doing this assignment, you should be able to:
* Understand the merge sort algorithm:
  * Understand the roles of the recursive split then merge steps
  * Justify its O(nlgn) runtime
  * Justify its O(n) space complexity, and be aware that it can run in O(1) space by using linked lists instead of arrays
* Understand the heap sort algorithm:
  * Use and understand the heap data structure thoroughly: how it is used in the algorithm, and what augmentation it needs in order to implement a priority queue
  * Justify its O(nlgn) runtime
  * Justify its O(n) space complexity

## Assignment

### Reading

- In *Think Algorithms*, read sections **23.4, 23.5 and 23.7**.

### Code

Draw the recursive trees (see [here](https://docs.google.com/presentation/d/1mNRb1tx3ibY2FjKkcXqJvjfDnT0vkxfYKEf38HrU26Y/edit?usp=sharing)) of the merge sort algorithm for the input array `[4,8,62,9,14,19]`.

Draw the different phases of the initial max heap `[1,2,3,4,5]` through the heap construction phase, and then through the heap sort algorithm. **Note**: you need not draw one heap per "percolation" when doing `heapify`, just beginning and end states are fine.

For both `MergeSort.java` and `HeapSort.java`, complete the methods annotated with `TODO`s so that `sort` runs; use (or not) the helper methods and method declarations we've provided for you.

