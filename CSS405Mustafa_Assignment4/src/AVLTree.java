/**
 * Method Name: AVLTree.java
 * Description:
**/

// make AVLTree class
public class AVLTree {

    // Node root
    private Node root;

    // root set to null until a node is added
    public AVLTree() {
        root = null;
    }

    // if text file is empty with nothing inside it
    public boolean isEmpty() {
        return root == null;
    }

    // insertion
    public void insert(String key) {
        root = insert(root, key);
    }

    private Node insert(Node node, String key) {
        if (node == null) {
            return new Node(key);
        }

        // comparison to make it follow the AVL format
        int comparison = key.compareTo(node.key);

        if (comparison < 0) {
            node.left = insert(node.left, key);
        }
        else if (comparison > 0) {
            node.right = insert(node.right, key);
        }
        else {
            node.count++;
            return node;
        }

        updateHeight(node);

        return balance(node);
    }

    // search method/function
    public int search(String key) {
        Node current = root;

        while (current != null) {

            int comparison = key.compareTo(current.key);

            if (comparison == 0) {
                return current.count;
            }
            else if (comparison < 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        return 0;
    }

    // Deletion
    public void delete(String key) {
        root = delete(root, key);
    }

    private Node delete(Node node, String key) {

        if (node == null) {
            return null;
        }

        int comparison = key.compareTo(node.key);

        if (comparison < 0) {
            node.left = delete(node.left, key);
        }
        else if (comparison > 0) {
            node.right = delete(node.right, key);
        }
        else {

            // Leaf node deletion
            if (node.left == null && node.right == null) {
                return null;
            }

            // One child deletion
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // Two children deletion
            Node successor = findMin(node.right);
            node.key = successor.key;
            node.count = successor.count;
            node.right = delete(node.right, successor.key);
        }

        updateHeight(node);

        return balance(node);
    }

    // finding the minimum word
    private Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private void updateHeight(Node node) {

        node.height = 1 +
                Math.max(height(node.left),
                        height(node.right));
    }

    private int getBalanceFactor(Node node) {

        if (node == null) {
            return 0;
        }

        return height(node.left) -
                height(node.right);
    }

    private Node balance(Node node) {

        int balanceFactor = getBalanceFactor(node);

        // Left Left balance
        if (balanceFactor > 1 &&
                getBalanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left Right balance
        if (balanceFactor > 1 &&
                getBalanceFactor(node.left) < 0) {

            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right balance
        if (balanceFactor < -1 &&
                getBalanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right Left balance
        if (balanceFactor < -1 &&
                getBalanceFactor(node.right) > 0) {

            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node y) {

        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {

        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    public void printInOrder() {
        inOrder(root);
    }

    // sort inorder
    private void inOrder(Node node) {

        if (node != null) {

            inOrder(node.left);

            System.out.println(node.key +
                    " : " + node.count);

            inOrder(node.right);
        }
    }

    public void printPreOrder() {
        preOrder(root);
    }

    // sort preorder
    private void preOrder(Node node) {

        if (node != null) {

            System.out.println(
                    node.key +
                            " (" + node.count + ")"
            );

            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
