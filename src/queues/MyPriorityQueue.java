package queues;

import java.util.Arrays;

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
        if (count == 0) {
            values[count++] = item;
            return;
        }
        for (int i = count - 1; i >= 0; i--) {
            if (item < values[i]) {
                values[i+1] = values[i];
            } else {
                values[i+1] = item;
                break;
            }
        }
        count++;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
