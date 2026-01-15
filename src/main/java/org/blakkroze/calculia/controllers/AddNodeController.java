package org.blakkroze.calculia.controllers;

import javafx.scene.control.Alert;
import org.blakkroze.calculia.containers.NodeContainer;
import org.blakkroze.calculia.nodes.AddNode;
import org.blakkroze.calculia.nodes.Node;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class AddNodeController {
    
    @FXML
    public Text nodeId;
    @FXML
    public TextField leftArgNodeId;
    @FXML
    public TextField rightArgNodeId;
    @FXML
    public Text nodeResult;

    private AddNode currNode;
    private NodeContainer container;

    public void setId(String id) {
        nodeId.setText(id);
    }

    public void setLeftArgNode(Node node) {
        if( node == null ){
            leftArgNodeId.setText("");
            return;
        }
        leftArgNodeId.setText(node.getId());
    }

    public void setRightArgNode(Node node) {
        if( node == null ){
            rightArgNodeId.setText("");
            return;
        }
        rightArgNodeId.setText(node.getId());
    }

    public void setValue(String value) {
        nodeResult.setText(value);
    }

    public void setNode(AddNode node) {
        this.currNode = node;
    }

    public void setContainer(NodeContainer container) {
        this.container = container;
    }

    public void onLeftArgChanged() {

        String oldValue = nodeId.getText();
        String newValue = leftArgNodeId.getText();

        if (currNode == null || container == null) return;

        try {
            if (newValue == null || newValue.trim().isEmpty()) {
                if (currNode.getLeftArgNode() != null) {
                    currNode.getLeftArgNode().unsubscribe(currNode);
                }
                return;
            }

            int nodeId = Integer.parseInt(newValue.trim());
            Node newLeft = container.get(nodeId);

            if (newLeft != null) {
                currNode.setLeft(newLeft);
            }
        }
        catch (NumberFormatException _) {

        } catch (IllegalArgumentException e) {
            showCycleError();
            leftArgNodeId.setText(oldValue);
        }

    }

    public void onRightArgChanged() {

        String oldValue = nodeId.getText();
        String newValue = rightArgNodeId.getText();

        if (currNode == null || container == null) return;

        try {
            if (newValue == null || newValue.trim().isEmpty()) {
                if (currNode.getRightArgNode() != null) {
                    currNode.getRightArgNode().unsubscribe(currNode);
                }
                return;
            }

            int nodeId = Integer.parseInt(newValue.trim());
            Node newRight = container.get(nodeId);

            if (newRight != null) {
                currNode.setRight(newRight);
            }
        }
        catch (NumberFormatException _) {

        } catch (IllegalArgumentException e) {
            showCycleError();
            rightArgNodeId.setText(oldValue);
        }

    }

    private void showCycleError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cycle Error");
        alert.setHeaderText("Circular Dependency Detected");
        alert.setContentText("Cannot set this node as a dependency of node #" + currNode.getId() +
                ".\nThis would create a circular reference.");
        alert.showAndWait();
    }

}
