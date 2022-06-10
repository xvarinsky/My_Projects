package AVL;

public class Main {
    public static int hashSize = 200000;
    public static int size = 200000;
    public static int fullnessFactor=0;



//    public static void main(String[] args) {
//        ListNode[] listNodeTab = new ListNode[size];
//
//        String[] string = new String[size*10];
//        for (int i = 0 ; i < size*10; i++){
//            string[i]=test.StringGenerator();
//        }
//
//        StopWatch insert = new StopWatch();
//        for (int i = 0 ; i < size*10; i++){
//
//           listNodeTab = HashTab1.insert(listNodeTab, test.StoCh(string[i]),string[i]);
//
//        }
//        double time1 = insert.elapsedTime();
//        System.out.println(time1);
//
//
//        for (int i = 0; i < 10; i++){
//
//            HashTab1.delete(listNodeTab, test.StoCh(string[i]));
//        }
//    }
//
//
//
//    public static void main(String[] args){
//        NodeOA[] nodeOAS = new NodeOA[size];
//        StopWatch insert = new StopWatch();
//        for (int i = 0; i < size*8 ; i++){
//            nodeOAS = HashOA.insert(nodeOAS, (int)(Math.random()*10000000),"");
//        }
//        double time1 = insert.elapsedTime();
//
//        System.out.println(time1);
//        int key = HashOA.search(nodeOAS, 98);
//        System.out.println(key);
//        for (int i = 0; i < size; i++){
//            nodeOAS = HashOA.delete((int)(Math.random()*100), nodeOAS);
//        }
//        nodeOAS = HashOA.insert(98, " ",nodeOAS);
//        System.out.println("done");
//
//    }
//

//    public static void main(String [] args) {                                                   //Hasovacia tabulka zretazená
//
//        for (int j = 0 ; j < 10 ; j++){
//            ListNode[] tree20 = new ListNode[size];
//            ListNode[] tree10 = new ListNode[size];
//            ListNode[] tree5 = new ListNode[size];
//            ListNode[] tree1 = new ListNode[size];
//
//            System.out.println(j);
//            StopWatch generation = new StopWatch();
//            String[] string = new String[size * 20000];
//            for (int i = 0; i < size * 20000; i++) {
//                string[i] = StringOperations.StringGenerator();
//            }
//            double generationTime = generation.elapsedTime();
//            System.out.println("Generation time Hashchain: " + generationTime + "s");
//
//
//// 200
//
//            StopWatch insert = new StopWatch();
//            for (int i = 0; i < size * 2000; i++) {
//                tree20 = HashTab1.insert(tree20, StringOperations.StoCh(string[i]), string[i]);
//            }
//            double splayTime = insert.elapsedTime();
//            System.out.println("Insert time Hashchain: " + splayTime + "s");
//
//            StopWatch searchT = new StopWatch();
//            for (int i = 0; i < size * 10; i++) {
//                HashTab1.search(tree20, StringOperations.StoCh(string[i]));
//            }
//            double searchTime = searchT.elapsedTime();
//            System.out.println("SearchTime Hashchain: " + searchTime + "s");
//
//            StopWatch deleteT = new StopWatch();
//            for (int i = 0; i < size * 10; i++) {
//                tree20 = HashTab1.delete(tree20, StringOperations.StoCh(string[i]));
//            }
//            double deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            // 100
//
//            insert = new StopWatch();
//            for (int i = 0; i < size * 10000; i++) {
//                tree10 = HashTab1.insert(tree10, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time Hashchain: " + splayTime + "s");
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size * 10000; i++) {
//                HashTab1.search(tree10, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("SearchTime Hashchain: " + searchTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size * 10000; i++) {
//                tree10 = HashTab1.delete(tree10, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Hashchain: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            //50
//            insert = new StopWatch();
//            for (int i = 0; i < size * 5000; i++) {
//                tree5 = HashTab1.insert(tree5, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time Hashchain: " + splayTime + "s");
//
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size * 5000; i++) {
//                HashTab1.search(tree5, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("Search Time Hashchain: " + searchTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size * 5000; i++) {
//                tree5 = HashTab1.delete(tree5, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Hashchain: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            //10
//            insert = new StopWatch();
//            for (int i = 0; i < size * 1000; i++) {
//                tree1 = HashTab1.insert(tree1, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time Hashchain: " + splayTime + "s");
//
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size * 1000; i++) {
//                HashTab1.search(tree1, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("Search Time Hashchain: " + searchTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size * 1000; i++) {
//                tree1 = HashTab1.delete(tree1, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Hashchain: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            //Search
//
//        }
//    }


//    public static void main(String [] args) {             //Open addressing
//
//
//        for (int j = 0; j < 10;  j++){
//            NodeOA[] tree20 = new NodeOA[size];
//            NodeOA[] tree10 = new NodeOA[size];
//            NodeOA[] tree5 = new NodeOA[size];
//            NodeOA[] tree1 = new NodeOA[size];
//            System.out.println(j);
//        StopWatch generation = new StopWatch();
//        String[] string = new String[size*20000];
//        for (int i = 0 ; i < size*20000; i++){
//            string[i]= StringOperations.StringGenerator();
//        }
//        double generationTime = generation.elapsedTime();
//        System.out.println("Generation time splay: " + generationTime+ "s");
//
//
//// 200{
//
//
//            StopWatch insert = new StopWatch();
//            for (int i = 0; i < size * 20000; i++) {
//                tree20 = HashOA.insert(tree20, StringOperations.StoCh(string[i]), string[i]);
//            }
//            double splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//            StopWatch searchT = new StopWatch();
//            for (int i = 0; i < size * 20000; i++) {
//                HashOA.search(tree20, StringOperations.StoCh(string[i]));
//            }
//            double searchTime = searchT.elapsedTime();
//            System.out.println("SearchTime splay: " + searchTime + "s");
//
//            StopWatch deleteT = new StopWatch();
//            for (int i = 0; i < size * 20000; i++) {
//                tree20 = HashOA.delete(tree20, StringOperations.StoCh(string[i]));
//            }
//            double deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            // 100
//
//            insert = new StopWatch();
//            for (int i = 0; i < size * 10000; i++) {
//                tree10 = HashOA.insert(tree10, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size * 10000; i++) {
//                HashOA.search(tree10, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("SearchTime splay: " + searchTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size * 10000; i++) {
//                tree10 = HashOA.delete(tree10, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            //50
//            insert = new StopWatch();
//            for (int i = 0; i < size * 5000; i++) {
//                tree5 = HashOA.insert(tree5, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size * 5000; i++) {
//                HashOA.search(tree5, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("Search Time splay: " + searchTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size * 5000; i++) {
//                tree5 = HashOA.delete(tree5, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//            //10
//            insert = new StopWatch();
//            for (int i = 0; i < size * 1000; i++) {
//                tree1 = HashOA.insert(tree1, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size * 1000; i++) {
//                HashOA.search(tree1, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("Search Time splay: " + searchTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size * 1000; i++) {
//                tree1 = HashOA.delete(tree1, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//            fullnessFactor = 0;
//            hashSize = 1000;
//
//
//        }
//
//
//    }

//    public static void main(String[] args) {                              //AVL
//
//
//        Node root = new Node(450);
//        root = AVL.insert(root, 500);
//        for (int i = 0 ; i < 10000000; i++ ){
//            root = AVL.insert(root,(int)(Math.random()*1000)+1);
//
//        }
//        root = AVL.delete(root,500);
//        Node node = AVL.search(root,450);
//        System.out.println(node.index);
//
////        System.out.println("H");
//    }

//    public static void main(String [] args) {               //AVL testy
//        Node tree20 = new Node();
//        Node tree10 = new Node();
//        Node tree5 = new Node();
//        Node tree1 = new Node();
//
//        for (int j = 0; j < 6; j++){
//            System.out.println(j);
//            StopWatch generation = new StopWatch();
//            String[] string = new String[size];
//            for (int i = 0; i < size; i++) {
//                string[i] = StringOperations.StringGenerator();
//            }
//            double generationTime = generation.elapsedTime();
//            System.out.println("Generation time splay: " + generationTime + "s");
//
//            StopWatch insert = new StopWatch();
//            for (int i = 0; i < size; i++) {
//                tree20 = AVL.insert(tree20, StringOperations.StoCh(string[i]), string[i]);
//            }
//            double splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//            insert = new StopWatch();
//            for (int i = 0; i < size / 2; i++) {
//                tree10 = AVL.insert(tree10, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//            insert = new StopWatch();
//            for (int i = 0; i < size / 10; i++) {
//                tree5 = AVL.insert(tree5, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//            insert = new StopWatch();
//            for (int i = 0; i < size / 20; i++) {
//                tree1 = AVL.insert(tree1, StringOperations.StoCh(string[i]), string[i]);
//            }
//            splayTime = insert.elapsedTime();
//            System.out.println("Insert time splay: " + splayTime + "s");
//
//
//            //Search
//
//            StopWatch searchT = new StopWatch();
//            for (int i = 0; i < size; i++) {
//                AVL.search(tree20, StringOperations.StoCh(string[i]));
//            }
//            double searchTime = searchT.elapsedTime();
//            System.out.println("SearchTime splay: " + searchTime + "s");
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size / 2; i++) {
//                AVL.search(tree10, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("SearchTime splay: " + searchTime + "s");
//
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size / 10; i++) {
//                AVL.search(tree5, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("Search Time splay: " + searchTime + "s");
//
//
//            searchT = new StopWatch();
//            for (int i = 0; i < size / 20; i++) {
//                AVL.search(tree1, StringOperations.StoCh(string[i]));
//            }
//            searchTime = searchT.elapsedTime();
//            System.out.println("Search Time splay: " + searchTime + "s");
//
//
//            //delete
//            StopWatch deleteT = new StopWatch();
//            for (int i = 0; i < size * 1; i++) {
//                tree20 = AVL.delete(tree20, StringOperations.StoCh(string[i]));
//            }
//            double deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size / 2; i++) {
//                tree10 = AVL.delete(tree10, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size / 10; i++) {
//                tree5 = AVL.delete(tree5, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//
//            deleteT = new StopWatch();
//            for (int i = 0; i < size / 20; i++) {
//                tree1 = AVL.delete(tree1, StringOperations.StoCh(string[i]));
//            }
//            deleteTime = deleteT.elapsedTime();
//            System.out.println("Delete time Splay: " + deleteTime + "s");
//
//        }
//    }


//
    public static void main(String [] args) {                         //Splay
        SplayTree tree20 = new SplayTree();
        SplayTree tree10 = new SplayTree();
        SplayTree tree5 = new SplayTree();
        SplayTree tree1 = new SplayTree();


        for (int j = 0 ; j < 10 ; j++){
            StopWatch generation = new StopWatch();
            String[] string = new String[size];
            for (int i = 0; i < size; i++) {
                string[i] = StringOperations.StringGenerator();
            }
            double generationTime = generation.elapsedTime();
            System.out.println("Generation time splay: " + generationTime + "s");

            StopWatch insert = new StopWatch();
            for (int i = 0; i < size; i++) {
                tree20.insert(StringOperations.StoCh(string[i]), string[i]);
            }
            double splayTime = insert.elapsedTime();
            System.out.println("Insert time splay: " + splayTime + "s");

            insert = new StopWatch();
            for (int i = 0; i < size / 2; i++) {
                tree10.insert(StringOperations.StoCh(string[i]), string[i]);
            }
            splayTime = insert.elapsedTime();
            System.out.println("Insert time splay: " + splayTime + "s");

            insert = new StopWatch();
            for (int i = 0; i < size / 10; i++) {
                tree5.insert(StringOperations.StoCh(string[i]), string[i]);
            }
            splayTime = insert.elapsedTime();
            System.out.println("Insert time splay: " + splayTime + "s");

            insert = new StopWatch();
            for (int i = 0; i < size / 20; i++) {
                tree1.insert(StringOperations.StoCh(string[i]), string[i]);
            }
            splayTime = insert.elapsedTime();
            System.out.println("Insert time splay: " + splayTime + "s");


            //Search

            StopWatch searchT = new StopWatch();
            for (int i = 0; i < size; i++) {
                tree20.search(StringOperations.StoCh(string[i]));
            }
            double searchTime = searchT.elapsedTime();
            System.out.println("SearchTime splay: " + searchTime + "s");

            searchT = new StopWatch();
            for (int i = 0; i < size / 2; i++) {
                tree10.search(StringOperations.StoCh(string[i]));
            }
            searchTime = searchT.elapsedTime();
            System.out.println("SearchTime splay: " + searchTime + "s");


            searchT = new StopWatch();
            for (int i = 0; i < size / 10; i++) {
                tree5.search(StringOperations.StoCh(string[i]));
            }
            searchTime = searchT.elapsedTime();
            System.out.println("Search Time splay: " + searchTime + "s");


            searchT = new StopWatch();
            for (int i = 0; i < size / 20; i++) {
                tree1.search(StringOperations.StoCh(string[i]));
            }
            searchTime = searchT.elapsedTime();
            System.out.println("Search Time splay: " + searchTime + "s");


            //delete
            StopWatch deleteT = new StopWatch();
            for (int i = 0; i < size ; i++) {
                tree20.delete(StringOperations.StoCh(string[i]));
            }
            double deleteTime = deleteT.elapsedTime();
            System.out.println("Delete time Splay: " + deleteTime + "s");


            deleteT = new StopWatch();
            for (int i = 0; i < size / 2; i++) {
                tree10.delete(StringOperations.StoCh(string[i]));
            }
            deleteTime = deleteT.elapsedTime();
            System.out.println("Delete time Splay: " + deleteTime + "s");


            deleteT = new StopWatch();
            for (int i = 0; i < size / 10; i++) {
                tree5.delete(StringOperations.StoCh(string[i]));
            }
            deleteTime = deleteT.elapsedTime();
            System.out.println("Delete time Splay: " + deleteTime + "s");


            deleteT = new StopWatch();
            for (int i = 0; i < size / 20; i++) {
                tree1.delete(StringOperations.StoCh(string[i]));
            }
            deleteTime = deleteT.elapsedTime();
            System.out.println("Delete time Splay: " + deleteTime + "s");


        }
    }
}
