package designpatterns.observer;

public class Main {


    public static void main(String[] args) {
        IAgency agency = new Agency();
        agency.addChannel(new Channel("Aaj Tak"));
        agency.addChannel(new Channel("BBC"));
        agency.addChannel(new Channel("News 1"));

        agency.relayNews("Tornado warning in 5 hours");


    }
}
