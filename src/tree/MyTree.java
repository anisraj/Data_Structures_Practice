package tree;

import java.util.ArrayList;
import java.util.List;

public class MyTree {

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value){
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        return contains(node.leftChild, value) || contains(node.rightChild, value);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }
    private void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.leftChild);
        System.out.println(node.value);
        traverseInOrder(node.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.println(node.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return node.value;
        }
        int left = min(node.leftChild);
        int right = min(node.rightChild);
        return Math.min(Math.min(left, right), node.value);
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return node.value;
        }
        int left = max(node.leftChild);
        int right = max(node.rightChild);
        return Math.max(Math.max(left, right), node.value);
    }

    public int minOfBinarySearchTree() {
        if (root == null) {
            throw new IllegalStateException();
        }
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean areEquals(MyTree tree) {
        if (tree == null) {
            return false;
        }
        return isNodeEqual(root, tree.root);
    }

    private boolean isNodeEqual(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        boolean left = isNodeEqual(first.leftChild, second.leftChild);
        boolean right = isNodeEqual(first.rightChild, second.rightChild);
        return first.value == second.value && left && right;
    }

    public boolean isBinarySearchTree() {
        return isValidBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value > max) {
            return false;
        }
        boolean i = isValidBinarySearchTree(node.leftChild, min, node.value - 1);
        boolean i1 = isValidBinarySearchTree(node.rightChild, node.value + 1, max);
        return i && i1;
    }

    public void nodesAtKDistance(int distance) {
        nodesAtKDistance(root, distance);
    }

    private void nodesAtKDistance(Node node, int distance) {
        if (node == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(node.value);
            return;
        }
        nodesAtKDistance(node.leftChild, distance - 1);
        nodesAtKDistance(node.rightChild, distance - 1);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i<= height(); i++) {
            nodesAtKDistance(i);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return  1 + size(node.leftChild) + size(node.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return 1;
        }
        return countLeaves(node.leftChild) + countLeaves(node.rightChild);
    }

    public boolean areSiblings(int first, int second) {
        return areSiblings(root, first, second);
    }

    private boolean areSiblings(Node node, int first, int second) {
        if (node == null || node.leftChild == null || node.rightChild == null) {
            return false;
        }
        if ((node.leftChild.value == first && node.rightChild.value == second) ||
                (node.rightChild.value == first && node.leftChild.value == second)) {
            return true;
        }
        return areSiblings(node.leftChild, first, second) || areSiblings(node.rightChild, first, second);
    }

    public List<Integer> getAncestors(int value) {
        List<Integer> list = new ArrayList<>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node node, int value, List<Integer> list) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        boolean l = getAncestors(node.leftChild, value, list);
        boolean r = getAncestors(node.rightChild, value, list);
        if (l || r) {
            list.add(node.value);
            return true;
        }
        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(height(node.leftChild) - height(node.rightChild)) > 1) {
            return false;
        }
        return isBalanced(node.leftChild) && isBalanced(node.rightChild);
    }

    public boolean isPerfect() {
        return size() == Math.pow(2, height() + 1) - 1;
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = "+value;
        }
    }
}
