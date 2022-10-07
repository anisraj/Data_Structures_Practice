package queues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyPriorityQueue {
    private int[] values;
    private int count;

    public MyPriorityQueue(int size) {
        values = new int[size];
    }

    public void add(int item) {
        if (count == values.length) {
            throw new IllegalStateException();
        }
        int i = shiftValuesToInsert(item);
        values[i] = item;
        count++;
    }

    private int shiftValuesToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (item < values[i]) {
                values[i+1] = values[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int remove() {
        if (count == 0) {
            throw new IllegalStateException();
        }
        return values[--count];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
