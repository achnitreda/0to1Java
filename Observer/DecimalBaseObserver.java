import java.util.ArrayList;
import java.util.List;

public class DecimalBaseObserver implements NumericBaseObserver {
    private List<String> events;
    
    public DecimalBaseObserver() {
        this.events = new ArrayList<>();
    }
    
    @Override
    public void updateState(int state) {
        String decimalRepresentation = String.valueOf(state);
        events.add(decimalRepresentation);
    }
    
    @Override
    public List<String> getEvents() {
        return events;
    }
}