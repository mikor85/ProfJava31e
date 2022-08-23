package lesson6.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//  5. * Реализовать вызов Free Weather API - документация https://open-meteo.com/en/docs ,
//  пример вызова - https://api.open-meteo.com/
//                                      v1/forecast
//                                      ?
//                                      latitude=52.52
//                                      &
//                                      longitude=13.41
//                                      &
//                                      hourly=temperature_2m
public interface WeatherService {

    @GET("v1/forecast")
    Call<Weather> getWeather(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("hourly") String hourly
    );
}
