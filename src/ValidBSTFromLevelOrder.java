import java.util.LinkedList;
import java.util.Queue;

public class ValidBSTFromLevelOrder {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }


    static Integer count = 0;
    public static void findCountOffWaysToDecode(String str,int index,String curr){
        System.out.println(curr);


        if(index>str.length()){
            return;
        }

        if(index == str.length()){
            count++;
            return;
        }

        if(curr.length()>0){
            if(Integer.valueOf(curr)== 0 || Integer.valueOf(curr)>26){
                return;
            }
        }


        findCountOffWaysToDecode(str,index+1,str.substring(index,index+1));
        if(index+2<str.length())
            findCountOffWaysToDecode(str,index+2,str.substring(index,index+2));
    }

    public static Boolean checkIfValidBST(Integer [] arr){
        // check each level if that follows the BST rule
        Queue<Node> currentLevel= new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList();

        int index = 1;
        currentLevel.offer(new Node(arr[0]));
        while(index < arr.length && !currentLevel.isEmpty()){
            int levelSize = currentLevel.size();
            for(int i =0;i<levelSize;i++){
                Node node = currentLevel.poll();
                // left
                if(index<arr.length && arr[index]!= null && node.val>arr[index]){
                    node.left = new Node(arr[index]);
                    nextLevel.offer(node.left);

                }else if(index<arr.length && arr[index]!= null && node.val<arr[index]){
                    return false;
                }
                index++;
                //right
                if(index<arr.length && arr[index] != null && node.val<arr[index]){
                    node.right = new Node(arr[index]);
                    nextLevel.offer(node.right);

                }else if(index<arr.length && arr[index] != null && node.val>arr[index]){
                    return false;
                }
                index++;

            }

            Queue<Node> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = currentLevel;

        }

        if(index<arr.length){
            // there are still some elements left
            return false;
        }

        return true;





    }
    public static void main(String[] args) {
//        Integer arr [] = {2, null, 3, 1};
//        Integer arr2 [] = {8,5,13,null,null,10,16,9,11};
//        System.out.println(checkIfValidBST(arr));
//        System.out.println(checkIfValidBST(arr2));


        findCountOffWaysToDecode("2121",0,"");
        System.out.println("ANSWER: " +count);


    }
}
