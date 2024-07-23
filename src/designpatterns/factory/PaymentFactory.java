package designpatterns.factory;

public class PaymentFactory {

    public  Payment getPaymentGateway(PaymentType type){
        switch(type){
            case UPI:
                return new UPI();
            case NETBANKING:
                return new Netbanking();
            default:
                return null;
        }
    }

    public enum PaymentType{
        UPI("upi"), NETBANKING("netbanking");

         PaymentType(String value){
            this.value  = value;
        }

        private String value;

        public String getValue(){
            return value;
        }

        public void setValue(String value){
            this.value = value;
        }

        public static PaymentType getType(String value){
            for(PaymentType type : PaymentType.values()){
                if(type.getValue().equals(value)){
                    return type;
                }
            }

            return null;
        }
    }
}
