# Wikipedia Search Engine Project - Day00

## Learning Goals

In this project, you will learn to:

* Use persistent storage in the form of Redis
* Make meaningful and justifiable design decisions regarding which data structure(s) to use given specifications/requirements
* Design classes and their appropriate methods
* Learn and understand the functionality of the basic components of a search engine
* Write testable code, and test effectively

## Due Date

Day00: 

Midnight, Feb. 13

## Assignment

### Reading

In *Think Algorithms*, read the following sections:

* 
* 

### Code

Finish the implementation of these methods in TermCounter.java:

* `TermCounter(String label)`
* `String getLabel()`
* `int size()`
* `void processElements(Elements paragraphs)`
* `void printCounts()`

Finish the implementation of these methods in Index.java:

* `void get(String term)`
* `void indexPage(String url, Elements paragraphs)`
* `void printIndex()`

Finish the implementation of these methods in WikiPhilosophy.java:

* `void testConjecture(String destination, String source, int limit)`
