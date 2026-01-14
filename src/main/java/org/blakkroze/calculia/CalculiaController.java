package org.blakkroze.calculia.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;

import java.io.IOException;

public class CalculiaController {

    @FXML
    public Parent nodeList;
    @FXML
    public NodeListController nodeListController;


    @FXML
    public void handleAddNode(ActionEvent event) {

        Node sourceNode = (Node) event.getSource();
        Stage sourceStage = (Stage) sourceNode.getScene().getWindow(); 

        Stage addNodeWindow = new Stage();
        addNodeWindow.setTitle("Add node");
        addNodeWindow.initModality(Modality.APPLICATION_MODAL);
        addNodeWindow.initOwner(sourceStage); 

        System.out.println(getClass().getResource("../newnode/new-node-view.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../newnode/new-node-view.fxml"));

        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            addNodeWindow.setScene(scene);
        }
        catch (IOException e) {
            throw new RuntimeException("CalculiaController: Could not load the FXMLs", e);
        }

        NewNodeController newNodeController = loader.getController();
        newNodeController.setContainer(nodeListController.getNodes());
        addNodeWindow.showAndWait();

        if (newNodeController.getResult() != null) nodeListController.addNode(newNodeController.getResult());

    }

}
