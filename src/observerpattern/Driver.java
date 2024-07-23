package observerpattern;

import observerpattern.publisher.Publisher;
import observerpattern.subscriber.Subscriber;

public class Driver {

    public static void main(String[] args) {
        Subscriber s1 = new Subscriber();
        s1.subscribeToPublisher();

        Subscriber s2 = new Subscriber();
        s2.subscribeToPublisher();
        Content c = new Content<String>("PUBLISH");
        c.setMsg("Hello World");
        Publisher.getInstance().broadcast(c);


        /*
                select e.id,e.name,f.salary from employe e left join on salary f where e.id = f.id and e.salary is null;
        *
        **/

    }
}
