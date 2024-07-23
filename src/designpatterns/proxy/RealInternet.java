package designpatterns.proxy;

public class RealInternet implements Internet {
    @Override
    public void connnectToHost(String address) {
        System.out.println("Connected to "+address);
    }
}
