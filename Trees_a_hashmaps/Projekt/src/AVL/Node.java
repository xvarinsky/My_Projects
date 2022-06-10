package AVL;

public class Node {
    Node left=null;
    Node right = null;
    public int index = 0;
    String key;
    int height=0;

    public Node(int number,String key) {
        this.index = number;
        this.key = key;
    }

    public Node() {
    }
}
