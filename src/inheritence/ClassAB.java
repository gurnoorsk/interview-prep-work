package inheritence;

public class ClassAB implements IInterfaceA{





    public static void main(String[] args) {
        IInterfaceA ab = new ClassAB();
        ab.print();

        //ab.staticPrint();


//        IInterfaceB ib = new ClassAB();
//        ib.apply();
    }

    /*
        default methods from the interfaces are inherited automatically to implementing classes, it is not mandatory
         to provide implementation for the implementation class. If multiple interfaces have the same default method and the class
         implements them both, then the class has to provide an implementation.
    *
    **/

    static public void staticTest(){
        System.out.println("static test");
    }

    static public void staticPrint(){
        System.out.println("static classAB print");
    }

    @Override
    public void print() {
        System.out.println("new implementatino of pront");
    }

    @Override
    public void apply() {
       // IInterfaceA.super.print();

        System.out.println("Apply in Class AB");
    }

    @Override
    public void accept() {
        System.out.println("Accept in Class AB");
    }
}
