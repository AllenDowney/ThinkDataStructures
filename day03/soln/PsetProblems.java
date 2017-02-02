package your_code;

import ADTs.StackADT;

import java.util.Stack;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        StackADT<Integer> stack = new MyStack();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c==')' && s.charAt(stack.peek())=='(')
                stack.pop();
            else
                stack.push(i);
        }
        int end_valid = s.length();
        int start_valid = s.length();

        int longest = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
                end_valid = i;
            } else {
                start_valid = i;
            }
            if (end_valid-start_valid>longest)
                longest = end_valid-start_valid;
        }
        return longest;
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        StackADT<Integer> helperStack = new MyStack();

        Integer current;
        while (!s.isEmpty()) {
            current = s.pop();

            // Figure out where to add current to stack
            while (!(helperStack.isEmpty() || current <= helperStack.peek())) {
                s.push(helperStack.pop());
            }
            helperStack.push(current);
        }

        return helperStack;
    }

}
