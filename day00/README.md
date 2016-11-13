# `ArrayList`s and `LinkedList`s

In this homework assignment, you are going to given the class definition of `MyArrayList` and `MyLinkedList`. 
```java
// MyArrayList.java
public class MyArrayList {
}
```
```java
// MyLinkedList.java
public class MyLinkedList {
}
```

Nothing will be provided to you to start off with, but with each problem, we will add functionality to our classes to more closely match the real functionality of a real Java `ArrayList` and `LinkedList`.

### `MyArrayList`

Joe wants to open up a milk store that sells milk. In order to get the milk, he decides to raise a lot of cows, milk the cows himself, bottle the milk, and sell the bottles. Joe is a very tech savvy person and likes to organize his business using Java. He wants to keep track of these cows using an `ArrayList` because he heard that is an efficient way of storing data! The cows are located in their own physical space as indicated by their position in the `ArrayList`. 

You will be provided a `Cow` class that your `MyArrayList` will exclusively store. Each `Cow` has the following properties:
```java
public class Cow {
    String name;
    int age;
    String color;
    ...
}
```
**Write code for the following sections:**

1. Unfortunately, Joe only has enough space for 10 cows. He will not ever be able to fit more than 10 cows. Create a constructor for `MyArrayList` that initializes a `MyArrayList` given this constraint.

    `public MyArrayList(){...}`

2. Joe needs to start adding cows to his farm so he can make some milk! Cows are always added after all the already existing cows. He will NEVER be offered another cow if he already has 10 cows in his `MyArrayList`. Implement a method called `add` that will add a Cow to the end of your `MyArrayList`.

    `public void add(Cow c){...}`

3. Sometimes, the US Cow Bureau stops by the farm and needs to know the number of cows in your farm. Implement a method called `size` that returns the number of cows currently in your farm. Remember that the USCB is busy, and you do not have enough time to just count the number of cows you have every time they need to know the size.

    `public int size(){...}`

4. The US Cow Bureau is also sometimes interested in observing the cows, and we should be able to return information to them about any given cow. Implement a method called `get` that will return a `Cow` given the index of the `Cow`. (Use proper error handling in case a `Cow` doesn't exist at a given index).

    `public Cow get(int index){...}`

5. Some cows might leave the farm for various reasons, and they might leave in any order. If a cow in the middle leaves, we want to shift all the cows down so there are no empty spaces of cows. Implement a method called `remove` that will remove a cow. Also, make sure to return that `Cow` so we can "deal" with it later on.

    `public Cow remove(int index){...}`

6. When some cows come to the farm, they might feel more productive in between two particular cows. Add an overloaded `add` function that takes in an index as a first argument and inserts a cow at that index. Note that we are not replacing any cows, just inserting one in between two other cows. (Also perform error handeling here).

    `public void add(int index, Cow c){...}`
    
7. Thanks to your help, Joe's milk business has really gotten off the ground. He is able to expand his farm and is able to accept up to $$2^{31}-1$$ cows. Modify your code so that we can **optimally** perform resizes. We never want to allocate more space than we need to, but we should also have an *average* insertion time complexity of $$O(1)$$.

8. Joe would like to continue to expand his business into different animals! Make your `MyArrayList` generic.
