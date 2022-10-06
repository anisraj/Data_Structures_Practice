package queues;

import java.util.Arrays;

public class ArrayQueue {
    private int[] values;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int size) {
        values = new int[size];
    }

    public void add(int item) {
        if (count == values.length) {
            throw new IllegalStateException();
        }
        values[rear] = item;
        rear = (rear + 1) % values.length;
        count++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int item = values[front];
        front = (front + 1) % values.length;
        count--;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
