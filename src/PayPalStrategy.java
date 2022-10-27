public class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalStrategy(String email, String password, double money) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount, double money, String user) {
        double c = money - amount;
        if (c > -1) {
            System.out.println(user + " paid " + amount + " $, with PayPal method and in your bank your have " + c + " $");
        } else System.out.println("You money not enough");
    }
}
