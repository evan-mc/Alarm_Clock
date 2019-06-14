import java.util.Scanner;

public class Alarm_Clock
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("When would you like to wake up?");
        System.out.print("Hour: ");
        int hourToWake = scan.nextInt();
        scan.nextLine();

        System.out.print("Minute: ");
        int minuteToWake = scan.nextInt();
        scan.nextLine();

        System.out.print("Path to video links: ");
        String pathToVideos = scan.nextLine();

        System.out.println("You will be woken up in " + hourToWake + " hours and " + minuteToWake + " minutes from now.");

        AlarmClock alarm = new AlarmClock(hourToWake, minuteToWake, pathToVideos);

        alarm.sleep();
        alarm.launchRandomVideo();

    }
}
