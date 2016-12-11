# Chapter 13

## Learning Goals:

Students will be able to:

- Have a general understanding of how maps work in programming
- Be able to create a simple implementation of Java's `map` implementation using an `ArrayList` of key-value pairs.
- Understand when it is effective to utilize a map

## Assignment

### 13.4 - MyLinearMap

In `MyLinearMap`:

- In MyLinearMap: Fill in the body of `findEntry(Object target)`
- In MyLinearMap: Fill in the body of `put(K key, V value)`
- In MyLinearMap: Fill in the body of `get(Object key)`
- In MyLinearMap: Fill in the body of `remove(Object key)`

*Hint: Use the built in `equals` function to compare object equality and handle `null`s correctly.*

Run `MyLinearMapTest` to test your `Map` implementation. If your code isn't passing tests, make sure you understand what each of your functions is supposed to do by reading the [Map API](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html).

### Problems

**Solve one of the following**

- Write the function `getCountMap(int[] arr)`,  that returns a `MyLinearMap` that maps from `int`s to their appearance counts, in the order they first appear. For example, if the input is `[1, 1, 3, 4, 1, 4, 5]`, the output should be `MyLinearMap` containing `{1:3, 3:1, 4:2, 5:1}`, because `1` appears three times, `3` appears once, `4` appears twice, and `5` appears once.
- Write the function `pairsThatAddTo(int[] arr, int k)`, that returns a `List<int[]>` of pairs (represented as length 2 arrays) of integers in `arr` that add up to `k`. Each individual element in `arr` can only be used once. *Only iterate over `arr` once.* For example, if the input is `[1, 4, 6, 5, 0, 5, 1, 2, 3, 5], 6`, the answer would be `[[1, 5], [4, 2], [6, 0], [1, 5]]`. Note that each element can only be used once.