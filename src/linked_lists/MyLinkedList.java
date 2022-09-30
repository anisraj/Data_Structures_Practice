package linked_lists;

import java.util.NoSuchElementException;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public int indexOf(int value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        last = getPrevious(last);
        last.next = null;
        size--;
    }

    public int size() {
        return size;
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

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (k > size || k <= 0 ) {
            throw new IllegalArgumentException();
        }
        Node current = first;
        Node next = first;
        for (int i = 0; i < k-1; i++) {
            next = next.next;
        }

        while (next != last) {
            current = current.next;
            next = next.next;
        }
        return current.value;
    }

    public String printMiddle() {
        Node a = first;
        Node b = first;
        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }
        if (b != last) {
            return a.value+","+a.next.value;
        }
        return a.value+"";
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
