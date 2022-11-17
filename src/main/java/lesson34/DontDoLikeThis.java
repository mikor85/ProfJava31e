package lesson34;

public class DontDoLikeThis {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                Rate rate = Request.getRate(10, "GBP", "USD");
                startNewThread(rate);
            }

            private void startNewThread(Rate rate) {
                new Thread(){
                    @Override
                    public void run(){
                        Rate rate1 = Request.getRate(rate.rates.get("USD"), "USD", "EUR");
                    }
                };
            }
        }.start();
    }
}