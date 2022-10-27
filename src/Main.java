import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SearchProducts searchProducts = new SearchProducts();
        PayContext payContext = new PayContext();
        State StateCan = new PayActionCan();
        State StateCanNot = new PayActionCanNot();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome our online shop-WHAP(we have all products)");
        System.out.println("Please choose action:" + "\n1.Register" + "\n 2.Auth");
        int choose_reg = sc.nextInt();
        String name = null;
        if (choose_reg == 1) {
            System.out.println("Please enter your name for register:");
            String name1 = sc.nextLine();
            name1 = sc.nextLine();
            name = name1;
            System.out.println("Your name:" + name);
            System.out.println("Enter your password:");
            int psw = sc.nextInt();
            System.out.println("Your password:" + psw);
        } else if (choose_reg == 2) {
            System.out.println("We does not have account in our service please create...");
            System.out.println("Please enter your name for register:");
            String name1 = sc.nextLine();
            name1 = sc.nextLine();
            name = name1;
            System.out.println("Your name:" + name);
            System.out.println("Enter your password:");
            int psw = sc.nextInt();
            System.out.println("Your password:" + psw);
        } else return;
        /*Observer pattern code*/
        searchProducts.addProducts("Potato");
        searchProducts.addProducts("Oil");
        searchProducts.addProducts("Apple");
        IObserver firstSubscriber = new Subscriber(name);
        searchProducts.addObserver(firstSubscriber);
        searchProducts.notifyObservers();
        System.out.println("We have some changes in our shop:");
        searchProducts.removeProducts("Oil");
        /**/

        /*Decorator pattern code*/
        int cont = 1;
        double all_price = 0;
        String desc = null;
        while (cont == 1) {
            System.out.println("Do you want to buy some products from our shop?" + "\n 1.Yes" + "\n 2.No");
            int choose = sc.nextInt();
            if (choose == 1) {
                System.out.println("1.Potato" + "\n 2.Apple");
                int choose_product = sc.nextInt();
                if (choose_product == 1) {
                    System.out.println("Which potato do you want to buy?" + "\n 1.from Kazakhstan" + "" +
                            "\n 2.from Belarus");
                    int potato_choose = sc.nextInt();
                    if (potato_choose == 1) {
                        Potato potato = PotatoByKazakhstan.getInstance();
                        all_price += potato.cost();
                        desc += potato.getDesc();
                    }
                    if (potato_choose == 2) {
                        Potato potato = PotatoByBelarus.getInstance();
                        all_price += potato.cost();
                        desc += potato.getDesc();
                    }
                }
                if (choose_product == 2) {
                    System.out.println("Which apple do you want to buy?" + "\n 1.from Almaty" + "" + "\n 2.from Uralsk");
                    int apple_choose = sc.nextInt();
                    if (apple_choose == 1) {
                        Apple apple = AppleByAlmaty.getInstance();
                        all_price += apple.cost();
                        desc += apple.getDesc();
                    }
                    if (apple_choose == 2) {
                        Apple apple = AppleByUralsk.getInstance();
                        all_price += apple.cost();
                        desc += apple.getDesc();
                    }
                }
            } else {
                cont = 2;
                desc = desc.substring(4);
                System.out.println(desc + all_price + " $");
            }
        }
        /**/

        /*Strategy pattern*/
        Pay pay = Pay.getInstance();
        System.out.println("How you want to pay for this products?:" + "\n 1.PayPal" + "\n 2.CreditCard");
        int pay_choose = sc.nextInt();
        if (pay_choose == 1) {
            System.out.println("Enter your email:");
            String email = sc.nextLine();
            email = sc.nextLine();
            System.out.println("Your email: " + email);

            System.out.println("Enter your password: ");
            String password = sc.nextLine();
            System.out.println("Your password: " + password);

            System.out.println("How many money you have?");
            double money = sc.nextInt();
            System.out.println("You have: " + money + " $");
            /* State pattern */
            if (money >= all_price) {
                payContext.setState(StateCan);
                payContext.doAction();
                pay.setPaymentStrategy(new PayPalStrategy(email, password, money));
                pay.executeStrategy(all_price, money, name);
            } else {
                payContext.setState(StateCanNot);
                payContext.doAction();
            }
            /**/
        }
        if (pay_choose == 2) {
            System.out.println("Enter your card number:");
            int card_number = sc.nextInt();
            System.out.println("Your card number: " + card_number);

            System.out.println("Enter you cvv:");
            int cvv = sc.nextInt();
            System.out.println("Your cvv: " + cvv);

            System.out.println("Enter date of Expire card:");
            String dateOfExpire = sc.nextLine();
            dateOfExpire = sc.nextLine();
            System.out.println("Enter date of Expire card:" + dateOfExpire);

            System.out.println("How many money you have?");
            double money = sc.nextInt();
            System.out.println("You have: " + money + " $");

            /* State pattern */
            if (money >= all_price) {
                payContext.setState(StateCan);
                payContext.doAction();
                pay.setPaymentStrategy(new CreditCardPay(name, card_number, cvv, dateOfExpire, money));
                pay.executeStrategy(all_price, money, name);
            }
            else {
                payContext.setState(StateCanNot);
                payContext.doAction();
            }
            /**/
        }
        /**/
    }
}