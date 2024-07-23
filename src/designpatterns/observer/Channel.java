package designpatterns.observer;

public class Channel implements IChannel{

    private String name;

    Channel(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void updateNews(String news) {
        System.out.println(this.name+" => "+"News update: "+news);
    }
}
