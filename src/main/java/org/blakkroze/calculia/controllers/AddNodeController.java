package org.blakkroze.calculia.controllers;

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
        setupListeners();
    }

    private void setupListeners() {
        leftArgNodeId.textProperty().addListener((observable, oldValue, newValue) -> {
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

                if (newLeft != null && newLeft != currNode) {
                    currNode.setLeft(newLeft);
                }
            } catch (NumberFormatException _) {

            }
        });

        rightArgNodeId.textProperty().addListener((observable, oldValue, newValue) -> {
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

                if (newRight != null && newRight != currNode) {
                    currNode.setRight(newRight);
                }
            } catch (NumberFormatException _) {

            }
        });
    }
}
