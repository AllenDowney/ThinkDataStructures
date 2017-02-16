# Wikipedia Search Engine Project - Day02

## Due Date (Day02)

This project is split up over three assignments.  Day01 is due **Midnight, Feb. 20**.

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
