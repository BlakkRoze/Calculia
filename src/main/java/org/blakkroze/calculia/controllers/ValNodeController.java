package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class ValNodeController {

    @FXML
    public Text nodeId;
    @FXML
    public Text nodeResult;

    ListView<Node> listView;

    public void setId(String id) {
        nodeId.setText(id);
    }

    public void setListView(ListView<Node> listView) {
        this.listView = listView;
    }

    public void setValue(String value) {
        nodeResult.setText(value);
    }

}
