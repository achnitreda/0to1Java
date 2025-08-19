import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList { 
    public static List<Integer> sort(List<Integer> list) {
        if (list == null) return null;
        List<Integer> res = new ArrayList<>(list);
        Collections.sort(res);
        return res;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) return null;
        List<Integer> res = SortList.sort(list);
        Collections.reverse(res);
        return res;
    }
}