package sample.gui.view.DecoratorButton;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class KillDecoratorButton extends DecoratorButton {
    public KillDecoratorButton(CaseButton button) {
        super(button);
    }

    @Override
    protected void addIcon() {
        // create the red circle representing a boat
        Ellipse greenCircle = new Ellipse(ICON_SIZE / 2, ICON_SIZE / 2);
        greenCircle.setFill(Color.GREEN);

        icons.getChildren().add(greenCircle);

    }
}
