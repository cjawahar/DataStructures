package Questions.Blind_Retry;

import LinkedLists.LLNode;
import LinkedLists.randomLinkedList;

import java.util.Scanner;

/*
    Implement an algorithm to find the kth to last
    element of a singly linked list.
    EX. 3rd to last element
 */
public class Chap2_2 {

    public static void main(String[] args) {
        int[] inputs = getProgramInputs();
        randomLinkedList random = new randomLinkedList();
        LLNode randomLL = random.createRandomLinkedList(inputs[0], inputs[1], inputs[2]);

        System.out.println(randomLL.printForward());

        LLNode kthNode = find_k_ele(randomLL, inputs[3]);
        System.out.println("The kth node is: " + kthNode.data);
    }

    public static LLNode find_k_ele(LLNode head, int kth) {
        LLNode first = head;
        LLNode second = head;

        if (kth <= 0) return null;

        for (int i = 0; i < kth; i++) {
            second = second.next;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }

        return first;
    }

    public static int[] getProgramInputs() {
        int[] inputs = new int[4];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length of linked list?");
        inputs[0] = scanner.nextInt();
        System.out.println("Minimum value in the linked list?");
        inputs[1] = scanner.nextInt();
        System.out.println("Maximum value in the linked list?");
        inputs[2] = scanner.nextInt();
        System.out.println("Kth element to find from end of linked list?");
        inputs[3] = scanner.nextInt();

        return inputs;
    }
}
