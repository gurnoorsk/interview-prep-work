import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericExceptionHandler {


    private static <Target,Ex extends Exception> Consumer<Target> handleGenericException(Consumer<Target> consumer,
                                                                                         Class<Ex> exceptionClass){
       return (obj) ->{
           try{
               consumer.accept(obj);
           }catch(Exception ex){
               try{
                   Ex genex = exceptionClass.cast(ex);
                   System.out.println("Exception " +genex.getMessage());
               }catch(ClassCastException exc){
                   throw exc;
               }
           }

        };

    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","10","xyz");
        list.forEach(handleGenericException(obj-> System.out.println(Integer.parseInt(obj)),NumberFormatException.class));
    }
}
