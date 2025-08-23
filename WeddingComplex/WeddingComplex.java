import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WeddingComplex {
    public static void main(String[] args) {
        System.out.println(WeddingComplex.createBestCouple(
                Map.of("Naruto", List.of("Sakura", "Hinata"), "Sasuke", List.of("Sakura", "Hinata")),
                Map.of("Sakura", List.of("Sasuke", "Naruto"), "Hinata", List.of("Naruto", "Sasuke"))));
    }
    // {Sasuke=Sakura, Naruto=Hinata}
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> couples = new HashMap();

        Map<String, String> whoIsPartnerOf = new HashMap();

        Map<String, Integer> nextToPropose = new HashMap();

        for (String person : first.keySet()) {
            nextToPropose.put(person, 0);
        }

        while (couples.size() < first.size()) {
            String proposer = null;
            for (String person : first.keySet()) {
                if (!couples.containsKey(person)) {
                    proposer = person;
                    break;
                }
            }

            int index = nextToPropose.get(proposer);
            String target = first.get(proposer).get(index);
            nextToPropose.put(proposer, index + 1);

            if (!whoIsPartnerOf.containsKey(target)) {
                couples.put(proposer, target);
                whoIsPartnerOf.put(target, proposer);
            }else {
                // {Sasuke=Hinata, Naruto=Sakura}
                String currentPartner = whoIsPartnerOf.get(target);
                List<String> targetPrefs = second.get(target);
                int currentRank = targetPrefs.indexOf(currentPartner);
                int newRank = targetPrefs.indexOf(proposer);

                if (newRank < currentRank) {
                    couples.remove(currentPartner);
                    couples.put(proposer, target);
                    whoIsPartnerOf.put(target, proposer);
                }
            }
        }

        return couples;
    }
}