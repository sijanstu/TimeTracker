package timetracker;

import java.io.BufferedReader;
import java.io.File;

public class TimeCounter {
    private int milliseconds;
    private boolean isRunning;
    private boolean isPaused;
    static TimeRunner runner;
    static double timeLimit;

    public TimeCounter() {
        milliseconds = 0;
        isRunning = false;
        isPaused = false;
        //read previous time file from user directory
        File file = new File(System.getProperty("user.home") + "\\TimeTracker\\time.txt");
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
                String line = reader.readLine();
                timeLimit = Double.parseDouble(line);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            timeLimit= 60*60*1000; //default time limit is 1 hour
        }
    }

    public void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        isPaused = false;
        runner = new TimeRunner(this);
        runner.start();

    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
        runner = new TimeRunner(this);
        runner.start();
    }

    public void stop() {
        isRunning = false;
        isPaused = false;
        milliseconds = 0;
    }

    public void tick() {
        if (isRunning && !isPaused) {
            milliseconds++;
        }
        if (milliseconds >= timeLimit) {
            NotificationFrame.main(null);
            milliseconds = 0;
        }
        //
    }

    public String getTime() {
        String time = "";
        int seconds = milliseconds / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        time=hours+":"+minutes+":"+seconds;
        return time;
    }

    private class TimeRunner extends Thread {
        private final TimeCounter counter;

        public TimeRunner(TimeCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while (!isPaused&&isRunning) {
                counter.tick();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
