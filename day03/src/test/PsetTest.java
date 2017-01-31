package test;

import ADTs.StackADT;
import org.junit.Test;
import your_code.MyStack;
import your_code.PsetProblems;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PsetTest {

    @Test
    public void testLongestValidSubstring() {
        assertThat(PsetProblems.longestValidSubstring("(()))("), is(4));
        assertThat(PsetProblems.longestValidSubstring("(()()))()"), is(6));
        assertThat(PsetProblems.longestValidSubstring("))(("), is(0));
    }

    @Test
    public void testSortStackLimitedMemory() {
        StackADT<Integer> s = new MyStack();
        s.push(4);
        s.push(2);
        s.push(7);
        s.push(1);
        s.push(6);
        s.push(19);
        s.push(2);

        StackADT<Integer> r = PsetProblems.sortStackLimitedMemory(s);

        assertThat(r.pop(), is(19));
        assertThat(r.pop(), is(7));
        assertThat(r.pop(), is(6));
        assertThat(r.pop(), is(4));
        assertThat(r.pop(), is(2));
        assertThat(r.pop(), is(2));
        assertThat(r.pop(), is(1));
    }

}
