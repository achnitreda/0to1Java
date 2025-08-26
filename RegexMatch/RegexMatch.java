import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// true
// false
// true
// false
// true
// false

public class RegexMatch {
     public static void main(String[] args) throws IOException {
        System.out.println(RegexMatch.containsOnlyAlpha("azejkdfhjsdf"));
        System.out.println(RegexMatch.containsOnlyAlpha("azejkd fhjsdf"));
        System.out.println(RegexMatch.startWithLetterAndEndWithNumber("asjd jd34jds jkfd6f5"));
        System.out.println(RegexMatch.startWithLetterAndEndWithNumber("asjd jd34jds jkfd6."));
        System.out.println(RegexMatch.containsAtLeast3SuccessiveA("sdjkAAAAAsdjksj"));
        System.out.println(RegexMatch.containsAtLeast3SuccessiveA("sdjkAAsdaaasdjksj"));
    }

    public static boolean containsOnlyAlpha(String s) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
    
    public static boolean startWithLetterAndEndWithNumber(String s) {
        Pattern pattern = Pattern.compile("^[a-zA-Z].*[0-9]$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
    
    public static boolean containsAtLeast3SuccessiveA(String s) {
        Pattern pattern = Pattern.compile("A{3,}");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}