# Wikipedia Search Engine Project

## Learning Goals
In this project, you will learn to:
* Use persistent storage in the form of Redis
* Make meaningful and justifiable design decisions regarding which data structure(s) to use given specifications/requirements
* Design classes and their appropriate methods
* Learn and understand the functionality of the basic components of a search engine
* Write testable code, and test effectively

## Preparation
* Redis: To learn what you can store in Redis, read **Chapter 19** in Think Algorithms. **19.5** and **19.6** will be particularly useful.

## Redis

### Reading

To learn what you can store in Redis, read **Chapter 19** in Think Algorithms. **19.5** and **19.6** will be particularly useful.

### Set-up

  * Go to [redistogo](https://redistogo.com)
  * Select the free plan and set up your account. You need 1 account for your team.
  * Select "New Instance"
  * Scroll to the bottom and select "Free"
  * You should see an ID that starts with `redis://redistogo`. Copy it.
  * In your Terminal, `cd` into your `day07/resources/` directory and execute `touch redis_url.txt`. This is the file `JedisMaker` will read when connecting to your Redis instance.
  * Copy your Redis instance's ID into the file.
  * Read through `JedisMaker.make()`. Assure that your team understand what the code is doing.
  * Follow the instructions in `JedisMaker.main()`.


## Jsoup

### Set-up

No fancy set up required here. Just read through `WikiFetcher.java`. Make sure your team understand what `fetchWikipedia` is doing.

## Specifications

Your team is going to design a Wikipedia search engine that comprises of the following components:

* *Crawler*: A program that can download a web page, parse it, and then "crawl" to other pages via hyperlinks.
* *Indexer*: We’ll need an index that makes it possible to look up a search term and find the pages that contain it.
* *SearchTool*: A way to collect results from the Index and identify pages that are relevant to the search terms.
* *Persistent Storage*: Store the data from your Indexer on a database (Redis)

### Crawler Requirements

Your Crawler should take in a starting page url. It should then:

* "Index" the page
* "Crawl" wikipedia by accessing hyperlinks on the given page. How it crawls is up to you. It can look at all pages directly linked on the initial input page, it can look at the first 10 pages, it can look at all pages within 2 clicks, etc. You decide based on how much time and space is required.

You will also write a test class that verifies your Crawler's functionality.

#### If you're stuck

Chapter 10 in Think Algorithms details using jsoup to iterate through a page DOM.

### Indexer Requirements

* Stores information about which pages terms occur on, and saves and retrieves this data to and from your Redis instance.
  * When saving, it saves to the hash for a given keyword that maps from url to score.
  * When retrieving, it must return URLs containing the given keyword(s).
* Given a page, your Indexer will count the number of occurences of each word on that page. For each keyword **k**, it will save the pair url:score to that **k**'s value in the Redis hash.
* Processes a page in **O(W)**, where W is the number of words on that page.
* Queries for pages containng keywords in **O(N)**, where N is the number of relevant URLs.
* Saves the indexing data of a page to Redis in **O(T)**, where T is the number of unique terms on that page.
* A test class that verifies your Indexer's functionality.

#### If you're stuck

Chapter 11 in Think Algorithms details how to take in a page and count the terms.

### SearchTool Requirements
* Supports searching for a given keyword, returns pages that word appears on.
* A test class that verifies your operators and sorting functionalities.
* **Stretch goal**
  * Supports union, intersection, and difference operators on search terms.
    * **Union** e.g. given, "arrays OR lists" returns 3 URLs containing either of those keywords
    * **Intersection** e.g. given "arrays AND lists", returns 3 URLs containing both keywords
    * **Difference** e.g. given "arrays NOT lists", returns 3 URLs containing the first keyword but not the second
  * Sorts results by relevance (how do you determine relevance? - this can be ask simple as word frequency).
