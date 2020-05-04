package Sorting;

public class BinarySearch {

    public boolean binarySearch(int x, int[] sortedNumbers) {
        int end = sortedNumbers.length - 1;
        int start = 0;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedNumbers[mid] == x) return true;
            else if (sortedNumbers[mid] > x) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    public boolean binarySearch2(int x, int[] sortedNumbers) {
        return binarySearchRecursive(x, sortedNumbers, 0, sortedNumbers.length);
    }

    public boolean binarySearchRecursive(int x, int[] sortedNumbers, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedNumbers[mid] == x) return true;
            if (sortedNumbers[mid] > x)
                return binarySearchRecursive(x, sortedNumbers, start, mid - 1);
            return binarySearchRecursive(x, sortedNumbers, mid + 1, end);
        }
        return false;
    }

    public static void main(String args[]) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(7, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(binarySearch.binarySearch2(7, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
