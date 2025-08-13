import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) return;

        try (InputStream input = System.in;
        FileOutputStream output = new FileOutputStream(args[0])) {
            int b;
            while ((b = input.read()) != -1) {
                output.write(b);
            }
        }
    }
}