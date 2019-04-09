import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class Zoned_date {
public static void fecha() {

  System.out.println("   \n ZONED DATE\n");
  ZoneId zone = ZoneId.of("Asia/Amman");
System.out.println(zone);
Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

allZoneIds.forEach((k)->System.out.println("Zonas : " + k ));

System.out.println("\n \n");
LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
System.out.println(localDateTime);



ZoneOffset offset = ZoneOffset.of("+02:00");

OffsetDateTime offSetByTwo = OffsetDateTime
  .of(localDateTime, offset);
System.out.println(offSetByTwo);

}
}
