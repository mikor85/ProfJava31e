package lesson5.homeworkRetrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class EmailPingTester {
    public static void main(String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("https://api.eva.pingutil.com/email?email=test@mail7.io")
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
//        if (response.isSuccessful()) { // если запрос удачный
//            ResponseBody emailPing = response.body();  // объект, который нам нужен
//            assert emailPing != null;
//            //System.out.println("Status: " + emailPing.getStatus() + ", Data: " + emailPing.getData());
//            System.out.println(emailPing);
//        }
//        System.exit(0);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.eva.pingutil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmailPingService service = retrofit.create(EmailPingService.class);

        //Call<EmailPing> call = service.getEmailAddress("email?email=cormakoff@gmail.com");
        Call<EmailPing> call = service.getEmailAddress("cormakoff@gmail.com");

        Response<EmailPing> response = call.execute();

        //System.out.println(response);

        if (response.isSuccessful()) {
            EmailPing emailPing = response.body();
            System.out.println("status: " + emailPing.getStatus() + '\n' +
                    "data: " + emailPing.getData());
            //System.out.println(emailPing);
        } //else System.out.println(response);
        System.exit(0);
    }
}
