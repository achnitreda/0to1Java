import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {

    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        try {
            return Duration.between(localTime1, localTime2).abs();
        }catch (Exception e) {
            return null;
        }
    }

    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        try {
            Period period = Period.between(date1, date2);
            return period.isNegative() ? period.negated() : period;
        }catch (Exception e) {
            return null;
        }
    }

    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        try {
            Duration duration = Duration.between(dateTime1, dateTime2);
            return Math.abs(duration.toHours());
        }catch (Exception e) {
            return null;
        }
    }

}