package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PauseController {
    BatailleController bCon

    // Constructor call before view init
    public PauseController(BatailleController bController) {

    }


    // Call when view elements are initialized
    @FXML
    private void initialize() {

    }

    @FXML
    private void resume(ActionEvent actionEvent) {

    }

    @FXML
    private void quit(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Main.getPrimaryStage().setTitle("Hello World");
        Main.getPrimaryStage().setScene(new Scene(root, 300, 275));
        Main.getPrimaryStage().show();
    }
}
