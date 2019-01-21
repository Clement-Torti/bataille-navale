package sample.gui.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import sample.model.Observer.IObserver;

import java.util.ArrayList;
import java.util.List;


public class BoatsBox extends HBox {
    public final int NB_BOATS = 5;
    public final int BOAT_WIDTH = 40;
    public final int BOAT_HEIGHT = 40;

    private List<ImageView> imageViewList = new ArrayList<>();

    private int nbDestroyedBoat = 0;

    public BoatsBox() {
        super();

        Insets insets = new Insets(20, 50, 20, 50);
        this.setPadding(insets);

        // Create 5 boats
        for(int i=0; i<NB_BOATS; i++) {
            Image img = new Image("/images/boat.png");

            ImageView imageV = new ImageView(img);
            imageV.setPreserveRatio(true);
            imageV.setFitWidth(BOAT_WIDTH);
            imageV.setFitHeight(BOAT_HEIGHT);

            imageViewList.add(imageV);
            this.getChildren().add(imageV);
        }
    }

    public void destroyBoat() {
        // Il ne reste aucun bateau
        if(nbDestroyedBoat == NB_BOATS) return;

        // On récupère dans la liste le bateau, à l'indice du nbre de bateaux détruits
        imageViewList.get(nbDestroyedBoat).setImage(new Image("/images/destroyBoat.png"));
        nbDestroyedBoat++;
    }

}
