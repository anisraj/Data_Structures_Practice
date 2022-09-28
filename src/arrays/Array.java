package arrays;

import java.util.*;

public class Array {
    private int count;
    private int[] values;

    public Array(int size) {
        values = new int[size];
    }

    public void insert(int value) {
        if (count == values.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = values[i];
            }
            values = newArray;
        }
        values[count++] = value;
    }

    public void removeAt(int position) {
        if (position < 0 || position >= count) {
            throw new IllegalArgumentException();
        }
        for (int i = position; i < count; i++) {
            values[i] = values[i + 1];
        }
        count--;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        if (count > 0) {
            int max = values[0];
            for (int i = 0; i < count; i++) {
                if (values[i] > max) {
                    max = values[i];
                }
            }
            return max;
        }
        throw new IllegalStateException();
    }

    public Set<Integer> intersect(int[] anotherArray) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < anotherArray.length; j++) {
                if (values[i] == anotherArray[j]) {
                    result.add(values[i]);
                    break;
                }
            }
        }
        return result;
    }

    public void reverse() {
        int[] reversedArray = new int[values.length - 1];
        int reversedCount = 0;
        for (int i = count - 1 ; i >= 0; i--) {
            reversedArray[reversedCount++] = values[i];
        }
        values = reversedArray;
    }

    public void insertAt(int value, int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        values[index] = value;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(values, count)));
    }


}
