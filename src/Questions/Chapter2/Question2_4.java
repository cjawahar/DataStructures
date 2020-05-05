package Questions.Chapter2;

import LinkedLists.LinkedListNode;
import LinkedLists.randomLinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Write code to partition a linked list around a value x,
    such that all nodes less than x come before all nodes greater
    than or equal to x.
 */
public class Question2_4 {
    public static void main(String[] args) {
        randomLinkedList rand = new randomLinkedList();
        ArrayList<Integer> inputs = getInputs();

        LinkedListNode list = rand.createRandomLinkedList(inputs.get(0), inputs.get(1), inputs.get(2));
        System.out.println(list.printForward());
        LinkedListNode returnList = partitionList(list, inputs.get(3));
        System.out.println(returnList.printForward());
    }
    /*
        Example: Partition: 15
                  11->12->25->7->25->15
        Iteration 1:
        11<15     11->12->25->7->25->15
        Iteration 2:
        12<15     12->11->25->7->25->15
        Iteration 3:
        25>15     12->11->7->25->15->25
        Iteration 4:
        7<15      7->12->11->25->15->25
        Iteration 5:
        25>15     7->12->11->15->25->25
        Iteration 6:
        15<15     15->7->12->11->25->25
        Above equality is according to how it's coded.

        Final:    15->7->12->11->25->25
     */
    // Order not required just < than and > than.
    public static LinkedListNode partitionList(LinkedListNode inputList, int partition) {
        LinkedListNode newHead = inputList;
        LinkedListNode newTail = inputList;

        // Start at beginning
        while (inputList != null) {
            LinkedListNode nextNode = inputList.next;
            // Adding to tail here
            if (inputList.data > partition) {
                newTail.next = inputList;
                newTail = inputList;
            }
            // Adding to head here
            else {
                inputList.next = newHead;
                newHead = inputList;
            }
            // replace original input with the saved next node from above.
            inputList = nextNode;
        }
        newTail.next = null;
        //System.out.println(newHead.printForward());
        //System.out.println(newTail.printForward());
        return newHead;
    }

    public static ArrayList<Integer> getInputs() {
        ArrayList<Integer> returnArr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer value for the length of the linked list");
        returnArr.add(scanner.nextInt());
        System.out.println("Enter an integer value for the minimum value of the data field");
        returnArr.add(scanner.nextInt());
        System.out.println("Enter an integer value for the maximum value of the data field");
        returnArr.add(scanner.nextInt());
        System.out.println("Enter an integer value X where the linked list will be partitioned around");
        returnArr.add(scanner.nextInt());

        return returnArr;
    }
}
