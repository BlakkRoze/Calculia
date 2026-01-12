package org.blakkroze.calculia.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.application.Platform;

public class FileMenuController {

    @FXML
    public void handleClose(ActionEvent event) {

        Platform.exit();

    }

}
