import arrays.Array;
import avl_tree.AVLTree;
import graph.Graph;
import hashtables.HashTable;
import hashtables.HashTableWithLinearProbing;
import heaps.Heap;
import heaps.SomeInterviewQuestions;
import linked_lists.MyLinkedList;
import org.w3c.dom.Node;
import queues.LinkedListQueue;
import queues.MyPriorityQueue;
import sorting_algorithms.BubbleSort;
import sorting_algorithms.SelectionSort;
import stack.*;
import tree.MyTree;
import trie.Trie;
import undirected_graph.WeightedGraph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] inputs = {8,2,4,1,3,3};
        new SelectionSort().sort(inputs);
        System.out.println(Arrays.toString(inputs));
    }
}