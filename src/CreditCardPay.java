public class CreditCardPay implements PaymentStrategy {
    private String name;
    private int cardNumber;
    private int cvv;
    private String dateOfExpiry;

    public CreditCardPay(String nm, int ccNum, int cvv, String expiryDate, double money) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(double amount, double money, String user) {
        double c = money - amount;
        if (c > -1) {
            System.out.println(user + " paid " + amount + " $, with CreditCard method and in your bank your have " + c + " $");
        } else System.out.println("You money not enough");
    }
}
