package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Agency implements IAgency{

    List<IChannel> channelList = new ArrayList<>();



    @Override
    public void addChannel(IChannel channel) {
        channelList.add(channel);
    }

    @Override
    public void removeChannel(IChannel channel) {
        channelList.remove(channel);
    }

    @Override
    public void relayNews(String news) {
        channelList.forEach(channel -> channel.updateNews(news));
    }
}
