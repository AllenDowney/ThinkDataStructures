# Wikipedia Search Engine Project - Day02

## Due Date (Day02)

This project is split up over three assignments.  Day02 is due **Midnight, Feb. 20**.

## Assignment

### Prerequisites

* Start by copying the `Index.java`, `TermCounter.java`, and `Crawler.java` files from search engine `day01/src` into your `day02/src` folder. 
* Copy the `redis_url.txt` file from `day01/resources` into `day02/resources`.
* Mark the `src` and `utils` folders as `Sources Root`.  To do this, right click on the `utils` and `src` folders in IntelliJ, select Mark Directory as, and then select Sources Root for `utils` and Test Sources Root for `tests`.

### Code

You will fill in the methods of WikiSearch.java to complete your search engine.  Each of the methods is commented with instructions.  If you get stuck, refer to the optional reading section below.

In `WikiSearch.java`:

* `WikiSearch search(String term, JedisIndex index)`
* `Integer getRelevance(String url)`
* `int totalRelevance(Integer rel1, Integer rel2)`
* `WikiSearch or(WikiSearch that)`
* `WikiSearch and(WikiSearch that)`
* `WikiSearch minus(WikiSearch that)`
* `List<Entry<String, Integer>> sort()`

#### Extension

To explore further and enhance your search engine, choose one of the suggested extensions in **Chapter 22.9** to implement as well.

### (Optional) Reading

If you get stuck during the implementation, you can read Chapter 22 (section 22.4 onwards) in *Think Algorithms*.
