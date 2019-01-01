package sample.gui.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sample.gui.view.DecoratorButton.*;
import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PlayerGrid extends Grille {
    public PlayerGrid() {
        super();
    }

    @Override
    protected CaseButton configureStandardButton(int x, int y) {
        CaseButton button =  new ConcreteCaseButton();

        return button;
    }

    @Override
    public void configureButtons(GrilleMdl grille) {
        // Faire tous les bateaux
        for (List<Point> boat: grille.getBoats()) {
            for (Point p: boat) {
                this.getChildren().remove(buttonList[p.x][p.y]);
                buttonList[p.x][p.y] = new VisibleDecoratorButton(buttonList[p.x][p.y]);
                buttonList[p.x][p.y].setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);
                this.add(buttonList[p.x][p.y], p.x + 1, p.y + 1);
            }
        }

        // Faire toutes les cases découvertes
        for (Point p: grille.getDiscovered()) {
            this.getChildren().remove(buttonList[p.x][p.y]);
            buttonList[p.x][p.y] = new ChoseDecoratorButton(buttonList[p.x][p.y]);
            buttonList[p.x][p.y].setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);
            this.add(buttonList[p.x][p.y], p.x + 1, p.y + 1);
        }

        // Faire tous les bateaux touchés
        for (List<Point> boat: grille.getTouchedBoats()) {
            for (Point p: boat) {
                this.getChildren().remove(buttonList[p.x][p.y]);
                buttonList[p.x][p.y] = new TouchedDecoratorButton(buttonList[p.x][p.y]);
                buttonList[p.x][p.y].setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);
                this.add(buttonList[p.x][p.y], p.x + 1, p.y + 1);
            }
        }

        // faire tous les bateaux coulés
        for (List<Point> boat: grille.getDestroyedBoats()) {
            for (Point p: boat) {
                this.getChildren().remove(buttonList[p.x][p.y]);
                buttonList[p.x][p.y] = new KillDecoratorButton(buttonList[p.x][p.y]);
                buttonList[p.x][p.y].setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);
                this.add(buttonList[p.x][p.y], p.x + 1, p.y + 1);
            }
        }

    }

    @Override
    public void update() {
        if(!subject.isPlayerTurn()) {
            super.update();
        }

    }
}
