package sample.gui.view;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import sample.gui.controller.BaseController;
import sample.gui.controller.BatailleController;
import sample.gui.view.DecoratorButton.CaseButton;
import sample.gui.view.DecoratorButton.ChoseDecoratorButton;
import sample.gui.view.DecoratorButton.KillDecoratorButton;
import sample.gui.view.DecoratorButton.TouchedDecoratorButton;
import sample.model.GrilleMdl;
import sample.model.Observer.IObserver;
import sample.model.Observer.Subject;
import sample.model.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class Grille extends GridPane implements IObserver {
    protected final int NB_ROW = 11;
    protected final int NB_COLUMN = 11;
    protected final int WIDHT = 600;
    protected final int HEIGHT = 600;

    protected Subject subject;

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
                this.add(buttonList[i][j], i + 1, j + 1);

            }
        }
    }

    protected abstract CaseButton configureStandardButton(int x, int y);

    public abstract void configureButtons(GrilleMdl grille);

    public void setSubject(Subject s) {
        this.subject = s;
    }

    @Override
    public void update() {
        Point p = subject.getCoordinate();
        CaseButton oldBtn = buttonList[p.x][p.y];
        CaseButton newBtn;

        switch(subject.getState()) {
            case -1:
                return;
            case 0:
                newBtn = new ChoseDecoratorButton(oldBtn);
                break;
            case 1:
                newBtn = new TouchedDecoratorButton(oldBtn);
                break;
            case 2:
                // Récupérer toutes les cases des bateaux
                List<Point> boat = subject.getBoat(p, !subject.isPlayerTurn());

                for (Point point : boat) {
                    CaseButton oldB = buttonList[point.x][point.y];
                    this.getChildren().remove(oldB);
                    CaseButton newB = new KillDecoratorButton(oldB);
                    newB.setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);
                    this.add(newB, point.x + 1, point.y + 1);
                }

                return;
            default:
                System.out.println("Erreur lors du clicked button");
                return;
        }


        this.getChildren().remove(oldBtn);
        newBtn.setPrefSize(WIDHT/NB_ROW, WIDHT/NB_COLUMN);

        this.add(newBtn, p.x + 1, p.y + 1);
    }
}
