/**
 * Method Name: Node.java
 * Description:
 **/

// make the Node class for the AVLTree
public class Node {
    String key;
    int count;
    int height;

    Node left;
    Node right;

    // set the variables
    public Node(String key) {
        this.key = key;
        this.count = 1;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
