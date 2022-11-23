package searching_algorithms;

public class ExponentialSearch {
    public static int search(int[] input, int target) {
        int bound = 1;
        while (bound < input.length && input[bound] < target) {
            bound = bound * 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, input.length - 1);
        return BinarySearch.searchRecursively(input, target, left, right);
    }
}
