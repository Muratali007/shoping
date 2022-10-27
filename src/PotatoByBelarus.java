public class PotatoByBelarus extends Potato{
    private static PotatoByBelarus instance = null;

    public static PotatoByBelarus getInstance() {
        if (instance == null)
            instance = new PotatoByBelarus();
        return instance;
    }
  public  PotatoByBelarus(){
        desc = "Potato from Belarus, ";
  }
    public double cost() {
        return 8.0;
    }
}
