import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Arrays;


// {B=[Bonjour, bonsoir], L=[le], M=[monde !]}
// {0=Optional[424], 1=Optional[97], 2=Optional[48354], 3=Optional[5843]}
// ##{Bordeaux # Hello # how are you ? # where do you live ?}

public class StreamCollect {
    public static void main(String[] args) {
        System.out.println(StreamCollect.mapByFirstLetter(Stream.of("Bonjour", "le", "monde !", "bonsoir")));
        System.out.println(StreamCollect.getMaxByModulo4(Stream.of(5, 12, 32, 4, 9, 17, 98, 424, 97, 5843, 48354)));
        System.out.println(StreamCollect.orderAndConcatWithSharp(Stream.of("Hello", "how are you ?", "where do you live ?", "Bordeaux")));
    }

    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        Map<Character, List<String>> mp = new HashMap();

        s.forEach(str -> {
            char key = Character.toUpperCase(str.charAt(0));

            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }

            mp.get(key).add(str);
        });

        return mp;        
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        Map<Integer, Optional<Integer>> mp = new HashMap();

        s.forEach(num -> {
            Integer mod = num%4;
            if (!mp.containsKey(mod)) {
                mp.put(mod, Optional.of(num));
            }

            Optional<Integer> current = mp.get(mod);
            Optional<Integer> newValue = Optional.of(num);

            if (current.get() < newValue.get()) {
                mp.put(mod,Optional.of(num));
            }
            
        });

        return mp;
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        List<String> res = s.sorted().toList();        
        return String.format("{%s}",String.join(" # ",res));
    }
}