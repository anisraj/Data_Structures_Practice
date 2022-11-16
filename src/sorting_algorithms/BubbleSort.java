package sorting_algorithms;

public class BubbleSort {
    public void sort(int[] input) {
        boolean isSorted;
        for (int i = 0; i < input.length; i++) {
            isSorted = true;
            for (int j = 1; j < input.length - i; j++) {
                if (input[j] < input[j - 1]) {
                    swap(input, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
