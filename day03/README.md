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
- have each of the its four functions (`push`, `pop`, `peek`, and `isEmpty`) take constant `O(1)` time.

Implement your stack in the `MyStack` class.

### Queue

Design an implementation of a `Queue`. It should also:

- use `O(n)` space-complexity
- have each of the its four functions (`enqueue`, `dequeue`, `isEmpty`, `front`) take constant `O(1)` time.

Implement your queue in the `MyQueue` class.

### Augmentation

* Modify your `MyStack` so that it supports: `public T maxElement()`. All operations (including `maxElement`) should still be constant time.
* Write a new class `MyPriorityQueue`, which supports `enqueue` and `dequeueMax`. This queue dequeues the largest element on the queue, rather than the element at the front of the queue. In this case, you will only be able to do one of the operations in O(1) time. The other operation will be O(N).

### Analysis

- Use the code in the `test.TimeTest` to make sure your `MyStack` and `MyQueue` operations happen in constant time. Your time per operation for both the stack and queue should not be more than a few milliseconds.

### Pset Problems

Finally, write a java solution in `PsetProblems` to problems 6 and 7 on the in class problem set:

* Given a string of open and close parenthesis, determine the longest substring that contains a valid expression. If you want an additional challenge, restrict yourself to using only one stack as additional storage.
* Sort a stack in ascending order (with smallest items on top). The only extra memory you may use is one additional stack to hold items (you cannot use any arrays). Return the sorted stack. O(N^2) time.

Use the tests in `test.PsetTest` to verify your solutions.
