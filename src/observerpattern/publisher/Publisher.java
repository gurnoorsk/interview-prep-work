package observerpattern.publisher;

import observerpattern.Content;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublisher{

    List<IContract> contractList = null;
    private static Publisher instance = null;
    static {
        instance = new Publisher();
    }

    public static Publisher getInstance(){
        return instance;
    }

    private Publisher(){
        this.contractList = new ArrayList<IContract>();
    }

    @Override
    public void subscribe(IContract contract) {
        this.contractList.add(contract);
    }

    public void broadcast(Content msg){
        if("PUBLISH".equalsIgnoreCase(msg.getStatus())){
            contractList.stream().forEach(c -> c.broadcast((String)msg.getMsg()));
        }

    }
}
