import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class times {
  public static void fecha() {
    

System.out.println("     \n TIMES\n");

LocalTime ahora=LocalTime.now();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
System.out.println(1+"   "+ahora.format(dtf));


LocalTime sixThirty = LocalTime.of(6, 30);
System.out.println(2+"   "+sixThirty);


LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.MINUTES);
System.out.println(sevenThirty);

System.out.println(LocalTime.now().getHour());

LocalTime maxTime = LocalTime.MAX;
System.out.println(maxTime);
  }
}
