public class AppleByAlmaty extends Apple{
    private static AppleByAlmaty instance = null;
    public static AppleByAlmaty getInstance(){
        if(instance == null)
            instance = new AppleByAlmaty();
        return instance;
    }
    public AppleByAlmaty (){
        desc = "Apple from Almaty, ";
    }

    public double cost() {
        return 5.0 ;
    }
}
