package org.blakkroze.calculia.controllers;

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
        setupListeners();
    }

    private void setupListeners() {
        argNodeId.textProperty().addListener((observable, oldValue, newValue) -> {
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

                if (newArg != null && newArg != negNode) {
                    negNode.setFather(newArg);
                }
            } catch (NumberFormatException _) {

            }
        });
    }

}
