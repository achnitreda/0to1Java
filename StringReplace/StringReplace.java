public class StringReplace {
    public static void main(String[] args) {
        System.out.println(StringReplace.replace("javatpoint is a very good website", 'a', 'e'));
        System.out.println(StringReplace.replace("my name is khan my name is java", "is","was"));
        System.out.println(StringReplace.replace("hey i'am java", "I'am","was"));
    }
    public static String replace(String s, char target, char replacement) {
        return s.replace(target, replacement);
    }

    public static String replace(String s, String target, String replacement) {
        return s.replace(target, replacement);
    }
}