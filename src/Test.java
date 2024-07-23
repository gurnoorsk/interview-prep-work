import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    void show() throws Exception{
        System.out.println("hfu4huh4r");
    }
}

 class UnitTest extends Test{
    void show() throws ArithmeticException {
        System.out.println("shsjhd");
    }

    public static UnitTest object = null;

     static {
         System.out.println("This is static block");
         object = new UnitTest();
     }

     {
         System.out.println("This is non static block");
//         object = new UnitTest();
     }
     public static UnitTest getInstance(){
         return object;
     }

     Object o = new Object();
     UnitTest(){
         System.out.println("This is default constructor");
     }

    public static void main(String[] args) {

        System.out.println("This is main block");
        UnitTest t = UnitTest.getInstance();
        if(t== null){
            System.out.println("jajaj");
        }
        try {
            t.show();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }



    }
}


