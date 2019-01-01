package sample.gui.view.DecoratorButton;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class VisibleDecoratorButton extends DecoratorButton {
    public VisibleDecoratorButton(CaseButton button) {
        super(button);
    }

    @Override
    protected void addIcon() {
        // create the red circle representing a boat
        Image img = new Image("/images/boatIcon.png");

        ImageView imgV = new ImageView(img);
        imgV.setFitWidth(ICON_SIZE);
        imgV.setFitHeight(ICON_SIZE);
        imgV.setPreserveRatio(true);

        icons.getChildren().add(imgV);

    }
}
