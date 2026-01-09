import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class NodegraphController {
    private NodeContainer container;
    private ListView<String> nodeListView;
    private Label resultLabel;
    
    public NodegraphController(NodeContainer container) {
        this.container = container;
    }
    
    public VBox createView() {
        VBox view = new VBox(10);
        view.setPadding(new Insets(10));
        
        Label title = new Label("Nodes:");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        nodeListView = new ListView<>();
        nodeListView.setPrefHeight(300);
        
        resultLabel = new Label("Result: (not evaluated)");
        resultLabel.setStyle("-fx-font-size: 12px; -fx-padding: 10px;");
        
        view.getChildren().addAll(title, nodeListView, resultLabel);
        return view;
    }
    
    public void refreshNodeList() {
        nodeListView.getItems().clear();
        for (Node node : container.getAllNodes()) {
            nodeListView.getItems().add("Node " + node.getId() + ": " + node.getDisplayName());
        }
    }
    
    public void evaluateAndDisplay() {
        if (container.getAllNodes().isEmpty()) {
            resultLabel.setText("Result: No nodes to evaluate");
            return;
        }
        
        StringBuilder results = new StringBuilder("Results:\n");
        for (Node node : container.getAllNodes()) {
            try {
                BigFrac value = node.getValue();
                results.append("Node ").append(node.getId())
                       .append(": ").append(value).append("\n");
            } catch (Exception e) {
                results.append("Node ").append(node.getId())
                       .append(": ERROR - ").append(e.getMessage()).append("\n");
            }
        }
        resultLabel.setText(results.toString());
    }
}