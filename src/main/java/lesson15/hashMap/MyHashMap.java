package lesson15.hashMap;

import java.util.Objects;

public class MyHashMap implements MyMap {
    private int size = 0;                                   // количество пар в контейнере
    private static final int INITIAL_CAPACITY = 16;         // начальный размер массива
    private static final double LOAD_FACTOR = 0.75;         // коэффициент загруженности
    // если size/source.length >= LOAD_FACTOR то нужно перебалансировать
    // для равномерного распределения элементов чтобы не было длинных цепочек

    private Pair[] source = new Pair[INITIAL_CAPACITY]; // массив для хранения голов цепочек

    private static class Pair {
        String key;     // ключ
        String value;   // значение
        Pair next;      // ссылка на следующую пару

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(String key, String value) {
        if (size > LOAD_FACTOR * source.length) {
            resize();
        }
        Pair pair = findPair(key); // поиск пары по ключу
        if (pair == null) {
            int bucket = findBucket(key);  // поиск номера ведар по ключу
            pair = new Pair(key, value, source[bucket]);
            source[bucket] = pair;         // делаем новую пару корнем цепочки
            size++;
        } else {
            pair.value = value;            // такая пара уже есть, поэтому меняем ее значение
        }
    }

    // по ключу находит хэш и по хэшу находим бакет
    private int findBucket(String key) {
        return Math.abs(key.hashCode()) % source.length;
    }

    // поиск пары по ключу
    private Pair findPair(String key) {
        int bucket = findBucket(key);
        Pair currentPair = source[bucket];  // корень цепочки
        while (currentPair != null) {
            if (currentPair.key.equals(key)) {
                return currentPair;
            }
            currentPair = currentPair.next; // следующая пара по цепочке
        }
        return null;  // пара с ключом key не найдена
    }

    // перебалансировка массива - создание массива в два раза больше и перенос туда всех элементов
    private void resize() {
        // нужно создать новый массив в два раза больше, чем source
        // пробежаться по всем элементам

    }

    @Override
    public String get(String key) {
        Pair pair = findPair(key);
        if (pair == null) {
            return null;
        }
        return pair.value;
    }

    @Override
    public String remove(String key) {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}