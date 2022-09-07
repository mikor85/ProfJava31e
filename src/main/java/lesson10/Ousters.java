package lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

interface Filter {  // SAM - single access method
    boolean criteria(String string); // критерий
}

class MyFilter implements Filter {

    @Override
    public boolean criteria(String string) {
        return string.contains("r");
    }
}

public class Ousters {

    public static void main(String[] args) {
        String[] months = new String[]{"January", "February", "March", "Aril", "May",
                "June", "July", "August", "September", "October", "November", "December"};

        Collection<String> result = filter(   // вызов функции filter
                //new MyFilter(),             // конкретный класс
//                new Filter() {              // анонимный внутренний класс
//                    @Override
//                    public boolean criteria(String string) {
//                        return string.contains("r");
//                    }
//                },
                string -> string.contains("r"),  // лямбда-выражение
                new ArrayList<>(Arrays.asList("January", "February", "March", "Aril", "May",
                        "June", "July", "August", "September", "October", "November", "December")));
        System.out.println(result);
        // архитектурный шаблон Command
    }

    public static Collection<String> filter(Filter f, Collection<String> strings) {
        List<String> ret = new ArrayList<>();
        for (String s : strings)  // для всех строк из выходной коллекции
            if (f.criteria(s))    // если строка соответствует критерию
                ret.add(s);       // добавим ее в выходную коллекцию
        return ret;
    }
}
