package timetracker;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrayInstance {
    public static SystemTray tray;
    MenuItem editItem, exitTrack, exitItem,editTime;
    public void Start(){
        if (SystemTray.isSupported()) {
            TimeCounter counter = new TimeCounter();
            counter.start();
            tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon.png"));
            PopupMenu popup = new PopupMenu();
            editTime = new MenuItem("Edit Time");
            editTime.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConfigPanel.main(null);
                }
            });
            popup.add(editTime);
            editItem = new MenuItem("Pause Timer");
            editItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (editItem.getLabel().equals("Pause Timer")) {
                        counter.pause();
                        editItem.setLabel("Resume Timer");
                    }
                    else{
                        counter.resume();
                        editItem.setLabel("Pause Timer");
                    }
                }
            });
            popup.add(editItem);
            exitTrack = new MenuItem("Stop Timer");
            exitTrack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(exitTrack.getLabel().equals("Stop Timer")){
                        counter.stop();
                        editItem.setEnabled(false);
                        exitTrack.setLabel("Start Timer");
                    }
                    else{
                        counter.start();
                        editItem.setEnabled(true);
                        exitTrack.setLabel("Stop Timer");
                    }
                }
            });
            popup.add(exitTrack);
            exitItem = new MenuItem("Exit");
            exitItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            popup.add(exitItem);
            TrayIcon trayIcon = new TrayIcon(image, "TimeTracker", popup);
            trayIcon.setImageAutoSize(true);
            //trayIcon mouse entered
            trayIcon.setImageAutoSize(true);
            //one click to open the app
            trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    System.out.println("Tray icon clicked");
                }

            });
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
        } else {
            System.err.println("System tray not supported!");
        }
    }
    public void Stop(){
        tray.remove(tray.getTrayIcons()[0]);
    }
    public void sendNotification(){
        tray.getTrayIcons()[0].displayMessage("TimeTracker", "TimeTracker is Started", TrayIcon.MessageType.INFO);
    }
    public void sendNotification(String title, String message){
        tray.getTrayIcons()[0].displayMessage(title, message, TrayIcon.MessageType.INFO);
    }
}
