package cardgame;

import java.util.ArrayList;
import java.util.List;


import static cardgame.Rank.*;
import static cardgame.Suite.*;

public class Deck {
    private List<Card> cards = new ArrayList();

    public Deck(){
        cards.addAll(createSpades());
        cards.addAll(createClub());
        cards.addAll(createHearts());
        cards.addAll(createDiamonds());

    }

    public List<Card> getCards(){
        return cards;
    }

    public void printDeck(){
        for(Card card:cards){
            System.out.println(card.suite.getValue()+" - "+card.rank.getValue());
        }
    }


    private List<Card> createSpades(){
        List<Card> spades = new ArrayList();
        spades.add(new Card(ACE,SPADE));
        spades.add(new Card(KING,SPADE));
        spades.add(new Card(QUEEN,SPADE));
        spades.add(new Card(JACK,SPADE));
        spades.add(new Card(TEN,SPADE));
        spades.add(new Card(NINE,SPADE));
        spades.add(new Card(EIGTH,SPADE));
        spades.add(new Card(SEVEN,SPADE));
        spades.add(new Card(SIX,SPADE));
        spades.add(new Card(FIVE,SPADE));
        spades.add(new Card(FOUR,SPADE));
        spades.add(new Card(THREE,SPADE));
        spades.add(new Card(TWO,SPADE));

        return spades;
    }

    private List<Card> createDiamonds(){
        List<Card> spades = new ArrayList();
        spades.add(new Card(ACE,DIAMOND));
        spades.add(new Card(KING,DIAMOND));
        spades.add(new Card(QUEEN,DIAMOND));
        spades.add(new Card(JACK,DIAMOND));
        spades.add(new Card(TEN,DIAMOND));
        spades.add(new Card(NINE,DIAMOND));
        spades.add(new Card(EIGTH,DIAMOND));
        spades.add(new Card(SEVEN,DIAMOND));
        spades.add(new Card(SIX,DIAMOND));
        spades.add(new Card(FIVE,DIAMOND));
        spades.add(new Card(FOUR,DIAMOND));
        spades.add(new Card(THREE,DIAMOND));
        spades.add(new Card(TWO,DIAMOND));

        return spades;
    }

    private List<Card> createClub(){
        List<Card> spades = new ArrayList();
        spades.add(new Card(ACE,CLUBS));
        spades.add(new Card(KING,CLUBS));
        spades.add(new Card(QUEEN,CLUBS));
        spades.add(new Card(JACK,CLUBS));
        spades.add(new Card(TEN,CLUBS));
        spades.add(new Card(NINE,CLUBS));
        spades.add(new Card(EIGTH,CLUBS));
        spades.add(new Card(SEVEN,CLUBS));
        spades.add(new Card(SIX,CLUBS));
        spades.add(new Card(FIVE,CLUBS));
        spades.add(new Card(FOUR,CLUBS));
        spades.add(new Card(THREE,CLUBS));
        spades.add(new Card(TWO,CLUBS));

        return spades;
    }


    private List<Card> createHearts(){
        List<Card> spades = new ArrayList();
        spades.add(new Card(ACE,HEARTS));
        spades.add(new Card(KING,HEARTS));
        spades.add(new Card(QUEEN,HEARTS));
        spades.add(new Card(JACK,HEARTS));
        spades.add(new Card(TEN,HEARTS));
        spades.add(new Card(NINE,HEARTS));
        spades.add(new Card(EIGTH,HEARTS));
        spades.add(new Card(SEVEN,HEARTS));
        spades.add(new Card(SIX,HEARTS));
        spades.add(new Card(FIVE,HEARTS));
        spades.add(new Card(FOUR,HEARTS));
        spades.add(new Card(THREE,HEARTS));
        spades.add(new Card(TWO,HEARTS));

        return spades;
    }


}
