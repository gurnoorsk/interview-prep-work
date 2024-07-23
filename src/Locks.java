import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locks {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    Map<String,String> map = new HashMap<>();

    public String readMap(String key){
        if(!readWriteLock.readLock().tryLock()){
            System.out.println("Read lock could not be acquired");
        }

        readWriteLock.readLock().lock();
        String res = "";
        try{
            Thread.sleep(3000);
            res = this.map.get(key);
        }catch(Exception e){
            System.out.println("exception while reading");
        }finally{
            readWriteLock.readLock().unlock();
        }

        return res;
    }

    public void writeMap(String key,String value){
        readWriteLock.writeLock().lock();
        try{
            Thread.sleep(10000);
            this.map.put(key,value);
        }catch(Exception e){
            System.out.println("exception while reading");
        }finally{
            readWriteLock.writeLock().unlock();
        }
    }



    public static void main(String[] args) {
        Locks main = new Locks();
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        executorService.execute(()->{
            main.writeMap("test1","value1");
        });

        executorService.execute(()->{
            main.writeMap("test2","value2");
        });

        executorService.execute(()->{
            main.writeMap("test3","value3");
        });

        executorService.execute(()->{
            System.out.println("Value read for test1: "+main.readMap("test1")+" at :"+ LocalDateTime.now());
        });

        executorService.execute(()->{
            System.out.println("Value read for test2: "+main.readMap("test2")+" at :"+ LocalDateTime.now());
        });

        executorService.execute(()->{
            System.out.println("Value read for test3: "+main.readMap("test3")+" at :"+ LocalDateTime.now());
        });


        executorService.shutdown();
    }
}
