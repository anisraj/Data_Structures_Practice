package trie;

import java.util.HashMap;

public class Trie {
    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String input) {
        if (input == null) {
            return false;
        }
        Node current = root;
        for (char ch : input.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        System.out.println(node.value);
        for (Node child : node.getChildren()) {
            traverse(child);
        }
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node node, String word, int index) {
        if (index == word.length()) {
            node.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = node.getChild(ch);
        if (child == null) {
            return;
        }
        remove(child, word, index + 1);
        if (!child.hasChildren() && !child.isEndOfWord) {
            node.removeChild(ch);
        }
    }

    private class Node {
        private char value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            children = new HashMap<>();
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
}
