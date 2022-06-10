package AVL;

public class AVL {


    static void heightUpdate(Node n){                           //update výšky
        //  System.out.println("heightUpdate();");
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    static int height(Node n) {                                  //výpočet výšky

        if (n == null) {
            return -1;
        } else {
            return n.height;
        }
    }

    static int getBalance(Node n) {                                     //výpočet balance factoru
//        System.out.println("getBalanced");
        if (n == null) {
            return 0;
        } else {
            return (height(n.right) - height(n.left));
        }


    }

    public static Node rebalance(Node node) {               //balancuje jednotlivé uzly
       // System.out.println("rebalance");
        heightUpdate(node);
        int balance = getBalance(node);
       // System.out.println("pred" + node + " " + node.left + " " + node.right);
        if (balance > 1) {                                  // ak je rozdiel medzi childmi vačsí ako 1
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {                               // ak je rozdiel medzi childmi menší ako -1
            if (height(node.left.left) > height(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
       // System.out.println("PO " + node + " " + node.left + " " + node.right);
        return node;
    }


    static Node rotateRight(Node x) {               //pravá rotácia
        Node y;
        y = x.left;
        Node z;
        z = y.right;
        y.right = x;
        x.left = z;
        heightUpdate(y);
        heightUpdate(x);
        return y;
    }

    static Node rotateLeft(Node x) {            //lavá rotácia
        Node y;
        y = x.right;
        Node z;
        z = y.left;
        y.left = x;
        x.right = z;
        heightUpdate(y);
        heightUpdate(x);
        return y;
    }




    public static Node insert(Node node, int number, String s) {            //vkladanie
//        System.out.println("position");
        if (node == null) {
            return new Node(number,s);
        } else if (node.index > number) {
            node.left = insert(node.left, number, s);
//            System.out.println("Number " + number + "added to the left of" + node.index);
        } else if (node.index < number) {
            node.right = insert(node.right, number, s);
//            System.out.println("Number " + number + "added to the right of" + node.index);
        }

        return rebalance(node);
    }


    public static Node delete(Node n, int index) {              //odstránovanie
//        System.out.println("delete");
        if (n == null) {
            return n;
        } else if (n.index > index) {
            n.left = delete(n.left, index);
        } else if (n.index < index) {
            n.right = delete(n.right, index);
        } else {
            if (n.left == null || n.right == null) {
                if (n.left == null) {
//                    System.out.println("I deleted" + n.index);
                    n = n.right;
                } else {
//                    System.out.println("I deleted" + n.index);
                    n = n.left;
                }
            } else {
//                System.out.println("I deleted" + n.index);

                Node taken = n.left;
//                System.out.println("Taken : " + n.left);
                while (taken.right != null) {
                    taken = taken.right;
                }

                n.index = taken.index;
                n.left = delete(n.left, n.index);

            }
        }
        if (n != null) {
            n = rebalance(n);
        }
        return n;
    }

    public static Node search(Node node, int index) {
//        System.out.println("search");
        while (node.index != index) {
            if (node == null) return null;
            node = node.index < index ? node.right : node.left;
        }
        return node;
    }


}
