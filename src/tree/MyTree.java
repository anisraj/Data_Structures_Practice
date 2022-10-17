package tree;

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

    public int height(Node node) {
        if (node == null) {
            return -1; //return any minus value
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
