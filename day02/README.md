# Day02 - `LinkedList`s

## Learning Goals

- Understand memory allocation of linked lists
- Understand the need and implementation of pointer based data structures
- Be able to analyze time complexities of linked lists
- Understand when to use LinkedList versus ArrayList

## `MyLinkedList`

In this homework assignment, you are going to given the class definition and some method definitions of `MyLinkedList`
```java
// MyLinkedList.java
public class MyLinkedList
```

With each problem, we will add functionality to our classes to more closely match the real functionality of a Java `LinkedList`.

Hieu would like to start a farm that only contains chickens. He wants your help in creating an `LinkedList` to store these chickens in.

You will be provided a `Chicken` class that your `MyLinkedList` will *exclusively* store. Each `Chicken` has the following properties:
```java
public class Chicken {
    String name;
    int age;
    String color;
}
```
The tests you will be running on your `MyLinkedList` class will be using this `Chicken` class.

# Assignment

## Reading

- In *Think Algorithms*, read sections **5.5, 5.6, 7.3 and 7.4**

## Code

In this homework assignment, you will be implementing your own doubly-linked list.

### Provided for you

1. The internal `Node` class: its constructor takes in the Chicken, as well as references to the `prev` and `next` nodes.
1. Some internal variable you probably want to keep track of in the `LinkedList`: the `head` and `tail` `Node`s, and the `size` of the `LinkedList`.

### Your code

1. Implement an empty constructor. Initialize `head`, `tail`, and `size`.

    `public MyLinkedList()`
    
1. Implement a method called `addLast` that will add a `Chicken` to the end of your `MyLinkedList`. Remember to consider the special case where `size` is 0.

    `public void addLast(Chicken c)`

1. Sometimes a chicken will confuse the beginning of the line with the end of the line, and Hieu needs to be able to deal with this. Implement `addFirst` that will allow a chicken to be added to the front of the `LinkedList`. Remember to consider the special case where `size` is 0.

    `public void addFirst(Chicken c)`

1. Can we inspect a chicken in our `MyLinkedList`? Implement a method called `get` that will return a `Chicken` given the index of the `Chicken`. Make sure to check that `index` is valid.

    `public Chicken get(int index)`
    
1. Some chickens might leave the farm for various reasons. LinkedLists have special case O(1) deletes off the front and back. Implement `removeFirst` and `removeLast`, and make sure to return them so Hieu can "deal" with them. Remember to consider the special cases where `size` is 0 or 1.

    `public Chicken removeFirst()`

    `public Chicken removeLast()`
    
1. Chickens might leave in any order. If a chicken in the middle leaves, we want to update our `LinkedList` pointers so that the `Node` before the removed chicken points to the `Node` after the removed `Chicken`. Return the removed `Chicken` so we can "deal" with it. Remember to consider the special cases where `index=0` or `index=size-1`.

    `public Chicken remove(int index)`


Test your DLL by running `MyLinkedListTest.java`. Make all test cases pass.

### Generics in Java

Generics in Java allow devs to generalize method and classes declarations. Generic classes act as stand-ins for **any class**. In this example, you can make the SLL generic by changing the class declaration to

```java
public class MyLinkedList<T>
```

And the constructor invocation becomes

```java
MyLinkedList<Chickens> anyAnimal = new MyLinkedList<>();
```

Here, `T` acts as a stand-in whatever is specified between the `<>` in the new constructor.

### Making `MyLinkedList` generic

1. Hieu would like to expand his business to different animals! Make your `MyLinkedList` generic. Start with the class declaration as shown in the paragraph above.

2. Generalize the `add` methods to take in a generic object instead of a `Chicken` object, and change the implementation accordingly.

	`public void addFirst(T e)`

  `public void addLast(T e)`

3. Generalize the `remove` and `get` methods to return a generic object.

  `public T get(int index)`
  
  `public T removeFirst()`

  `public T removeLast()`

In order to test your new generic `MyLinkedList`, edit `MyLinkedListTest.java` and find the four lines that need to be commented/uncommented. Look for the following sections:

```java
// QUESTIONS 1-7. COMMENT THIS LINE FOR GENERICS TESTING
// private MyLinkedList chickens;
// private MyLinkedList emptyChickens;

// GENERICS TESTING. COMMENT THIS LINE FOR QUESTIONS 1-7
private MyLinkedList<Chicken> chickens;
private MyLinkedList<Chicken> emptyChickens;

@Before
public void setUp() throws Exception {
    // QUESTIONS 1-7. COMMENT THIS LINE FOR GENERICS TESTING
    chickens = new MyLinkedList();
    emptyChickens = new MyLinkedList();

    // GENERICS TESTING. COMMENT THIS LINE FOR QUESTIONS 1-7
    // chickens = new MyLinkedList<>();
    // emptyChickens = new MyLinkedList<>();
```

# Optional Assignments

## Make your ArrayList generic

Now that you've made the DLL generic, you can go back and make your ArrayList generic. This will give you further practice and you will come out with a much stronger grasp on working with generics in Java. Data structures you implement from now on will be generic.
