package designpatterns.proxy;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
    RealInternet realInternet = new RealInternet();
    List<String> bannedAddresses =  Arrays.asList("www.google.com","www.youtube.com");

    @Override
    public void connnectToHost(String address) throws Exception {
        if(bannedAddresses.contains(address)){
            throw new Exception("Address not allowed");
        }
        realInternet.connnectToHost(address);
    }
}
