package Sorting;
import java.util.Arrays;

/*
    Lomuto Partitioning:
    1. Pick the right most element of the array as the pivot.
    2. Start from the left and find the next element that is larger than the pivot.
    3. Swap this element with the next, which is smaller than pivot element.
    4. Repeat steps 2 and 3 until no more swapping is possible.
    5. Swap the first item which is larger than the pivot's value with the pivot itself.
 */

public class QuickSort {
    // 1. calls 2.
    public void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }
    // 2. calls 3.
    private void sort(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partition(numbers, start, end);
            sort(numbers, start, p - 1);
            sort(numbers, p + 1, end);
        }
    }
    // 3. calls swap as needed.
    private int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int x = start - 1;
        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                x++;
                swap(numbers, x, i);
            }
        }
        swap(numbers, x + 1, end);
        return x + 1;
    }
    // 4.
    private void swap(int[] numbers, int j, int k) {
        int temp = numbers[j];
        numbers[j] = numbers[k];
        numbers[k] = temp;
    }

    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();
        int[] numbers = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0, 9, 3, 6};
        quickSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
