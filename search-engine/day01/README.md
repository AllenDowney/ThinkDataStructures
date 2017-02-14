# Wikipedia Search Engine Project - Day01

## Getting Started with Redis

### Reading

To learn what you can store in Redis, read **Chapter 19** in *Think Algorithms*. **19.5** and **19.6** will be particularly useful.

### Setting up your Redis Instance
  * Go to [redistogo](https://redistogo.com)
  * Select the free plan and set up your account. You need one account for your team.
  * Select "New Instance"
  * Scroll to the bottom and select "Free"
  * You should see an ID that starts with `redis://redistogo`. Copy it.
  * Create a new folder `resources` in the `search-engine/day01` directory.
  * In your Terminal, `cd` into your `search-engine/day01/resources/` directory and execute `touch redis_url.txt`. This is the file `JedisMaker` will read when connecting to your Redis instance.
  * Copy your Redis instance's ID into the `redis_url.txt` file.
  * Read through `JedisMaker.make()`. Assure that your team understand what the code is doing.
  * Follow instructions in `JedisMaker.main()` to get some practice with the Jedis API methods.

### The data you will be storing on Redis
  * A map of each URL to their `TermCounter` data.
  * A map of each term to a set of URLs that contain that term.

*Hint: each of the above objects is the value in a key-value pair in Redis.*

## Due Date (Day01)

This project is split up over three assignments.  Day01 is due **Midnight, Feb. 16**.

## Assignment

### Prerequisites

Start by copying the `Index.java` and `TermCounter.java` files from search engine `day00/src` into your `day01/src` folder. Mark the `src` and `utils` folders as `Sources Root`.  To do this, right click on the `utils` and `src` folders in IntelliJ, select Mark Directory as, and then select Sources Root for `utils` and Test Sources Root for `tests`.

We do not provide test files for this homework. You will need to justify the correctness of your search engine components to your check-off NINJAs.

### Code

You will improve your Indexer and Crawler in this homework.

* For the indexer, after you index each page, push the relevant data to Redis. *Use a `Transaction t = jedis.multi()` to make multiple updates, rather than pushing an update every time you increment a count. This will improve the performance of your indexer.* Here's a sample `Transaction`, updating a TermCounter hash and a urlSet set:
```java
Transaction t = jedis.multi();

String url = "wikipedia.org/wiki/Java_(programming_language)";
String hashname = "TermCounter: " + url;
String term = "programming";
String urlSetKey = "urlSet: " + term;
Integer count = 43;
t.hset(hashname, term, count.toString());
t.sadd(urlSetKey, url);
List<Object> res = t.exec();
return res;
```
* For the crawler, implement `crawl()` that will take each of the URLs in the queue and 1. index the page 2. add all hyperlinks on that page to the queue using the provided method `queueInternalLinks()`. Make sure you do not index the same page repeatedly.
* You are also provided the `StopWords.java` class in `utils/` that has the method `getStopWords()`. This will return a `Set` of stop words that you should not index.

If you get stuck, reference Chapter 19.9 in *Think Algorithms* for some suggested helper methods to work on.


### (Optional) Reading

If you get stuck during the implementation, you can read Chapters 19 and 21 in *Think Algorithms*.
