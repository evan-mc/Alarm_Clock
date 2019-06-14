import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.lang.RuntimeException;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AlarmClock
{
    private int hourToWake;
    private int minuteToWake;
    private List<String> urlList = new ArrayList<>();
    
    public AlarmClock(int hour, int minute, String path)
    {
        hourToWake = hour;
        minuteToWake = minute;

        //populates list with videos to choose from
        try
        {
            Scanner fileScan = new Scanner(new File(path));
            while(fileScan.hasNext())
            {
                urlList.add(fileScan.nextLine());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Could not find the txt document to load.");
            throw new RuntimeException(ex);
        }
    }

    public void sleep()
    {
        try
        {
            TimeUnit.HOURS.sleep(hourToWake);
            TimeUnit.MINUTES.sleep(minuteToWake);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void launchRandomVideo()
    {
        Desktop desktop = Desktop.getDesktop();
        try
        {
            desktop.browse(URI.create(urlList.get(getRandomVideoIdx())));
        }
        catch(IOException io)
        {
            System.out.println("Could not launch the video.");
            throw new RuntimeException(io);
        }
    }

    private int getRandomVideoIdx()
    {
        Random randomNum = new Random();
        return randomNum.nextInt(urlList.size());
    }
}
