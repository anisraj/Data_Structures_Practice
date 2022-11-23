package searching_algorithms;

public class JumpSearch {
    public static int search(int[] input, int target) {
        int blockSize = (int) Math.sqrt(input.length);
        int start = 0;
        int next = blockSize;

        while (start < input.length && input[next - 1] < target) {
            start = next;
            next = next + blockSize;
            if (next > input.length) {
                next = input.length;
            }
        }
        for (int i = start; i < next; i++) {
            if (input[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
