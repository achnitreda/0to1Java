import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Le 22 août de l'an 2021 à 13h25m et 46s
// febbraio 13 22
// 16:18:56.008495847

public class FormatDate {
    public static void main(String[] args) {
        System.out.println(FormatDate.formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
        System.out.println(FormatDate.formatSimple(LocalDate.of(2022, 2, 13)));
        System.out.println(FormatDate.formatIso(LocalTime.of(16, 18, 56, 8495847)));
    }


    public static String formatToFullText(LocalDateTime dateTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "'Le' dd MMM 'de l''an' yyyy 'à' HH'h'mm'm et' ss's'", 
            Locale.FRENCH
            );
            return dateTime.format(formatter);
        }catch (Exception e) {
            return null;
        }
        
    }

    public static String formatSimple(LocalDate date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "MMMM dd yy", 
                Locale.ITALIAN
            );
            return date.format(formatter);
        }catch (Exception e) {
            return null;
        }
    }

    public static String formatIso(LocalTime time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return time.format(formatter);
        }catch (Exception e) {
            return null;
        }
    }
}
