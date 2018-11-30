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

import java.net.URL;


public class AccueilController extends BaseController {

    private static final String BATAILLE_FXML = "../view/vueBataille.fxml";

    public AccueilController(Stage stage) {
        super(stage);
    }

    @FXML
    private void start(ActionEvent actionEvent) throws Exception {
        URL url = getClass().getResource(BATAILLE_FXML);
        FXMLLoader loader = new FXMLLoader(url);

        loader.setController(new BatailleController(stage));

        Parent root = loader.load();

        stage.setScene(new Scene(root, Main.WIN_WIDTH, Main.WIN_HEIGHT));
    }

    @FXML
    private void infos(ActionEvent actionEvent) {

    }
}
