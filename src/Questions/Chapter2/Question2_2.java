package Questions.Chapter2;

import LinkedLists.LinkedListNode;
import LinkedLists.randomLinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Implement an algorithm to find the kth to last
    element of a singly linked list.
    EX. 3rd to last element
 */
public class Question2_2 {
    public static void main(String[] args) {
        int[] input = getProgramInputs();
        // Min, Max are changeable but not asked for in getProgramInputs.
        randomLinkedList rand = new randomLinkedList();
        LinkedListNode list = rand.createRandomLinkedList(input[0], 5, 25);
        LinkedListNode returnNode = find_K_ele(list, input[1]);

        System.out.println("Original LL: " + list.printForward());
        if (returnNode == null) {
            throw new NullPointerException("Return node was null, kth element must be lower than LL input length");
        }
        System.out.println(input[1] + "th to last node is: " + returnNode.data);
    }

    public static LinkedListNode find_K_ele(LinkedListNode input, int k) {
        LinkedListNode iter1 = input;
        LinkedListNode iter2 = input;
        if (k <= 0) return null;
        // Initial loop to move iter2 ahead by k nodes.
        for (int i = 0; i < k; i++) {
            if (iter2 == null) {
                return null;
            }
            iter2 = iter2.next;
        }
        // move both iter's to end of list, iter1 would the answer.
        while (iter2 != null) {
            iter1 = iter1.next;
            iter2 = iter2.next;
        }
        return iter1;
    }

    private static int[] getProgramInputs() {
        int[] returnArr = new int[2];
        int kth = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length of linked list");
        int listLen = scanner.nextInt();
        System.out.println("Enter kth to last element - to find in linked list: ");

        try {
            kth = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("kth input must be an integer");
            // Is System.exit() ok to use here?
            System.exit(1);
        }

        if (kth > listLen) {
            throw new NumberFormatException("kth input must be lower than input linked list length");
        }
        returnArr[0] = listLen;
        returnArr[1] = kth;
        return returnArr;
    }
}
