package AVL;

public class SplayTree {
    private NodeST root;

    public SplayTree() {
        root = null;
    }


    public NodeST search(int k) {
        NodeST x = searchHelp(root, k);
        if (x != null) {                        //ak nam našlo daný uzol s danou hodnotou tak nech sa pomocou funkcie splay dostane na vrch
            splay(x);
        }
        return x;
    }

    private NodeST searchHelp(NodeST node, int index) {             //vráti nám daný uzol
        if (node == null || index == node.index) {
            return node;
        }

        if (index < node.index) {
            return searchHelp(node.left, index);
        }
        return searchHelp(node.right, index);
    }



    private void leftRotate(NodeST x) {             //rotacia do lava s podávanim si parrentov
        NodeST y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }


    private void rightRotate(NodeST x) {            //rotacia do prava s podavanim si rodičov
        NodeST y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }


    private void splay(NodeST x) {                  //funkcia splay ktorá nám pomocou operácii presunie x do rootu
        while (x.parent != null) {
            if (x.parent.parent == null) {              //ak sa vykonáva iba jedna rotácia
                if (x == x.parent.left) {
                    // zig rotation
                    rightRotate(x.parent);
                } else {
                    // zag rotation
                    leftRotate(x.parent);
                }
            } else if (x == x.parent.left && x.parent == x.parent.parent.left) {
                // zig-zig rotation
                rightRotate(x.parent.parent);
                rightRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.right) {
                // zag-zag rotation
                leftRotate(x.parent.parent);
                leftRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.left) {
                // zig-zag rotation
                leftRotate(x.parent);
                rightRotate(x.parent);
            } else {
                // zag-zig rotation
                rightRotate(x.parent);
                leftRotate(x.parent);
            }
        }
    }

    // joins two trees y and z
    private NodeST join(NodeST y, NodeST z){            //pomocná funkcia ku funkcii delete ktorá nam pomože spojit 2 stromi po vymazaní korena
        if (y == null) {
            return z;
        }

        if (z == null) {
            return y;
        }

        NodeST x = y;
        while(x.right!= null){
            x=x.right;
        }
        splay(x);
        x.right = z;
        z.parent = x;
        return x;
    }








    public void insert(int index, String s) {               //funkcia insert
        NodeST node = new NodeST(index,s);
        NodeST y = null;
        NodeST x = this.root;

        while (x != null) {                                 //prechadzanie zoznamu poial sa nedostaneme na miesto kde dané číslo patrí
            y = x;
            if (node.index < x.index) {
                x = x.left;
            } else {
                x = x.right;
            }
        }


        node.parent = y;                                        //nastavenie rodiča
        if (y == null) {
            root = node;                                         //ak je zoznam prázdny
        } else if (node.index < y.index) {                       //nastavenie pointera
            y.left = node;
        } else {
            y.right = node;
        }


        splay(node);                                             //rebalancovanie
    }





    public void delete(int index) {                             //odstranovanie zo zoznamu
        NodeST node= root;
        NodeST x = null;
        NodeST z = null;
        NodeST y = null;
        while (node != null){                                   //hladanie daného indexu
            if (node.index == index) {
                x = node;
                break;
            }

            if (node.index <= index) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (x == null) {
            System.out.println("Nepodarilo sa nájsť daný index");
            return;
        }

        splay(x);                                   //vybalancovanie aby z´prvok ktorý ideme mazat bol na vrchu
        if (x.right != null) {                      //vymazanie a rozdelenie stromov na 2 časti
            z = x.right;
            z.parent = null;
        } else {
            z = null;
        }
        y = x;
        y.right = null;
        x = null;


        if (y.left != null){        // remove x
            y.left.parent = null;
        }
        this.root = join(y.left, z);                //spojenie 2 stromv do jedného a insertovanie do rootu

        y = null;
    }


}