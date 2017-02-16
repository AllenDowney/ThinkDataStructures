
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.Jedis;


/**
 * Represents the results of a search query.
 *
 */
public class WikiSearch {

    // map from URLs that contain the term(s) to relevance score
    private Map<String, Integer> map;

    /**
     * Constructor.
     */
    public WikiSearch(Map<String, Integer> map) {
        this.map = map;
    }

    /**
     * Looks up the relevance of a given URL.
     */
    public Integer getRelevance(String url) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     * Prints the contents in order of term frequency.
     *
     * @param
     */
    private  void print() {
        List<Entry<String, Integer>> entries = sort();
        for (Entry<String, Integer> entry: entries) {
            System.out.println(entry);
        }
    }

    /**
     * Computes the union of two search results.
     *
     * @param that
     * @return New WikiSearch object.
     */
    public WikiSearch or(WikiSearch that) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     * Computes the intersection of two search results.
     *
     * @param that
     * @return New WikiSearch object.
     */
    public WikiSearch and(WikiSearch that) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     * Computes the intersection of two search results.
     *
     * @param that
     * @return New WikiSearch object.
     */
    public WikiSearch minus(WikiSearch that) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     * Computes the relevance of a search with multiple terms.
     *
     * @param rel1: relevance score for the first search
     * @param rel2: relevance score for the second search
     * @return
     */
    protected int totalRelevance(Integer rel1, Integer rel2) {
        // TODO: FILL THIS IN!
        return 0;
    }

    /**
     * Sort the results by relevance.
     *
     * @return List of entries with URL and relevance.
     */
    public List<Entry<String, Integer>> sort() {
        // TODO: FILL THIS IN!
        return null;
    }


    /**
     * Performs a search and makes a WikiSearch object.
     *
     * @param term
     * @param index
     * @return
     */
    public static WikiSearch search(String term, Index index) {
        // TODO: Use the index to get a map from URL to count
        Map<String, Integer> map = null; // Fix this
        // Store the map locally in the WikiSearch
        return new WikiSearch(map);
    }

    public static void main(String[] args) throws IOException {

        // make a Index
        Jedis jedis = JedisMaker.make();
        Index index = new Index(jedis); // You might need to change this, depending on how your constructor works.

        // search for the first term
        String term1 = "java";
        System.out.println("Query: " + term1);
        WikiSearch search1 = search(term1, index);
        search1.print();

        // search for the second term
        String term2 = "programming";
        System.out.println("Query: " + term2);
        WikiSearch search2 = search(term2, index);
        search2.print();

        // compute the intersection of the searches
        System.out.println("Query: " + term1 + " AND " + term2);
        WikiSearch intersection = search1.and(search2);
        intersection.print();
    }
}