import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File documentsFolder = new File("documents");
        return searchFileRecursive(documentsFolder,fileName);      
    }
    public static String searchFileRecursive(File folder,String fileName) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        return file.getAbsolutePath().substring("/jail/project/".length());
                    }else if (file.isDirectory()) {
                        String filePath = searchFileRecursive(file, fileName);
                        if (filePath != null) {
                            return filePath;
                        }
                    }
                }
            }
        }  
        return null;    
    }
}