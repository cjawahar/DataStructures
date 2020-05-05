package Questions.Chapter2;

import LinkedLists.LLNode;
import LinkedLists.randomLinkedList;
/*
    Implement an algorithm to delete a node in the middle of a singly
    linked list, if only given access to that node.
    Example
    Input: node c from linked list a -> b -> c -> d -> e
    Output: nothing is returned but linked list is a -> b -> d -> e
 */
public class Question2_3 {
    public static void main(String[] args) throws Exception {
        randomLinkedList rand = new randomLinkedList();
        LLNode randomList = rand.createRandomLinkedList(10, 10, 20);

        System.out.println(randomList.printForward());
        // Not the same implementation, randomList of size 10
        // Choose one of the nodes?
        deleteNode(randomList.next.next.next);
        System.out.println(randomList.printForward());
    }
    // Won't work if a nextNode doesn't exist, i.e input is the last node in the list.
    public static void deleteNode(LLNode input) throws Exception {
        if (input == null || input.next == null) {
            throw new Exception("Input was null or next node doesn't exist.");
        }
        // Set nextNode to be input's nextNode.
        LLNode nextNode = input.next;
        // Copy data from nextNode to the input node
        // Then delete nextNode by reassigning next.
        // The input node's data/next is overwritten with the nextNode.
        // Effectively, it removes the input node.
        input.data = nextNode.data;
        input.next = nextNode.next;
    }
}
