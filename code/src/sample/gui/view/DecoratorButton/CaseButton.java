package sample.gui.view.DecoratorButton;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;



public abstract class CaseButton extends Button {
    protected final int ICON_SIZE = 10;
    protected StackPane icons = new StackPane();

    public CaseButton() {
        super();
        getChildren().add(icons);
    }

    protected abstract void addIcon();
}
