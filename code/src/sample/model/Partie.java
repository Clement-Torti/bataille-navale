package sample.model;

import sample.gui.view.Grille;
import sample.model.IAStrategie.IA;
import sample.model.IAStrategie.IAFactory;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private int duree;
    private int nbCoup;
    private boolean isPlayerTurn;

    private GrilleMdl iaGrid;
    private GrilleMdl playerGrid;

    private final Difficulty difficulty;

    private IA ia;

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

}
