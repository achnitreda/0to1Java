import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        try {
            Path path = Paths.get(fileName);
            Files.write(path, content.getBytes());
        }catch (IOException e){
            return;
        }
    }
    public static String getContentFile(String fileName) throws IOException {
        try {
           return Files.readString(Paths.get(fileName));
        }catch (IOException e) {
            return null;
        }
    }
    public static void deleteFile(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            return;
        }
    }
}