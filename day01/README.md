# `ArrayList`s

## Learning Goals

- Understand memory allocation of arrays
- Understand the need and implementation of dynamically sized arrays
- Be able to analyze time complexities of data structures 
- Understand the design intentions of the ArrayList data structure

## `ArrayList`

In this homework assignment, you are going to write your own implementation of an ArrayList.
```java
// MyArrayList.java
public class MyArrayList {
...
}
```

With each problem, we will add functionality to our classes to more closely match the real functionality of a real Java `ArrayList`.

### `MyArrayList`

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

1. Unfortunately, Joe only has enough space for 10 cows. He will not ever be able to fit more than 10 cows. Create a constructor for `MyArrayList` that initializes a `MyArrayList` given this constraint.

    `public MyArrayList(){...}`

2. Implement a method called `add` that will add a Cow to the end of your `MyArrayList`. Assume that Joe will never be given a cow if he already has 10.

    `public void add(Cow c){...}`

3. How many cows does Joe have? Implement a method called `size` that returns the number of cows currently in your farm. Make sure to make this an $$O(1)$$ operation.

    `public int size(){...}`

4. Can we inspect a cow in our `MyArrayList`? Implement a method called `get` that will return a `Cow` given the index of the `Cow`. (Use proper error handling in case a `Cow` doesn't exist at a given index).

    `public Cow get(int index){...}`

5. Some cows might leave the farm for various reasons, and they might leave in any order. If a cow in the middle leaves, we want to shift all the cows down so there are no empty spaces of cows. Implement a method called `remove` that will remove a cow. Also, make sure to return that `Cow` so we can "deal" with it later on.

    `public Cow remove(int index){...}`

6. How can we add a `Cow` in the middle of our `MyArrayList`? Add an overloaded `add` function that takes in an index as a first argument and inserts a cow at that index. Note that we are not replacing any cows, just inserting one in between two other cows. (Also perform error handeling here).

    `public void add(int index, Cow c){...}`
    
7. Thanks to your help, Joe's milk business has really gotten off the ground. He is able to expand his farm and is able to accept up to $$2^{31}-1$$ cows. Modify your code so that we can **optimally** perform resizes. We never want to allocate more space than we need to, but we should also have an *average* insertion time complexity of $$O(1)$$. Make sure that the load factor of your `MyArrayList` stays above 25%.

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

