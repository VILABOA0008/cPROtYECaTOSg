import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formateo {
public static void fecha() {
  
  System.out.println("\n  FORMATEO");
  LocalDateTime local = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
  System.out.println(local);

  
  String localDateString = local.format(DateTimeFormatter.ISO_DATE);
  System.out.println(localDateString);
  
  String formateado=local.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  System.out.println(formateado+"   formateado");
  
  
  local.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
  .withLocale(Locale.UK));
  System.out.println(local);
  
  
}
}
