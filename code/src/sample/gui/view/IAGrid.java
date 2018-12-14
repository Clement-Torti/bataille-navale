package sample.gui.view;

import sample.gui.view.DecoratorButton.*;
import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.ArrayList;

public class IAGrid extends Grille {
    public IAGrid() {
        super();
    }

    @Override
    protected CaseButton configureStandardButton(int x, int y) {
        CaseButton button = new ConcreteCaseButton();
        button.setStyle("fx-background-color: #0");
        return new ConcreteCaseButton();
    }

    @Override
    public void configureButtons(GrilleMdl grille) {
        // Faire toutes les cases découvertes

        // Faire tous les bateaux touchés

        // Faire tous les bateaux coulés

    }
}
