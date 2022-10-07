import arrays.Array;
import linked_lists.MyLinkedList;
import queues.LinkedListQueue;
import queues.MyPriorityQueue;
import queues.SomeInterviewQuestions;
import stack.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        System.out.println(stack.remove());
    }
}