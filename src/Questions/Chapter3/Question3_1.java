package Questions.Chapter3;

import Stacks_Queues.Stack;

/*

 */
public class Question3_1 {
    static int stackSize = 10;
    // buffer contains enough space for 3 stacks.
    static int[] buffer = new int[stackSize * 3];
    // 3 pointers, start at -1 so first one starts at 0 when incremented.
    // Keeps track of how many values have been added to each partition.
    // empty means the stackPointer value is -1.
    static int[] stackPointer = {-1, -1, -1};

    public static void main(String[] args) throws Exception {
        //stackCheck();

        push(0, 10);
        push(1, 20);
        push(2, 30);

        peek(0);
        peek(1);
        peek(2);

        pop(0);
        push(0, 11);
        peek(0);
    }

    // need custom push, pop, peek methods
    static void push(int stackNum, int dataVal) throws Exception {
        if (stackPointer[stackNum] + 1 >= stackSize) {
            //error stack is full
            throw new Exception("Error: Stack " + stackNum + " is full");
        }
        // increment pointer
        stackPointer[stackNum]++;
        // how to add to correct section - need another method.
        buffer[topOfStack(stackNum)] = dataVal;
        System.out.println(dataVal + " added to Stack " + stackNum);
    }

    static void pop(int stackNum) throws Exception {
        if (isStackEmpty(stackNum)) {
            throw new Exception("Stack " + stackNum + " is already empty.");
        }
        int value = buffer[topOfStack(stackNum)];
        buffer[topOfStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        System.out.println("Stack " + stackNum + " pop value: " + value);
    }

    static void peek(int stackNum) throws Exception {
        if (isStackEmpty(stackNum)) {
            throw new Exception("Stack " + stackNum + " is already empty.");
        }
        System.out.println("Stack " + stackNum + " peek value: " +buffer[topOfStack(stackNum)]);
    }

    static int topOfStack(int stackNum) {
        // Remember buffer length is stackSize * 3;
        // First find which partition we move to, then add stackPointer value.
        return stackSize * stackNum + stackPointer[stackNum];
    }

    static boolean isStackEmpty(int stackNum) {
        return (stackPointer[stackNum] == -1);
    }

    public static void stackCheck() {
        Stack stack = new Stack(20);

        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();
        stack.push(3);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is " + stack.size());

        stack.pop();

        if (stack.isEmpty())
            System.out.println("Stack Is Empty");
        else
            System.out.println("Stack Is Not Empty");
    }
}
