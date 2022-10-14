import arrays.Array;
import hashtables.HashTable;
import hashtables.HashTableWithLinearProbing;
import hashtables.SomeInterviewQuestions;
import linked_lists.MyLinkedList;
import queues.LinkedListQueue;
import queues.MyPriorityQueue;
import stack.*;
import tree.MyTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.height());

    }
}