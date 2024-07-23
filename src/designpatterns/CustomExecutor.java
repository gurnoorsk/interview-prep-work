package designpatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

interface ICustomExecutor{
    void submit(Runnable rn);
}
class CustomThreadpool{

    CopyOnWriteArrayList<Thread> threadPool = new CopyOnWriteArrayList<>();
    Thread t = new Thread(()->{
        while(true){

        }
    });

    {
        t.start();
    }

    public Thread execute(Runnable rn){
        if(threadPool.size()<10){
            Thread t = new Thread(rn);
            threadPool.add(t);
            return t;
        }

        return null;
    }




}

public class CustomExecutor implements ICustomExecutor {


    Queue<Runnable> queue = new LinkedList<>();

    CustomThreadpool threadPool = new CustomThreadpool();
    @Override
    public void submit(Runnable rn) {
        queue.add(rn);
    }


    Thread t = new Thread(()->{
        while(true){
            if(!queue.isEmpty()){
                Thread exe = threadPool.execute(queue.peek());
                exe.start();
            }
        }
    });

    {
        t.start();
    }


    public static void main(String[] args) {
        CustomExecutor executor = new CustomExecutor();
        for(int i =0;i<50;i++){
            final int itr = i;
            executor.submit(() -> System.out.println("Printing "+itr));
        }
    }
}
