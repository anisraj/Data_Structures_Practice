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

    public boolean containsRecursive(String input) {
        if (input == null) {
            return false;
        }
        return containsRecursive(root, 0, input);
    }

    private boolean containsRecursive(Node node, int index, String input) {
        if (index == input.length()) {
            return node.isEndOfWord;
        }
        if (!node.hasChild(input.charAt(index))) {
            return false;
        }
        return containsRecursive(node.getChild(input.charAt(index)), index + 1, input);
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

    public int countWords() {
        return countWords(root, 0);
    }

    private int countWords(Node node, int count) {
        for (Node child : node.getChildren()) {
            count = 1 + countWords(child, count);
        }
        return count;
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

    public static String longestCommonPrefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Node current = trie.root;
        StringBuilder longestPrefix = new StringBuilder();
        int maxChars = getShortestWord(words).length();
        while (longestPrefix.length() < maxChars) {
            Node[] children = current.getChildren();
            if (children.length != 1) {
                break;
            }
            current = children[0];
            longestPrefix.append(current.value);
        }
        return longestPrefix.toString();
    }

    private static String getShortestWord(String[] words) {
        String shortestWord = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortestWord.length()) {
                shortestWord = words[i];
            }
        }
        return shortestWord;
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
