public class ExceptionHandling {




    public static int doWork() throws Exception{
        int i = 100;
        try{
            // do something
            i = i/0;
            //throw new Exception("check");
        }catch(Exception e){
            System.out.println("In catch block");
            throw new Exception("check");
            //return 1;
        }
        finally{
            System.out.println("In finally block");
            return 2; //-> if return from finally is executed then the calling functions catch will be skipped
        }
       //return 3;

    }

    public static void main(String[] args) throws Exception {
        //

        try {
            Long lo = 60000L;
            String l = "60000";
            System.out.println(Long.valueOf(lo.toString()));
            System.out.println(ExceptionHandling.doWork());
        }catch(Exception e){
            System.out.println("in main catch");
        }

        System.out.println("After main catch");
    }
}
