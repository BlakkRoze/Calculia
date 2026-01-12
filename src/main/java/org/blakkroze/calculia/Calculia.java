package org.blakkroze.calculia;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class Calculia extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = new FXMLLoader(this.getClass().getResource("calculia.fxml")).load();
        primaryStage.setTitle("Calculia");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

}
