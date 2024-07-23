public class Mobi {

    public static void main(String[] args) {
//        "ola"
//        List<String> string = new ArrayList();
//        string.stream().filter(s->"ola".equalsIgnoreCase(s.substring(0,3))).collect(Collectors.toList());
//
//        @SpringbootApplication
//                @Coonfigurations
//        @Service
//        @Repository
//        @RestController
//        @RequestMapping
//        @RequestParam
//        @Autowire
//        @Bean
//        @Component
//        @GetMapping/PostMapping
//                @Scope
//                        @ConfigurationPropery
//                @PreAuthorised
//
//
//                department
//                student
//                        student_department
//
//        select name from student where student_id in
//                (select sId from student_department where department_id in
//                        (select id from departments where name = 'MATHS'))
//
//        (select name,department_id from student s join (select sId,id from department d join student_department sd d.dep_id = d.id and d.name = 'MAths') sd on s.id = sd.studnet_id)

        int [] arr = {2,3,4};
        printComninations(arr,new int [arr.length],0,new HashSet<Integer>());

    }

    public static void printComninations(int [] arr,int [] data,int cursor,Set<Integer> set){
        if(data.length -1 ==  arr.length-1) {
            System.out.println(Arrays.toString(data));
            return;
        }

       for(int i =0;i<arr.length;i++){
           int index = i;
           if(!set.containsKey(arr[index])){
               data[cursor] = arr[index];
               set.add(arr[index]);
               printComninations(arr,data,cursor+1, set);
           }else{
               printComninations(arr,data,cursor, new HashSet(set));
           }
       }




    }

    public List<List<Integer>> backtract(int [] nums){

    }


}
