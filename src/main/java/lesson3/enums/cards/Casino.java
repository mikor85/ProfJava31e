package lesson3.enums.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Dealer d = new Dealer();
        Scanner s = new Scanner(System.in);  // читать с консоли
        List<Card> deck = new ArrayList<>();
        do {
            Card card = d.getCard();
            deck.add(card);
            System.out.println("Карта " + card);
            int score = 0;
            for (Card value : deck) {
                score += value.getValue();
            }
            System.out.println("Ваш счет: " + score);
            System.out.println("Нажмите N для прекращения игры");
        } while (!s.next().equals("N"));
    }
}
