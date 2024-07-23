package designpatterns.factory;

public class UPI implements Payment{


    @Override
    public void makeTransaction(int amount) {
        System.out.println("Transaction made by UPI for : "+amount);
    }
}
