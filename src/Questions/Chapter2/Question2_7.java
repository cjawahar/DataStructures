package Questions.Chapter2;

import LinkedLists.LLNode;

import java.util.Stack;

/*
    Implement a function to check if a linked list is a palindrome.
 */
public class Question2_7 {
    public static void main(String[] args) {
        // Data field is an int, just use numbers
        LLNode one = new LLNode(1, null, null);
        LLNode two = new LLNode(2, null, one);
        LLNode three = new LLNode(2, null, two);
        LLNode four = new LLNode(1, null, three);

        System.out.println(one.printForward());
        boolean isPalindrome = checkPalindrome(one);
        System.out.println(isPalindrome);
    }

    public static boolean checkPalindrome(LLNode head) {
        LLNode fast = head, slow = head;

        Stack<Integer> stack = new Stack<Integer>();
        // Populate the stack
        // Only need HALF the values in stack (initial half of LL)
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        /*
            Pop elements from stack and compare with slow node.
            The slow node will be at the halfway point of the LL.
            Continue the iteration and check against second half of LL.
            Stack is LIFO
         */
        while (slow != null) {
            int popVal = stack.pop();

            if (popVal != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
