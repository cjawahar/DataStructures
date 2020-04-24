package Sorting;
/*
    The technique involves making multiple passes over the input array
    and swapping unordered elements close to one another. The technique
    is called bubble sort, as the sorted list "bubbles" up from the tail end of the list.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

// Swaps adjacent elements and pushes them to the end of the list
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] numbers = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0};
        int[] numbers1 = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0};
        int[] numbers2 = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0};

        bubbleSort.sort(numbers);
        bubbleSort.sortImprovement1(numbers1);
        bubbleSort.sortImprovement2(numbers2);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));
    }

    public void sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // Inner loop -- subtract i instead of 1.
    // Basically, don't process till the end of the numbers list every time.
    public void sortImprovement1(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }
    }

    public void sortImprovement2(int[] numbers) {
        int i = 0;
        boolean swapOccured = true;
        while (swapOccured) {
            swapOccured = false;
            i++;
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                    swapOccured = true;
                }
            }
        }
    }

    private void swap(int[] numbers, int j, int k) {
        int temp = numbers[j];
        numbers[j] = numbers[k];
        numbers[k] = temp;
    }
}
