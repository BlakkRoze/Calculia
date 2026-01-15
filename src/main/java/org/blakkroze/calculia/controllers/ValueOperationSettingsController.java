package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.ValNode;
import org.blakkroze.calculia.models.BigFrac;
import org.blakkroze.calculia.containers.NodeContainer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class ValueOperationSettingsController implements OperationSettingsController <ValNode> {

    @FXML
    TextField nodeIdField;
    @FXML
    TextField valueField;
    
    NodeContainer nodes;

    @Override
    public void setContainer(NodeContainer container) {

        this.nodes = container;

    }

    @Override
    public boolean fillNode(ValNode node) {

        String nodeIdStr = nodeIdField.getText();
        String valueStr = valueField.getText();

        Integer nodeId;
        BigFrac value;

        try {
            nodeId = Integer.parseInt(nodeIdStr);
        }
        catch (NumberFormatException e) {
            showNodeIdInvalid();
            return false;
        }
        
        if (nodeId < 0) {
            showNodeIdInvalid();
            return false;
        }

        if (nodes.get(nodeId) != null) {
            showNodeIdPresent();
            return false;
        }

        try {
            value = BigFrac.parseBigFrac(valueStr);
        }
        catch (NumberFormatException e) {     
            showValueInvalid();
            return false;  
        }

        node.setId(nodeId);
        node.setFracValue(value);

        return true;

    }

    public void showNodeIdInvalid() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong node ID");
        alert.setContentText("Node ID is not a valid natural number");
        alert.showAndWait();

    }

    public void showNodeIdPresent() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong node ID");
        alert.setContentText("Node ID is already used!");
        alert.showAndWait();

    }

    public void showValueInvalid() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong value");
        alert.setContentText("Value is not a valid Calculia fraction representation");
        alert.showAndWait();

    }

}
