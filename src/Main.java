public class Main {

    private static int max = Integer.MIN_VALUE;
    public static void hop(int [] arr,int index,int bricks,int ladders,int maxTillNow){
        if(index == arr.length-1){
            max = Math.max(max,maxTillNow);
            return;
        }

        if(((arr[index+1] - arr[index])>0)){
            int diff = arr[index+1] - arr[index];
            if(diff > bricks && ladders == 0){
                max = Math.max(max,maxTillNow);
                return;
            }

        }

        if(arr[index+1]>arr[index]){
            // we need to use our tools
            int diff = arr[index+1] - arr[index];
            if(bricks>=diff){
                // use bricks
                hop(arr,index+1,bricks - diff,ladders,maxTillNow+1);
            }
            if(ladders>0){
                // use ladders
                hop(arr,index+1,bricks,ladders-1,maxTillNow+1);
            }


        }else{
            hop(arr,index+1,bricks,ladders,maxTillNow+1);
        }
    }

    public static void main(String[] args) {

        /*
        Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
Output: 7
Yash Gupta
3:39 PM
heights = [14,3,19,3], bricks = 17, ladders = 0
        * **/
        int [] arr = {4,12,2,7,3,18,20,3,19};
        //int [] arr = {14,3,19,3};
        int bricks = 10;
        int ladders = 2;
        hop(arr,0,bricks,ladders,1);
        System.out.println(max);
    }
}
