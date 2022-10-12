package hashtables;

import java.util.Arrays;

public class HashTableWithLinearProbing {
    private Entry[] entries;
    private int count;

    public HashTableWithLinearProbing(int size) {
        entries = new Entry[size];
    }

    public void put(int key, String value) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        int index = getIndex(key);
        Entry entry = entries[index];
        if (entry != null) {
            entry.value = value;
            return;
        }
        entries[index] = new Entry(key, value);
        count++;
    }

    public String get(int key) {
        int index = getIndex(key);
        return entries[index].value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (isEmpty() || index == -1) {
            throw new IllegalStateException();
        }
        entries[index] = null;
        count--;
    }

    private int getIndex(int key) {
        int steps = 0;
        while (steps < entries.length) {
            int index = index(key, steps);
            Entry entry = entries[index];
            if (entry == null || entry.key == key) {
                return index;
            }
            steps++;
        }
        return -1;
    }

    public boolean isFull() {
        return count == entries.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private int index(int key, int i) {
        return (hash(key) + i) % entries.length;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key+"="+value;
        }
    }
}
