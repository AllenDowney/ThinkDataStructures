import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private MyStack stack;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        stack = new MyStack();
        stack.push(1);
        stack.push(4);
        stack.push(2);
    }

    /**
     * Tests functionality of the stack
     */
    @Test
    public void testStack() {
        assertThat(stack.size(), is(3));
        stack.push(3);
        assertThat(stack.size(), is(4));


        // TODO: Uncomment these tests if you implemented maxElement
//        assertThat(stack.maxElement(), is(4));
        int e = stack.pop();
        assertThat(e, is(3));
        assertThat(stack.size(), is(3));

        int bigNumber = 6;
        stack.push(bigNumber);
//        assertThat(stack.maxElement(), is(bigNumber));

        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        stack.pop();
        stack.pop();
//        assertThat(stack.maxElement(), is(1));
        e = stack.pop();
        assertThat(e, is(1));

        assertThat(stack.isEmpty(), is(true));
    }

}
