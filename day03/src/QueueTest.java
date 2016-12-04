import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueueTest {

    private MyQueue queue;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    /**
     * Tests functionality of the LinkedList-based queue
     */
    @Test
    public void testQueue() {
        assertThat(queue.size(), is(3));
        Integer e = queue.dequeue();
        assertThat(e, is(1));
        assertThat(queue.size(), is(2));

        queue.enqueue(150);
        assertThat(queue.size(), is(3));
        assertThat(queue.isEmpty(), is(false));

        e = queue.dequeue();
        assertThat(e, is(2));
        assertThat(queue.isEmpty(), is(false));

        e = queue.dequeue();
        assertThat(e, is(3));
        assertThat(queue.isEmpty(), is(false));

        e = queue.dequeue();
        assertThat(e, is(150));
        assertThat(queue.isEmpty(), is(true));
    }

    // /**
    //  * Tests functionality of the LinkedList-based queue
    //  */
    // @Test
    // public void testSlidingWindow() {
    //     int[] arr = new int[]{5, 3, 2, 6, 5, 2, 9, 10, 2};
    //     int[] maxInWindows = SlidingWindow.maxInWindows(arr, 3);
    //     int[] expectedAnswer = new int[]{5, 6, 6, 6, 9, 10, 10};
    //     assertThat(maxInWindows, is(expectedAnswer));
    // }
}
