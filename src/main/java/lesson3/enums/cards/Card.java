package lesson3.enums.cards;

public class Card {
    private Rank rank;
    private Suite suit;

    public Card(Rank rank, Suite suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue(){
        return rank.getValue();
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
