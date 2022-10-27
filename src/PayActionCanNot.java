public class PayActionCanNot implements State{
    @Override
    public void doAction() {
        System.out.println("You have not enough money to buy products");
    }
}
