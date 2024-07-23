package HashCodeAndEqualsExample;

import java.util.HashSet;
import java.util.Set;



import java.util.*;
class Child{
    String name;

    Child(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != getClass()) return false;
        Child c = (Child) obj;
        return this.name.equals(c.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}

 class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");
        Object obj1 = new Object();
        Object obj2 = new Object();

        Child c1 = new Child("Naman");
        Child c2 = new Child("Naman");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}


public class Control {
    public static void main(String[] args) {
        Bean b1 = new Bean(1,"gur");
        Bean b2 = new Bean(1,"gur");
        System.out.println(b1.hashCode()+" "+b2.hashCode());

        Set<Bean> set = new HashSet<>();
        set.add(b1);
        set.add(b2);


        System.out.println(set.toString());

        String s = "java";
        String str = "java";

        s = s.concat(" techie");
        //s.intern() method is used to get the object from SCP (String constant pool)
        // String s = new String("test") -> creates 2 objects one s due to new keyword and stores it in heap and the other in
        // string literal "test" which is stores in SCP.
        // now if we write String str = test; -> this will create no new object as test is already present in SCP
        System.out.println(s);
        System.out.println(str);



        // learing is ki for hashmap and hashset implementations -> hashCode is checked first. If found equal then
        // equals is checked. If hashcode is not found equal the equals is not checked and object is considered a diff object
        // hence before using classes/beans in hash based collections always implement hashcode as well .


        /*

        * the hashCode method in Java does not necessarily return the memory address of the object. The hashCode method is designed to return an integer hash code that represents the object's state. While the default implementation in the Object class (from which all Java objects inherit) returns the memory address of the object in the form of an integer, this behavior is not guaranteed and can vary between different Java Virtual Machine (JVM) implementations.

In Java, the general contract for hashCode is as follows:

If two objects are equal (according to their equals method), they must have the same hash code. However, the reverse is not necessarily true: two objects with the same hash code are not required to be equal.

The hashCode method should strive to distribute hash codes as evenly as possible across the range of integers, to improve the performance of hash-based data structures.

It's important for developers to override the hashCode method when they override the equals method in their classes to ensure that these contracts are maintained. The implementation of hashCode should be based on the same set of fields used in the equals method to represent the object's state. This helps maintain consistency between equality and hash code computation.










        **/

    }
}
