package avl_tree;

public class AVLTree {

    private AVLNode root;

    public void insert(int value) {
        AVLNode node = new AVLNode(value);
        if (root == null) {
            root = node;
            return;
        }
        insert(root, value);
    }

    private boolean insert(AVLNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value < node.value) {
            if (node.leftChild == null) {
                node.leftChild = new AVLNode(value);
                return true;
            }
            return insert(node.leftChild, value);
        } else {
            if (node.rightChild == null) {
                node.rightChild = new AVLNode(value);
                return true;
            }
            return insert(node.rightChild, value);
        }
    }

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = "+value;
        }
    }
}
