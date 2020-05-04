package Questions.Chapter2;

import LinkedLists.LinkedListNode;
import java.util.ArrayList;
import java.util.HashSet;
/*
    Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed.
 */
public class Question2_1 {
    public static void main(String[] args) {
        //How to make an unsorted linked list?
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode second = first; // use first/second as temp nodes

        LinkedListNode head = first; // Actual head of LL

        for (int i = 1; i < 6; i++) {
            // Data will be only 0 or 1.
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            // second currently doesn't have a next node, added next iteration.
            first = second;
        }

        LinkedListNode clone = head.clone();

        System.out.println("Head LL: " + head.printForward());
        deleteDuplicates(head);
        System.out.println(head.printForward());

        System.out.println("Clone LL: " + clone.printForward());
        noBufferDelete(clone);
        System.out.println(clone.printForward());
    }

    // Sets only accept unique values -- use that to parse the linkedlist.
    // LinkedListNode contains, next, previous
    public static void deleteDuplicates(LinkedListNode input) {
        if (input == null) return;

        //HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        LinkedListNode tempPrev = null;
        while (input != null) {
             /*
                Well...we aren't adding every iter, checking with .contains
                Guess we don't need set, could use HashTable or ArrayList.
              */
//            if (!set.contains(input.data)) {
//                set.add(input.data);
//                tempPrev = input;
//            }
            if (!arrayList.contains(input.data)) {
                arrayList.add(input.data);
                tempPrev = input;
            }
            else {
                //"delete" here by updating the next pointer
                tempPrev.next = input.next;
            }
            input = input.next;
        }
    }

    // Can't use buffer to store values
    public static void noBufferDelete(LinkedListNode input) {
        if (input == null) return;
        LinkedListNode current = input;

        while (current != null) {
            LinkedListNode iter = current;
            // 1 by 1 checking.
            while (iter.next != null) {
                // Delete by updating iter's to skip the next node.
                if (current.data == iter.next.data) {
                    iter.next = iter.next.next;
                } else {
                    iter = iter.next;
                }
            }
            current = current.next;
        }
    }
}
