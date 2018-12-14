package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.gui.view.Grille;
import sample.launcher.Main;
import sample.model.Partie;

import java.net.URL;


public class BatailleController extends BaseController {
    @FXML
    Grille iaGrid;
    @FXML
    Grille playerGrid;

    private static final String PAUSE_FXML = "../view/vuePause.fxml";

    // Constructor call before View init
    public BatailleController(Stage stage) {
        super(stage);
    }

    public BatailleController(Stage stage, Partie game) {
        super(stage, game);
    }


    // Call when View elements are initialized
    @FXML
    private void initialize() {
        //iaGrid.configureButtons(getCurrGame().getIaGrid());
    }

    @FXML
    private void pause(ActionEvent actionEvent) throws Exception {
        changeStage(PAUSE_FXML, new PauseController(getStage(), getCurrGame()));
    }
}
