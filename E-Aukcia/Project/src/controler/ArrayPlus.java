package controler;


import java.util.Arrays;

public class ArrayPlus <T>{
    T ob;

    /**
     * Extend array by adding element to the last position of array
     * @param ob array
     * @param addLast what we wnat to add to the end
     * @return array with added element to the end
     */
    public T[] addOne(T[] ob,T addLast) {

        ob = Arrays.copyOf(ob,ob.length+1);
        ob[ob.length-1] = addLast;
//        System.out.println("Ididit");


        this.ob = (T) ob;
        return ob;
    }
}
;