import java.util.ArrayList;
import java.util.List;

public class BinaryBaseObserver implements NumericBaseObserver {
    private List<String> events;
    
    public BinaryBaseObserver() {
        this.events = new ArrayList<>();
    }
    
    @Override
    public void updateState(int state) {
        String binaryRepresentation = Integer.toBinaryString(state);
        events.add(binaryRepresentation);
    }
    
    @Override
    public List<String> getEvents() {
        return events;
    }
}