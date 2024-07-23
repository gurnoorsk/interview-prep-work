import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    class Buffer{
        Queue<Integer> queue = new LinkedList();
        int MAX_CAPACITY = 5;
        Object consumerMutex = new  Object();
        Object producerMutex = new  Object();


        public void produce(int i){
            System.out.println("Request received to produce: "+i);
            synchronized (this){
//                try {
//                    System.out.println("Going to Add a new element in the queue with id :"+i);
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                while(queue.size() == MAX_CAPACITY){
                    try {
                        System.out.println("Queue is full, waiting for it to have some space");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queue.add(i);
                System.out.println("Added a new element in the queue with id :"+i);
                notify();
            }
        }

        public void consume(){
            System.out.println("Request received to consume");
            synchronized (this){
//                try {
//                    System.out.println("Going to consume a new element in the queue");
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                while(queue.size() == 0){
                    System.out.println("Queue is empty, waiting for it to have something to execute");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                int i = queue.poll();
                System.out.println("Consumed an element from the queue with id :"+i);
                notify();
            }
        }


    }

    public Buffer getBuffer(){
        return new Buffer();
    }

    public static void main(String [] args){
        ProducerConsumer p = new ProducerConsumer();
        final Buffer buffer = p.getBuffer();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1;i++){
                buffer.produce(i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<1;i++){
                buffer.consume();;
            }
        });

        t1.start();
        t2.start();
    }
}
