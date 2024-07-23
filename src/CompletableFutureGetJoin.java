import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureGetJoin {

    public void process(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<String> messages = Arrays.asList("Msg1", "Msg2", "Msg3", "Msg4", "Msg5", "Msg6", "Msg7", "Msg8", "Msg9",
                "Msg10", "Msg11", "Msg12");
        List<String> result = new ArrayList<>();

        List<Future<?>> futures = messages.stream()
            .map(message->CompletableFuture
                    .supplyAsync(()->{
                        System.out.println("Sending message "+message+ " by thread "+Thread.currentThread().getName());
                        return sendNotification(message);
                    },executorService)
                    .exceptionally(ex ->{
                        System.out.println("Exception occurred "+ex.toString());
                        return "ERROR";
                    })
                    .thenAccept((output)->{
                        System.out.println("Adding output "+output+" with thread "+Thread.currentThread().getName());
                        result.add(output);
                    }))
            .collect(Collectors.toList());


        try {
            System.out.println("Main thread reached here1 with futures Array size "+futures.size()+"and first future stage as "+futures.get(0).isDone());
            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0]));
            combinedFuture.get();
            System.out.println(result.toString());
            System.out.println("Main thread reached here2");
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        }


    }

    public String sendNotification(String message)  {
        try{
            Thread.sleep(3000);
            if(message.equals("Msg10")){
                throw new InterruptedException("ho gaya kand");
            }
            System.out.println("Notification sent "+message);
            return "sent "+message;
        }
        catch (InterruptedException e) {
            // If interrupted, you might want to handle it or re-interrupt the thread
           // Thread.currentThread().interrupt();
            throw new MyNewException("19001","dummy failure",e.getMessage(),e);
        }
    }

    public class MyNewException extends RuntimeException{
        String statusCode;
        String reason;

        MyNewException(String message){
            super(message);
        }

        MyNewException(String statusCode,String reason,String message,Throwable cause){
            super(message,cause);
            this.statusCode = statusCode;
            this.reason = reason;

        }

        @Override
        public String toString(){
            return statusCode+" "+reason+" "+super.getCause()+" "+super.getMessage();
        }
    }


    public static void main(String[] args) {

        CompletableFutureGetJoin main = new CompletableFutureGetJoin();
        main.process();


    }
}
