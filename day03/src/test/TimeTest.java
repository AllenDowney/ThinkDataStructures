package test;

import ADTs.QueueADT;
import ADTs.StackADT;
import your_code.MyQueue;
import your_code.MyStack;


public class TimeTest {

    public static void timeQueue() {

        int[] numOperations = new int[]{1000, 10000, 100000, 1000000};
        long[] runTimes = new long[numOperations.length];
        for (int i = 0; i < numOperations.length; i++) {
            QueueADT<Integer> q = new MyQueue();
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
            System.out.println("Time per operation for n=" + numOperations[i] + ": " + 1000.0 * runTimes[i]
                    / numOperations[i] + " milliseconds");
        }
    }

    public static void timeStack() {

        int[] numOperations = new int[]{1000, 10000, 100000, 1000000};
        long[] runTimes = new long[numOperations.length];
        for (int i = 0; i < numOperations.length; i++) {
            StackADT<Integer> q = new MyStack();
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < numOperations[i]; j++) {
                q.push(j);
            }
            for (int j = 0; j < numOperations[i]; j++) {
                q.pop();
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            runTimes[i] = elapsedTime;
        }

        for (int i = 0; i < numOperations.length; i++) {
            System.out.println("Time per operation for n=" + numOperations[i] + ": " + 1000.0 * runTimes[i]
                    / numOperations[i] + " milliseconds");
        }
    }

    public static void main(String[] args) {
        System.out.println("Timing queue:");
        timeQueue();
        System.out.println();
        System.out.println("Timing stack:");
        timeStack();
    }

}
