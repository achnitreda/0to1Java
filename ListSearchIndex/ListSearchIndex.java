import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) return null;
        Integer n = list.lastIndexOf(value);
        if (n == -1) {
            return null;
        }else {
            return n;
        }
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) return null;
        Integer n = list.indexOf(value);
        if (n == -1) {
            return null;
        }else {
            return n;
        }
    }
    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> res = new ArrayList<>();
        if (list == null) return res;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals(value)) {
                res.add(i);
            }
        }
        return res;
    }
}