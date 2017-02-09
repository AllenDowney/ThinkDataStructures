# Wikipedia Search Engine Project - Day00

## Project Description

### Learning Goals

In this project, you will learn to:

* Use persistent storage in the form of Redis
* Make meaningful and justifiable design decisions regarding which data structure(s) to use given specifications/requirements
* Design classes and their appropriate methods
* Learn and understand the functionality of the basic components of a search engine
* Write testable code, and test effectively

### Specifications

Your team is going to design a Wikipedia search engine that comprises of the following components:

* *Crawler*: A program that can download a web page, parse it, and then "crawl" to other pages via hyperlinks.
* *Indexer*: We’ll need an index that makes it possible to look up a search term and find the pages that contain it.
* *SearchTool*: A way to collect results from the Index and identify pages that are relevant to the search terms.
* *Persistent Storage*: Store the data from your Indexer on a database (Redis)

## Due Date (Day00)

The project is split up over three assignments.  Day00 is due:

**Midnight, Feb. 13**

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
