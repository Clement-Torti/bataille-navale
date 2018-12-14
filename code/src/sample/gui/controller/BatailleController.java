package sample.gui.controller;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.launcher.Main;

import java.net.URL;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.ChronoZonedDateTime;
import java.util.concurrent.TimeUnit;


public class BatailleController extends BaseController {
    @FXML
    Grille iaGrid;
    @FXML
    Grille playerGrid;

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
	//iaGrid.configureButtons(getCurrGame().getIaGrid());
        
	creerChrono();
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
