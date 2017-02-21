# Sorting Day00 - `InsertionSort`, `MergeSort` and `QuickSort`

## Learning Goals

By doing this assignment, you should be able to:

* Understand and justify the runtime and space complexities of each sort
* Understand how these three sorts are implemented.
* Avoid worst case performances (time and/or space) of:
  * Merge sort by using insertion sort on smaller arrays
  * Quick sort by randomly shuffling before sorting
  
## Assignment

### Quicksort

Because we did not cover quicksort today in class, part of your homework is watching [this](https://www.youtube.com/watch?v=852wJdsgl2I) MIT lecture on Quicksort. You will probably find it most helpful to watch it after finishing your implementation of insertion and merge sort.

This lecture goes a bit more into the math then you will require for DSA. You are only required to watch from

- 0:00-31:10
- 45:45-50:12

Feel free to watch at double speed!

[Here](https://drive.google.com/open?id=0B_K4P69ad_l_RDY2U3VZUkpTY3M) are the corresponding powerpoint slides for the MIT lecture. [This](http://videolectures.net/mit6046jf05_leiserson_lec04/) website plays the video lecture side-by-side with the powerpoint lecture, with the downside of not being able to play faster than normal speed.

### Code

- Draw the recursive trees (see [here](https://docs.google.com/presentation/d/1mNRb1tx3ibY2FjKkcXqJvjfDnT0vkxfYKEf38HrU26Y/edit?usp=sharing)) of the merge sort algorithm for the input array `[4,8,62,9,14,19]`. Show (a photo of) this to your NINJA at checkoff.
- In `InsertionSort.java`, `MergeSort.java`, and `QuickSort.java`, complete the `sort` method.
- For each `sort` function, detail the best, worst, and average case runtime complexity, as well as the space complexity, in the comments.

### Peak-Finding

Imagine you had a 1-dimensional array of numbers. A peak of that array would be any element that is not less than either of its neighbors (assuming `nums[-1] = nums[N]= -INF`). For example, in `[3,2,3,4,5,6,4,3,2]`, the peaks are the first `3` and the `6`. In `[1,1,1,1,1]`, every element is a peak.
  
One way of solving this in `O(N)` time is to look at every element until you find an element that is a peak, or find the global maximum. We can do this in `O(log N)` time using a binary search technique! (how??)
 
In `PeakFinding.java`, implement `int findOneDPeak(int[] nums)` and return the index of ANY peak in `O(log N)` time.

Now that you have warmed up, solve this same problem in two dimensions. An element is a peak in a two dimensional array if it is not less than any of its four non-diagonal neighbors (or at least the neighbors that exist, meaning values on the edges can also be peaks).

Can you solve this in `O(N log N)` time? We are sure you can...but we want something faster than that. Implement `int[] findTwoDPeak(int[][] nums)`, where `answer[0]` is the row index and `answer[1]` is the column index of any peak. In other words, the peak is `nums[answer[0]][answer[1]]`.

Hint: `1 + 2 + 4 + 8 + 16 + ... + N = O(N)`

### Reading

- **required**: When you're done coding, in *Think Algorithms* read section **23.2** and **23.5**.
- **if you get stuck**: **23.3** and **23.4** contain implementations of insertion and merge sort. We encourage you to implement them without copying the book code.

### Getting checked off

- Talk your NINJA through your recursive trees for merge sort.
- Talk your NINJA through the four commented complexities for the three sorting algorithms.