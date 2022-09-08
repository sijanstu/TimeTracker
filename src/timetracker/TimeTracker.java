package timetracker;

/**
 *
 * @author Sijan Bhandari
 */
public class TimeTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    TrayInstance tray = new TrayInstance();
    tray.Start();
    tray.sendNotification();
    }
    
}
