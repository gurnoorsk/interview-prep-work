package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {

    public static int binarySearch(Integer [] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                return mid;
            }
        }

        return -1;
    }


    public static int binarySearchForUpperBoundIfNotFound(Integer [] arr,int target){
        int start = 0;
        int end = arr.length -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]>target){
                end = mid -1;
            }else if(arr[mid]<target){
                start = mid +1;
            }else{
                if(mid == 0)
                    return mid;
                else if(mid == arr.length -1){
                    return mid;
                }else{
                    start = mid+1;
                }
            }
        }

        return end;
        /**
         * return end for lower bound in case not found
         * return start for upper bound in case not found
         * return end in case you need to find last occurrence of target or upper bound if not found
         * */


    }

    public static void main(String[] args) {
        System.out.println("Simple binary search "+BinarySearch.
                binarySearch(Arrays.asList(1,2,3,4,5,6,7,8,9).toArray(new Integer[0]),5));

        System.out.println("Upper bound binary search "+BinarySearch.
                binarySearchForUpperBoundIfNotFound(Arrays.asList(1,2,3,4,5,5,6,7,8,9).toArray(new Integer[0]),5));


        List<List<Integer>> ll = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6));
        ll.stream().flatMap(l -> l.stream()).collect(Collectors.toList()).forEach(System.out::print);
    }
}
