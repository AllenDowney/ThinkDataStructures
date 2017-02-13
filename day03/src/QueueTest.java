import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueueTest {
    protected MyQueueLL<Integer> queueLL;
    protected MyQueueAL<String> queueAL;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        queueAL = new MyQueueAL<>();
        queueAL.enqueue("Will");
        queueAL.enqueue("the");
        queueAL.enqueue("real");

        queueLL = new MyQueueLL<>();
        queueLL.enqueue(1);
        queueLL.enqueue(2);
        queueLL.enqueue(3);
    }

    /**
     * Tests functionality of the ArrayList-based stack
     */
    @Test
    public void testQueueAL() {
        String slim = "Slim";

        assertThat(queueAL.size(), is(3));
        queueAL.enqueue(slim);
        assertThat(queueAL.size(), is(4));

        String e = queueAL.dequeue();
        assertThat(e, is(slim));
        assertThat(queueAL.size(), is(3));

        assertThat(queueAL.isEmpty(), is(false));
        queueAL.dequeue();
        queueAL.dequeue();
        e = queueAL.dequeue();
        assertThat(e, is("Will"));

        assertThat(queueAL.isEmpty(), is(true));
    }

    /**
     * Tests functionality of the LinkedList-based stack
     */
    @Test
    public void testQueueLL() {
        assertThat(queueLL.size(), is(3));
        Integer e = queueLL.dequeue();
        assertThat(e, is(3));
        assertThat(queueLL.size(), is(2));

        queueLL.enqueue(150);
        assertThat(queueLL.size(), is(3));
        assertThat(queueLL.isEmpty(), is(false));

        queueLL.dequeue();
        assertThat(queueLL.isEmpty(), is(false));

        queueLL.dequeue();
        assertThat(queueLL.isEmpty(), is(false));

        queueLL.dequeue();
        assertThat(queueLL.isEmpty(), is(true));
    }
}
