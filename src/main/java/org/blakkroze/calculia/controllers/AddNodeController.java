package org.blakkroze.calculia.controllers;

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

    public void setId(String id) {
        nodeId.setText(id);
    }

    public void setLeftArgNode(Node node) {
        leftArgNodeId.setText(node.getId());
    }

    public void setRightArgNode(Node node) {
        rightArgNodeId.setText(node.getId());
    }

    public void setValue(String value) {
        nodeResult.setText(value);
    }

}
