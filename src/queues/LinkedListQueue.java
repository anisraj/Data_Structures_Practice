package queues;

import java.util.NoSuchElementException;

public class LinkedListQueue {
    private Node first;
    private Node last;
    private int size;

    public void add(int item) {
        Node lastNode = new Node(item);
        if (isEmpty()) {
            first = last = lastNode;
        } else {
            last.next = lastNode;
            last = lastNode;
        }
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int value = first.value;
        if (first == last) {
            first = last = null;
            size = 0;
            return value;
        }
        Node second = first.next;
        first.next = null;
        first = second;
        size--;
        return value;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
