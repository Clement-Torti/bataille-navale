package sample.gui.view;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Grille extends GridPane {
    private final int nbRow = 11;
    private final int nbColumn = 11;

    public Grille() {
        super();

        // Création de toutes les colonnes
        for(int i=0; i<nbColumn; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100/nbColumn);
            this.getColumnConstraints().add(col);
        }

        // Création de toutes les lignes
        for(int i=0; i<nbRow; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(this.getColumnConstraints().get(i).getPercentWidth());
            this.getRowConstraints().add(row);
        }

        // Ajout des labels (0, 1, 2 ..)
        for(int i=1; i<nbColumn; i++) {
            Label l = new Label();
            l.setText(Integer.toString(i -1));
            this.add(l, i, 0);
        }

        // Ajout des labels (A, B ...)
        for(int i=0; i<nbRow; i++) {
            Label l = new Label();
            String text = "" + ((char)('A' + i));
            l.setText(text);
            this.add(l, 0, i+1);
        }

    }
}
