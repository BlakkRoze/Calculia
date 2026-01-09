import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class NodeContainer {
    private Map<Integer, Node> nodes;
    
    public NodeContainer() {
        this.nodes = new HashMap<>();
    }
    
    public Node get(int id) {
        return nodes.get(id);
    }
    
    public void add(Node node) {
        nodes.put(node.getId(), node);
    }
    
    public void delete(int id) {
        nodes.remove(id);
    }
    
    public List<Node> getAllNodes() {
        return new ArrayList<>(nodes.values());
    }
}