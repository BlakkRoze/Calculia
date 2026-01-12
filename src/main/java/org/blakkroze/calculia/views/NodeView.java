package org.blakkroze.calculia.views;

import org.blakkroze.calculia.controllers.AddNodeController;
import org.blakkroze.calculia.controllers.SubNodeController;
import org.blakkroze.calculia.controllers.MulNodeController;
import org.blakkroze.calculia.controllers.DivNodeController;
import org.blakkroze.calculia.controllers.MinNodeController;
import org.blakkroze.calculia.controllers.MaxNodeController;
import org.blakkroze.calculia.controllers.NegNodeController;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.AddNode;
import org.blakkroze.calculia.nodes.SubNode;
import org.blakkroze.calculia.nodes.MulNode;
import org.blakkroze.calculia.nodes.DivNode;
import org.blakkroze.calculia.nodes.MinNode;
import org.blakkroze.calculia.nodes.MaxNode;
import org.blakkroze.calculia.nodes.NegNode;

import javafx.scene.control.ListCell;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class NodeView extends ListCell<Node> {

    private final Parent addGraphicContainer;
    AddNodeController addController;
    private final Parent subGraphicContainer;
    SubNodeController subController;
    private final Parent mulGraphicContainer;
    MulNodeController mulController;
    private final Parent divGraphicContainer;
    DivNodeController divController;
    private final Parent minGraphicContainer;
    MinNodeController minController;
    private final Parent maxGraphicContainer;
    MaxNodeController maxController;
    private final Parent negGraphicContainer;
    NegNodeController negController;

    public NodeView() {

        FXMLLoader addNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/add-node-view.fxml"));
        FXMLLoader subNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/sub-node-view.fxml"));
        FXMLLoader mulNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/mul-node-view.fxml"));
        FXMLLoader divNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/div-node-view.fxml"));
        FXMLLoader minNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/min-node-view.fxml"));
        FXMLLoader maxNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/max-node-view.fxml"));
        FXMLLoader negNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/neg-node-view.fxml"));
        
        try {
            addGraphicContainer = addNodeLoader.load();
            addController = addNodeLoader.getController();
            subGraphicContainer = subNodeLoader.load();
            subController = subNodeLoader.getController();
            mulGraphicContainer = mulNodeLoader.load();
            mulController = mulNodeLoader.getController();
            divGraphicContainer = divNodeLoader.load();
            divController = divNodeLoader.getController();
            minGraphicContainer = minNodeLoader.load();
            minController = minNodeLoader.getController();
            maxGraphicContainer = maxNodeLoader.load();
            maxController = maxNodeLoader.getController();
            negGraphicContainer = negNodeLoader.load();
            negController = negNodeLoader.getController();
        }
        catch (IOException e) {
            throw new RuntimeException("NodeView: Could not load the FXMLs", e);
        }

    }

    @Override
    protected void updateItem(Node node, boolean empty) {

        super.updateItem(node, empty);

        if (empty || node == null) {
            setText(null);
            setGraphic(null);
        }

        else {

            if (node instanceof AddNode addNode) {
                addController.setId(node.getId());
                addController.setLeftArgNode(addNode.getLeftArgNode());
                addController.setRightArgNode(addNode.getRightArgNode());
                addController.setValue(node.getValue());
                setGraphic(addGraphicContainer);
            }

            if (node instanceof SubNode subNode) {
                subController.setId(node.getId());
                subController.setLeftArgNode(subNode.getLeftArgNode());
                subController.setRightArgNode(subNode.getRightArgNode());
                subController.setValue(node.getValue());
                setGraphic(subGraphicContainer);
            }

            if (node instanceof MulNode mulNode) {
                mulController.setId(node.getId());
                mulController.setLeftArgNode(mulNode.getLeftArgNode());
                mulController.setRightArgNode(mulNode.getRightArgNode());
                mulController.setValue(node.getValue());
                setGraphic(mulGraphicContainer);
            }

            if (node instanceof DivNode divNode) {
                divController.setId(node.getId());
                divController.setLeftArgNode(divNode.getLeftArgNode());
                divController.setRightArgNode(divNode.getRightArgNode());
                divController.setValue(node.getValue());
                setGraphic(divGraphicContainer);
            }

            if (node instanceof MinNode minNode) {
                minController.setId(node.getId());
                minController.setLeftArgNode(minNode.getLeftArgNode());
                minController.setRightArgNode(minNode.getRightArgNode());
                minController.setValue(node.getValue());
                setGraphic(minGraphicContainer);
            }

            if (node instanceof MaxNode maxNode) {
                maxController.setId(node.getId());
                maxController.setLeftArgNode(maxNode.getLeftArgNode());
                maxController.setRightArgNode(maxNode.getRightArgNode());
                maxController.setValue(node.getValue());
                setGraphic(maxGraphicContainer);
            }

            if (node instanceof NegNode negNode) {
                negController.setId(node.getId());
                negController.setArgNode(negNode.getArgNode());
                negController.setValue(node.getValue());
                setGraphic(negGraphicContainer);
            }

        }

    }

}
