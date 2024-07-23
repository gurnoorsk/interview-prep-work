import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TargetSumSorted {

    static List<List<Integer>>  answers = new ArrayList();

    public static void check(int arr[],int index, int curr, int target, List<Integer> list){



        if(index <= arr.length && curr == target){
             answers.add(list);
         }else if(curr > target || index>=arr.length){
             return;
         }


        if(curr < target){

            List<Integer> l = new ArrayList();
            l.addAll(list);
            l.add(index);
            check(arr,index+1,curr+arr[index],target,l);
            check(arr,index+1,curr,target,list);
        }
    }

    public static Boolean check(int i){
        if(i%2 == 0){
            throw new RuntimeException();
        }
        return true;
    }

    public static void main(String[] args) {
        /*
            [2,7,11,15], target = 9 or 24 -- Output: [0,1] or [0,1,3]
        * **/

        List<Integer> l = Arrays.asList(2,3,5,7,8);
        l.stream().filter(ele -> {
            try{
                return check(ele);
            }catch(RuntimeException ex){
                System.out.println("Exception for "+ele);
                return false;
            }
                })
    .collect(Collectors.toList()).forEach(System.out::print);


        int [] arr = {2,7,11,15};
        int target = 13;
        check(arr,0,0,target,new ArrayList<Integer>());
        System.out.println(answers.size() == 0?-1:answers.toString());



    }
}
