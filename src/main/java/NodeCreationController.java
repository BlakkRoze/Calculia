import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.math.BigInteger;

public class NodeCreationController {
    private NodeContainer container;
    private Runnable onNodeAdded;

    public NodeCreationController(NodeContainer container, Runnable onNodeAdded) {
        this.container = container;
        this.onNodeAdded = onNodeAdded;
    }

    public void showCreationDialog(Stage owner) {
        Stage dialog = new Stage();
        dialog.initOwner(owner);
        dialog.setTitle("Create Node");

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        ComboBox<String> typeSelector = new ComboBox<>();
        typeSelector.getItems().addAll("Value", "Add", "Subtract", "Multiply", "Divide", "Min", "Max", "Negate");
        typeSelector.setValue("Value");

        TextField numeratorField = new TextField();
        numeratorField.setPromptText("Numerator");

        TextField denominatorField = new TextField();
        denominatorField.setPromptText("Denominator");
        denominatorField.setText("1");

        ComboBox<String> leftNodeSelector = new ComboBox<>();
        leftNodeSelector.setPrefWidth(250);
        ComboBox<String> rightNodeSelector = new ComboBox<>();
        rightNodeSelector.setPrefWidth(250);
        ComboBox<String> unaryNodeSelector = new ComboBox<>();
        unaryNodeSelector.setPrefWidth(250);

        updateNodeSelectors(leftNodeSelector, rightNodeSelector, unaryNodeSelector);

        VBox valueInputs = new VBox(5, new Label("Value:"), numeratorField, denominatorField);
        VBox operationInputs = new VBox(5,
                new Label("Left operand:"), leftNodeSelector,
                new Label("Right operand:"), rightNodeSelector
        );
        VBox unaryInputs = new VBox(5, new Label("Operand:"), unaryNodeSelector);

        // Make sure all containers are properly managed
        valueInputs.setManaged(true);
        operationInputs.setManaged(false);
        unaryInputs.setManaged(false);

        valueInputs.setVisible(true);
        operationInputs.setVisible(false);
        unaryInputs.setVisible(false);

        typeSelector.setOnAction(e -> {
            String type = typeSelector.getValue();

            boolean isValue = type.equals("Value");
            boolean isBinaryOp = type.equals("Add") || type.equals("Subtract") ||
                    type.equals("Multiply") || type.equals("Divide") ||
                    type.equals("Min") || type.equals("Max");
            boolean isUnaryOp = type.equals("Negate");

            valueInputs.setVisible(isValue);
            valueInputs.setManaged(isValue);

            operationInputs.setVisible(isBinaryOp);
            operationInputs.setManaged(isBinaryOp);

            unaryInputs.setVisible(isUnaryOp);
            unaryInputs.setManaged(isUnaryOp);

            // Refresh node lists when switching to operation types
            if (isBinaryOp || isUnaryOp) {
                updateNodeSelectors(leftNodeSelector, rightNodeSelector, unaryNodeSelector);
            }
        });

        Button submitButton = new Button("Create");
        submitButton.setOnAction(e -> {
            try {
                String type = typeSelector.getValue();

                // Validation for operations
                if (!type.equals("Value")) {
                    if (container.getAllNodes().isEmpty()) {
                        showError("You must create at least one Value node first!");
                        return;
                    }

                    String selectedNode = type.equals("Negate") ? unaryNodeSelector.getValue() : leftNodeSelector.getValue();
                    if (selectedNode == null) {
                        showError("Please select an operand!");
                        return;
                    }
                    if (!type.equals("Negate") && rightNodeSelector.getValue() == null) {
                        showError("Please select a right operand!");
                        return;
                    }
                }

                submit(type, numeratorField.getText(),
                        denominatorField.getText(),
                        type.equals("Negate") ? unaryNodeSelector.getValue() : leftNodeSelector.getValue(),
                        rightNodeSelector.getValue());
                dialog.close();
                if (onNodeAdded != null) onNodeAdded.run();
            } catch (Exception ex) {
                showError("Error creating node: " + ex.getMessage());
            }
        });

        root.getChildren().addAll(
                new Label("Node Type:"), typeSelector,
                valueInputs, operationInputs, unaryInputs,
                submitButton
        );

        Scene scene = new Scene(root, 300, 400);
        dialog.setScene(scene);
        dialog.show();
    }

    private void updateNodeSelectors(ComboBox<String> left, ComboBox<String> right, ComboBox<String> unary) {
        left.getItems().clear();
        right.getItems().clear();
        unary.getItems().clear();

        for (Node node : container.getAllNodes()) {
            String item = "Node " + node.getId() + " (" + node.getDisplayName() + ")";
            left.getItems().add(item);
            right.getItems().add(item);
            unary.getItems().add(item);
        }
    }

    private void submit(String type, String numerator, String denominator,
                        String leftStr, String rightStr) {
        Node newNode = null;

        switch (type) {
            case "Value":
                BigInteger num = new BigInteger(numerator.isEmpty() ? "0" : numerator);
                BigInteger den = new BigInteger(denominator.isEmpty() ? "1" : denominator);
                newNode = new ValNode(new BigFrac(num, den));
                break;

            case "Add":
                newNode = new AddNode(getNodeFromString(leftStr), getNodeFromString(rightStr));
                break;

            case "Subtract":
                newNode = new SubNode(getNodeFromString(leftStr), getNodeFromString(rightStr));
                break;

            case "Multiply":
                newNode = new MulNode(getNodeFromString(leftStr), getNodeFromString(rightStr));
                break;

            case "Divide":
                newNode = new DivNode(getNodeFromString(leftStr), getNodeFromString(rightStr));
                break;

            case "Min":
                newNode = new MinNode(getNodeFromString(leftStr), getNodeFromString(rightStr));
                break;

            case "Max":
                newNode = new MaxNode(getNodeFromString(leftStr), getNodeFromString(rightStr));
                break;

            case "Negate":
                newNode = new NegNode(getNodeFromString(leftStr));
                break;
        }

        if (newNode != null) {
            container.add(newNode);
        }
    }

    private Node getNodeFromString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Please select a node");
        }
        int id = Integer.parseInt(str.split(" ")[1]);
        Node node = container.get(id);
        if (node == null) {
            throw new IllegalArgumentException("Node not found: " + id);
        }
        return node;
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}