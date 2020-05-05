package LinkedLists;

public class randomLinkedList {
    public LinkedListNode createRandomLinkedList(int N, int min, int max) {
        LinkedListNode root = new LinkedListNode(getRandomNumberInRange(min, max), null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            int data = getRandomNumberInRange(min, max);
            LinkedListNode next = new LinkedListNode(data, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than Min");
        }
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
