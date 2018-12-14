package sample.gui.view;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import sample.gui.view.DecoratorButton.CaseButton;
import sample.gui.view.DecoratorButton.TouchedDecoratorButton;
import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.ArrayList;

public abstract class Grille extends GridPane {
    protected final int NB_ROW = 11;
    protected final int NB_COLUMN = 11;
    private final int WIDHT = 600;
    private final int HEIGHT = 600;

    // List des button de la grille
    protected CaseButton[][] buttonList = new CaseButton[10][10];

    public Grille() {
        super();

        // Création de toutes les colonnes
        for(int i=0; i<NB_COLUMN; i++) {
            ColumnConstraints col = new ColumnConstraints(20, WIDHT / NB_COLUMN, 100);

            this.getColumnConstraints().add(col);
        }

        // Création de toutes les lignes
        for(int i = 0; i< NB_ROW; i++) {
            RowConstraints row = new RowConstraints(20, HEIGHT / NB_ROW, 50);
            this.getRowConstraints().add(row);
        }

        // Ajout des labels (0, 1, 2 ..)
        for(int i=1; i<NB_COLUMN; i++) {
            Label l = new Label();
            l.setText(Integer.toString(i -1));
            this.add(l, i, 0);
        }

        // Ajout des labels (A, B ...)
        for(int i = 0; i< NB_ROW-1; i++) {
            Label l = new Label();
            String text = "" + ((char)('A' + i));
            l.setText(text);
            this.add(l, 0, i+1);
        }

        // Ajout des buttons
        for(int i=0; i<NB_ROW-1; i++) {
            for(int j=0; j<NB_COLUMN-1; j++) {
                // Méthode abstraite implémentée par les filles
                buttonList[i][j] = configureStandardButton(i, j);

                buttonList[i][j].setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);
                this.add(buttonList[i][j], j + 1, i + 1);

            }
        }
    }

    protected abstract CaseButton configureStandardButton(int x, int y);

    protected void buttonClicked(int x, int y) {
        this.getChildren().remove(buttonList[x][y]);
        buttonList[x][y] = new TouchedDecoratorButton(buttonList[x][y]);
        buttonList[x][y].setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);

        this.add(buttonList[x][y], y + 1, x + 1);
    }

    public abstract void configureButtons(GrilleMdl grille);


}
