package sample.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.gui.controller.AccueilController;

import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {

    public static final int WIN_WIDTH = 1000;
    public static final int WIN_HEIGHT = 600;
    private static final String ACCUEIL_FXML = "../gui/view/vueAccueil.fxml";


    @Override
    public void start(Stage primaryStage) throws Exception {

        URL url = getClass().getResource(ACCUEIL_FXML);

        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(new AccueilController(primaryStage));
        Parent root = loader.load();

        primaryStage.setTitle("Bataille Navale");
        primaryStage.setScene(new Scene(root, WIN_WIDTH, WIN_HEIGHT));
        primaryStage.setMinWidth(WIN_WIDTH+16);
        primaryStage.setMinHeight(WIN_HEIGHT+39);
        //primaryStage.getIcons().setAll(new Image(getClass().getResource("images/logo.png").toExternalForm()));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        // Enregistrement de la partie en cours
    }
}
