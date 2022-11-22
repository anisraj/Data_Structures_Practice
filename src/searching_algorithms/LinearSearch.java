package searching_algorithms;

public class LinearSearch {
    public static int search(int[] input, int target) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
