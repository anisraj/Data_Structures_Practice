import arrays.Array;
import linked_lists.MyLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        System.out.println(linkedList.printMiddle());
    }
}