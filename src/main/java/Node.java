import java.util.ArrayList;
import java.util.List;

public abstract class Node implements NodeSubscriber {
    private static int nextId = 1;
    private int id;
    private boolean evaluated;
    private BigFrac value;
    private List<NodeSubscriber> subscribers;
    
    public Node() {
        this.id = nextId++;
        this.evaluated = false;
        this.subscribers = new ArrayList<>();
    }
    
    public int getId() { return id; }
    
    public BigFrac getValue() {
        if (!evaluated) {
            evaluate();
        }
        return value;
    }
    
    protected void setValue(BigFrac value) {
        this.value = value;
        this.evaluated = true;
    }
    
    public void invalidate() {
        if (evaluated) {
            evaluated = false;
            notifySubscribers();
        }
    }
    
    public void subscribe(NodeSubscriber subscriber) {
        subscribers.add(subscriber);
    }
    
    public void unsubscribe(NodeSubscriber subscriber) {
        subscribers.remove(subscriber);
    }
    
    private void notifySubscribers() {
        for (NodeSubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
    
    @Override
    public void update() {
        invalidate();
    }
    
    public abstract void evaluate();
    public abstract String getDisplayName();
}