package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.launcher.Main;

import java.io.IOException;
import java.net.URL;


public class AccueilController extends BaseController {

    private static final String BATAILLE_FXML = "../view/vueBataille.fxml";
    private static final String INFOS_FXML = "../view/vueInfos.fxml";

    public AccueilController(Stage stage) {
        super(stage);
    }

    @FXML
    private void start(ActionEvent actionEvent) throws Exception {
        changeStage(BATAILLE_FXML, new BatailleController(getStage()));
    }

    @FXML
    private void infos(ActionEvent actionEvent) throws IOException {
        openStage(INFOS_FXML, 800, 500);
    }
}
