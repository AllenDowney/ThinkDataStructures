# Wikipedia Search Engine Project

## Learning Goals
In this project, you will learn to:
* Use persistent storage in the form of Redis
* Make meaningful design decisions (and be able to defend them!) regarding which data structure(s) to use given specifications/requirements
* Design classes and their appropriate methods
* Learn and understand the functionality of the basic components of a search engine
* Write testable code, and test effectively

## Preparation
* Read about search engine
* Set up Redis
  * Go to [redistogo](https://redistogo.com)
  * Select the free plan and set up your account. You need 1 account for your team.
  * Select "New Instance"
  * Scroll to the bottom and select "Free"
  * You should see an ID that starts with `redis://redistogo`. Copy it.
  * In your Terminal, `cd` into your `day07/resources/` directory and execute `touch redis_url.txt`. This is the file `JedisMaker` will read when connecting to your Redis instance.
  * Copy your Redis instance's ID into the file.
  * Read through `JedisMaker.make()`. Assure that your team understand what the code is doing.
  * Follow the instructions in `JedisMaker.main()`.
* Set up Jsoup
  * No fancy set up required here. Just read through `WikiFetcher.java`. Make sure your team understand what `fetchWikipedia` is doing.

## Specifications
Your team is going to design a Wikipedia search engine that comprise of the
following components:
* *Crawler*: "crawls" from page to page via hyperlinks
* *Indexer*: keep track of which pages contain which search terms
* *SearchTool*: takes search terms and boolean operators and returns the most relevant results.
* *Persistent Storage*: Redis

### Redis Requirements
* No set up here on your side, just a quick note about what kind of data you'll be storing on Redis:
  * You will be storing one massive hash (a Redis data structure), in which you map keywords (words that are not in the set of stop words) to a set of tuples (url, score): url is the URL of the page containing that keyword, and score is the number of times that keyword appears on the page at that URL.

### Crawler Requirements
* Your Crawler's job is to, given a page, locate and retrieve hyperlinks to other pages. It can keep doing this for as long as you want (you may choose to only look at that page, or all pages 1 hyperlinks away, or all pages 3 hyperlinks away). You decide based on how much time and space is required.
* A test class that verifies your Crawler's functionality.

### Indexer Requirements
* Saves and retrieves data to and from your Redis instance.
  * When saving, it saves to the hash that maps keywords to (url, score) tuples.
  * When retrieving, it must return the top 3 (or fewer) URLs containing the given keyword(s).
* Given a page, your Indexer will count the number of occurences of keywords on that page. For each keyword **k**, it will save the tuple (url, score) to that **k**'s value in the Redis hash.
* Processes a page in **O(W)**, where W is the number of words on that page.
* Queries for pages containg keywords in **O(N)**, where N is the number of relevant URLs.
  * A query is a search phrase like "java AND programming". See the **SearchTool Requirements** section below for more details.
* Saves the indexing data of a page to Redis in **O(T)**, where T is the number of unique terms on that page.
* A test class that verifies your Indexer's functionality.


### SearchTool Requirements
* Supports union, intersection, and difference operators on search terms.
  * **Union** e.g. given, "arrays OR lists" returns 3 URLs containing either of those keywords
  * **Intersection** e.g. given "arrays AND lists", returns 3 URLs containing both keywords
  * **Difference** e.g. given "arrays NOT lists", returns 3 URLs containing the first keyword but not the second
* Sorts results by relevance (how do you determine relevance? - this can be ask simple as word frequency).
* A test class that verifies your operators and sorting functionalities.
