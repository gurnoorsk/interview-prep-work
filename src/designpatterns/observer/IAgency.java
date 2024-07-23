package designpatterns.observer;

public interface IAgency {
    public void addChannel(IChannel channel);
    public void removeChannel(IChannel channel);

    public void relayNews(String news);
}
