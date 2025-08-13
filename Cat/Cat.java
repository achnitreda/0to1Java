import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }
        for (String arg : args) {
            try (FileInputStream input = new FileInputStream(arg)) {
                int byteVal;
                while ((byteVal = input.read()) != -1) {
                    System.out.write(byteVal);
                }
            }catch (IOException e) {
                return;
            }
        }
        System.out.flush();
    }
}