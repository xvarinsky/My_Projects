package AVL;

import java.util.Arrays;

public class HashOA {

    public static int HashCode(int i){
        return i % Main.hashSize;
    }


    public static NodeOA[] insert(NodeOA[] nodeOAS , int index ,   String name){
        int key = HashCode(index);
        if (nodeOAS[key]==null){
            nodeOAS[key] = new NodeOA(index, name, false);
           Main.fullnessFactor= Main.fullnessFactor+1;
        }else if (nodeOAS[key]!= null){
            while (nodeOAS[key]!= null){
                if (nodeOAS[key].deleted==true){
                    nodeOAS[key]=new NodeOA(index,name,false);

                    return nodeOAS;
                }else if (nodeOAS[key].index==index){
                    return nodeOAS;
                }else if (Main.fullnessFactor*1.3 > nodeOAS.length){
                    NodeOA[] newArr = new NodeOA[nodeOAS.length*10+1];
                    Main.hashSize=nodeOAS.length*10+1;
                    Main.fullnessFactor=0;
                    for (int i = 0 ; i < nodeOAS.length ; i++){
                        if (nodeOAS[i]!=null) {
                            insert( newArr, nodeOAS[i].index, nodeOAS[i].name);
                        }
                    }


                    nodeOAS = newArr;
                    nodeOAS[key] = new NodeOA(index, name , false);

                    return nodeOAS;
                }else if (key +1 == nodeOAS.length){
                    key=0;
                }
                key++;
            }

        }

        return nodeOAS;
    }

    public static NodeOA[] delete(NodeOA[] nodeOAS, int index){
        int key = HashCode(index);
        if(nodeOAS[key]!= null){
            while (index != nodeOAS[key].index ) {
                if (key + 1 == nodeOAS.length) {

                    return nodeOAS;
                }
                if (nodeOAS[key+1] == null) {
                    return nodeOAS;
                }
                key++;
            }

            nodeOAS[key] = new NodeOA(true);
        }
        return nodeOAS;
    }

    public static int search(NodeOA[] nodeOAS, int index){
        int key = HashCode(index);
        if (nodeOAS[key]!=null){
            while (index != nodeOAS[key].index) {
                key++;
                if (nodeOAS.length == key) {
                    return -1;
                }
                if (nodeOAS[key] == null) {
                    return -1;
                }
            }
        }
        return key;
    }



}
