package Stacks_Queues;

public class Stack {
    private int top;
    private int stackArr[];
    private int capacity;

    public Stack(int size) {
        stackArr = new int[size];
        capacity = size;
        top = -1;
    }

    public Boolean isEmpty() {
        return top == -1;	// or return size() == 0;
    }

    public Boolean isFull() {
        return top == capacity - 1;	// or return size() == capacity;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }
        System.out.println("Inserting " + x);
        stackArr[++top] = x;
    }

    public int pop() {
        // check for stack underflow
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing " + peek());
        // decrease stack size by 1 and (optionally) return the popped element
        return stackArr[top--];
    }

    public int peek() {
        if (!isEmpty()){
            return stackArr[top];
        }
        else {
            System.exit(1);
        }
        return -1;
    }

    public int size() {
        return top + 1;
    }
}
