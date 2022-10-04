package queues;

import java.util.Queue;
import java.util.Stack;

public class SomeInterviewQuestions {

    public static Queue<Integer> reverse(Queue<Integer> inputQueue) {
        Stack<Integer> outputStack = new Stack<>();
        while (!inputQueue.isEmpty()) {
            outputStack.push(inputQueue.remove());
        }
        while (!outputStack.isEmpty()) {
            inputQueue.add(outputStack.pop());
        }
        return inputQueue;
    }
}
