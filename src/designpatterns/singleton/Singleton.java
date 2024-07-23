package designpatterns.singleton;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {

   private static Singleton  instance = null;
    private Singleton(){

    }

    private static class InnerSingleton{
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        //return InnerSingleton.INSTANCE;
        if(instance == null){
            System.out.println(Thread.currentThread().getName() +" thread came to get the instance at "+ LocalDateTime.now());
            synchronized (Singleton.class){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                if(instance == null){
                    System.out.println(Thread.currentThread().getName() +" thread created the instance at "+LocalDateTime.now());
                    instance = new Singleton();
                }
            }

        }

        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            System.out.println(Singleton.getInstance().hashCode());
        });

        executorService.execute(()->{
            System.out.println(Singleton.getInstance().hashCode());
        });

        executorService.shutdown();



    }


    /*

    *The lazy initialization holder class idiom uses a class whose only purpose is to
    initialize the Resource. The JVM defers initializing the ResourceHolder class until it is
    actually used [JLS 12.4.1], and because the Resource is initialized with a static initializer,
    no additional synchronization is needed. The first call to getresource by any thread causes ResourceHolder
    to be loaded and initialized, at which time the initialization of the Resource happens through the static initializer.

    **/
}
