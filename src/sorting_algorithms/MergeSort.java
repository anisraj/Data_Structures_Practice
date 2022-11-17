package sorting_algorithms;

public class MergeSort {
    public void sort(int[] input) {

        if (input.length < 2) {
            return;
        }

        int middleIndex = input.length / 2;

        int[] left = new int[middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            left[i] = input[i];
        }

        int[] right = new int[input.length - middleIndex];
        for (int i = middleIndex; i < input.length; i++) {
            right[i - middleIndex] = input[i];
        }

        sort(left);
        sort(right);

        merge(left, right, input);

    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

    }
}
