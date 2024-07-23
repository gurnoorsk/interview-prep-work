import javax.print.attribute.HashAttributeSet;
import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceTestClass implements  FunctionInterfaceDemo{
    @Override
    public void get1() {
        System.out.println("Class get1");
    }

//    @Override
//    public void get5() {
//        System.out.println("Class get5");
//    }
    @Override
    public void get2(){
        System.out.println("Class get2");
    }
    //default method of an interface can be overrriden, if the class does not override it, then the interface mehtod
    // will be called
    // static methods cannot be overriden

    public static void main(String args[]){
        FunctionInterfaceDemo app = new FunctionalInterfaceTestClass();
        app.get1();
        //app.get5();
        app.get2();

        FunctionInterfaceDemo demo = ()->{
            System.out.println("Lambda get1 called");
        };

        demo.get1();


        Map<Integer,String> map = new HashMap<>();
        map.put(2,"amit");
        map.put(3,"jamit");
        map.put(1,"famit");


        map = map.entrySet().stream().sorted((o1,o2) -> o1.getKey().compareTo(o2.getKey())).collect(Collectors.toMap(o->o.getKey(), o->o.getValue()));
        System.out.println(map.toString());


        List<String> l = List.of("rishav","amit","robin","gurnoor");

        List<List<String>> lis = new ArrayList();

        lis.add(Arrays.asList("set","met","fet"));


        lis.add(Arrays.asList("kem","fem"));

        String [][] s = lis.stream().map(li -> li.toArray(new String[li.size()])).toArray(String [][]::new);


//        Map<String,Long> map = l.stream().filter(e-> e.substring(0,1).equalsIgnoreCase("r")).collect(Collectors.toMap(e->e,e->e.chars().distinct().count()));
//        System.out.println(map.toString());





    }

}
