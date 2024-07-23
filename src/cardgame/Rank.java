package cardgame;

public enum Rank {

    ACE(1),KING(13),
    QUEEN(12),JACK(11),TEN(10),NINE(9),EIGTH(8),SEVEN(7)
    ,SIX(6),FIVE(5),FOUR(4),THREE(3),TWO(2);

    private Integer value ;

    Rank(Integer value){
        this.value = value;
    }

    Integer getValue(){
        return value;
    }

}
