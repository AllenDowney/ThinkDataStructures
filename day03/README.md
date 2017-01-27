# Day03 - `Stack`s and `Queue`s

## Learning Goals

After completing this homework, students will be able to:

* Understand the difference between a stack and a queue
* Identify problems where stacks or queues can contribute to an effective solution.
* Implement a stack and a queue that uses `O(n)` space and has `O(1)` per-operation time complexity.

## Assignment

### Reading

- In *Think Algorithms*, read section **10.8**. Ignore the stuff about "DFS", we'll learn about that later.

### Stack

Design an implementation of a `Stack`. It should:

- use `O(n)` space-complexity
- have each of the its four functions (`push`, `pop`, `isEmpty`, and `size`) take constant `O(1)` time.

Implement your stack in the `MyStack` class.

### Queue

Design an implementation of a `Queue`. It should also:

- use `O(n)` space-complexity
- have each of the its four functions (`enqueue`, `dequeue`, `isEmpty`, and `size`) take constant `O(1)` time.

Implement your queue in the `MyQueue` class.

### Solve one of the following
* **(Easier)** Modify your `MyStack` and add the following function: `public T maxElement()`. All operations (including `maxElement`) should still be constant time. Uncomment the tests in `StackTest` to test your implementation.
* **(Harder)**Implement the function `maxInWindows(int[] arr, int k)`, which takes in an array of ints length `n`, and returns the local maximums in each sliding window of size `k`. Your solution should be at worst `O(kn)`. It's possible to solve this problem in `O(n)` time. If you want to know the queue-based `O(n)` solution, read [this](http://codercareer.blogspot.com/2012/02/no-33-maximums-in-sliding-windows.html)! For example, for the input: `[5, 3, 2, 6, 5, 2, 9, 10, 2]`, your function should return `[5, 6, 6, 6, 9, 10, 10]` (The max of `[5, 3, 2]` is `5`, of `[3, 2, 6]` is `6`, etc.) Uncomment `testSlidingWindow` in `QueueTest` to test your implementation.

### Analysis

- Use the code in the `TimeTest` to make sure your `MyStack` and `MyQueue` operations happen in constant time. Your time per operation for both the stack and queue should not be more than a few milliseconds.