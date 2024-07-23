import java.util.PriorityQueue;

public class ReverseString {




    public static void kthLargest(){
        int [] arr1 = {1,2,3,4};
        int [] arr2 = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i:arr1){
            pq.add(i);
        }

        int kth = -1;
        while(pq.size()>k){
            pq.poll();
        }
        kth = pq.poll();
        System.out.print("kth -> "+kth+" ");
        for(int i:arr2){
            if(i<=kth){
                //System.out.print(kth);
            }else{
                if(i>kth && i<pq.peek()){
                    kth = i;
                }else{
                    kth = pq.poll();
                    pq.add(i);
                }
            }
            System.out.print(" kth -> "+kth+" ");
        }

    }
    public static void reverseAString(String s){

        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)== ' '){
                sb.append(" ");
            }else{
                String sub = "";
                while(i>=0 && s.charAt(i) != ' '){
                    sub = s.charAt(i)+sub;
                    i--;
                }
                sb.append(sub);
                if(i>=0)
                    sb.append(" ");

            }
        }

        System.out.println(s.length() +" "+sb.toString().length()+" "+sb.toString());

    }

    public static void main(String[] args) {
        String s ="II will do it.  ";
        reverseAString(s);
        kthLargest();
    }
}
