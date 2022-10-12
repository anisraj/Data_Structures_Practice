import arrays.Array;
import hashtables.HashTable;
import hashtables.HashTableWithLinearProbing;
import hashtables.SomeInterviewQuestions;
import linked_lists.MyLinkedList;
import queues.LinkedListQueue;
import queues.MyPriorityQueue;
import stack.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        HashTableWithLinearProbing map = new HashTableWithLinearProbing(5);
        map.put(1,"Anis");
        map.put(2,"Raju");
        map.put(3,"Jamadar");
        map.put(12,"Jamadar");
        map.remove(12);
        System.out.println(map);
    }
}