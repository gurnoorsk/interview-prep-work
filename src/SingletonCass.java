public class SingletonCass {

    // peek(), poll() push()

    static private int front,back;
    static int cap = 10;
    static int [] queue;

    public SingletonCass(){
        queue = new int [cap];
    }

    public void push(int x){
        if(back==cap){
            System.out.println("Capacity full");
            return;
        }else{
            queue[back] = x;
            back++;
        }
    }

    public int poll(){
        if(back == front){
            System.out.println("Queue is empty");
            return -1;
        }
        int element = queue[front];
        for(int i=0;i<cap-1;i++){
            queue[i] = queue[i+1];
        }

        return element;
    }

    public int peek(){
        if(back == front){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[0];

    }

    public static void main(String[] args) {
        SingletonCass c = new SingletonCass();
        c.push(1);
        c.push(2);
        c.push(3);

        System.out.println(c.peek());
        System.out.println(c.poll());
        System.out.println(c.peek());
    }



}
