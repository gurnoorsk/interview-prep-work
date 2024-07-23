import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureDemo {


    public Void printNames(List<String> names,ExecutorService executor) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> runAsyncCompletableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            names.stream().forEach(System.out::println);
        },executor);
        // or call runAsyncCompletableFuture.completedFuture() to forcefully complete a task
        return runAsyncCompletableFuture.get();
    }

    public String getStirng(List<String> names,ExecutorService executor) throws ExecutionException, InterruptedException {
        CompletableFuture<String> supplyAsynCompletableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName());
            return names.stream().distinct().collect(Collectors.toMap(n->n,n->n.length())).toString();
        },executor);

        return supplyAsynCompletableFuture.get();
    }

    public static void main(String args []) throws ExecutionException, InterruptedException {
        // Run async
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.printNames(Arrays.asList("gurnoor","rishav","amit","robin","aruhsi","jatin"),executor);
        System.out.println(demo.getStirng(Arrays.asList("gurnoor","rishav","amit","robin","aruhsi","jatin"),executor));


        // more methods in Completable future -> thenApply(Function) , thenRun(Runnable), theAccept(Consumer)
        // each of these methods have a async function to run the method asyncrnously
        executor.shutdown();
        System.out.println("Application completed");
    }

    /*
        function R apply(A a)
        predicate Boolean test()
        consumer accept(A a)
        supplier R get()
    *
    **/
}
