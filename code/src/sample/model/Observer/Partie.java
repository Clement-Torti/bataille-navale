package sample.model.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.gui.view.Grille;
import sample.model.Difficulty;
import sample.model.GrilleMdl;
import sample.model.IAStrategie.IA;
import sample.model.IAStrategie.IAFactory;
import sample.model.Point;

import java.util.ArrayList;
import java.util.List;

public class Partie extends Subject {
    private int duree;
    private int nbCoup;
    private int winner;

    private GrilleMdl iaGrid;
    private GrilleMdl playerGrid;

    private final Difficulty difficulty;

    private IA ia;

    private ObservableList<String> iaMessage = FXCollections.observableArrayList();
    private ObservableList<String> playerMessage = FXCollections.observableArrayList();

    public Partie(Difficulty d) {
        this(null, null, d);
        initializeGrids();
    }

    public Partie(GrilleMdl iaGrid, GrilleMdl playerGrid, Difficulty d) {
        this.duree = 0;
        this.nbCoup = 0;
        this.isPlayerTurn = true;

        this.iaGrid = iaGrid;
        this.playerGrid = playerGrid;

        this.difficulty = d;

        this.ia = IAFactory.createIA(d);

    }

    private void initializeGrids() {
        List<ArrayList<Point>> boats = generateRandomPos();
        iaGrid = new GrilleMdl(boats);

        boats = generateRandomPos();
        playerGrid = new GrilleMdl(boats);
    }

    private List<ArrayList<Point>> generateRandomPos() {
        List<ArrayList<Point>> boats = new ArrayList<ArrayList<Point>>();

        ArrayList<Point> boat1 = new ArrayList<Point>();
        boat1.add(new Point(0, 0));
        boat1.add(new Point(1, 0));

        ArrayList<Point> boat2 = new ArrayList<Point>();
        boat2.add(new Point(0, 2));
        boat2.add(new Point(1, 2));
        boat2.add(new Point(2, 2));

        boats.add(boat1);
        boats.add(boat2);

        return boats;
    }

    public GrilleMdl getIaGrid() {
        return iaGrid;
    }

    public GrilleMdl getPlayerGrid() {
        return playerGrid;
    }

    @Override
    public void updatePartie(int x, int y) {

        this.coordinate = new Point(x, y);

        if(isPlayerTurn) {
            // Mettre à jour les infos de partie
            nbCoup++;

            // Mettre  à jour la grille
            this.state = iaGrid.discover(coordinate.x, coordinate.y);

            // Ajouter le message
            addMessage(state, coordinate, playerMessage);

            // Vérifier si c'est gagné
            if(iaGrid.isWin()) {
                winner = 0;
                stopPartie();
            }

        } else {
            this.state = playerGrid.discover(coordinate.x, coordinate.y);

            // Ajouter le message
            addMessage(state, coordinate, iaMessage);

            // Vérifier si c'est gagné
            if(playerGrid.isWin()) {
                winner = 1;
                stopPartie();
            }
        }

        // Patron observateur, mettre  à jour la vue
        notifier();

        // Changer le rôle
        isPlayerTurn = !isPlayerTurn;

        // C'est au tour de l'IA
        if(!isPlayerTurn) {
            Point p = ia.choseCase(playerGrid);
            updatePartie(p.x, p.y);
        }

    }

    private void stopPartie() {
        System.out.println("partie terminer");
    }

    @Override
    public List<Point> getBoat(Point p, boolean isPlayerGrid) {
        List<ArrayList<Point>> boats = isPlayerGrid ? playerGrid.getBoats() : iaGrid.getBoats();
        for(List<Point> boat: boats) {
            if(boat.contains(p)) {
                return boat;
            }
        }

        return null;
    }

    public ObservableList<String> getIaMessage() {
        return iaMessage;
    }

    public ObservableList<String> getPlayerMessage() {
        return playerMessage;
    }

    private void addMessage(int state, Point coordinate, ObservableList<String> list) {
        switch(state) {
            case 0:
                list.add("(" + coordinate.x + "-" + coordinate.y + "): Manqué");
                break;
            case 1:
                list.add("(" + coordinate.x + "-" + coordinate.y + "): Touché");
                break;
            case 2:
                list.add("(" + coordinate.x + "-" + coordinate.y + "): Coulé");
                break;
            default:
                System.out.println("switch innatendu dans addMessage: Partie.java");
        }
    }


}
