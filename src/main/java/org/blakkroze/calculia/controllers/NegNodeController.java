package org.blakkroze.calculia.controllers;

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

}
