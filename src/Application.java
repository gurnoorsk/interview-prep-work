import java.util.Arrays;
import java.util.concurrent.*;

public class Application {

    class Task implements Runnable{

        int id;
        long sleepTime;

        Task(int id,long sleepTime){
            this.id = id;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task executed with task id: "+id);
        }
    }

    public Task createNewTask(int id,long sleepTime){
        return new Task(id,sleepTime);
    }


    public static void main(String [] args){

        String s = "aeiou";
        String [] ar = s.split("");
        System.out.println(Arrays.toString(ar));

        AbstractDemo d = new AbstractImpl();
        d.print();
        System.out.println("Hello world");

        ExecutorService executor =  Executors.newFixedThreadPool(5);
        Application app = new Application();
        Task t1 = app.createNewTask(1,10000);
        Task t2 = app.createNewTask(2,20000);

        Future f1 = executor.submit(t1);
        Future f2 = executor.submit(t2);

//        try {
//            f1.get();
//            f2.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }



//          Thread exec1 = new Thread(t1);
//          Thread exec2 = new Thread(t2);
//
//          exec1.start();
//          exec2.start();
//
//          synchronized (app){
//              try {
//                  exec2.join();
//                  //exec1.wait();
//              } catch (InterruptedException e) {
//                  throw new RuntimeException(e);
//              }
//          }




        executor.shutdown();
        System.out.println("Application completed");
    }
}
