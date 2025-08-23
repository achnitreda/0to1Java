import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.*;

public class KeepTheChange {
    public static void main(String[] args) {
        System.out.println(KeepTheChange.computeChange(18, Set.of(1, 3, 7)));
    }

    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> res = new ArrayList<>();

        List<Integer> arr = coins.stream().collect(Collectors.toList());
        Collections.sort(arr, Collections.reverseOrder());

        int sum = 0;
        int i = 0;
        while (i<arr.size()){
            if (sum == amount){
                break;
            }
            if (arr.get(i)+sum <= amount){
                sum += arr.get(i);
                res.add(arr.get(i));
            }else {
                i++;
            }
        }
        return res;
    }
}