package lesson5.homeworkRetrofit;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Query;

// https://api.eva.pingutil.com/email?email=cormakoff@gmail.com
// https://api.eva.pingutil.com/email?email=test@mail7.io
public interface EmailPingService {
    @GET("https://api.eva.pingutil.com/email") // веб-сервис куда "приземлять" запрос
        // добавляется в query string в виде ?email=...
    Call<EmailPing> getEmailAddress(@Query("https://api.eva.pingutil.com/email") String email_address);
}
