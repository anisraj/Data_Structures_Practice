package arrays;

import java.util.Arrays;

public class Array {
    private int count;
    private int[] values;

    public Array(int size) {
        values = new int[size];
    }

    public void insert(int value) {
        if (count >= values.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i<values.length; i++) {
                newArray[i] = values[i];
            }
            values = newArray;
        }
        values[count] = value;
        count++;
    }

    public void removeAt(int position) {
        if (position < count) {
            for (int i = position; i<count; i++) {
                values[i] = values[i + 1];
            }
            count--;
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i<values.length; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(values, count)));
    }


}
