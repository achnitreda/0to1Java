import java.io.IOException;
import java.util.stream.Stream;

public class StreamReduce {
     public static void main(String[] args) throws IOException {
        System.out.println(StreamReduce.sumAll(Stream.of(3, 5, 7, 10)));
        System.out.println(StreamReduce.sumAll(Stream.of()));
        System.out.println(StreamReduce.divideAndAddElements(Stream.of(3, 5, 7, 10), 2));
        System.out.println(StreamReduce.divideAndAddElements(Stream.of(), 2));
    }

    public static Integer sumAll(Stream<Integer> s) {
        return s.reduce(0,Integer::sum);
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        return s.map(n -> n/divider).reduce(0,Integer::sum);
    }
}