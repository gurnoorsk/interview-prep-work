package reflectiondemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reflection {
//https://www.baeldung.com/java-reflection
    class Person{
        String name;
        Integer age;
    }

//    public interface Eating{
//        public String eats();
//    }
//
//    abstract class Animal implements Eating{
//        public static final String CATEGORY = "Domestic";
//        private String name;
//
//        protected abstract String getSound();
//
//        public Animal(String name){
//            this.name = name;
//        }
//        public String getName(){
//            return name;
//        }
//    }
//
//    public interface Locomotion{
//        String getLocomotion();
//    }
//
//    public class Goat extends Animal implements Locomotion{
//
//        public Goat(String name) {
//            super(name);
//        }
//
//        @Override
//        public String eats() {
//            return "grass";
//        }
//
//        @Override
//        protected String getSound() {
//            return "blehh";
//        }
//
//        @Override
//        public String getLocomotion() {
//            return "walks";
//        }
//    }

    public static Class<?> getObject(Class c) throws ClassNotFoundException {
        return Class.forName("reflectiondemo.Reflection");
    }

    public void doWork() throws ClassNotFoundException {
        Object p = new Person();
        Field[] fields = p.getClass().getDeclaredFields();
        List<String> list = Arrays.stream(fields).map(input -> input.getName()).collect(Collectors.toList());
        System.out.println(list);

//        Goat goat = new Goat("goat1");
//        Class<?> clazz = goat.getClass();//Class.forName("Goat");
//        System.out.println("Basic name "+ clazz.getSimpleName());
//        System.out.println("Qualified name "+clazz.getName()); // -> in case of inner classes the name comes as reflectiondemo.Reflection$Goat and only this works with Class.forNmae()
//        System.out.println("Qualified name "+clazz.getCanonicalName()); // comes with . ie reflectiondemo.Reflection.Goat in case of inner classes and does not work with Class.forName()

        Class<?> clazz = Class.forName("reflectiondemo.Goat");
        System.out.println("Basic name "+ clazz.getSimpleName());
        System.out.println("Qualified name "+clazz.getName());
        System.out.println("Qualified name "+clazz.getCanonicalName());



    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //https://www.baeldung.com/java-reflection

        Class<?> r = getObject(Reflection.class);
        System.out.println(Arrays.stream(r.getMethods()).count());
        //r.doWork();
        Object reflection = r.getDeclaredConstructor().newInstance();
        Method method = r.getMethod("doWork");
        method.invoke(reflection);


        Class<?> r1 = Bird.class;
        Constructor<?> c1 = r1.getConstructor(String.class);
        Constructor<?> c2 = r1.getConstructor(String.class,Boolean.class);
        Bird b1 = (Bird)c1.newInstance("Happy");
        Bird b2 = (Bird)c2.newInstance("Hogan",true);

        System.out.println("B1 locomotion ? "+b1.getLocomotion());
        System.out.println("B2 locomotion ? "+b2.getLocomotion());


    }
}
