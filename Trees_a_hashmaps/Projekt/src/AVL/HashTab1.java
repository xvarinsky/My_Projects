package AVL;

public class HashTab1 {




    public static ListNode [] insert(ListNode[] listNodeTab, int index, String s){  // insertovanie
        int x = (index % Main.hashSize);
        ListNode listNode = new ListNode(index, s);
        int j= 0;
        if (listNodeTab[x]==null){                                  // ak este nieje prvá hodnota inicializovaná
            listNodeTab[x]=listNode;
        }else if (listNodeTab[x].next==null){                       // ak nieje ešte 2. hodnota inicializovaná
            listNodeTab[x].next=listNode;
        }else {
            listNodeTab[x].next = insertL(listNodeTab[x].next, listNode);       //ostatné hodnoty
        }
        if (Main.fullnessFactor*0.7>listNodeTab.length){                    //ak je tabulka zaplnená
            Main.fullnessFactor=0;
            Main.hashSize=listNodeTab.length*10+1;
            ListNode[] newarr = new ListNode[Main.hashSize];
            while (listNodeTab.length!= j){                                         //rehashovanie tabulky
                while (listNodeTab[j] != null) {
                    newarr = insert(newarr, listNodeTab[j].index, s);
                    listNodeTab[j]=listNodeTab[j].next;

                }
                j++;
            }
            listNodeTab=newarr;



        }
        Main.fullnessFactor++;
        return listNodeTab;
    }

    public static ListNode insertL(ListNode listNodeTab, ListNode listNode) {  // Hladanie posledného ukazovatela
        if (listNodeTab.next==null){
            listNodeTab.next=listNode;
        }else {
            listNodeTab.next = insertL(listNodeTab.next, listNode);
        }
        return listNodeTab;
    }

    public static ListNode search(ListNode[] listNodeTab, int index){       //vyhladavanie prvkov
        int x = index % Main.hashSize;
        ListNode find = listNodeTab[x];

        if (find!=null){
            while (find.index != index) {
                if (find.next != null) {
                    find = find.next;
                } else break;
            }
        }
        return find;
    }

    public static ListNode[] delete(ListNode[] listNodeTab, int index){ //mazanie
        int x = index % Main.hashSize;
        ListNode temp = listNodeTab[x];
        if (temp == null) return listNodeTab;                          //ak sme dostali prázdny ukazovateľ tak sa nič nestane
        if (temp.index != index ) {
            while (temp.next != null) {
                if (temp.index == index) {
                    break;
                }

                temp = temp.next;

            }
            if (temp.index == index) {                                  //odstranovanie pointerov na zmazané prvky
                temp = temp.next;
                listNodeTab[x]=temp;
            }
        }else {
            listNodeTab[x] = listNodeTab[x].next;

        }
        return listNodeTab;
    }
}



