package lesson5.homeworkRetrofit;

import retrofit2.Call;
import retrofit2.http.*;

// https://api.eva.pingutil.com/email?email=cormakoff@gmail.com
// https://api.eva.pingutil.com/email?email=test@mail7.io
public interface EmailPingService {
    @GET("/{email_address}")
    Call<EmailPing> getEmailAddress(@Path("email_address") String email_address);
}
