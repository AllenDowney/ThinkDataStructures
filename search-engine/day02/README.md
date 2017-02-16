# Wikipedia Search Engine Project - Day02

## Due Date (Day02)

This project is split up over three assignments.  Day02 is due **Midnight, Feb. 20**.

## Assignment

### Prerequisites

Start by copying the `Index.java`, `TermCounter.java`, and `Crawler.java` files from search engine `day00/src` into your `day01/src` folder. Mark the `src` and `utils` folders as `Sources Root`.  To do this, right click on the `utils` and `src` folders in IntelliJ, select Mark Directory as, and then select Sources Root for `utils` and Test Sources Root for `tests`.

We do not provide test files for this homework. You will need to justify the correctness of your search engine components to your check-off NINJAs.

### Code

You will fill in the methods of WikiSearch.java to complete your search engine.  Each of the methods is commented with instructions.  If you get stuck, refer to the optional reading section below.

In `WikiSearch.java`:

* `WikiSearch search(String term, JedisIndex index)`
* `Integer getRelevance(String url)`
* `WikiSearch or(WikiSearch that)`
* `WikiSearch and(WikiSearch that)`
* `WikiSearch minus(WikiSearch that)`
* `List<Entry<String, Integer>> sort()`


### (Optional) Reading

If you get stuck during the implementation, you can read Chapter 22 in *Think Algorithms*.
