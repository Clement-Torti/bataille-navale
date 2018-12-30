package sample.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;

public class GrilleMdl {

    private List<ArrayList<Point>> boats;
    private List<ArrayList<Point>> touchedBoats;
    private List<ArrayList<Point>> destroyedBoats;
    private List<Point> discovered;

    public GrilleMdl(List<ArrayList<Point>> boats) {
        this(boats, new ArrayList<ArrayList<Point>>(), new ArrayList<ArrayList<Point>>(), new ArrayList<Point>());
    }

    public GrilleMdl(List<ArrayList<Point>> boats, List<ArrayList<Point>> touchedBoats, List<ArrayList<Point>> destroyedBoats, List<Point> discovered) {
        this.boats = boats;
        this.touchedBoats = touchedBoats;
        this.destroyedBoats = destroyedBoats;
        this.discovered = discovered;
    }

    public List<ArrayList<Point>> getBoats() { return boats; }

    public List<ArrayList<Point>> getTouchedBoats() { return touchedBoats; }

    public List<ArrayList<Point>> getDestroyedBoats() { return destroyedBoats; }

    public List<Point> getDiscovered() { return discovered; }


    public int discover(int x, int y) {
        Point p = new Point(x, y);
        discovered.add(p);

        // On veut savoir si la case contient un bateau
        for(ArrayList<Point> boat: boats) {
            if(boat.contains(p)) {

                // On cherche à quelle bateau la case appartient
                for(ArrayList<Point> tBoat: touchedBoats) {
                    // On a trouvé le bateau, on lui ajoute la case decouverte
                    if(boat.containsAll(tBoat)) {
                        tBoat.add(p);

                        // Si le bateau à été détruit
                        if(tBoat.containsAll(boat)) {
                            destroyedBoats.add(tBoat);
                            return 2;
                        } else {
                            return 1;
                        }

                    }
                }

                // Le bout de bateau vient d'être découvert
                ArrayList<Point> tBoat = new ArrayList<Point>();
                tBoat.add(p);
                touchedBoats.add(tBoat);
                return 1;

            }
        }

        return 0;
    }

    public boolean isWin() {
        return destroyedBoats.size() == boats.size();
    }

}
