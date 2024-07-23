import java.util.function.Function;

public class LambdaAndFunctionInterface {

    public static void main(String [] args){
        Function<String,String> f1 = s -> {System.out.println("main");return s;};
        f1 = f1.andThen(s -> {System.out.println("andThen 1");return s;});
        f1 = f1.compose(s -> {System.out.println("compose 1");return s;});
        f1 = f1.andThen(s -> {System.out.println("andThen 2");return s;});
        f1 = f1.compose(s -> {System.out.println("compose 2");return s;});
        f1 = f1.andThen(s -> {System.out.println("andThen 3");return s;});
        f1 = f1.compose(s -> {System.out.println("compose 3");return s;});
        f1 = f1.andThen(s -> {System.out.println("andThen 4");return s;});
        f1 = f1.compose(s -> {System.out.println("compose 4");return s;});

        f1.apply("not important");
    }
}
