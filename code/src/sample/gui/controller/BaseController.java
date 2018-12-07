package sample.gui.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.launcher.Main;

import java.io.IOException;
import java.net.URL;

import static sample.launcher.Main.WIN_HEIGHT;
import static sample.launcher.Main.WIN_WIDTH;

public abstract class BaseController {
    private Stage stage;

    public BaseController(Stage stage) {
        this.stage = stage;
    }

    protected Stage getStage() {
        return stage;
    }

    public void changeStage(String source, BaseController destController) throws IOException {
        URL url = getClass().getResource(source);
        FXMLLoader loader = new FXMLLoader(url);

        loader.setController(destController);

        Parent root = loader.load();

        getStage().setScene(new Scene(root, WIN_WIDTH, WIN_HEIGHT));
    }

    public void openStage(String source, int width, int height) throws IOException {
        URL url = getClass().getResource(source);

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage newStage = new Stage();

        newStage.setTitle("Infos");
        newStage.setScene(new Scene(root, width, height));
        newStage.showAndWait();

    }
}
