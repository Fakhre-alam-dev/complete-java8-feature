package mfa.codecurve.groupfun;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeDemo {
    /*
    1. LocalDate
    2. LocalTime
    3. LocalDateTime
    4. Period
    5. ZoneId
    6. Year
    7. ZoneDateTime
     */
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        int dayOfMonth = date.getDayOfMonth();
        int yyyy=date.getYear();
        Month month = date.getMonth();

        System.out.printf("%d-%d-%d",dayOfMonth,yyyy,month.getValue());
        System.out.println("---------------------------------------------------------------");

        //Zone id
        ZoneId ls=ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdt=ZonedDateTime.now(ls);
        System.out.println(zdt.getHour()+":"+zdt.getMinute());

    }
}
