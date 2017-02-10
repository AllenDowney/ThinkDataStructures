# Wikipedia Search Engine Project - Day00

## Project Description

### Learning Goals

In this project, you will learn to:

* Use Redis as persistent storage
* Design classes with appropriate methods and their implementations
* Learn and understand the functionality of the basic components of a search engine

### Specifications

Your team is going to design a Wikipedia search engine that comprises of the following components:

* *Crawler*: A program that can download a web page, parse it, and then "crawl" to other pages via hyperlinks.
* *Indexer*: We’ll need an index that makes it possible to look up a search term and find the pages that contain it.
* *SearchTool*: A way to collect results from the Index and identify pages that are relevant to the search terms.
* *Persistent Storage*: Store the data from your Indexer on a database (Redis)

## Due Date (Day00)

This project is split up over three assignments.  Day00 is due **Midnight, Feb. 13**.

## Assignment

### Code

Each file has comments with definitions for the methods listed below.  If you get stuck, refer to the optional reading section.

Complete these methods:

in `TermCounter.java`:

* `int size()`
* `void processText(String text)`
* `void incrementTermCount(String term)`
* `void put(String term, int count)`
* `Integer get(String term)`

in `Index.java`:

* `void add(String term, TermCounter tc)`
* `Set<TermCounter> get(String term)`
* `void indexPage(String url, Elements paragraphs)`

in `WikiPhilosophy.java`:

* `boolean testConjecture(String destination, String source, int limit)`

### (Optional) Reading

If you get stuck during the implementation, you can read the following sections in *Think Algorithms*:

* TermCounter: Chapter 12.1-12.5
* Index: Chapter 12.6
* WikiPhilosophy: Chapter 11
