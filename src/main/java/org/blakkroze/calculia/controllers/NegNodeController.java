package org.blakkroze.calculia.controllers;

import javafx.scene.control.Alert;
import org.blakkroze.calculia.containers.NodeContainer;
import org.blakkroze.calculia.nodes.NegNode;
import org.blakkroze.calculia.nodes.Node;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class NegNodeController {
    
    @FXML
    public Text nodeId;
    @FXML
    public TextField argNodeId;
    @FXML
    public Text nodeResult;

    private NegNode negNode;
    private NodeContainer container;

    public void setId(String id) {
        nodeId.setText(id);
    }

    public void setArgNode(Node node) {
        if(node == null){
            argNodeId.setText("");
            return;
        }
        argNodeId.setText(node.getId());
    }

    public void setValue(String value) {
        nodeResult.setText(value);
    }

    public void setNode(NegNode node) {
        this.negNode = node;
    }

    public void setContainer(NodeContainer container) {
        this.container = container;
    }

    public void onArgChanged() {

        String oldValue = nodeId.getText();
        String newValue = argNodeId.getText();

        if (negNode == null || container == null) return;

        try {
            if (newValue == null || newValue.trim().isEmpty()) {
                if (negNode.getArgNode() != null) {
                    negNode.getArgNode().unsubscribe(negNode);
                }
                return;
            }

            int nodeId = Integer.parseInt(newValue.trim());
            Node newArg = container.get(nodeId);

            if (newArg != null) {
                negNode.setFather(newArg);
            }
        } catch (NumberFormatException _) {

        } catch (IllegalArgumentException e) {
            showCycleError();
            argNodeId.setText(oldValue);
        }
    }
    private void showCycleError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cycle Error");
        alert.setHeaderText("Circular Dependency Detected");
        alert.setContentText("Cannot set this node as a dependency of node #" + negNode.getId() +
                ".\nThis would create a circular reference.");
        alert.showAndWait();
    }

}
