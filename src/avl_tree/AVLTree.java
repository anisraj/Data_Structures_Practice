package avl_tree;

public class AVLTree {

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else {
            node.rightChild = insert(node.rightChild, value);
        }
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
        node = balance(node);
        return node;
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0) {
                node.leftChild = leftRotate(node.leftChild);
            }
            return rightRotate(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0) {
                node.rightChild = rightRotate(node.rightChild);
            }
            return leftRotate(node);
        }
        return node;
    }

    private AVLNode rightRotate(AVLNode node) {
        AVLNode newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        resetHeight(node);
        resetHeight(newRoot);
        return newRoot;
    }

    private AVLNode leftRotate(AVLNode node) {
        AVLNode newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        resetHeight(node);
        resetHeight(newRoot);
        return newRoot;
    }

    private void resetHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = "+this.value;
        }
    }
}
