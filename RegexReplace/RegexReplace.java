import java.io.IOException;

public class RegexReplace {
    public static void main(String[] args) throws IOException {
        System.out.println(RegexReplace.removeUnits("32cm et 50€"));
        System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
        System.out.println(RegexReplace.removeUnits("32cms et 50€!"));
        
        System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
        System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }

    public static String removeUnits(String s) {
        if (s == null) {
            return "";
        }
        s = s.replaceAll("(\\d+)(cm|€)( |$)", "$1$3");
        return s;
    }
    
    public static String obfuscateEmail(String s) {
      if (s == null || !s.contains("@")) return s;
        
        String[] parts = s.split("@");
        String user = parts[0];
        String domain = parts[1];
        
        // Obfuscate user: if contains dot, keep part before dot + . + asterisks for the rest
        // Otherwise, keep first 3 chars + asterisks
        String obfuscatedUser;
        if (user.contains(".")) {
            int dotIndex = user.indexOf(".");
            String beforeDot = user.substring(0, dotIndex);
            String afterDot = user.substring(dotIndex + 1);
            obfuscatedUser = beforeDot + "." + "*".repeat(afterDot.length());
        } else {
            if (user.length() <= 3) {
                obfuscatedUser = user.charAt(0) + "*".repeat(user.length() - 1);
            } else {
                obfuscatedUser = user.substring(0, 3) + "*".repeat(user.length() - 3);
            }
        }
        
        // Obfuscate domain: always ******* + handle extension
        String obfuscatedDomain;
        if (domain.contains(".")) {
            String[] domainParts = domain.split("\\.");
            if (domainParts.length == 2) {
                // simple case: domain.com
                String ext = domainParts[1];
                if (ext.equals("com") || ext.equals("org") || ext.equals("net")) {
                    obfuscatedDomain = "*******." + ext;
                } else {
                    obfuscatedDomain = "*******.**";
                }
            } else {
                // complex case: domain.co.org
                obfuscatedDomain = "*******.co.***";
            }
        } else {
            obfuscatedDomain = "*******";
        }
        
        return obfuscatedUser + "@" + obfuscatedDomain;
    }
}