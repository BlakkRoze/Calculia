package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.AddNode;
import org.blakkroze.calculia.nodes.SubNode;
import org.blakkroze.calculia.nodes.MulNode;
import org.blakkroze.calculia.nodes.DivNode;
import org.blakkroze.calculia.nodes.MinNode;
import org.blakkroze.calculia.nodes.MaxNode;
import org.blakkroze.calculia.nodes.NegNode;
import org.blakkroze.calculia.nodes.SingleArgNode;
import org.blakkroze.calculia.nodes.TwoArgNode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class NewNodeController {

    @FXML
    StackPane settingsPane;

    @FXML
    ComboBox<Node> operationComboBox;

    OperationSettingsController operationSettingsController;

    @FXML
    public void initialize() {

       operationComboBox.getItems().add(new AddNode());
       operationComboBox.getItems().add(new SubNode());
       operationComboBox.getItems().add(new MulNode());
       operationComboBox.getItems().add(new DivNode());
       operationComboBox.getItems().add(new MinNode());
       operationComboBox.getItems().add(new MaxNode());
       operationComboBox.getItems().add(new NegNode());
       

       operationComboBox.setCellFactory(lv -> new ListCell<Node>() {

           @Override
           protected void updateItem(Node node, boolean empty) {

               super.updateItem(node, empty);

               if (empty || node == null) {
                   setGraphic(null);
               }
               else {
                   FXMLLoader loader;
                   Parent cellView;

                   if (node instanceof AddNode addNode) {
                   loader = new FXMLLoader(getClass().getResource("../newnode/add-node-combo-view.fxml"));
                   }

                   else if (node instanceof SubNode subNode) {
                   loader = new FXMLLoader(getClass().getResource("../newnode/sub-node-combo-view.fxml"));
                   }

                   else if (node instanceof MulNode mulNode) {
                       loader = new FXMLLoader(getClass().getResource("../newnode/mul-node-combo-view.fxml"));
                   }

                   else if (node instanceof DivNode divNode) {
                       loader = new FXMLLoader(getClass().getResource("../newnode/div-node-combo-view.fxml"));
                   }

                   else if (node instanceof MinNode minNode) {
                       loader = new FXMLLoader(getClass().getResource("../newnode/min-node-combo-view.fxml"));
                   }

                   else if (node instanceof MaxNode maxNode) {
                       loader = new FXMLLoader(getClass().getResource("../newnode/max-node-combo-view.fxml"));
                   }

                   else if (node instanceof NegNode negNode) {
                       loader = new FXMLLoader(getClass().getResource("../newnode/neg-node-combo-view.fxml"));
                   }

                   else {
                       throw new RuntimeException("NewNodeController: Unsupported node type!");
                   }

                   try {
                       cellView = loader.load();
                   }
                   catch (IOException e) {
                       throw new RuntimeException("NewNodeController: Couldn't load the FXML file", e);
                   }

                   setGraphic(cellView);

               }

            }

        });

    }

    @FXML
    public void handleComboSelection(ActionEvent event) {

        System.out.println("Combo selection!");

        String layoutPath = "";

        Node val = operationComboBox.getValue();
        if (val instanceof TwoArgNode) {

            layoutPath = "../newnode/binary-operation-settings.fxml";

        }
        else if (val instanceof SingleArgNode) {

            layoutPath = "../newnode/unary-operation-settings.fxml";

        }
        else {

            throw new RuntimeException("NewNodeController: Could not load FXML");

        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(layoutPath));
        operationSettingsController = loader.getController();

        try {
            Parent parent = loader.load();
            settingsPane.getChildren().remove(0, settingsPane.getChildren().size());
            settingsPane.getChildren().add(parent);
        }
        catch (IOException e) {
            throw new RuntimeException("NewNodeController: Could not load FXML", e);
        }

        Stage stage = (Stage) ((ComboBox) event.getSource()).getScene().getWindow();
        stage.sizeToScene();

    }

    public Node getNode() {

        Node result = operationComboBox.getValue();
        
        operationSettingsController.getNode(result);
        
        return result; 
               
    }

}
