package AVL;

public class NodeST {
    int index; // holds the key
    NodeST parent; // pointer to the parent
    NodeST left; // pointer to left child
    NodeST right; // pointer to right child
    String key;

    public NodeST(int data, String s) {
        this.key = s;
        this.index = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}
