package designpatterns.factory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Make payment via : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        PaymentFactory pf = new PaymentFactory();
        Payment payment = pf.getPaymentGateway(PaymentFactory.PaymentType.getType(input));
        payment.makeTransaction(100);

    }
}
