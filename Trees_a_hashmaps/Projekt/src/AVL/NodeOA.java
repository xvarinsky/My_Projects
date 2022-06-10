package AVL;

public  class NodeOA {
    public int index;
    public String name;
    boolean deleted = false;

    public NodeOA(int index, String name,boolean deleted) {
        this.index = index;
        this.name = name;
        this.deleted = deleted;
    }

    public NodeOA(boolean deleted) {
        this.deleted = deleted;
    }

}
