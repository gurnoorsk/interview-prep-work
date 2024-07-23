import java.util.Arrays;

public class SortedSet {




    interface Callback{
        void call(String name);
    }

    class CallbackImpl implements  Callback{

        private String name;

        public String getName(){
            return name;
        }
        @Override
        public void call(String name) {
            // write logic
            this.name = name;
        }
    }

    class Task extends Thread{
        Callback callback;

        Task(Callback callback){
            this.callback = callback;
        }
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
            callback.call(Thread.currentThread().getName());
        }
    }

    public void doWork() throws InterruptedException {
        CallbackImpl ci = new CallbackImpl();
        Task t = new Task(ci);
        t.start();
        ci.wait();
        ci.getName();
    }
    public static void main(String[] args) {



        int[] arr = {1,3,2,4};

        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));


        int [] ar = {4,1,5,6,3,7};

        int buy = 0;
        int sell =1;
        int curr = 0;
        int max = 0;
        int total = 0;
        while(buy<ar.length){
            sell = buy+1;
            while(sell<arr.length && ar[sell]<=ar[sell+1]){
                sell++;
            }
            if(ar[buy]<ar[sell]){
                total += (ar[sell] - ar[buy]);
            }

            buy =sell+1;
        }

        System.out.println(total);



    }
}
