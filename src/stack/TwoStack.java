package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class TwoStack {
    private int[] values;
    private int count1;
    private int count2;

    public TwoStack(int size) {
        values = new int[size];
        count2 = size;
    }

    public void push1(int value) {
        if (count1 == count2) {
            throw new StackOverflowError();
        }
        values[count1++] = value;
    }

    public int pop1() {
        if (count1 == 0) {
            throw new EmptyStackException();
        }
        return values[--count1];
    }

    public int pop2() {
        if (count2 == values.length) {
            throw new EmptyStackException();
        }
        return values[count2++];
    }

    public void push2(int value) {
        if (count2 == count1) {
            throw new StackOverflowError();
        }
        values[--count2] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(values, count1)) + Arrays.toString(Arrays.copyOfRange(values, count1, values.length));
    }
}
