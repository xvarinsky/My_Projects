public class Node {
    String expression;
    String character;
    Node zero;
    Node one;
    Node parent;
    Character letter;
    int nCount = 1;
    String finish ;



    public Node(String finish,int nCount) {
        this.nCount = nCount;
        this.finish = finish;
    }


    public String getExpression() {
        return expression;
    }

    public Node(String expression, String character, Node parent) {
        this.expression = expression;
        this.character = character;
        this.parent = parent;

    }

    public Node(String expression, String character) {
        this.expression = expression;
        this.character = character;

    }
}
