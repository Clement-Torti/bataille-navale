package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.launcher.Main;

import java.net.URL;


public class BatailleController extends BaseController {

    private static final String PAUSE_FXML = "../view/vuePause.fxml";

    // Constructor call before View init
    public BatailleController(Stage stage) {
        super(stage);
    }


    // Call when View elements are initialized
    @FXML
    private void initialize() {

    }

    @FXML
    private void pause(ActionEvent actionEvent) throws Exception {
        changeStage(PAUSE_FXML, new PauseController(getStage()));
    }
}
