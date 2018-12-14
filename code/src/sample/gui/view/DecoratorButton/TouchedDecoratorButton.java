package sample.gui.view.DecoratorButton;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class TouchedDecoratorButton extends DecoratorButton {
    public TouchedDecoratorButton(CaseButton button) {
        super(button);
    }

    @Override
    protected void addIcon() {
        // create the red circle representing a boat
        Ellipse redCircle = new Ellipse(ICON_SIZE / 2, ICON_SIZE / 2);
        redCircle.setFill(Color.RED);

        icons.getChildren().add(redCircle);

    }
}
