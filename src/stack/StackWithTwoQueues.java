package stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> stackQueue;
    private int size;

    public StackWithTwoQueues() {
        stackQueue = new ArrayDeque<>();
    }

    public void add(int item) {
        stackQueue.add(item);
        size++;
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        if (size == 1) {
            return stackQueue.remove();
        }
        Queue<Integer> tempQueue = new ArrayDeque<>();
        while (stackQueue.size() != 1) {
            tempQueue.add(stackQueue.remove());
        }
        int returnedValue = stackQueue.remove();
        while (!tempQueue.isEmpty()) {
            stackQueue.add(tempQueue.remove());
        }
        size--;
        return returnedValue;
    }
}
