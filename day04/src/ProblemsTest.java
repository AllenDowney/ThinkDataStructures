/**
 *
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author David Abrahams
 *
 */
public class ProblemsTest {


    private class Node<T> {
        T val;
        Node<T> next;

        private Node(T data) {
            this.val = data;
            this.next = null;
        }
    }

    /**
     * Test method for {@link Problems#getCountMap(int[])}.
     */
    @Test
    public void testCountMap() {
        int[] in = new int[]{1, 1, 3, 4, 1, 4, 5};
        Map m = Problems.getCountMap(in);
        assertThat(m.get(1), is(3));
        assertThat(m.get(3), is(1));
        assertThat(m.get(4), is(2));
        assertThat(m.get(5), is(1));

        in = new int[]{3, 4, 1, 4, 4};
        m = Problems.getCountMap(in);
        assertThat(m.get(3), is(1));
        assertThat(m.get(4), is(3));
        assertThat(m.get(1), is(1));

        in = new int[]{1, 2, 3, 4};
        m = Problems.getCountMap(in);
        assertThat(m.get(1), is(1));
        assertThat(m.get(2), is(1));
        assertThat(m.get(3), is(1));
        assertThat(m.get(4), is(1));

        in = new int[]{2, 3, 2, 3, 2, 3, 2};
        m = Problems.getCountMap(in);
        assertThat(m.get(2), is(4));
        assertThat(m.get(3), is(3));

    }

    public Node<Integer> arrToNodes(int[] arr) {
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> current = dummyHead;
        for (int i : arr) {
            Node<Integer> n = new Node<>(i);
            current.next = n;
            current = current.next;
        }

        return dummyHead.next;
    }

    public boolean equalLLists(Node<Integer> head1, Node<Integer> head2) {
        while (head1 != null || head2 != null) {
            if (head1 == null || head2 == null || !(head1.val.equals(head2.val))) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    /**
     * Test method for {@link Problems#sumLists(Problems.Node, Problems.Node)}
     */
    @Test
    public void testSumLists() {
        // Case 1: README example
        int[] a1 = {7, 4, 4, 2};
        int[] a2 = {5, 2, 9};
        int[] soln1 = {7, 9, 7, 1};

        Node<Integer> case1 = arrToNodes(soln1);
        Node<Integer> n1 = arrToNodes(a1);
        Node<Integer> n2 = arrToNodes(a2);
        assertThat(sumLists(n1, n2), is(case1));
    }

}
