package searching_algorithms;

public class BinarySearch {
    public static int search(int[] input, int target) {
        //return searchIteratively(input, target);
        return searchRecursively(input, target, 0, input.length - 1);
    }

    public static int searchRecursively(int[] input,
                                         int target,
                                         int left,
                                         int right) {
        if (right < left) {
            return -1;
        }
        int middle = left + right / 2;
        if (input[middle] == target) {
            return middle;
        }
        if (target < input[middle]) {
            return searchRecursively(input, target, left, middle - 1);
        } else {
            return searchRecursively(input, target, middle + 1, right);
        }
    }

    private static int searchIteratively(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;
        while (right >= left) {
            int middle = left + right / 2;
            if (input[middle] == target) {
                return middle;
            }
            if (target < input[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
