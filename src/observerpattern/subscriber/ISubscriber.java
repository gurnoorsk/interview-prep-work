package observerpattern.subscriber;

public interface ISubscriber {
    void subscribeToPublisher();
    void broadcastMessage(String message);
}
