# Sorting Day00 - `InsertionSort`, `MergeSort` and `QuickSort`

## Learning Goals

By doing this assignment, you should be able to:

* Understand and justify the runtime and space complexities of each sort
* Understand how these three sorts are implemented.
* Avoid worst case performances (time and/or space) of:
  * Merge sort by using insertion sort on smaller arrays
  * Quick sort by randomly shuffling before sorting
  
## Assignment

### Code

- Draw the recursive trees (see [here](https://docs.google.com/presentation/d/1mNRb1tx3ibY2FjKkcXqJvjfDnT0vkxfYKEf38HrU26Y/edit?usp=sharing)) of the merge sort algorithm for the input array `[4,8,62,9,14,19]`. Show (a photo of) this to your NINJA at checkoff.
- In `InsertionSort.java`, `MergeSort.java`, and `QuickSort.java`, complete the `sort` method.
- For each `sort` function, detail the best, worst, and average case runtime complexity, as well as the space complexity, in the comments. Provide a short (one to two sentences total) explanation for the complexities.

### Reading

- **required**: When you're done coding, in *Think Algorithms* read section **23.2** and **23.5**.
- **if you get stuck**: **23.3** and **23.4** contain implementations of insertion and merge sort. We encourage you to implement them without copying the book code.