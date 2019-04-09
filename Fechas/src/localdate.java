import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class localdate {
  public static void fecha() {
    
    
    System.out.println("     \n DATES \n");
    
    LocalDate lc=LocalDate.now();
    System.out.println(1+"   "+lc);


    lc = LocalDate.now().plusDays(1);
    System.out.println(2+"   "+lc);

    DayOfWeek dia_sem = LocalDate.now().getDayOfWeek();
    System.out.println(3+"   "+dia_sem);

    int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
    System.out.println(4+"   "+twelve);

    System.out.println("5   bisiesto  "+ LocalDate.now().plusYears(1).isLeapYear());

    LocalDate a= LocalDate.parse("2014-02-02");
    LocalDate b= LocalDate.parse("2015-02-03");
    System.out.println("6   "+a.isBefore(b));
    System.out.println("7   "+a.isAfter(b));


    LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
    System.out.println(beginningOfDay);
    LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
    System.out.println(firstDayOfMonth);

    
    
    
    
  }
}
