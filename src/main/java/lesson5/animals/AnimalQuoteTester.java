package lesson5.animals;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class AnimalQuoteTester {
    public static void main(String[] args) throws IOException {

//        AnimalService service = new Retrofit.Builder()
//                // класс retrofit нужен, чтобы создать класс, имплементящий аннотиованный интерфейс
//                .baseUrl("https://cat-fact.herokuapp.com/")  // что вызывать
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(AnimalService.class);

        // https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2
        Retrofit retrofit = new Retrofit.Builder()
                // класс retrofit нужен, чтобы создать класс, имплементящий аннотиованный интерфейс
                .baseUrl("https://cat-fact.herokuapp.com/")  // что вызывать
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalService service = retrofit.create(AnimalService.class);

        Call<Fact> call1 = service.getFact();
        Response<Fact> response1 = call1.execute();
        if (response1.isSuccessful()) {
            Fact f = response1.body();
            System.out.println(f.getText());
        }

        /* вызов списочной структуры
        Call<List<Fact>> call = service.getFacts("dog", 3);

        Response<List<Fact>> response = call.execute();  // результат запроса
        if (response.isSuccessful()) {
            List<Fact> facts = response.body();
            for (Fact f : facts) {
                System.out.println(f.getText());
            }
        }
         */
    }
}
