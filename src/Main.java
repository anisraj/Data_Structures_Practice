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
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "D", 6);
        graph.addEdge("B", "E", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 5);
        System.out.println(graph.getShortestPath("A", "C"));
    }
}