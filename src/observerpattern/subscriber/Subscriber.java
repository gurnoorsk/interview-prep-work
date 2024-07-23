package observerpattern.subscriber;

import observerpattern.publisher.Publisher;

public class Subscriber implements ISubscriber{



    @Override
    public void subscribeToPublisher() {
        Publisher.getInstance().subscribe((message)->{
            broadcastMessage(message);
        });
    }

    @Override
    public void broadcastMessage(String message) {
        System.out.println("New message recieved "+message);
    }
}
