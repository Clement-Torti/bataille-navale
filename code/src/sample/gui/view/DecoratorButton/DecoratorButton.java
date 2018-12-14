package sample.gui.view.DecoratorButton;

public abstract class DecoratorButton extends CaseButton {
    protected CaseButton button;

    public DecoratorButton(CaseButton button) {
        super();
        this.button = button;
        icons = button.icons;
        addIcon();
        setGraphic(icons);
    }

}
