package lesson6.weather;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class AppWeatherTester {
    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);

        Call<Weather> call = weatherService.getWeather(40.875, 74.125, "123temperature_2m");
        Response<Weather> response = call.execute();
        if (response.isSuccessful()) {
            Weather weather = response.body();
            System.out.println(weather);
        } else {
            Gson gson = new Gson();
            Error error = gson.fromJson(response.errorBody().string(), Error.class);
            System.out.println(error.reason);
        }
        System.exit(0);
    }
}
