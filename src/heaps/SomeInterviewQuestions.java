package heaps;

import java.util.Arrays;

public class SomeInterviewQuestions {

    public static void heapify(int[] input) {
        int lastParentIndex = input.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(input, i);
        }
        /*for (int i = 0; i < input.length; i++) {
            int index = i;
            int parentIndex = (index - 1) / 2;
            if (input[index] > input[parentIndex]) {
                int temp = input[index];
                input[index] = input[parentIndex];
                input[parentIndex] = temp;
            }
        }*/
    }

    private static void heapify(int[] array, int index) {
        int largerIndex = index;
        int leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex]) {
            largerIndex = leftIndex;
        }
        int rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex]) {
            largerIndex = rightIndex;
        }
        if (index == largerIndex) {
            return;
        }
        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static int kthLargestItem(int[] input, int k) {
        Heap heap = new Heap(input.length);
        for (int item : input) {
            heap.insert(item);
        }
        int i = k;
        while (i != 1) {
            heap.remove();
            i--;
        }
        return heap.remove();
    }

    public static boolean isMaxHeap(int[] input) {
        return isMaxHeap(input, 1);
    }

    private static boolean isMaxHeap(int[] intput, int index) {
        int lastParentIndex = intput.length / 2 - 1;
        if (index > lastParentIndex) {
            return true;
        }
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        boolean isValidParent =
                intput[index] >= intput[leftIndex] && intput[index] >= intput[rightIndex];
        return isValidParent && isMaxHeap(intput, leftIndex) && isMaxHeap(intput, rightIndex);
    }
}
