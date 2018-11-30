package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class BatailleController {
    // Constructor call before view init
    public BatailleController() {

    }


    // Call when view elements are initialized
    @FXML
    private void initialize() {

    }

    @FXML
    private void pause(ActionEvent actionEvent) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("vuePause.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 800, 400));
        Main.getPrimaryStage().setTitle("Pause");
    }
}
