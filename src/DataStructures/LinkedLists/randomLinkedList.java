package LinkedLists;

import java.util.Random;

public class randomLinkedList {
    public LLNode createRandomLinkedList(int N, int min, int max) {
        LLNode root = new LLNode(getRandomNumberInRange(min, max), null, null);
        LLNode prev = root;
        for (int i = 1; i < N; i++) {
            int data = getRandomNumberInRange(min, max);
            LLNode next = new LLNode(data, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than Min");
        }
        // Alternate method to get random int, but requires Intstream.
        // Random r = new Random();
        // return r.ints(1, min, max);

        return (int)(Math.random() * ((max - min) + 1)) + min;
        /*
            Math.random() gives us a random number between 0 and 1.

            But we don’t want a random decimal; we want a random number.
            We can get that by multiplying our Math.random() result by the size of the range.
            For example, if we want a random number between 0 and 10, we need to multiply by 10.
            A result of 0.4 would become 4.
            If we want random numbers from 7 to 11, that is 5 possible numbers (7, 8, 9, 10, 11).
            This is where we get Math.random() * (max - min + 1)

            We don’t want decimal numbers though, we want whole numbers.
            Math.floor() just chops off the decimal. 3.14159 becomes 3.
            (int) will do the same as Math.floor
            That’s where we get Math.floor(Math.random() * (max - min + 1)).

            Now we’re getting a number from 0 to whatever our range size was.
            If we wanted a number from 7 to 11, it’s a random number from 0 to 5.
            To make that be a number from 7 to 11, we just need to add 7 to whatever number we got.
            7 is our minimum value.
            This leads us to Math.floor(Math.random() * (max - min + 1)) + min
            (int) will do the same as Math.floor
         */
    }
}
