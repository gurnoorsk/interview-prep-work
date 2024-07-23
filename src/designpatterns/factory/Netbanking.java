package designpatterns.factory;

public class Netbanking implements Payment{
    @Override
    public void makeTransaction(int amount) {
        System.out.println("Transaction made by Netbanking for : "+amount);
    }
}
