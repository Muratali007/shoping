public class AppleByUralsk extends Apple{
    private static AppleByUralsk instance = null;
    public static AppleByUralsk getInstance(){
        if(instance == null)
            instance = new AppleByUralsk();
        return instance;
    }
    public AppleByUralsk(){
        desc = "Apple from Uralsk, ";
    }
    public double cost() {
        return 2.0 ;
    }
}
