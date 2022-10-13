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
        map.put(0,"Anis");
        map.put(2,"Raju");
        map.put(5,"Jamadar");
        map.put(11,"Jamadar");
        System.out.println(map);
        map.remove(5);
        map.remove(11);
        System.out.println(map);
    }
}