package sorting_algorithms;

public class CountingSort {
    public void sort(int[] input, int max) {
        int[] countsArray = new int[max + 1];
        for (int i = 0; i < input.length; i++) {
            int count = countsArray[input[i]];
            countsArray[input[i]] = count + 1;
        }
        int k = 0;
        for (int i = 0; i < countsArray.length; i++) {
            int count = countsArray[i];
            for (int j = 0; j < count; j++) {
                input[k++] = i;
            }
        }
    }
}
