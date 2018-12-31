package sample.gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.model.Difficulty;
import sample.model.Observer.Partie;
import sample.model.Score;
import sample.model.Util.ScoreReader;

import java.io.IOException;


public class AccueilController extends BaseController {

    private static final String BATAILLE_FXML = "../view/vueBataille.fxml";
    private static final String INFOS_FXML = "../view/vueInfos.fxml";
    private static final String SCORES_TEXT = "resources/database/data.txt";

    @FXML
    private RadioButton boutonFacile;
    @FXML
    private RadioButton boutonNormal;
    @FXML
    private RadioButton boutonDifficile;
    @FXML
    private ListView scoresList;

    ToggleGroup group = new ToggleGroup();

    private ObservableList<Score> scores;
    private ScoreReader scoreReader;

    public AccueilController(Stage stage) {
        super(stage);
    }

    @FXML
    private void initialize()
    {
        // Permet de créer un groupe de RadioButton et donc il n'y a qu'un RadioButton qui peut être coché
        boutonFacile.setToggleGroup(group);
        boutonNormal.setToggleGroup(group);
        boutonDifficile.setToggleGroup(group);

        // Bind les scores à la ListView
        scores = FXCollections.observableArrayList();
        scoreReader  = new ScoreReader(SCORES_TEXT);
        for(Score score: scoreReader.getScores()) {
            scores.add(score);
        }
        scoresList.setItems(scores);

    }

    @FXML
    private void start(ActionEvent actionEvent) throws Exception {
        Partie game;

        // Create the game
        if(group.getSelectedToggle().equals(boutonFacile)) {
            game = new Partie(Difficulty.EASY);
        } else if(group.getSelectedToggle().equals(boutonNormal)) {
            game = new Partie(Difficulty.MEDIUM);
        } else {
            game = new Partie(Difficulty.HARD);
        }

        setCurrGame(game);
        changeStage(BATAILLE_FXML, new BatailleController(getStage(), getCurrGame()));
    }

    @FXML
    private void infos(ActionEvent actionEvent) throws IOException {
        openStage(INFOS_FXML, 800, 500);
    }


}
