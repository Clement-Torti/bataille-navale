package sample.gui.view.DecoratorButton;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class KillDecoratorButton extends DecoratorButton {
    public KillDecoratorButton(CaseButton button) {
        super(button);
    }

    @Override
    protected void addIcon() {
        // create the red circle representing a boat
        Image img = new Image("/images/explosionIcon.gif");

        ImageView imgV = new ImageView(img);
        imgV.setFitWidth(ICON_SIZE);
        imgV.setFitHeight(ICON_SIZE);
        imgV.setPreserveRatio(true);

        Rectangle rect = new Rectangle(ICON_SIZE, ICON_SIZE);
        rect.setFill(Color.WHITE);

        icons.getChildren().add(rect);
        icons.getChildren().add(imgV);

    }
}
