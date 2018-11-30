package sample.gui.controller;

import javafx.stage.Stage;

public abstract class BaseController {
    Stage stage;

    public BaseController(Stage stage) {
        this.stage = stage;
    }
}
