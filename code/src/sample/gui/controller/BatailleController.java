package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.gui.view.Grille;
import sample.model.Observer.Partie;


public class BatailleController extends BaseController {
    @FXML
    Grille iaGrid;
    @FXML
    Grille playerGrid;
    @FXML
    ListView iaMessage;
    @FXML
    ListView playerMessage;

    private static final String PAUSE_FXML = "../view/vuePause.fxml";

    @FXML
    private Label chrono;

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
        // Configure grids
	    iaGrid.configureButtons(getCurrGame().getIaGrid());
	    playerGrid.configureButtons(getCurrGame().getPlayerGrid());

	    // Initialize les connections entre notifieurs et notifiés
        getCurrGame().attach(iaGrid);
        getCurrGame().attach(playerGrid);
        iaGrid.setSubject(getCurrGame());
        playerGrid.setSubject(getCurrGame());

        // Bind les messages à la list de Partie
        iaMessage.setItems(getCurrGame().getIaMessage());
        playerMessage.setItems(getCurrGame().getPlayerMessage());

	    //creerChrono();
    }

    private void creerChrono() {
        int minutes = 0;
        int secondes = 0;
        int heures = 0;
        int j = 0;

        while (j<10)
        {
            for(int i = 0; i<60; i++)
            {
                secondes++;
                if(secondes == 60)
                {
                    minutes++;
                    secondes = 0;
                }
                if(minutes == 60)
                {
                    heures++;
                    minutes = 0;
                }

                if(secondes < 10)
                {
                    chrono.setText(heures + ":" + minutes + ":0" + secondes);
                }
                else{
                    chrono.setText(heures + ":" + minutes + ":" + secondes);
                }

                if(minutes < 10)
                {
                    chrono.setText(heures + ":0" + minutes + ":" + secondes);
                }
                else{
                    chrono.setText(heures + ":" + minutes + ":" + secondes);
                }

            }

            j++;
        }
    }

    @FXML
    private void pause(ActionEvent actionEvent) throws Exception {
        changeStage(PAUSE_FXML, new PauseController(getStage(), getCurrGame()));
    }

}
