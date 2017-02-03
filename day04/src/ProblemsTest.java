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
     * Test method for {@link Problems#sumLists(Node, Node)}
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
        assertThat(Problems.sumLists(n1, n2), is(case1));

        // Case 2: overflow example
        int[] a3 = {9, 9, 9};
        int[] a4 = {9, 9, 9};
        int[] soln2 = {1, 9, 9, 8};

        Node<Integer> case2 = arrToNodes(soln2);
        Node<Integer> n3 = arrToNodes(a3);
        Node<Integer> n4 = arrToNodes(a4);
        assertThat(Problems.sumLists(n3, n4), is(case2));

        // Case 3: different lengths
        int[] a5 = {9, 9, 9};
        int[] a6 = {9, 9, 9};
        int[] soln3 = {1, 9, 9, 8};

        Node<Integer> case3 = arrToNodes(soln3);
        Node<Integer> n5 = arrToNodes(a5);
        Node<Integer> n6 = arrToNodes(a6);
        assertThat(Problems.sumLists(n5, n6), is(case3));

        // Case 3: zeros
        int[] a7 = {0};
        int[] a8 = {0};
        int[] soln4 = {0};

        Node<Integer> case4 = arrToNodes(soln4);
        Node<Integer> n7 = arrToNodes(a7);
        Node<Integer> n8 = arrToNodes(a8);
        assertThat(Problems.sumLists(n7, n8), is(case4));
    }

}
