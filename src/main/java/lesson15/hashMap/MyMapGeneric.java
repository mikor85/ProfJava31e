package lesson15.hashMap;

public interface MyMapGeneric<K, V> {
    void put(K key, V value); // добавление значения по ключу

    V get(K key);             // получение значения по ключу

    V remove(K key);          // удаление пары по ключу

    boolean contains(K key);  // содержится ли ключ в мапе

    int size();               // количество пар

    public static void main(String[] args) {
        MyMapGeneric<String, Integer> map = new MyMapGeneric<String, Integer>() {
            @Override
            public void put(String key, Integer value) {

            }

            @Override
            public Integer get(String key) {
                return null;
            }

            @Override
            public Integer remove(String key) {
                return null;
            }

            @Override
            public boolean contains(String key) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }
}