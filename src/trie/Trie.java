package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node node, String prefix, List<String> words) {
        if (node == null) {
            return;
        }
        if (node.isEndOfWord) {
            words.add(prefix);
        }
        for (Node child : node.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
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
