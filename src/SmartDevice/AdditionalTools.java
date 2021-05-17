package SmartDevice;

public class AdditionalTools {

    public static void interrupt(int time){
        try
        {
            Thread.sleep(time);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
