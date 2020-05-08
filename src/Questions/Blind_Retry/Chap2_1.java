package Questions.Blind_Retry;

import LinkedLists.LLNode;
import LinkedLists.randomLinkedList;

import java.util.LinkedList;

/*
    Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed.
 */
public class Chap2_1 {
    public static void main(String[] args) {
        randomLinkedList random = new randomLinkedList();
        LLNode unsortedLL = random.createRandomLinkedList(10, 0, 3);

        System.out.println(unsortedLL.printForward());
        //removeDuplicates(unsortedLL);
        secondDelete(unsortedLL);
        System.out.println(unsortedLL.printForward());
    }

    public static void removeDuplicates(LLNode head) {
        if (head == null) return;

        LinkedList<Integer> uniques = new LinkedList<>();
        LLNode temp = null;
        while (head != null) {
            if (!uniques.contains(head.data)) {
                uniques.add(head.data);
                temp = head;
            } else {
                temp.next = head.next;
            }
            head = head.next;
        }
    }

    public static void secondDelete(LLNode head) {
        if (head == null) return;

        while (head != null) {
            LLNode iter = head;
            while (iter.next != null) {
                if (head.data == iter.next.data) {
                    iter.next = iter.next.next;
                } else {
                    iter = iter.next;
                }
            }
            head = head.next;
        }
    }

}
