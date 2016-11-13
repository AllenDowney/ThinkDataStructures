# Chapter 13

## Learning Goals:

Students will be able to:

- Have a general understanding of how maps work in programming
- Be able to create a simple implementation of Java's `map` implementation using an `ArrayList` of key-value pairs.

## Assignment

## 13.4 - MyLinearMap

In `MyLinearMap`:

- In MyLinearMap: Fill in the body of `findEntry(Object target)`
- In MyLinearMap: Fill in the body of `put(K key, V value)`
- In MyLinearMap: Fill in the body of `remove(Object key)`

## Problems

- Write the function `countInts(int[] arr)`,  that returns a `List` of appearance counts for each integer in the array, in the order they first appear. For example, if the input is `[1, 1, 3, 4, 1, 4, 5]`, the output should be `[3, 1, 2, 1]`, because `1` appears three times, `3` appears once, `4` appears twice, and `5` appears once.
- Write the function `pairsThatAddTo(int[] arr, int k)`, that returns a `List` of pairs (represented as length 2 arrays) of integers in `arr` that add up to `k`. Each individual element in `arr` can only be used once. *Only iterate over `arr` once.* For example, if the input is `[1, 4, 6, 5, 0, 5, 1, 2, 3, 5], 6`, the answer would be `[[1, 5], [4, 2], [6, 0], [1, 5]]`. Note that each element can only be used once.

Okay so, I'm not really sure what to do with this homework. It's pretty simple, but I think the thing we really want to bang home with Hashmaps is how they can be used to generate really efficient solutions because of their constant operation time. However, the LinearMap clearly violates that, so it's pratically useless.

That being said, I think both of the learning goals I identified are quite valuable. As of right now, I think the best thing is for them to implement the LinearMap, and then do some really simple Map problems.

I didn't have time to time myself doing these problems, I will do it for next week.
