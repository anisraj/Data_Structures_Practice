import arrays.Array;
import avl_tree.AVLTree;
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

        tree.insert(30);
        tree.insert(10);
        tree.insert(40);
        System.out.println(tree.isPerfect());

    }
}