package stack;

import java.util.EmptyStackException;

public class MinStack {
    private int[] values;
    private int[] minValues;
    private int count;
    private int minCount;

    public MinStack(int size) {
        values = new int[size];
        minValues = new int[size];
    }

    public void push(int value) {
        if (count == values.length) {
            throw new StackOverflowError();
        }
        if (count == 0 || value < minValues[minCount - 1]) {
            minValues[minCount++] = value;
        }
        values[count++] = value;
    }

    public int pop() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        int top = values[--count];
        if (top == minValues[minCount - 1]) {
            minCount--;
        }
        return values[count];
    }

    public int minValue() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        return minValues[minCount - 1];
    }
}
