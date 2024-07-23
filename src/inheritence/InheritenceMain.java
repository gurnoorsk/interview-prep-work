package inheritence;

import java.util.ArrayList;

public class InheritenceMain {

    public void doWork(Car c){
        if(c instanceof FuelableCar){
            ((FuelableCar) c).fuel(); // This means the reference is now of the FuelableCar and the object is still of the RealCar
        }

        ArrayList a = new CustomArrayList();
        a.add("Test");
        a.add("Test");
        a.add("Test1");


        System.out.println(a);

    }

    public class CustomArrayList extends ArrayList {

        @Override
        public boolean add(Object o) {
            if(this.contains(o)){
                return true;
            }
            return super.add(o);

        }
    }





    public static void main(String [] args){
        Car c = new RealCar();
        //Car c1 = new ToyCar();

        InheritenceMain main = new InheritenceMain();
        //c.brake(); -> calls real cars break method . But It can only call methods that either Real car overrides or it's own methods
        // that were inherited to RealCar. If realcar overrides some of them then realcar's methods will be called and if not then car's
        // methods will be called
        main.doWork(c);
       // main.doWork(c1);




    }


    /**
     *
     * In Java, when you write A a = new B(); where A is the parent class of B, it means that you are creating an
     * instance of class B and assigning it to a reference variable of type A.
     *
     * Let's break down what this line of code does:
     *
     * A a: Declares a reference variable a of type A. This means that a can refer to objects of type A or any of its subclasses.
     * new B(): Creates a new object of class B. This object is an instance of B, and memory is allocated for it.
     * =: Assigns the newly created object of class B to the reference variable a.
     * ();: Invokes the constructor of class B to initialize the object.
     * Even though the object created is of type B, it can be assigned to a reference variable of type A because in
     * object-oriented programming, a subclass object can be treated as an instance of its superclass due to inheritance.
     *
     * Here's an example to illustrate this concept:
     *
     * class A {
     *     void display() {
     *         System.out.println("Inside class A");
     *     }
     * }
     *
     * class B extends A {
     *     void show() {
     *         System.out.println("Inside class B");
     *     }
     * }
     *
     * public class Main {
     *     public static void main(String[] args) {
     *         A a = new B(); // Creating an instance of B and assigning it to reference variable a of type A
     *         a.display();   // Accessing the method from class A
     *         // a.show();    // Error: The method show() is not available in class A
     *     }
     * }
     *
     *
     *
     * In this example:
     *
     * A a = new B(); creates an object of class B and assigns it to a reference variable a of type A.
     * a.display(); calls the display() method from class A. Even though a refers to an object of class B,
     * it can only access methods and members defined in class A. If you try to call a.show(), it will result in
     * a compilation error because show() is not available in class A.
     * This concept is known as polymorphism in Java, where a reference variable of a superclass can refer
     * to an object of its subclass. The methods or behaviors available to the reference variable are determined by
     * the declared type (A in this case), not the actual object type at runtime (B).
     *
     *
     *
     *
     * */
}
