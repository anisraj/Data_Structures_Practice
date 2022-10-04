import arrays.Array;
import linked_lists.MyLinkedList;
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
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);
        System.out.println(SomeInterviewQuestions.reverse(q));
    }
}