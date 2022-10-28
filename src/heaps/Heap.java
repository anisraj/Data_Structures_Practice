package heaps;

public class Heap {
    private int[] values;
    private int size;

    public Heap(int size) {
        values = new int[size];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        values[size++] = value;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;
        int parentIndex = parent(index);
        while (index > 0 && values[index] > values[parentIndex]) {
            swap(index, parentIndex);
            index = parent(index);
            parentIndex = parent(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (
                index <= size && !isValidParent(index)
        ) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        if (!hasRightChild(index)) {
            return values[index] >= values[leftChildIndex(index)];
        }
        return values[index] >= values[leftChildIndex(index)] &&
                values[index] >= values[rightChildIndex(index)];
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }
        return (values[leftChildIndex(index)] > values[rightChildIndex(index)])
                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int value = values[0];
        values[0] = values[--size];
        values[size] = 0;
        bubbleDown();
        return value;
    }

    public boolean isFull() {
        return size == values.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int first, int second) {
        int temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }
}
