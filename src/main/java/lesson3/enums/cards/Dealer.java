package lesson3.enums.cards;

import java.util.Random;

public class Dealer {

    private Random r = new Random();

    public Card getCard() {
        int rank = r.nextInt(13);  // генерирует псевдослучайное число в диапазоне от 0 до 12.
        int suit = r.nextInt(4);

        return new Card(
                Rank.values()[rank],  // values() - это массив всех элементов от 0
                Suite.values()[suit]
        );
    }
}
