package sorting_algorithms;

public class QuickSort {

    public void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }
    private void sort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }

        int boundary = partition(input, start, end);
        sort(input, start, boundary - 1);
        sort(input, boundary + 1, end);
    }

    private int partition(int[] input, int start, int end) {
        int boundary = start - 1;
        int pivot = input[end];

        for (int i = start; i <= end; i++) {
            if (input[i] <= pivot) {
                boundary++;
                swap(input, boundary, i);
            }
        }

        return boundary;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
