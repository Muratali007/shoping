public class Pay {

    private PaymentStrategy paymentStrategy;

    private static Pay instance = null;
    public static Pay getInstance(){
        if(instance == null)
            instance = new Pay();
        return instance;
    }

    public void executeStrategy(double amount , double money ,String user){
            paymentStrategy.pay(amount,money,user);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
