package sample.gui.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import sample.model.Observer.IObserver;


public class BoatsBox extends HBox {
    public final int NB_BOATS = 5;
    public final int BOAT_WIDTH = 50;
    public final int BOAT_HEIGHT = 50;

    public BoatsBox() {
        super();

        Insets insets = new Insets(0, 50, 0, 50);
        this.setPadding(insets);

        // Create 5 boats
        for(int i=0; i<NB_BOATS; i++) {
            Image img = new Image("/images/boat.png");

            ImageView imageV = new ImageView(img);
            imageV.setPreserveRatio(true);
            imageV.setFitWidth(BOAT_WIDTH);
            imageV.setFitHeight(BOAT_HEIGHT);

            this.getChildren().add(imageV);
        }
    }

}
