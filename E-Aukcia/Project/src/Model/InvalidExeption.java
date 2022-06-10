package Model;
/**
 * custom exception
 */

public class InvalidExeption  extends Exception{
    public InvalidExeption(){
        super("Invalid name or password");
    }
    public InvalidExeption(String message){
        super(message);
    }
}
