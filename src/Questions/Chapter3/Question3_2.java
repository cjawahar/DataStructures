package Questions.Chapter3;

import java.util.Stack;

/*
    How would you design a stack that has a min method,
    in addition to push and pop. Which returns the minimum element.
    All methods need to work in 0(1) time.
 */
public class Question3_2 {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();

        for (int i = 0; i < 10; i++) {
            int value = getRandomNumberInRange(0, 100);
            stack.push(value);
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("Popped " + stack.pop().value);
            System.out.println("New min is " + stack.min());
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than Min");
        }
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}

class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return peek().min;
        }
    }
}

class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min){
        value = v;
        this.min = min;
    }
}


