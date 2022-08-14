package lesson4.card;

public class AppCardTester {
    public static void main(String[] args) {
        Card.CardStatus status = Card.CardStatus.ORDERED;
        System.out.println(status.isOrdered());

        Card.CardStatus d = Card.CardStatus.DELIVERED;
        // d.isDelivered();

        Card card = new Card();
        card.setStatus(Card.CardStatus.READY);

        System.out.println(card.isDeliverable());

    }
}
