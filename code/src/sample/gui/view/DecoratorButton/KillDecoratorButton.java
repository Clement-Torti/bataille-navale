package sample.gui.view.DecoratorButton;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class KillDecoratorButton extends DecoratorButton {
    public KillDecoratorButton(CaseButton button) {
        super(button);
    }

    @Override
    protected void addIcon() {
        // create the red circle representing a boat
        Rectangle redRect = new Rectangle(ICON_SIZE, ICON_SIZE);
        redRect.setFill(Color.RED);

        icons.getChildren().add(redRect);

    }
}
