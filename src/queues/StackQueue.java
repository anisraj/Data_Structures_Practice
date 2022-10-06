package queues;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> queueStack;

    public StackQueue() {
        queueStack = new Stack<>();
    }

    public void add(int item) {
        queueStack.add(item);
    }

    public int remove() {
        Stack<Integer> tempStack = new Stack<>();
        while (!queueStack.isEmpty()) {
            tempStack.add(queueStack.pop());
        }
        int item = tempStack.pop();
        while (!tempStack.isEmpty()) {
            queueStack.add(tempStack.pop());
        }
        return item;
    }
}
