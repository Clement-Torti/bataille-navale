package sample.gui.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sample.gui.view.DecoratorButton.*;
import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.ArrayList;

public class PlayerGrid extends Grille {
    public PlayerGrid() {
        super();
    }

    @Override
    protected CaseButton configureStandardButton(int x, int y) {
        CaseButton button =  new ConcreteCaseButton();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                buttonClicked(x, y);
            }
        });

        return button;
    }

    @Override
    public void configureButtons(GrilleMdl grille) {
        // Faire tous les bateau

        // Faire toutes les cases découvertes

        // Faire tous les bateaux touchés

        // faire tous les bateaux coulés



    }
}
