package lesson15.hashMap;

public class MyHashMap implements MyMap {
    private int size = 0;                                   // количество пар в контейнере
    private static final int INITIAL_CAPACITY = 4;         // начальный размер массива
    private static final double LOAD_FACTOR = 0.75;         // коэффициент загруженности
    // если size/source.length >= LOAD_FACTOR, то нужно сбалансировать контейнер
    // для равномерного распределения элементов чтобы не было длинных цепочек

    private Pair[] source = new Pair[INITIAL_CAPACITY]; // массив для хранения голов цепочек
    public int sourceLength = source.length;  // удалить после обкатки кода

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
        if (size >= LOAD_FACTOR * source.length) {
            resize();
        }
        Pair pair = findPair(key); // поиск пары по ключу
        if (pair == null) {
            int bucket = findBucket(key);  // поиск номера ведра по ключу
            pair = new Pair(key, value, source[bucket]);
            source[bucket] = pair;         // делаем новую пару корнем цепочки
            size++;
        } else {
            pair.value = value;            // такая пара уже есть, поэтому меняем ее значение
        }
        System.out.println("<" + key + " " + value + "> - has been added to the Map");
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

    // балансировка массива - создание массива в два раза больше и перенос туда всех элементов
    private void resize() {
        // нужно создать новый массив в два раза больше, чем source
        Pair[] newSource = new Pair[source.length * 2];
        for (int i = 0; i < source.length; i++) {
            Pair currentPair = source[i];
            while (currentPair != null) {
                // находим бакет в новом массиве
                int bucket = Math.abs(currentPair.key.hashCode()) % newSource.length;
                Pair newPair = newSource[bucket];
                if (newPair == null) {
                    newSource[bucket] = currentPair;
                    currentPair = currentPair.next;
                    continue;
                } else {
                    while (newPair != null) {
                        newPair = newPair.next;
                    }
                    // в этом месте вместо newPair должно быть что-то связанное с newSource
                    newPair = currentPair;
                }
                currentPair = currentPair.next;
            }
        }
        source = newSource;
    }

//    Pair pair = findPair(key); // поиск пары по ключу
//        if (pair == null) {
//        int bucket = findBucket(key);  // поиск номера ведра по ключу
//        pair = new Pair(key, value, source[bucket]);
//        source[bucket] = pair;         // делаем новую пару корнем цепочки
//        size++;
//    } else {
//        pair.value = value;            // такая пара уже есть, поэтому меняем ее значение
//    }

    // поиск пары по ключу для resize
    private Pair findPairResize(String key, Pair[] newSource) {
        int bucket = Math.abs(key.hashCode()) % newSource.length;
        Pair currentPair = newSource[bucket];  // корень цепочки
        while (currentPair != null) {
            if (currentPair.key.equals(key)) {
                return currentPair;
            }
            currentPair = currentPair.next; // следующая пара по цепочке
        }
        return null;  // пара с ключом key не найдена
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
        if (size == 0) {
            return "Map container is empty";
        }
        int bucket = findBucket(key);      // ищем ведро
        Pair currentPair = source[bucket]; // переходим к ведру
        if (currentPair.key.equals(key)) {
            if (currentPair.next == null) {
                source[bucket] = null;
                size--;
                return currentPair.value;
            }
            source[bucket] = currentPair.next;
            size--;
            return currentPair.value;
        }
        while (currentPair.next != null) {
            if (currentPair.next.key.equals(key)) {
                Pair temp = currentPair.next;
                currentPair.next = currentPair.next.next;
                size--;
                return temp.value;
            }
            currentPair = currentPair.next;
        }
        return null;
    }

    @Override
    public boolean contains(String key) {
        if (size >= 0) {
            // ищем пару по ключу
            Pair pair = findPair(key);
            return pair != null;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}