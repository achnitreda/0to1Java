import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Wedding {
    public static void main(String[] args) {
        System.out.println(Wedding.createCouple(Set.of("Pikachu", "Dracaufeu", "Tortank"), Set.of("Legolas", "Aragorn", "Gimli","reda")));
    }
    // {Pikachu=Legolas, Tortank=Gimli, Dracaufeu=Aragorn}

    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {

        int n = Math.min(first.size(),second.size());

        String[] f = first.toArray(new String[0]);
        String[] s = second.toArray(new String[0]);

        Map<String, String> mp = new HashMap(); 

        for (int i=0; i< n; i++) {
            mp.put(f[i],s[i]);
        }

        return mp;
    }
}