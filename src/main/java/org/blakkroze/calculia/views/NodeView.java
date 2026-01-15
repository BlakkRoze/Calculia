package org.blakkroze.calculia.views;

import org.blakkroze.calculia.containers.NodeContainer;

import javafx.scene.control.ListCell;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import org.blakkroze.calculia.controllers.AddNodeController;
import org.blakkroze.calculia.controllers.DivNodeController;
import org.blakkroze.calculia.controllers.MulNodeController;
import org.blakkroze.calculia.controllers.SubNodeController;
import org.blakkroze.calculia.controllers.MinNodeController;
import org.blakkroze.calculia.controllers.MaxNodeController;
import org.blakkroze.calculia.controllers.NegNodeController;
import org.blakkroze.calculia.controllers.ValNodeController;
import org.blakkroze.calculia.nodes.AddNode;
import org.blakkroze.calculia.nodes.DivNode;
import org.blakkroze.calculia.nodes.MulNode;
import org.blakkroze.calculia.nodes.SubNode;
import org.blakkroze.calculia.nodes.MinNode;
import org.blakkroze.calculia.nodes.MaxNode;
import org.blakkroze.calculia.nodes.NegNode;
import org.blakkroze.calculia.nodes.ValNode;
import org.blakkroze.calculia.nodes.Node;

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
    private final Parent valGraphicContainer;
    ValNodeController valController;

    public NodeView(NodeContainer container) {

        FXMLLoader addNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/add-node-view.fxml"));
        FXMLLoader subNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/sub-node-view.fxml"));
        FXMLLoader mulNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/mul-node-view.fxml"));
        FXMLLoader divNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/div-node-view.fxml"));
        FXMLLoader minNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/min-node-view.fxml"));
        FXMLLoader maxNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/max-node-view.fxml"));
        FXMLLoader negNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/neg-node-view.fxml"));
        FXMLLoader valNodeLoader = new FXMLLoader(getClass().getResource("../nodelist/val-node-view.fxml"));

        try {
            addGraphicContainer = addNodeLoader.load();
            addController = addNodeLoader.getController();
            addController.setContainer(container);

            subGraphicContainer = subNodeLoader.load();
            subController = subNodeLoader.getController();
            subController.setContainer(container);

            mulGraphicContainer = mulNodeLoader.load();
            mulController = mulNodeLoader.getController();
            mulController.setContainer(container);

            divGraphicContainer = divNodeLoader.load();
            divController = divNodeLoader.getController();
            divController.setContainer(container);

            minGraphicContainer = minNodeLoader.load();
            minController = minNodeLoader.getController();
            minController.setContainer(container);

            maxGraphicContainer = maxNodeLoader.load();
            maxController = maxNodeLoader.getController();
            maxController.setContainer(container);

            negGraphicContainer = negNodeLoader.load();
            negController = negNodeLoader.getController();
            negController.setContainer(container);

            valGraphicContainer = valNodeLoader.load();
            valController = valNodeLoader.getController();
            //valController.setContainer(container);
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
                addController.setNode(addNode);
                addController.setId(node.getId());
                addController.setLeftArgNode(addNode.getLeftArgNode());
                addController.setRightArgNode(addNode.getRightArgNode());
                if( addNode.getLeftArgNode() == null || addNode.getRightArgNode() == null ){
                    addController.setValue("");
                } else {
                    addController.setValue(node.getValue());
                }
                setGraphic(addGraphicContainer);
            }

            if (node instanceof SubNode subNode) {
                subController.setNode(subNode);
                subController.setId(node.getId());
                subController.setLeftArgNode(subNode.getLeftArgNode());
                subController.setRightArgNode(subNode.getRightArgNode());
                if( subNode.getLeftArgNode() == null || subNode.getRightArgNode() == null ){
                    subController.setValue("");
                } else {
                    subController.setValue(node.getValue());
                }
                setGraphic(subGraphicContainer);
            }

            if (node instanceof MulNode mulNode) {
                mulController.setNode(mulNode);
                mulController.setId(node.getId());
                mulController.setLeftArgNode(mulNode.getLeftArgNode());
                mulController.setRightArgNode(mulNode.getRightArgNode());
                if( mulNode.getLeftArgNode() == null || mulNode.getRightArgNode() == null ){
                    mulController.setValue("");
                } else {
                    mulController.setValue(node.getValue());
                }
                setGraphic(mulGraphicContainer);
            }

            if (node instanceof DivNode divNode) {
                divController.setNode(divNode);
                divController.setId(node.getId());
                divController.setLeftArgNode(divNode.getLeftArgNode());
                divController.setRightArgNode(divNode.getRightArgNode());
                if( divNode.getLeftArgNode() == null || divNode.getRightArgNode() == null ){
                    divController.setValue("");
                } else {
                    divController.setValue(node.getValue());
                }
                setGraphic(divGraphicContainer);
            }

            if (node instanceof MinNode minNode) {
                minController.setNode(minNode);
                minController.setId(node.getId());
                minController.setLeftArgNode(minNode.getLeftArgNode());
                minController.setRightArgNode(minNode.getRightArgNode());
                if( minNode.getLeftArgNode() == null || minNode.getRightArgNode() == null ){
                    minController.setValue("");
                } else {
                    minController.setValue(node.getValue());
                }
                setGraphic(minGraphicContainer);
            }

            if (node instanceof MaxNode maxNode) {
                maxController.setNode(maxNode);
                maxController.setId(node.getId());
                maxController.setLeftArgNode(maxNode.getLeftArgNode());
                maxController.setRightArgNode(maxNode.getRightArgNode());
                if( maxNode.getLeftArgNode() == null || maxNode.getRightArgNode() == null ){
                    maxController.setValue("");
                } else {
                    maxController.setValue(node.getValue());
                }
                setGraphic(maxGraphicContainer);
            }

            if (node instanceof NegNode negNode) {
                negController.setNode(negNode);
                negController.setId(node.getId());
                negController.setArgNode(negNode.getArgNode());
                if( negNode.getArgNode() == null ){
                    negController.setValue("");
                } else {
                    negController.setValue(node.getValue());
                }
                setGraphic(negGraphicContainer);
            }

            if (node instanceof ValNode valNode) {
                //valController.setNode(valNode);
                valController.setId(node.getId());
                valController.setValue(node.getValue());
                setGraphic(valGraphicContainer);
            }
        }
    }
}