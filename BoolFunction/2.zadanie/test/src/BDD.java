import java.util.Hashtable;
import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;


public class BDD {
    public static Hashtable<String,Node> htable = new Hashtable<>();
    static Node one = new Node("1",1);
    static Node zero = new Node("0",1);
    static Node root;
    public static int pocet = 3;
//príkaz use ktorý po pridaní stringu a root node rekurzívne vyvoláva dalšiu node a zistuje či výsledok je 0 alebo 1
    public static String use(String s, Node root){
        if ((s.length()>1||root.finish==null) && root.one!=null&&root.zero!=null){
            if (s.length()>0){
                if (s.charAt(0) == '1') {
                   return use(s.substring(1), root.one);
                } else if (s.charAt(0) == '0') {
                   return use(s.substring(1), root.zero);
                }
            }else return root.expression;
        }
            return root.finish;
    }


    public static Node create(Node node){
        //ak sa výraz nachadza v strome tak sa mi iba presunie ukazovatel na danú node ak nie vytvorí sa a pridá sa do hashmap z ktorej si
        //dokáže danú node vybrať redukcia typu S
        String substring = node.character.substring(0);
        if (htable.containsKey(node.expression)&&!(substring.contains(node.expression.substring(0,1).toLowerCase()))){
            node = htable.get(node.expression);

        }else
        {

            htable.put(node.expression, node);
            if (node.expression == "1") {
                node.zero = node.one = one;
                return node;
            }
            if (node.expression == "0") {
                node.zero = node.one = zero;
                return node;
            }

            if (allvaysTrue(node.expression)) {

                return one;

            } else if (node.expression.length() == 1 && (node.character.charAt(0)==node.expression.charAt(0)||Character.toUpperCase(node.character.charAt(0))==node.expression.charAt(0))) {
                char c = node.expression.charAt(0);
                if ('a' <= c && c <= 'z') {

                    node.zero = zero;
                    node.one = one;
                } else {
                    node.zero = one;
                    node.one = zero;
                }
            }else /*if (node.expression.length() > 1)*/ {
//                System.out.println("node expresion:" + node.expression.length() + ":done");
                node.zero = create(new Node(formation(node.expression, node.character, 'z'), node.character.substring(1)));
                node.one = create(new Node(formation(node.expression, node.character, 'o'), node.character.substring(1)));
                pocet+=2;
            }
        }
        //redukcia typu I
        if (node.zero!=null&&node.one!=null){
            if (node.zero.one != null && node.one.one != null) {
                if (node.one.one == node.one.zero) {
                    node.one = node.one.one;
                    pocet -= 1;
                }
                if (node.zero.one == node.zero.zero) {
                    node.zero = node.zero.one;
                    pocet -= 1;
                }
            }
        }

        return node;
    }
//tistuje či sa nenachádza výraz ktor´je stále 1 napr A+a
    public static boolean allvaysTrue(String s){
        if (s.length() ==3 ){
            if (s.charAt(0) == s.charAt(2)-('A'-'a')||s.charAt(0) == s.charAt(2)+('A'-'a')) {
                return true;
            }
        }return false;

    }


    public static boolean dontOcure(String s, Character c){
        char l = Character.toLowerCase(c);
        Character u = Character.toUpperCase(c);
        if (s.contains(Character.toString(l))||s.contains(u.toString())) {
            return false;
        }
        return true;
    }


    public static String manage(String str,Character c){
        if (str.length()!=0){
            str = str.replace(Character.toLowerCase(c), ' ');
            str = str.replace(Character.toUpperCase(c),' ');
            str = str.replaceAll("\\s+", "");
            if (str.substring(str.length()-1).equals("+")){
                str = str.substring(0,str.length()-1);
            }
        }


        if (str.length()!=0){
            if (str.charAt(0) == '+') {
                str = str.substring(1);
            }
        }
        return str;
    }

//formatovanie stringu a odstránovanie nádledujúceho písmena v poradí
    public static String formation(String s, String poradie,Character help){
        s = firstCorrection(s,poradie);
        s = firstCorrection(s,poradie.toUpperCase());
        String str = new String();
        Character c = poradie.charAt(0);

        if (help=='z'){
            c = Character.toUpperCase(c);
        }else if (help == 'o'){
            c = Character.toLowerCase(c);
        }

        if (s.contains(c.toString().toUpperCase())||s.contains(c.toString().toLowerCase())){
            s = s.replace('+', '-');
            String[] returned = s.split("-", 0);
            for (int i = 0 ; i < returned.length; i++){
                if (returned[i].equals(c.toString())){
                    str="1";
                    return str;
                }
            }
            for (int i = 0; i < returned.length; i++) {
                if (returned[i].contains(c.toString()) || dontOcure(returned[i], c)) {
                    str = str + returned[i] + "+";
                }
            }
            str = manage(str, c);
            int l=0;
            str = str.replace('+', '-');
            returned = str.split("-", 0);

            for (int j = 0; j < returned.length-l; j++) {
                for (int k = 0; k < returned.length; k++) {
                    if (returned[j].contains(returned[k]) && j != k) {
                        returned = removeTheElement(returned, j);
                        l++;
                        break;
                    }

                }

            }
            str = "";
            for (int i = 0; i < returned.length; i++) {
                str = str + returned[i] + "+";
            }

            str = manage(str, c);
            if (str.equals("") && help == 'o' ) {
                if (s.contains(c.toString())){
                    str = "1";
                }else {
                    str = "0";
                }
            }else if (str.equals("") && help == 'z') {
                str = "0";
            }


//            System.out.println(str);
        }else {
            str = s;
        }

        return str;
    }

//odstránuje duplicitné výskyty jednotlvých znakov v booleanovskej funkcii
    public static String firstCorrection(String s,String poradie){
        s = s.replace('+', '-');
        String[] returned = s.split("-", 0);
        s="";
        for (int i = 0 ; i< returned.length;i++) {
            for (int j = 0; j < poradie.length(); j++) {
                if (returned[i].contains(poradie.substring(j,j+1))){
                    returned[i] = returned[i].replaceAll(poradie.substring(j,j+1),"");
                    returned[i]=  returned[i]+=poradie.substring(j,j+1);
                }
            }
        }
        for (int i = 0 ;i <returned.length; i++){
            s = s+ "+" +returned[i];
        }
        s=s.substring(1);

        return s;
    };

    public static String[] removeTheElement(String[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {

            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];
        System.arraycopy(arr, 0, anotherArray, 0, index);
        System.arraycopy(arr, index + 1, anotherArray, index,arr.length - index - 1);

        return anotherArray;
    }


    public static String[] generator(){
        String[] s = new String[65536];
        for (int i = 0 ; i <65536; i++){
            s[i]=String.format("%13s", Integer.toBinaryString(i)).replace(" ","0");

        }
        return s;
    }

    //pomocná funkcia na kontrolu správnosti
    public static Boolean porovnanie(String numbers, String function,String poradie){
        function = function.replace('+', '-');


        for (int i = 0 ; i<poradie.length();i++){
            function = function.replace(poradie.charAt(i),numbers.charAt(i));
            if (numbers.charAt(i)=='1'){
                function = function.replace(Character.toUpperCase(poradie.charAt(i)),'0');
            }
            if (numbers.charAt(i)=='0'){
                function = function.replace(Character.toUpperCase(poradie.charAt(i)),'1');
            }
        }
        String[] temp = function.split("-", 0);
        for (int j = 0; j < temp.length; j++){
            if (!(temp[j].contains("0"))){
                return true;
            }
        }
        return false;
    }


//generuje náhodné booleanovské funkcie
    public static String generator(String poradie){
        String output="";
        int random;
        for (int i = 0; i<100;i++){
            random = (int)(Math.random()*100);
            random = random % poradie.length();
            random+= 65;
            if (random%2==0){
                output = output + Character.toLowerCase((char)random);
            }else output = output + (char)random;
            if (i%20==19){
                output+="+";
            }
        }
//        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        double precentnaRedukcia = 0;
        int priemernzpocetuylov=0;
        double time=0;
        String order = "abcd";
        for (int j = 0; j<100; j++){
//            String inputLogic = generator(order);
            String inputLogic = generator(order);


            int nodeCount = (int) Math.pow(2, order.length() + 1) - 1;

            root = new Node(inputLogic, order);
//            double currTime= System.currentTimeMillis();
            root = create(root);
//            time =time+((double) System.currentTimeMillis()-currTime);
            precentnaRedukcia = precentnaRedukcia + ((double)pocet/(double)nodeCount)*100;
            System.out.println("redukcia bola vykonaná na: " + precentnaRedukcia + "%");
            String[] s = generator();

            boolean useOutput;



            for (int i = 0; i < 8192; i++) {
                if (use(s[i], root).contains("1")) {
                    useOutput = true;
                } else useOutput = false;

                double currTime = System.currentTimeMillis();
                use(s[i],root);
                porovnanie(s[i],inputLogic,order);
                time = time + ((double) System.currentTimeMillis()-currTime);
                if (useOutput != porovnanie(s[i], inputLogic, order)) {
                    System.out.println(s[i] + "incorrect\n");
                    System.out.println("--" + use(s[i], root));
                    System.out.println(porovnanie(s[i], inputLogic, order));
                }
            }
            priemernzpocetuylov+=pocet;
            pocet=0;

        }
        System.out.println(time/100);
//        System.out.println(priemernzpocetuylov/100);
        System.out.println(100-(precentnaRedukcia/100));
    }
}



