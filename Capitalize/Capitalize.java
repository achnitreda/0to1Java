import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length != 2) return;

        String content = new String(Files.readAllBytes(Paths.get(args[0])));
        String[] words = content.trim().split("\\s+");

        List<String> res = new ArrayList<>();
        for (String word : words) {
            String capitalized = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            res.add(capitalized);
        }
        String ans = String.join(" ",res);
        Files.write(Paths.get(args[1]),ans.getBytes());
    }
}