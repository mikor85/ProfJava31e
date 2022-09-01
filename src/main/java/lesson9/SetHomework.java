package lesson9;

// ДЗ проф ява:
// У нас есть список стран
// countries = ["Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"]
// и есть список слов
// words = ["Andorra", "Canada", "First", "candy", "Argentina",
// "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba"]
// нужно получить список всех стран из списка слов, начинающихся на "A" - т.е., ["Argentina", "Andorra"]


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetHomework {
    public static void main(String[] args) {
        String[] countries = new String[]{"Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"};
        String[] words = new String[]{"Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod", "Avangard", "Cuba"};

        System.out.println(getCountriesStartedAtA(countries, words));
    }

    private static Set<String> getCountriesStartedAtA(String[] countries, String[] words) {
        Set<String> resSet = new HashSet<>();
        Set<String> checkSet = new HashSet<>(List.of(countries));
        for (String w : words) {
            if (checkSet.contains(w) && w.charAt(0) == 'A') {
                resSet.add(w);
            }
        }
        return resSet;
    }
}