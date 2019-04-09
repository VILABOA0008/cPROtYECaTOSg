import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
public class Periodd {

  public static void fecha() {
    
    System.out.println("     \n PERIODO \n");
    
LocalDate inic=LocalDate.now();
LocalDate fin=inic.plus(java.time.Period.ofDays(5));
System.out.println(fin);
    
int diff = Period.between(inic, fin).getDays();
System.out.println(diff);


diff = (int)ChronoUnit.DAYS.between(fin , inic);
System.out.println(diff);

System.out.println("    \n \n DURACION \n");


LocalTime initialTime = LocalTime.of(6, 30, 0);

LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
System.out.println(finalTime);


int thirty =(int) Duration.between(finalTime, initialTime).getSeconds();   
System.out.println(thirty);

thirty = (int)ChronoUnit.SECONDS.between(finalTime, initialTime);
System.out.println(thirty);
  }
  
  
}
