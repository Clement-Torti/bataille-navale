package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Controller {
    @FXML
    private void start(ActionEvent actionEvent) throws Exception {

        Parent root =  FXMLLoader.load(getClass().getResource("vueBataille.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 800, 400));
        Main.getPrimaryStage().setTitle("Bataille");

    }
}
