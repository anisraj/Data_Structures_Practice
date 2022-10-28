import arrays.Array;
import avl_tree.AVLTree;
import hashtables.HashTable;
import hashtables.HashTableWithLinearProbing;
import hashtables.SomeInterviewQuestions;
import heaps.Heap;
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
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(8);
        heap.insert(22);
        heap.remove();
        System.out.println("Done");
    }
}