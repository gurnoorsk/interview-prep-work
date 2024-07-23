package cardgame;

public enum Suite {

    HEARTS("HEARTS"),SPADE("SPADE"),DIAMOND("DIAMOND"),CLUBS("CLUB");

    private String value;

    Suite(String value){
        this.value = value;
    }

    String getValue(){
        return value;
    }

}
