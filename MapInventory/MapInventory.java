import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        // keySet(), values(), or entrySet()!
        for (Map.Entry<String, Integer> en : inventory.entrySet()) {
            if (en.getKey().equals(productId)) {
                return en.getValue();
            }
        }
        return -1;
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> en : inventory.entrySet()) {
            if (en.getValue().equals(price)){
                res.add(en.getKey());
            }
        }
        return res;
    }
}