package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.containers.NodeContainer;
import org.blakkroze.calculia.nodes.MulNode;
import org.blakkroze.calculia.nodes.Node;
import javafx.scene.control.ListView;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class MulNodeController {
    
    @FXML
    public Text nodeId;
    @FXML
    public TextField leftArgNodeId;
    @FXML
    public TextField rightArgNodeId;
    @FXML
    public Text nodeResult;

    private ListView<Node> listView;
    private MulNode currNode;
    private NodeContainer container;

    public void setId(String id) {
        nodeId.setText(id);
    }

    public void setListView(ListView<Node> listView) {
        this.listView = listView;
    }

    public void setLeftArgNode(Node node) {
        if( node == null ){
            leftArgNodeId.setText("");
            return;
        }
        leftArgNodeId.setText(node.getId());
    }

    public void setRightArgNode(Node node) {
        if( node == null ){
            rightArgNodeId.setText("");
            return;
        }
        rightArgNodeId.setText(node.getId());
    }

    public void setValue(String value) {
        nodeResult.setText(value);
    }

    public void setNode(MulNode node) {
        this.currNode = node;
    }

    public void setContainer(NodeContainer container) {
        this.container = container;
    }

    public void onLeftArgChanged() {
        
        String newValue = leftArgNodeId.getText();

        if (currNode == null || container == null) return;

        try {
            if (newValue == null || newValue.trim().isEmpty()) {
                if (currNode.getLeftArgNode() != null) {
                    currNode.getLeftArgNode().unsubscribe(currNode);
                }
                return;
            }

            int nodeId = Integer.parseInt(newValue.trim());
            Node newLeft = container.get(nodeId);

            if (newLeft != null && newLeft != currNode) {
                currNode.setLeft(newLeft);
            }
        }
        catch (NumberFormatException _) {
        }

        listView.refresh();

    }

    public void onRightArgChanged() {

        String newValue = rightArgNodeId.getText();

        if (currNode == null || container == null) return;

        try {
            if (newValue == null || newValue.trim().isEmpty()) {
                if (currNode.getRightArgNode() != null) {
                    currNode.getRightArgNode().unsubscribe(currNode);
                }
                return;
            }

            int nodeId = Integer.parseInt(newValue.trim());
            Node newRight = container.get(nodeId);

            if (newRight != null && newRight != currNode) {
                currNode.setRight(newRight);
            }
        }
        catch (NumberFormatException _) {
        }

        listView.refresh();

    }

}
