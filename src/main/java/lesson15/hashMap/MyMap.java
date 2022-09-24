package lesson15.hashMap;

public interface MyMap {
    void put(String key, String value);  // добавление значения по ключу

    String get(String key);               // получение значения по ключу

    String remove(String key);            // удаление пары по ключу

    boolean contains(String key);         // содержится ли ключ в мапе

    int size();                           // количество пар
}
