# Wikipedia Search Engine Project - Day01

## Getting Started with Redis

### Reading

To learn what you can store in Redis, read **Chapter 19** in *Think Algorithms*. **19.5** and **19.6** will be particularly useful.

### Set-up

  * Go to [redistogo](https://redistogo.com)
  * Select the free plan and set up your account. You need one account for your team.
  * Select "New Instance"
  * Scroll to the bottom and select "Free"
  * You should see an ID that starts with `redis://redistogo`. Copy it.
  * Create a new folder `resources` in the `search-engine/day01/` directory.
  * In your Terminal, `cd` into your `search-engine/day01/resources/` directory and execute `touch redis_url.txt`. This is the file `JedisMaker` will read when connecting to your Redis instance.
  * Copy your Redis instance's ID into the `redis_url.txt` file.
  * Read through `JedisMaker.make()`. Assure that your team understand what the code is doing.
  * Run the example code in JedisMaker.main() to understand the data types and methods used.


## Jsoup

### Set-up

No fancy setup required here. Just read through `WikiFetcher.java`. Make sure your team understands what `fetchWikipedia` is doing.

## Due Date (Day01)

This project is split up over three assignments.  Day01 is due **Midnight, Feb. 16**.

## Assignment

### Prerequisites

Start by copying the `Index.java` and `TermCounter.java` files from search engine `day00` into your `day01/src` folder.  Because the project is organized into the `src`, `utils`, and `tests` folders, you will need to mark all of them as source folders in IntelliJ as with the last homework.  To do this, right click on the folder in IntelliJ, select Mark Directory as, and finally select Sources Root.

### Code

Each file has comments with definitions for the methods listed below along with the written definitions below.  If you get stuck, refer to the optional reading section.

To complete the Indexer, implement the following methods:

In `JedisIndex.java`:

* `void indexPage(String url, Elements paragraphs)`: Takes a URL and JSoup Elements object that contains the elements of the page that should be indexed and adds the web page to the index.
* `Map<String, Integer> getCounts(String term)`: Takes a search term and returns a map from each URL that contains the search term to the number of times is appears on that page.
* `void add(String term)`: Add a URL to the set associated with term.
* `Set<String> getURLs(String term)`: Looks up a search term and returns a set of URLs
* Integer getCount(String url, String term): Returns the number of times the given term appears at the given URL.
* List <Object> pushTermCounterToRedis(TermCounter tc): Pushes the contents of the term counter to Redis.


To complete the Crawler, read section 21.2 in *Think Algorithms* to get the functionality list for the crawl function.  Then implement the following method:

In `WikiCrawler.java`:

* `String crawl(boolean testing) throws IOException`


### (Optional) Reading

If you get stuck during the implementation, you can read the following sections in *Think Algorithms*:

* JedisIndex: Chapter 19
* WikiCrawler: Chapter 20
