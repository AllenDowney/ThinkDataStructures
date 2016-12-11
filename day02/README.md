# `LinkedList`s

## Learning Goals

- Understand memory allocation of linked lists
- Understand the need and implementation of pointer based data structures
- Be able to analyze time complexities of linked lists
- Understand when to use LinkedList versus ArrayList

## `MyLinkedList`

In this homework assignment, you are going to given the class definition and some method definitions of `MyLinkedList`
```java
// MyLinkedList.java
public class MyLinkedList {
...
}
```

With each problem, we will add functionality to our classes to more closely match the real functionality of a real Java `LinkedList`.

Joe would like to start a farm that only contains chickens. He wants your help in creating an `LinkedList` to store these chickens in.

You will be provided a `Chicken` class that your `MyLinkedList` will *exclusively* store. Each `Chicken` has the following properties:
```java
public class Chicken {
    String name;
    int age;
    String color;
    ...
}
```
The tests you will be running on your `MyLinkedList` class will be using this `Chicken` class.

# Assignment

1. Create a constructor that initializes a `MyLinkedList`. We want to implement our data structure as a doubly-linked list. Make sure to have pointer to the head of our list.

    `public MyLinkedList(){...}`

2. Implement a method called `add` that will add a `Chicken` to the end of your `MyLinkedList`.

    `public void add(Chicken c){...}`

3. How many chickens does Joe have? Implement a method called `size` that returns the number of chickens currently in your farm. Make sure to make this an $$O(1)$$ operation.

    `public int size(){...}`

4. Can we inspect a chicken in our `MyLinkedList`? Implement a method called `get` that will return a `Chicken` given the index of the `Chicken`. (Use proper error handling in case a `Chicken` doesn't exist at a given index).

    `public Chicken get(int index){...}`

5. Some chickens might leave the farm for various reasons, and they might leave in any order. If a chicken in the middle leaves, we want to shift all the chickens down so there are no empty spaces of chickens. Implement a method called `remove` that will remove a chicken. Also, make sure to return that `Chicken` so we can "deal" with it later on.

    `public Chicken remove(int index){...}`

6. How can we add a `Chicken` in the middle of our `MyLinkedList`? Add an overloaded `add` function that takes in an index as a first argument and inserts a chicken at that index. Note that we are not replacing any chickens, just inserting one in between two other chickens. (Also perform error handeling here).

    `public void add(int index, Chicken c){...}`

## Optional

7. Joe would like to continue to expand his business into different animals! Make your `MyLinkedList` generic. In order to test your new generic `MyLinkedList`, edit `MyLinkedListTest.java` and find the four lines that need to be commented/uncommented. Look for the following sections:

    ```java
    // QUESTIONS 1-7. COMMENT THIS LINE FOR QUESTION 7
    MyLinkedList chickens;
    
    // QUESTION 8. COMMENT THIS LINE FOR QUESTIONS 1-6
    //MyLinkedList<Chicken> chickens;
    ...
    // QUESTIONS 1-7. COMMENT THIS LINE FOR QUESTION 7
    chickens = new MyLinkedList();
    
    // QUESTION 8. COMMENT THIS LINE FOR QUESTIONS 1-6
    //chickens = new MyLinkedList<Chicken>();
    ```
