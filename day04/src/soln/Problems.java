package soln;

import java.util.Map;

public class Problems {

    private class Node<T> {
        T val;
        Node next;

        private Node(T data) {
            this.val = data;
            this.next = null;
        }
    }

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        Map<Integer, Integer> countMap = new MyLinearMap<>();
        for (int i : arr) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        return countMap;
    }

    public Node<Integer> sumLists(Node<Integer> l1, Node<Integer> l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

     public Node<Integer> reverseList(Node<Integer> head){
         Node<Integer> previous = null;
         Node<Integer> current;
         while (head != null) {
             current = head;
             head = head.next;
             current.next = previous;
             previous = current;
         }
         return previous;
     }

    public int[] smallestPossible(int k, int[] arr) {
        // TODO: your code here
        return null;
    }

}
