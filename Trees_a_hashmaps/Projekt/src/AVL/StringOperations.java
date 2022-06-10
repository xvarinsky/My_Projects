package AVL;

import java.util.Random;

public class StringOperations {

    public static String StringGenerator() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 30;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        return generatedString;

    }

    public static int StoCh(String string ){

        int number = 0;
        for (int i = 0 ; i < string.length();i++){
            char ch = string.charAt(i);
            number = 31 * number + ch;
        }

        return (number)<0 ? number*-1: number;
    }


}