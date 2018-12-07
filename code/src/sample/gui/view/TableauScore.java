package sample.gui.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TableauScore extends GridPane {

    private final int NB_COLUMN = 4;
    private final int NB_ROW = 4;

    public TableauScore()
    {
        super();

        // Création de toutes les colonnes
        for(int i = 0; i< NB_COLUMN; i++)
        {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100/ NB_COLUMN);
            this.getColumnConstraints().add(col);
        }


        // Création de toutes les lignes
        for(int i = 0; i< NB_ROW; i++)
        {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(200/ NB_ROW);
            this.getRowConstraints().add(row);
        }


        // Noms des colonnes
        Label l = new Label("Place");
        l.setPadding(new Insets(10));
        this.add(l, 0, 0);

        Label l2 = new Label("Nom");
        l2.setPadding(new Insets(10));
        this.add(l2, 1, 0);

        Label l3 = new Label("Coups");
        l3.setPadding(new Insets(10));
        this.add(l3, 2, 0);

        Label l4 = new Label("Temps");
        l4.setPadding(new Insets(10));
        this.add(new Label("Temps"), 3, 0);



        //  1 ligne test
        Label ll = new Label("Ligne 1");
        ll.setPadding(new Insets(10));
        this.add(ll, 0, 1);

    }
}
