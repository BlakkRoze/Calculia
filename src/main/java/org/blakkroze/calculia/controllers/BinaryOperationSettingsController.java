package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.TwoArgNode;
import org.blakkroze.calculia.containers.NodeContainer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class BinaryOperationSettingsController implements OperationSettingsController <TwoArgNode> {

    @FXML
    TextField nodeIdField;
    @FXML
    TextField input1IdField;
    @FXML
    TextField input2IdField;

    NodeContainer nodes;

    @Override
    public void setContainer(NodeContainer container) {

        this.nodes = container;

    }
    
    @Override
    public boolean fillNode(TwoArgNode node) {

        String nodeIdStr = nodeIdField.getText();
        String input1IdStr = input1IdField.getText();
        String input2IdStr = input2IdField.getText();

        Integer nodeId;
        Integer input1Id;
        Integer input2Id;

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
            input1Id = Integer.parseInt(input1IdStr);
        }
        catch (NumberFormatException e) {     
            showInput1IdInvalid();
            return false;  
        }

        if (input1Id < 0) {
            showInput1IdInvalid();
            return false;
        }

        Node input1 = nodes.get(input1Id);

        if (input1 == null) {
            showInput1IdNotPresent();
            return false;
        }

        try {
            input2Id = Integer.parseInt(input2IdStr);
        }
        catch (NumberFormatException e) {     
            showInput2IdInvalid();
            return false;  
        }

        if (input2Id < 0) {
            showInput2IdInvalid();
            return false;
        }

        Node input2 = nodes.get(input2Id);

        if (input2 == null) {
            showInput2IdNotPresent();
            return false;
        }

        node.setLeft(input1);
        node.setRight(input2);
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

    public void showInput1IdInvalid() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong input 1 ID");
        alert.setContentText("Input 1 ID is not a valid natural number");
        alert.showAndWait();

    }

    public void showInput2IdInvalid() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong input 2 ID");
        alert.setContentText("Input 2 ID is not a valid natural number");
        alert.showAndWait();

    }

    public void showNodeIdPresent() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong node ID");
        alert.setContentText("Node ID is already used!");
        alert.showAndWait();

    }

    public void showInput1IdNotPresent() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong input 1 ID");
        alert.setContentText("Input 1 ID is not used yet!");
        alert.showAndWait();

    }

    public void showInput2IdNotPresent() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong input 2 ID");
        alert.setContentText("Input 2 ID is not used yet!");
        alert.showAndWait();

    }

}
