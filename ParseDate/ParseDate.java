import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 2022-04-25T20:51:28.709039322
// 2022-04-25
// 21:07:23

public class ParseDate {
    public static void main(String[] args) {
        System.out.println(ParseDate.parseIsoFormat("2022-04-25T20:51:28.709039322"));
        System.out.println(ParseDate.parseFullTextFormat("lundi 25 avril 2022"));
        System.out.println(ParseDate.parseTimeFormat("09 heures du soir, 07 minutes et 23 secondes"));
    }

    public static LocalDateTime parseIsoFormat(String stringDate) {
        try {
            return LocalDateTime.parse(stringDate);
        } catch (Exception e) {
            System.out.println("Error parsing ISO format: " + e.getMessage());
            return null;
        }
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
      try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);  
      }catch (Exception e) {
        return null;
      }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
      System.out.println(stringDate);
      try {
            Pattern pattern = Pattern.compile("(\\d{1,2}) heures (du soir), (\\d{1,2}) minutes et (\\d{1,2}) secondes");
            Matcher matcher = pattern.matcher(stringDate);
            
            if (matcher.find()) {
                int hours = Integer.parseInt(matcher.group(1));
                String period = matcher.group(2); // "du soir"
                int minutes = Integer.parseInt(matcher.group(3));
                int seconds = Integer.parseInt(matcher.group(4));
                
                if (period.equals("du soir") && hours != 12) {
                    hours += 12;
                }
                
                return LocalTime.of(hours, minutes, seconds);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}