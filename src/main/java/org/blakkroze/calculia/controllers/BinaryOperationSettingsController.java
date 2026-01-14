package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.TwoArgNode;
import org.blakkroze.calculia.containers.NodeContainer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BinaryOperationSettingsController implements OperationSettingsController <TwoArgNode> {

    @FXML
    TextField nodeIdField;
    @FXML
    TextField input1IdField;
    @FXML
    TextField input2IdField;

    NodeContainer nodes;

    public void setNodes(NodeContainer nodes) {

        this.nodes = nodes;

    }
    
    @Override
    public void getNode(TwoArgNode node) {

        String nodeIdStr = nodeIdField.getText();
        String input1IdStr = input1IdField.getText();
        String input2IdStr = input2IdField.getText();

        Integer nodeId = Integer.parseInt(nodeIdStr);
        Integer input1Id = Integer.parseInt(input1IdStr);
        Integer input2Id = Integer.parseInt(input2IdStr);
        
        Node left = nodes.get(input1Id);
        Node right = nodes.get(input2Id);

        node.SetLeft(left);
        node.SetRight(right);

    }

}
