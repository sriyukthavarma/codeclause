import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversionByCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter your local time zone \n(e.g. Asia/Kolkata, Asia/Tashkent, Asia/Kuwait): ");
        String localZoneIdStr = sc.nextLine();
        ZoneId localZoneId = ZoneId.of(localZoneIdStr);


        System.out.print("Enter the country time zone \n(e.g. America/New_York, Europe/London, Asia/Tokyo): ");
        String countryZoneIdStr = sc.nextLine();
        ZoneId countryZoneId = ZoneId.of(countryZoneIdStr);


        LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
        LocalDateTime countryDateTime = localDateTime.atZone(localZoneId).withZoneSameInstant(countryZoneId).toLocalDateTime();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = formatter.format(localDateTime);
        String countryTime = formatter.format(countryDateTime);


        System.out.println("Local time (" + localZoneId + "): " + localTime);
        System.out.println("Country time (" + countryZoneId + "): " + countryTime);
        sc.close();;
    }
}