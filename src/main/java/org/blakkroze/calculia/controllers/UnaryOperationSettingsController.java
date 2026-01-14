package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.SingleArgNode;
import org.blakkroze.calculia.containers.NodeContainer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UnaryOperationSettingsController implements OperationSettingsController <SingleArgNode> {

    @FXML
    TextField nodeIdField;
    @FXML
    TextField inputIdField;
    
    NodeContainer nodes;

    public void setNodes(NodeContainer nodes) {

        this.nodes = nodes;

    }

    @Override
    public void getNode(SingleArgNode node) {

        String nodeIdStr = nodeIdField.getText();
        String inputIdStr = inputIdField.getText();

        Integer nodeId = Integer.parseInt(nodeIdStr);
        Integer inputId = Integer.parseInt(inputIdStr);
        
        Node father = nodes.get(inputId);

        node.SetFather(father);

    }

}
