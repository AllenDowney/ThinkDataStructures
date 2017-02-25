import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     * Runtime is NlogN
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        // Maintain a PQ around the median.
        // Always make sure 0 <= belowMedian.size() - aboveMedian.size <= 1
        PriorityQueue<Integer> belowMedian = maxPQ();
        PriorityQueue<Integer> aboveMedian = minPQ();

        double[] runningMedian = new double[inputStream.length];

        for (int i = 0; i < inputStream.length; i++) {
            int value = inputStream[i];
            // Insert into belowMedian if aboveMedian is empty or the value is below the top of aboveMedian.
            boolean insertIntoBelow = aboveMedian.isEmpty() || value <= aboveMedian.peek();
            // Insert into one of the PQs
            boolean b = (insertIntoBelow) ? belowMedian.offer(value) : aboveMedian.offer(value);
            // Correct the sizes of the PQs according to the rule above
            if (belowMedian.size() > aboveMedian.size() + 1) aboveMedian.offer(belowMedian.poll());
            if (belowMedian.size() < aboveMedian.size()) belowMedian.offer(aboveMedian.poll());
            // Calculate the median
            if (belowMedian.size() > aboveMedian.size())
                runningMedian[i] = belowMedian.peek();
            else
                runningMedian[i] = (belowMedian.peek() + aboveMedian.peek()) / 2.0;
        }

        return runningMedian;
    }

}