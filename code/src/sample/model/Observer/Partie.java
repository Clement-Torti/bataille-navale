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
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Partie extends Subject {
    private int duree;
    private int nbCoup;
    private int winner = -1;

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
        // 5 bateaux au total
        // 1 porte avion (5 cases)
        // 1 croiseur (4 cases)
        // 1 contre torpilleur (3 cases)
        // 1 sous-marin (3 cases)
        // 1 torpilleur (2 cases)
        Random r = new Random();
        List<ArrayList<Point>> boats = new ArrayList<ArrayList<Point>>();
        List<Point> chosedPoints = new ArrayList<>();
        int[] boatsSize = {5, 4, 3, 3, 2};

        // Pour tous les tableaux
        for(int j=0; j<boatsSize.length; j++) {
            int size = boatsSize[j];

            // Création du bateau
            ArrayList<Point> porteAvion = new ArrayList<>();

            // Choix d'un premier point valide
            Point p = new Point(r.nextInt(10), r.nextInt(10));
            while(chosedPoints.contains(p)) { p = new Point(r.nextInt(10), r.nextInt(10)); }
            chosedPoints.add(p);
            porteAvion.add(p);

            // Choix de l'orientation
            boolean vertical = r.nextBoolean();

            int leftDownOffset = 1;
            // Conserve le nombre de case ayant pu etre créer pour un bateau
            int i;

            for(i=1; i<size; i++) {
                if(vertical) {
                    if(!chosedPoints.contains(new Point(p.x, min(p.y+i, 9)))) {
                        Point newP = new Point(p.x, min(p.y+i, 9));
                        chosedPoints.add(newP);
                        porteAvion.add(newP);
                        continue;
                    }

                    if(!chosedPoints.contains(new Point(p.x, max(p.y-leftDownOffset, 0)))) {
                        Point newP = new Point(p.x, max(p.y-leftDownOffset, 0));
                        leftDownOffset++;
                        chosedPoints.add(newP);
                        porteAvion.add(newP);
                        continue;
                    }

                    break;

                } else {
                    if(!chosedPoints.contains(new Point(min(p.x+i, 9), p.y))) {
                        Point newP = new Point(min(p.x+i, 9), p.y);
                        chosedPoints.add(newP);
                        porteAvion.add(newP);
                        continue;
                    }

                    if(!chosedPoints.contains(new Point(max(p.x-leftDownOffset, 0), p.y))) {
                        Point newP = new Point(max(p.x-leftDownOffset, 0), p.y);
                        chosedPoints.add(newP);
                        porteAvion.add(newP);
                        leftDownOffset++;
                        continue;
                    }

                    break;

                }
            }

            // Le bateau n'a pas pu être créer correctement
            if(i != size) {
                // On recommence
                j--;
            } else {
                boats.add(porteAvion);
            }

        }


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
        // Vérifier que la partie n'est pas fini
        if(winner != -1) { return; }

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
            }

        } else {
            this.state = playerGrid.discover(coordinate.x, coordinate.y);

            // Ajouter le message
            addMessage(state, coordinate, iaMessage);

            // Vérifier si c'est gagné
            if(playerGrid.isWin()) {
                winner = 1;
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

    public void addOneSec() { this.duree++; }

    public int getWinner() { return winner; }
    public int getDuree() { return duree; }
    public int getNbCoup() { return nbCoup; }

}
