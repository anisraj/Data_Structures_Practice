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

        if (isLeftHeavy(node)) {
            System.out.println(node.value + " node left heavy ");
        } else if (isRightHeavy(node)) {
            System.out.println(node.value + " node right heavy");
        }
        return node;
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
