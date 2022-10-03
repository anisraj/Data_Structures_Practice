package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
    private int[] values;
    private int count;

    public MyStack(int size) {
        values = new int[size];
    }

    public void push(int value) {
        if (count == values.length) {
            throw new StackOverflowError();
        }
        values[count++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return values[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(values, count));
    }
}
