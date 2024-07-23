import java.util.Arrays;

public class Streams {

    public static void main(String[] args) {
        Arrays.asList(1,2,3,4).stream().sorted((a, b)-> a>b?-1:1).forEach(System.out::print);
    }
}
