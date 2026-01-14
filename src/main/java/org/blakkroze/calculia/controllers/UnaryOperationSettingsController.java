package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.SingleArgNode;
import org.blakkroze.calculia.containers.NodeContainer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class UnaryOperationSettingsController implements OperationSettingsController <SingleArgNode> {

    @FXML
    TextField nodeIdField;
    @FXML
    TextField inputIdField;
    
    NodeContainer nodes;

    @Override
    public void setContainer(NodeContainer container) {

        this.nodes = container;

    }

    @Override
    public boolean fillNode(SingleArgNode node) {

        String nodeIdStr = nodeIdField.getText();
        String inputIdStr = inputIdField.getText();

        Integer nodeId;
        Integer inputId;

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
            inputId = Integer.parseInt(inputIdStr);
        }
        catch (NumberFormatException e) {     
            showFatherIdInvalid();
            return false;  
        }

        if (inputId < 0) {
            showFatherIdInvalid();
            return false;
        }

        Node father = nodes.get(inputId);

        if (father == null) {
            showFatherIdNotPresent();
            return false;
        }

        node.SetFather(father);
        node.setId(nodeId);

        return true;

    }

    public void showNodeIdInvalid() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong node ID");
        alert.setContentText("Node ID is not a valid natural number");
        alert.showAndWait();

    }

    public void showFatherIdInvalid() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong input ID");
        alert.setContentText("Input ID is not a valid natural number");
        alert.showAndWait();

    }

    public void showNodeIdPresent() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong node ID");
        alert.setContentText("Node ID is already used!");
        alert.showAndWait();

    }

    public void showFatherIdNotPresent() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong input ID");
        alert.setContentText("Input ID is not used yet!");
        alert.showAndWait();

    }

}
