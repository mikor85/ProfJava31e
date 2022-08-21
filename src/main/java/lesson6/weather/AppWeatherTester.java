package lesson6.weather;

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

        Call<Location> call = weatherService.getWeather(52.52, 13.41, "temperature_2m");
        Response<Location> response = call.execute();
        if (response.isSuccessful()) {
            Location location = response.body();
            System.out.println(location);
        }
        System.exit(0);
    }
}
