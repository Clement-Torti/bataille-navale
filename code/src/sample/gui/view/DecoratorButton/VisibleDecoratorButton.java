package sample.gui.view.DecoratorButton;

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
        Rectangle blueRect = new Rectangle(ICON_SIZE, ICON_SIZE);
        blueRect.setFill(Color.BLUE);

        icons.getChildren().add(blueRect);

    }
}
