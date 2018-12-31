package sample.gui.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sample.gui.view.BoatsBox;
import sample.gui.view.Grille;
import sample.model.Observer.IObserver;
import sample.model.Observer.Partie;
import sample.model.Util.SoundBox;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class BatailleController extends BaseController implements IObserver {
    @FXML
    Grille iaGrid;
    @FXML
    Grille playerGrid;
    @FXML
    ListView iaMessage;
    @FXML
    ListView playerMessage;
    @FXML
    BoatsBox iaBoatsBox;
    @FXML
    BoatsBox playerBoatsBox;
    @FXML
    private Label chrono;

    private static final String PAUSE_FXML = "../view/vuePause.fxml";
    private static final String FIN_FXML = "../view/vueFin.fxml";

    private Timer timer;

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
        SoundBox.playBackgroundMusic();

        // Configure grids
	    iaGrid.configureButtons(getCurrGame().getIaGrid());
	    playerGrid.configureButtons(getCurrGame().getPlayerGrid());

	    // Initialize les connections entre notifieurs et notifiés
        getCurrGame().attach(iaGrid);
        getCurrGame().attach(playerGrid);
        getCurrGame().attach(this);
        iaGrid.setSubject(getCurrGame());
        playerGrid.setSubject(getCurrGame());


        // Bind les messages à la list de Partie
        iaMessage.setItems(getCurrGame().getIaMessage());
        playerMessage.setItems(getCurrGame().getPlayerMessage());

        // Initialisation du timer
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                getCurrGame().addOneSec();

                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        String duree = getCurrGame().getDuree() + " sec.";
                        chrono.setText(duree);
                    }
                };

                Platform.runLater(run);

            }
        };
        timer.scheduleAtFixedRate(task, 0l, 1000l);
    }


    @FXML
    private void pause(ActionEvent actionEvent) throws Exception {
        // Arret du timer
        timer.cancel();

        changeStage(PAUSE_FXML, new PauseController(getStage(), getCurrGame()));
    }

    private void finish() {
        // Arret du timer
        timer.cancel();

        try {
            changeStage(FIN_FXML, new FinController(getStage(), getCurrGame()));
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void update(){
        // Vérifie si la partie est fini
        if(getCurrGame().getWinner() != -1) {
            finish();
        }

        // Verifie si un bateau est détruit
        if(getCurrGame().getState()!=2) return;

        // Met à jour la bonne boatsBox
        if(getCurrGame().isPlayerTurn()) {
            iaBoatsBox.destroyBoat();
        } else {
            playerBoatsBox.destroyBoat();
        }
    }


}
