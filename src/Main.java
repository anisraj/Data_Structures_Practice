import arrays.Array;
import linked_lists.MyLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addFirst(10);
        linkedList.reverse();
        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}