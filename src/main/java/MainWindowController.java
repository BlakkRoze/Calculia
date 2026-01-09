import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class MainWindowController extends Application {
    private NodeContainer container;
    private NodegraphController graphController;
    private NodeCreationController creationController;
    private Stage primaryStage;
    
    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.container = new NodeContainer();
        this.graphController = new NodegraphController(container);
        this.creationController = new NodeCreationController(container, this::onNodeAdded);
        
        BorderPane root = new BorderPane();
        
        // Center: Node graph view
        root.setCenter(graphController.createView());
        
        // Top: Buttons
        HBox buttonBar = new HBox(10);
        buttonBar.setPadding(new Insets(10));
        
        Button addButton = new Button("Add Node");
        addButton.setOnAction(e -> addNode());
        
        Button evaluateButton = new Button("Evaluate All");
        evaluateButton.setOnAction(e -> evaluate());
        
        buttonBar.getChildren().addAll(addButton, evaluateButton);
        root.setTop(buttonBar);
        
        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Calculia - Node Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
    private void addNode() {
        creationController.showCreationDialog(primaryStage);
    }
    
    private void evaluate() {
        graphController.evaluateAndDisplay();
    }
    
    private void onNodeAdded() {
        graphController.refreshNodeList();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}