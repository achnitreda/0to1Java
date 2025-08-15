
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Galaxy { 
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject o) {
        celestialObjects.add(o);
    }

   public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> plan = new HashMap<>();
        plan.put("Star", 0);
        plan.put("Other", 0);
        plan.put("Planet", 0);
        for (CelestialObject elem : celestialObjects) {
            String type;
            if (elem instanceof Star) {
                type = "Star";
            } else if (elem instanceof Planet) {
                type = "Planet";
            } else {
                type = "Other";
            }
            plan.put(type, plan.get(type) + elem.getMass());
        }
        return plan;
    }
}   
