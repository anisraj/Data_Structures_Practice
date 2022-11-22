package searching_algorithms;

public class TernarySearch {
    public static int search(int[] input, int target) {
        return searchRecursively(input, target, 0, input.length - 1);
    }

    private static int searchRecursively(int[] input,
                                         int target,
                                         int left,
                                         int right) {
        if (left > right) {
            return -1;
        }
        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (target == input[mid1]) {
            return mid1;
        }
        if (target == input[mid2]) {
            return mid2;
        }

        if (target < input[mid1]) {
            return searchRecursively(input, target, left, mid1 - 1);
        } else if (target > input[mid2]) {
            return searchRecursively(input, target, mid2 + 1, right);
        } else {
            return searchRecursively(input, target, mid1 + 1, mid2 - 1);
        }
    }
}
