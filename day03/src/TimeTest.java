import ADTs.QueueADT;

/**
 * Created by david on 11/12/16.
 */
public class TimeTest {

    public static void main(String[] args) {

        int[] numOperations = new int[]{1000, 1000000, 100000000};
        long[] runTimes = new long[numOperations.length];
        for (int i = 0; i < numOperations.length; i++) {
            QueueADT<Integer> q = new MyQueue<>();
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < numOperations[i]; j++) {
                q.enqueue(j);
            }
            for (int j = 0; j < numOperations[i]; j++) {
                q.dequeue();
            }

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            runTimes[i] = elapsedTime;
        }

        for (int i = 0; i < numOperations.length; i++) {
            System.out.println("Time per operation: " + runTimes[i] / numOperations[i]);
        }

    }

}
