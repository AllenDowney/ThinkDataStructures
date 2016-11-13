import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    protected MyStack<String> stack;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        stack = new MyStack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Java");
    }

    /**
     * Tests functionality of the stack
     */
    @Test
    public void testStack() {
        assertThat(stack.size(), is(3));
        stack.push("Fourth");
        assertThat(stack.size(), is(4));


        // TODO: Uncomment these tests if you implemented maxElement
//        assertThat(stack.maxElement(), is("World"));
        String e = stack.pop();
        assertThat(e, is("Fourth"));
        assertThat(stack.size(), is(3));

        String lateString = "ZZZ. I'm sleeping. Also, quite late in the alphabet.";
        stack.push(lateString);
//        assertThat(stack.maxElement(), is(lateString));

        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        stack.pop();
        stack.pop();
//        assertThat(stack.maxElement(), is("Hello"));
        e = stack.pop();
        assertThat(e, is("Hello"));

        assertThat(stack.isEmpty(), is(true));
    }

}
