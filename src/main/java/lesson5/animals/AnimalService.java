package lesson5.animals;

/*
https://cat-fact.herokuapp.com/ - веб сайт (домен)
                facts/random    - веб сервис
                ?               - разделитель
                animal_type=cat - первый параметр
                &               - амперсанд, разделитель параметров
                amount=3        - второй параметр
*/

// https://square.github.io/retrofit/

// facts/random/{animal_type}/{amount}  // @Path
// facts/random?animal_type=cat&amount=2  // @Query  ? и & добавляются автоматически

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AnimalService {
    @GET("facts/random")
    Call<List<Fact>> getFacts(
            @Query("animal_type") String animal,
            @Query("amount") int number
    );

    @GET("facts/random")
    Call<Fact> getFact();
}
