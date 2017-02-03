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
    public void testCountInts() {
        int[] in = new int[]{1, 1, 3, 4, 1, 4, 5};
        assertThat(Problems.getCountMap(in).toArray(), is(new int[]{3, 1, 2, 1}));

        int[] in2 = new int[]{3, 4, 1, 4, 4};
        assertThat(Problems.getCountMap(in2).toArray(), is(new int[]{1, 3, 1}));

        int[] in3 = new int[]{1, 2, 3, 4};
        assertThat(countInts(in3).toArray(), is(new int[]{1, 1, 1, 1}));

        int[] in4 = new int[]{2, 3, 2, 3, 2, 3, 2};
        assertThat(countInts(in4).toArray(), is(new int[]{4, 3}));

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
