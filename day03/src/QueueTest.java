import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueueTest {
    protected MyQueue<Integer> queue;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    /**
     * Tests functionality of the LinkedList-based stack
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
}
