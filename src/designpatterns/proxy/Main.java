package designpatterns.proxy;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args)  {


        Internet inet = new ProxyInternet();
        try{
            inet.connnectToHost("www.google.com");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
