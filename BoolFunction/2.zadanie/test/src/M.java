interface I {
    void m ( ) ;
}
    abstract class C implements I {
public void m ( ) {
        System . out . print ( "c" ) ;
        }
        }
        class D extends C {
public void m ( ) {
        super . m ( ) ;
        System . out . print ( "d" ) ;
        }
        }
        class E extends D {
public void m ( ) {
        super . m ( ) ;
        System . out . print ( "e"  ) ;
        }
}

class M {
public static void exe (I a) {
    for (I e : a) {
        e.m();
    }
}

public static void main ( String [ ] args ) {
        E o1 = new E ( ) ;
        I o2 = new D ( ) ;
        C o3 = new D ( ) ;
        I o4 = ( I ) new E ( ) ;
        exe ( o1 , ( I ) o2 , o3 , o4 ) ;
        }
}