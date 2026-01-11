package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.AddNode;
import org.blakkroze.calculia.nodes.SubNode;
import org.blakkroze.calculia.nodes.MulNode;
import org.blakkroze.calculia.nodes.DivNode;
import org.blakkroze.calculia.nodes.MinNode;
import org.blakkroze.calculia.nodes.MaxNode;
import org.blakkroze.calculia.nodes.NegNode;

import org.blakkroze.calculia.views.NodeView;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NodeListController {

    @FXML
    public ListView<Node> nodeListView;

    @FXML
    public void initialize() {

        ObservableList<Node> nodes = FXCollections.observableArrayList();
        nodes.add(new AddNode());
        nodes.add(new SubNode());
        nodes.add(new MulNode());
        nodes.add(new DivNode());
        nodes.add(new MinNode());
        nodes.add(new MaxNode());
        nodes.add(new NegNode());

        nodeListView.setItems(nodes);
        nodeListView.setCellFactory(_ -> new NodeView());

    }

}
