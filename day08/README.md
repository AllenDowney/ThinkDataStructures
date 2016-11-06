# Day08: Enhancing your indexer and crawler

## Indexer
* indexPage: use TermCounter to index the page at the given URL
* pushTermCounterToRedis: push the data in your TermCounter to Redis using Redis' map DS
* isIndexed
* add
* getURLs
* getCount
* getCounts

## Crawler
* crawl: this method should perform a BFS on the current source page and index every node it encounters

