package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.containers.NodeContainer;
import org.blakkroze.calculia.models.BigFrac;
import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.AddNode;
import org.blakkroze.calculia.nodes.SubNode;
import org.blakkroze.calculia.nodes.MulNode;
import org.blakkroze.calculia.nodes.DivNode;
import org.blakkroze.calculia.nodes.MinNode;
import org.blakkroze.calculia.nodes.MaxNode;
import org.blakkroze.calculia.nodes.NegNode;
import org.blakkroze.calculia.nodes.ValNode;

import org.blakkroze.calculia.views.NodeView;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NodeListController {

    @FXML
    public ListView<Node> nodeListView;

    private NodeContainer nodes = new NodeContainer();
    private ObservableList<Node> observableNodes;

    @FXML
    public void initialize() {

        observableNodes = FXCollections.observableArrayList();

        ValNode valNode1 = new ValNode(new BigFrac(2137,2));
        valNode1.setId(1);

        ValNode valNode2 = new ValNode(new BigFrac(2137,1));
        valNode2.setId(2);

        addNode(valNode1);
        addNode(valNode2);

        nodeListView.setItems(observableNodes);
        nodeListView.setCellFactory(_ -> new NodeView());

    }

    public void addNode(Node node) {

        nodes.add(node);
        observableNodes.add(node);

    }
    
    public NodeContainer getNodes() {

        return nodes;

    }

}
