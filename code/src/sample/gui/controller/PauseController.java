package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import sample.model.Observer.Partie;

import java.io.IOException;

public class PauseController extends BaseController {

    private static final String ACCUEIL_FXML = "../view/vueAccueil.fxml";
    private static final String BATAILLE_FXML = "../view/vueBataille.fxml";

    // Constructor call before View init
    public PauseController(Stage stage) {
        super(stage);
    }
    public PauseController(Stage stage, Partie game) {
        super(stage, game);
    }


    // Call when View elements are initialized
    @FXML
    private void initialize() {

    }

    @FXML
    private void resume(ActionEvent actionEvent) throws IOException {
        changeStage(BATAILLE_FXML, new BatailleController(getStage(), getCurrGame()));
    }

    @FXML
    private void quit(ActionEvent actionEvent) throws Exception {
        changeStage(ACCUEIL_FXML, new AccueilController(getStage()));
    }
}
