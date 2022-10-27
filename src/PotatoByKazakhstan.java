public class PotatoByKazakhstan extends Potato {
    private static PotatoByKazakhstan instance = null;

    public static PotatoByKazakhstan getInstance() {
        if (instance == null)
            instance = new PotatoByKazakhstan();
            return instance;
    }
    public PotatoByKazakhstan(){
        desc = "Potato from Kazakhstan, ";
    }
    public double cost() {
        return 5.0;
    }
}
