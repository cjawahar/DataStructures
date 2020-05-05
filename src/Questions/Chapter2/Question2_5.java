package Questions.Chapter2;
import LinkedLists.LLNode;

/*
    Two numbers are represented by two linked lists.
    Each node contains a singular digit of the overall number.
    Digits are stored in reverse order, the ones digit is at
    the head of the linked list. Write a function that sums up
    the two numbers and return the answer as a linked list.
    Follow up
    Suppose the digits are stored in forward order, repeat.
 */
public class Question2_5 {
    public static void main(String[] args) {
        // 617
        LLNode firstNum = new LLNode(7, null, null);
        LLNode firstNum2 = new LLNode(1, null, firstNum);
        LLNode firstNum3 = new LLNode(6, null, firstNum2);

        // 295 - use 617 as second test case - in case sum goes over 1000
        LLNode secondNum = new LLNode(7, null, null);
        LLNode secondNum2 = new LLNode(1, null, secondNum);
        LLNode secondNum3 = new LLNode(6, null, secondNum2);

        LLNode result = getSum(firstNum, secondNum, 0);
        System.out.println(result.printForward());

        int one = convertListToInt(firstNum);
        int two = convertListToInt(secondNum);
        int sum = convertListToInt(result);
        System.out.println(one + " + " + two + " = " + sum);
    }

    public static LLNode getSum(LLNode firstNum, LLNode secondNum, int carryNum) {
        // Eventually the recursive call down below will have two nulls
        // Premature exit here if so, need to check the carryNum in order not to lose the remainder.
        if (firstNum == null && secondNum == null && carryNum == 0) {
            return null;
        }

        LLNode result = new LLNode();
        int value = carryNum;
        if (firstNum != null) {
            value += firstNum.data;
        }
        if (secondNum != null) {
            value += secondNum.data;
        }
        // Check if sum was greater than 10, find remainder
        result.data = value % 10;

        // Recursive call -- need a result.next in here somewhere.
        // Need to pass in the remainder if it exists - Need a third parameter in getSum
        if (firstNum != null || secondNum != null) {
            LLNode cont = getSum(firstNum.next, secondNum.next, value > 10 ? 1: 0);
            result.setNext(cont);
        }
        return result;
    }
    // Ex. 2->1->9->null must become 912
    //  Ones, Tens, Hundreds
    // 9*10 = 90
    // (90 + 1) * 10 = 910
    // (910 + 2)
    public static Integer convertListToInt(LLNode result) {
        int value = 0;
        // Start return only when result.next = null
        // Each number is then multiplied by 10 and added.
        if (result.next != null) {
            value = 10 * convertListToInt(result.next);
        }
        return value + result.data;
    }
}
