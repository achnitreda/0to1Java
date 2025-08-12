import java.util.ArrayList;

public class CleanExtract {
    public static void main(String[] args) {
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
    public static String extract(String s) {
        if (s == null || s.trim().isEmpty() || s.replaceAll("[|. ]", "").isEmpty()) {
            return "";
        }
        String[] parts = s.split("\\|");
        ArrayList<String> res = new ArrayList<>();

        res.add(parts[0].replace(".","").trim());

        int first = s.indexOf("."); 
        int last = s.lastIndexOf("."); 
        String str = s.substring(first,last);


        String[] splitted = str.split("\\|");

        for (int i=0; i< splitted.length; i++) {
            String tmp = splitted[i].trim();
            if (i == 0 && tmp.replace(".","").equals(res.get(0))) {
                continue;
            }
            if (tmp.startsWith(".") && i == splitted.length-1){
                res.add(tmp.replaceFirst(".","").trim());
                break;
            }
            if (tmp.startsWith(".") && !tmp.replace(".","").trim().isEmpty()){
                res.add(tmp.replace(".","").trim());
            }
        }

        return String.join(" ", res).trim();
    }   
}
