import java.util.ArrayList;
import java.util.List;

public class HexaBaseObserver implements NumericBaseObserver {
    private List<String> events;
    
    public HexaBaseObserver() {
        this.events = new ArrayList<>();
    }
    
    @Override
    public void updateState(int state) {
        String hexadecimalRepresentation = Integer.toHexString(state);
        events.add(hexadecimalRepresentation);
    }
    
    @Override
    public List<String> getEvents() {
        return events;
    }
}