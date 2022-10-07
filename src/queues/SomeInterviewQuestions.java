package queues;

import java.util.ArrayDeque;
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

    public static Queue<Integer> reverse(Queue<Integer> inputQueue, int k) {
        Stack<Integer> reversedStack = new Stack<>();
        for (int i = 0; i < k; i++) {
            reversedStack.push(inputQueue.remove());
        }
        Queue<Integer> test = new ArrayDeque<>();
        while (!reversedStack.isEmpty()) {
            test.add(reversedStack.pop());
        }
        while (!inputQueue.isEmpty()) {
            test.add(inputQueue.remove());
        }
        return test;
    }
}
