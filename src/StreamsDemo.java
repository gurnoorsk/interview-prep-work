import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    static class Notes {
        int id;
        String name;
        int tagId;

        public Notes(int id,String name,int tagId){
            this.id = id;
            this.name = name;
            this.tagId = tagId;
        }

        public int getId(){return id;}
        public String getNote(){return name;}
        public int getTagId(){return tagId;}
    }

    public static List<Notes> getNotes(){
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));

        return noteLst;
    }

    public static void main(String[] args) {
        String inputString = "Hello World";

        Map<Character, Long> charCount = inputString.chars() // Get IntStream of characters
                .mapToObj(c -> (char) c) // Convert to Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count occurrences
        charCount.forEach((character, count) -> System.out.print(character + ": " + count));


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


        Map<String,Long> m = l.stream().filter(e-> e.substring(0,1).equalsIgnoreCase("r")).collect(Collectors.toMap(e->e,e->e.chars().distinct().count()));
        System.out.println(m.toString());

        // all evens in a list of numbers
        Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().filter(n -> n%2 == 0).forEach(System.out::print);

        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        Arrays.asList(100,200,13,34,152,263,175,548,1119,110).stream().map(n -> n+"").filter(n-> n.substring(0,1).equals("1")).forEach(System.out::println);

        // find duplicate elements in a list
        Set<Integer> set = new HashSet();
        Arrays.asList(10,15,8,49,25,98,98,32,15).stream().filter(n -> !set.add(n)).forEach(System.out::println);

        // find first element of the list
        System.out.println(Arrays.asList(10,15,8,49,25,98,98,32,15).stream().findFirst().get());


        //Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println(Arrays.asList(10,15,8,49,25,98,98,32,15).stream().count());


        // Given a list of integers, find the maximum value element present in it using Stream functions?
        System.out.println(Arrays.asList(10,15,8,49,25,98,98,32,15).stream().max((a,b)-> (a>b?1:-1)).get());
        System.out.println(Arrays.asList(10,15,8,49,25,98,98,32,15).stream().max(Integer::compare).get());


        // Given a String, find the first non-repeated character in it using Stream funtions?
        String input = "Java articles are Awesome";
        System.out.println(input.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()==1).map(ent -> ent.getKey()).findFirst().get());


        // if you have a list of integers and you want to group them into even and odd numbers:
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0)).toString());


        //Given a list of integers, sort all the values present in it using Stream functions
        Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .sorted().forEach(System.out::println);

        //Given a list of integers, sort all the values present in it in descending order using Stream functions?
        Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .sorted((a,b) -> b>a?1:-1).forEach(System.out::println);
        // or
        Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .sorted(Collections.reverseOrder()).forEach(System.out::println);

        // Given an integer array nums, return true if any value appears at least twice in the array,
        // and return false if every element is distinct.

        Set<Integer> set1 = new HashSet<>();
        System.out.println(Arrays.asList(10,15,8,49,25,98,32).stream().filter(e -> !set1.add(e)).count()>1?true:false);


        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time



        //Write a Java 8 program to concatenate two Streams?

        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

        // Concatenated the list1 and list2 by converting them into Stream

        concatStream.forEach(System.out::println);


        //Java 8 program to perform cube on list elements and filter numbers greater than 50
        Arrays.asList(4,5,6,7,1,2,3).stream().map(e -> (int)Math.pow(e,3)).filter(e ->e>50)
                .collect(Collectors.toList()).forEach(System.out::println);


        // How to use map to convert object into Uppercase in Java 8?
        Arrays.asList("explained", "through", "programs").stream().map(String::toUpperCase).forEach(System.out::println);

        //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?

        getNotes().stream().sorted(Comparator.comparingLong(Notes::getTagId).reversed())
                .collect(Collectors.toMap(Notes::getNote,Notes::getTagId,(oldValue,newValue)-> oldValue,LinkedHashMap::new));


        //How to count each element/word from the String ArrayList in Java8?

        System.out.println(Arrays.asList("AA", "BB", "AA", "CC").stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).toString());

        countEachWordAndPrintInDecendingOccuranceOrder();


        //How to find only duplicate elements with its count from the String ArrayList in Java8?

        System.out.println(Arrays.asList("AA", "BB", "AA", "CC").stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList()));

        //How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?

        Optional.ofNullable(getNotes())
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(note -> note.getNote()) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names

        Set<Integer> s4 = new HashSet<>();


        // find nth highest salary using streams
        System.out.println(Arrays.asList(1000,1002,900,800).stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList()).get(3));

        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> result = CompletableFuture.supplyAsync(()-> method1(5000),executor)
                .thenCombine(CompletableFuture.supplyAsync(()-> method2(5000),executor),(s1,s2)-> s1 + s2+" Final "+LocalDateTime.now());

        /**
         * Completable Future  creates daemon threads which will stop if main thread stops running daemon
         * thread will also stop. In case of executer service, it will create non daemon thread for which jvm
         * will wait for completion and exit when all work by these threads are done
         *
         * */


//        try {
//            System.out.println(result.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }




//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("plepele");
//            return "Hello";
//        });
//
//        CompletableFuture<Void> future1 = CompletableFuture
//                .runAsync(() -> System.out.println("Computation finished."));
//
//        try {
//            future1.get();
//            completableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


    }


    public static String method3(long milli){
        try {
            Thread.sleep(milli);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "implementing method3");
        return "Method3 completed at : "+ LocalDateTime.now();
    }

    public static String method2(long milli){
        try {
            //Thread.currentThread().setDaemon(false);
            System.out.println(Thread.currentThread().isDaemon());
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "implementing method2");
        return "Method2 completed at : "+ LocalDateTime.now();
    }

    public static String method1(long milli){
        try {
            //Thread.currentThread().setDaemon(false);
            System.out.println(Thread.currentThread().isDaemon());
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "implementing method1");
        return "Method1 completed at : "+ LocalDateTime.now();
    }

    public static void countEachWordAndPrintInDecendingOccuranceOrder(){
        System.out.println(Arrays.asList("AA", "BB", "AA", "CC").stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .sorted((e1,e2)->e2.getValue()>e1.getValue()?1:-1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    }
}
