import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

public class StreamMap {
    public static void main(String[] args) throws IOException {
        System.out.println(StreamMap.sumOfStringLength(Stream.of("Bonjour", "le", "monde !")));
        System.out.println(StreamMap.upperCaseAllString(Stream.of("IL", "Fait", "beaU !!")));
        System.out.println(StreamMap.uniqIntValuesGreaterThan42(Stream.of(23.439, 42.34, 39194.4)));
    }

    // 16
    // [IL, FAIT, BEAU !!]
    // [42, 39194]

    public static Integer sumOfStringLength(Stream<String> s) {
        return s.mapToInt(String::length).sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.map(String::toUpperCase).collect(Collectors.toList());
    }
    
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.filter(n -> n > 42).map(Double::intValue).collect(Collectors.toSet());
    }
}
