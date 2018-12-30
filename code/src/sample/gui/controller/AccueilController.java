package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.model.Difficulty;
import sample.model.Observer.Partie;

import java.io.IOException;


public class AccueilController extends BaseController {

    private static final String BATAILLE_FXML = "../view/vueBataille.fxml";
    private static final String INFOS_FXML = "../view/vueInfos.fxml";

    @FXML
    private RadioButton boutonFacile;
    @FXML
    private RadioButton boutonNormal;
    @FXML
    private RadioButton boutonDifficile;



    public AccueilController(Stage stage) {
        super(stage);
    }

    @FXML
    private void initialize()
    {
        // Permet de créer un groupe de RadioButton et donc il n'y a qu'un RadioButton qui peut être coché
        ToggleGroup group = new ToggleGroup();
        boutonFacile.setToggleGroup(group);
        boutonNormal.setToggleGroup(group);
        boutonDifficile.setToggleGroup(group);

    }

    @FXML
    private void start(ActionEvent actionEvent) throws Exception {
        // Create the game
        Partie game = new Partie(Difficulty.EASY);
        setCurrGame(game);
        changeStage(BATAILLE_FXML, new BatailleController(getStage(), getCurrGame()));
    }

    @FXML
    private void infos(ActionEvent actionEvent) throws IOException {
        openStage(INFOS_FXML, 800, 500);
    }


}
