# Day04 - `MyLinearMap` and review

## Learning Goals:

Students will be able to:

- Have a general understanding of how maps work in programming
- Be able to create a simple implementation of Java's `map` interface using an `ArrayList` of key-value pairs.
- Understand when a map is effective

## Due Date:

Midnight, Feb. 6, 2017

## Assignment

#### Due via check-off on Monday night (Feb 6).

### Reading

In *Think Algorithms*, read sections **13.2 and 13.3**. For information about what the methods you're implementing should do, read section **13.4**.

### Code

In `MyLinearMap.java`, implement:

- `findEntry(Object target)`
- `put(K key, V value)`
- `get(Object key)`
- `remove(Object key)`

**Hint:** Use the built-in `equals` function to compare object equality and handle `null`s correctly.

Run `MyLinearMapTest` to test your `Map` implementation. If your code isn't passing tests, make sure you understand what each of your functions is supposed to do by reading the [Java Map API](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html).

### Problems

- Write the function `getCountMap(int[] arr)`,  that returns a `MyLinearMap` that maps from `int`s to their appearance counts. For example, if the input is `[1, 1, 3, 4, 1, 4, 5]`, the output should be `MyLinearMap` containing `{1:3, 3:1, 4:2, 5:1}`.
- **O(N)/O(1)** You are given the head nodes of two singly linked lists representing non-negative integers. I.e., the number 7,442 is represented by the linked list `[7->4->4->2]`. Return the sum of the two numbers represented by the linked lists. E.g. `[7->4->4-2] + [5->2->9] = 7971`. You may modify the lists. Assume neither head is null.

### When you're done

In *Think Algorithms*, read sections **14.4 and 14.5** in preparation for next class.
