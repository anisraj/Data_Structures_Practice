import arrays.Array;
import avl_tree.AVLTree;
import graph.Graph;
import hashtables.HashTable;
import hashtables.HashTableWithLinearProbing;
import heaps.Heap;
import heaps.SomeInterviewQuestions;
import linked_lists.MyLinkedList;
import queues.LinkedListQueue;
import queues.MyPriorityQueue;
import stack.*;
import tree.MyTree;
import trie.Trie;
import undirected_graph.WeightedGraph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);
        graph.print();
    }
}