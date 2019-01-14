package sample.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;

public class GrilleMdl {

    private List<List<Point>> boats;
    private List<List<Point>> touchedBoats;
    private List<List<Point>> destroyedBoats;
    private List<Point> discovered;

    public GrilleMdl(List<List<Point>> boats) {
        this(boats, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public GrilleMdl(List<List<Point>> boats, List<List<Point>> touchedBoats, List<List<Point>> destroyedBoats, List<Point> discovered) {
        this.boats = boats;
        this.touchedBoats = touchedBoats;
        this.destroyedBoats = destroyedBoats;
        this.discovered = discovered;
    }

    public List<List<Point>> getBoats() { return boats; }

    public List<List<Point>> getTouchedBoats() { return touchedBoats; }

    public List<List<Point>> getDestroyedBoats() { return destroyedBoats; }

    public List<Point> getDiscovered() { return discovered; }


    public int discover(int x, int y) {
        Point p = new Point(x, y);
        discovered.add(p);

        // On veut savoir si la case contient un bateau
        for(List<Point> boat: boats) {
            if(boat.contains(p)) {

                // On cherche à quelle bateau la case appartient
                for(List<Point> tBoat: touchedBoats) {
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
                List<Point> tBoat = new ArrayList<>();
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
