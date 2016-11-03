import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    protected MyStackLL<Double> stackLL;
    protected MyStackAL<String> stackAL;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        stackAL = new MyStackAL<>();
        stackAL.push("Hello");
        stackAL.push("World");
        stackAL.push("Java");

        stackLL = new MyStackLL<>();
        stackLL.push(1.5);
        stackLL.push(Math.PI);
        stackLL.push(Math.E);
    }

    /**
     * Tests functionality of the ArrayList-based stack
     */
    @Test
    public void testStackAL() {
        assertThat(stackAL.size(), is(3));
        stackAL.push("Fourth");
        assertThat(stackAL.size(), is(4));

        String e = stackAL.pop();
        assertThat(e, is("Fourth"));
        assertThat(stackAL.size(), is(3));

        assertThat(stackAL.isEmpty(), is(false));
        stackAL.pop();
        stackAL.pop();
        e = stackAL.pop();
        assertThat(e, is("Hello"));

        assertThat(stackAL.isEmpty(), is(true));
    }

    /**
     * Tests functionality of the LinkedList-based stack
     */
    @Test
    public void testStackLL() {
        assertThat(stackLL.size(), is(3));
        Double e = stackLL.pop();
        assertThat(e, is(Math.E));
        assertThat(stackLL.size(), is(2));

        stackLL.push(1.41);
        assertThat(stackLL.size(), is(3));
        assertThat(stackLL.isEmpty(), is(false));

        stackLL.pop();
        assertThat(stackLL.isEmpty(), is(false));

        stackLL.pop();
        assertThat(stackLL.isEmpty(), is(false));

        stackLL.pop();
        assertThat(stackLL.isEmpty(), is(true));
    }
}
