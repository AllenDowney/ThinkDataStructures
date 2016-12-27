# `ArrayList`s

## Learning Goals

- Understand memory allocation of arrays
- Understand the need and implementation of dynamically sized arrays
- Be able to analyze time complexities of data structures

## `MyArrayList`

In this homework assignment, you are going to write your own implementation of an ArrayList.
```java
// MyArrayList.java
public class MyArrayList {
...
}
```

With each problem, we will add functionality to our classes to more closely match the real functionality of a real Java `ArrayList`.

Sidd would like to start a farm that only contains cows. He wants your help in creating an `ArrayList` to store these cows in.

You will be provided a `Cow` class that your `MyArrayList` will *exclusively* store. Each `Cow` has the following properties:
```java
public class Cow {
    String name;
    int age;
    String color;
    ...
}
```
The tests you will be running on your `MyArrayList` class will be using this `Cow` class.

# Assignment

## Reading

- In *Think Algorithms*, read sections **3.4 and 4.3.** If you're having trouble with resizing in your `MyArrayList` implementation, read **4.4**

## Code

1. Assume Joe will only ever store 10 cows. Create a constructor for `MyArrayList` that initializes a `MyArrayList` and stores a a cow array of size 10: `Cow[10]`.

    `public MyArrayList(){...}`

2. Implement a method called `add` that will add a Cow to the end of your `MyArrayList`. Assume that Joe will never be given a cow if he already has 10.

    `public void add(Cow c){...}`

3. How many cows does Joe have? Implement a method called `size` that returns the number of cows currently in your farm. Make sure to make this an `O(1)` operation.

    `public int size(){...}`

4. Implement a method called `get` that will return a `Cow` given the index of the `Cow`. (Throw an `IndexOutOfBoundsException()` if a `Cow` doesn't exist at the given index.)

    `public Cow get(int index){...}`

5. Some cows might leave the farm for various reasons, and they might leave in any order. If a cow in the middle leaves, we want to shift all the cows down so there are no empty spaces of cows. Implement a method called `remove` that will remove a cow. Also, make sure to return the removed `Cow`.

    `public Cow remove(int index){...}`

6. How can we add a `Cow` in the middle of our `MyArrayList`? Add an overloaded `add` function that takes in an index as a first argument and inserts a cow at that index. Note that we are not replacing any cows, just inserting one in between two other cows. (Also perform error handeling here using `IndexOutOfBoundsException()`).

    `public void add(int index, Cow c){...}`
    
7. Thanks to your help, Joe's milk business has really gotten off the ground. He is able to expand his farm and is able to accept lots of cows. Modify your code so that we can **optimally** perform resizes. We never want to allocate more space than we need to, but we should also have an *average* insertion time complexity of `O(1)`. Make sure that the load factor of your `MyArrayList` stays above 25%. This will require halving the size of your array if it is less than 25% full, and doubling the size of it when it fills up.

## Optional

8. Joe would like to continue to expand his business into different animals! Make your `MyArrayList` generic. In order to test your new generic `MyArrayList`, edit `MyArrayListTest.java` and find the four lines that need to be commented/uncommented. Look for the following sections:

    ```java
    // QUESTIONS 1-7. COMMENT THIS LINE FOR QUESTION 8
    MyArrayList cows;
    
    // QUESTION 8. COMMENT THIS LINE FOR QUESTIONS 1-7
    //MyArrayList<Cow> cows;
    ...
    // QUESTIONS 1-7. COMMENT THIS LINE FOR QUESTION 8
    cows = new MyArrayList();
    
    // QUESTION 8. COMMENT THIS LINE FOR QUESTIONS 1-7
    //cows = new MyArrayList<Cow>();
    ```

