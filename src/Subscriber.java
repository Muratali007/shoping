import java.util.List;

    public class Subscriber implements IObserver {
        String name;

        public Subscriber(String name) {
            this.name = name;
        }

        @Override
        public void handleEvent(List<String> products) {
            System.out.println("Dear " + name + " \nWe have this products on our shop:"  +
                    "\n " + products);
        }
    }