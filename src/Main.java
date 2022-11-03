import arrays.Array;
import avl_tree.AVLTree;
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

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        System.out.println(trie.findWords("ca"));
    }
}