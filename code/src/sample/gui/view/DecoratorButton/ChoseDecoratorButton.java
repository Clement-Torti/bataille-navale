package sample.gui.view.DecoratorButton;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class ChoseDecoratorButton extends DecoratorButton {
    public ChoseDecoratorButton(CaseButton button) {
        super(button);
    }

    @Override
    protected void addIcon() {
        // create the red circle representing a boat
        Ellipse blackCircle = new Ellipse(ICON_SIZE / 2, ICON_SIZE / 2);
        blackCircle.setFill(Color.BLACK);

        icons.getChildren().add(blackCircle);

    }
}
