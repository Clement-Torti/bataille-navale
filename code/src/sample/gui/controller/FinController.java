package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.Observer.Partie;
import sample.model.Score;
import sample.model.Util.ScoreWriter;
import sample.model.Util.SoundBox;

public class FinController extends BaseController {
    @FXML
    TextArea text;
    @FXML
    TextField name;
    @FXML
    VBox vbox;


    private static final String ACCUEIL_FXML = "../view/vueAccueil.fxml";
    private static final String SCORES_TEXT = "resources/database/data.txt";

    public FinController(Stage stage, Partie game) { super(stage, game); }

    @FXML
    private void initialize() {
        String string = "";

        if(getCurrGame().getWinner() == 0) {
            string += "Vous avez gagné!\n";
        } else {
            string += "Défaite.\n";
        }

        string += "La partie a durée " + getCurrGame().getDuree() + " secondes en " + getCurrGame().getNbCoup() + " coups.";

        text.setText(string);

        // Supprimer le TextField si le joueur n'a pas gagné
        if(getCurrGame().getWinner() == 1) {
            vbox.getChildren().remove(name);
        }
    }

    @FXML
    private void accueil(ActionEvent actionEvent) throws Exception {
        SoundBox.playButtonClickSound();

        if(getCurrGame().getWinner() == 0 &&  name.getText().isEmpty()) { return; }

        // S'il a gagné
        if(getCurrGame().getWinner() == 0) {
            // Write the score to the table
            ScoreWriter writer = new ScoreWriter(SCORES_TEXT);
            String duree = getCurrGame().getDuree() + " sec";
            Score score = new Score(name.getText(), duree, getCurrGame().getNbCoup());
            writer.insertScore(score);
        }

        changeStage(ACCUEIL_FXML, new AccueilController(getStage()));
    }
}
