import java.util.HashMap;
import java.util.*;

public class MapTest {

    static class Account{
        String id;
        Long balance;
        public Account(String id,Long Balance){
                this.id=id;
                this.balance=balance;
        }

        @Override
        public String toString() {
            return "id"+id+"-"+balance;
        }
    }
    public static void main(String[] args) {
        Map<String,Account> map = new HashMap<>();
        PriorityQueue<Account> pq = new PriorityQueue<>((s1,s2)->{
            return Long.compare(s2.balance,s1.balance);
        });
//        Map<String,Account> treeMap = new TreeMap<>((ac1,ac2)->{
//            return Long.compare(map.get(ac2).balance,map.get(ac1).balance);
//        });
        Account acc1 = new Account("1",100L);
        Account acc2 = new Account("2",100L);
        Account acc3 = new Account("3",100L);
        pq.add(acc1);
        pq.add(acc2);
        pq.add(acc3);
        map.put(acc1.id,acc1);
//        treeMap.put(acc1.id,acc1);
        map.put(acc2.id,acc2);
//        treeMap.put(acc2.id,acc2);
        map.put(acc2.id,acc2);
//        treeMap.put(acc2.id,acc2);
//        System.out.println(treeMap.values().toString());
        System.out.println(map.values().toString());
//        System.out.println(pq.toString());


    }

//    class CreditScoreComparator implements Comparator<String>{
//        Map<String,Account> base = null;
//        public CreditScoreComparator (Map<String,Account> base){
//            this.base = base;
//        }
//        public CreditScoreComparator (){
//
//        }
//        @Override
//        public int compare(String a1,String a2){
//            return Long.compare(base.get(a2).creditScore, base.get(a1).creditScore);
//        }
//    }
}
