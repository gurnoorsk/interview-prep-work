import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenOdd {



    Boolean flag = false;
    AtomicInteger counter = new AtomicInteger(1);



    class EvenThread implements  Runnable{

        Object mutex ;


        EvenThread(Object mutex){
            this.mutex = mutex;
        }

        @Override
        public void run() {
            synchronized (mutex){
                while(counter.get()<=10){
                    while(!flag){
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("EventThread "+Thread.currentThread().getName()+" counter :"+counter.getAndIncrement());

                    flag = false;
                    mutex.notify();
                }
            }

        }
    }

    class OddThread implements  Runnable{

        Object mutex ;


        OddThread(Object mutex){
            this.mutex = mutex;
        }

        @Override
        public void run() {
            synchronized (mutex){
                while(counter.get()<=10){
                    while(flag){
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("OddThread "+Thread.currentThread().getName()+" counter :"+counter.getAndIncrement());
                    flag = true;
                    mutex.notify();
                }
            }


        }
    }

    public void doWork(){
       Object mutex = new Object();
        EvenThread evenJob = new EvenThread(mutex);
        Thread t1 = new Thread(evenJob);
        OddThread oddJob = new OddThread(mutex);
        Thread t2 = new Thread(oddJob);

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        EvenOdd eo = new EvenOdd();
        eo.doWork();

    }
}
