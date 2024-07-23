import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Highradius {

    public static void main(String[] args) {
        int [] arr = {1,3,4,2,5,6,8,7,9,10};

        List<Integer> result = new ArrayList();
        int total = 0;
        for(int i =0;i<arr.length;i++){
            total = total + arr[i];
        }
        for(int i =0;i<arr.length;i++){
            result.add(total - arr[i]);
        }
        final int tot = total;

        Arrays.stream(arr).parallel().map(e -> tot - e).forEach(System.out::println);


        String[] val ={"(12.30)","abc","1(23","(yct)","1.2"};

        List<String> res = new ArrayList();
        for(int i =0;i<val.length;i++){
            String curr = val[i];
            if(curr.substring(0,1).equals("(") && curr.substring(curr.length()-1,curr.length()-1).equals(")")){
                String num = curr.substring(1,curr.length()-1);
                // check num is a number
                Number n =  null;
                try{
                    if(Double.valueOf(num) instanceof Number){
                        n = -1 * Double.valueOf(num);
                    } else if(Integer.valueOf(num) instanceof Number){
                        n = -1 * Integer.valueOf(num);
                    }
                    res.add(""+n);
                }catch(RuntimeException e){
                    res.add(curr);
                }

            }else{
                res.add(curr);
            }
        }

        System.out.println(result.toString());


        Arrays.stream(arr).filter(e -> e%2 ==0).forEach(System.out::println);



        //Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).

        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int targetSum = 14;
        Map<Integer,Integer> map = new HashMap();
        for(int i =0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int first=-1;
        int second=-1;
        for(int i =0;i<arr.length;i++){
           int buff = targetSum - arr[i];
           if(map.containsKey(buff)){
               first = i;
               second = map.get(buff);
               break;
           }
        }

        System.out.println("First: "+first+"Second: "+second);

        String s1 = "Angel";
        String s2 = "Glean";

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int [] c1 = new int[26];
        for(int i=0;i<s1.length();i++){
            c1[s1.charAt(i)-97] ++;
        }

        int [] c2 = new int[26];
        for(int i=0;i<s2.length();i++){
            c2[s2.charAt(i)-97] ++;
        }
        boolean found = false;
        for(int i=0;i<26;i++){
            if(c1[i] != c2[i]){
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Anagrams");
        }else{
            System.out.println("Not Anagrams");
        }


        String str1 = new String("Highradius");

        String str2 = "Highradius";

        System.out.println(str1 == str2); // false

        System.out.println(str1.equals(str2)); //true


        // employe id,employe name, gender , salary
        // select distinct salary from employe order by salary desc limit 2 offset 1;

        // select salary from employe where salary < (select max(salary) from employe) limit 1;

        // update employe set gender = temp_
        // update employe set gender = female where id in ( select employe id from employe where gender = male);



    }
}
