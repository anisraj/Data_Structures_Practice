import arrays.Array;
import linked_lists.MyLinkedList;
import queues.MyPriorityQueue;
import queues.SomeInterviewQuestions;
import stack.MinStack;
import stack.MyStack;
import stack.SomeInterViewQuestions;
import stack.TwoStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue(5);
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(2);
        System.out.println(queue);
    }
}