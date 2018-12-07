package sample.gui.view;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public abstract class Grille extends GridPane {
    private final int NB_ROW = 11;
    private final int NB_COLUMN = 11;
    private final int WIDHT = 450;
    private final int HEIGHT = 450;

    public Grille() {
        super();

        // Création de toutes les colonnes
        for(int i=0; i<NB_COLUMN; i++) {
            ColumnConstraints col = new ColumnConstraints(20, WIDHT / NB_COLUMN, 50);

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
                String text = i + "," + j;
                CaseButton button = new CaseButton(text);
                this.add(button, j + 1, i + 1);
            }
        }

    }
}
