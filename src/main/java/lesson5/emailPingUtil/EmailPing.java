package lesson5.emailPingUtil;

// ДЗ проф ява:
// Выберите на https://github.com/public-apis/public-apis любой сервис без apiKey
// и реализуйте его вызов с использованием Retrofit.
// https://square.github.io/retrofit/


// {"status":"success",
// "data":
// {"email_address":"dmitrij@rs-steel.lv",
// "domain":"rs-steel.lv",
// "valid_syntax":true,
// "disposable":false,
// "webmail":false,
// "deliverable":true,
// "catch_all":true,
// "gibberish":false,
// "spam":false}}
public class EmailPing {
    private String status;
    private EmailPingData data;

    public EmailPing(String status, EmailPingData data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmailPingData getData() {
        return data;
    }

    public void setData(EmailPingData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "status: " + status + '\n' +
                "data: " + data;
    }
}
