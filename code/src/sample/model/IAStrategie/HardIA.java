package sample.model.IAStrategie;

import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.List;
import java.util.Random;

public class HardIA extends IA {
    // Choisie une bonne case avec 50% de chance
    @Override
    public Point choseCase(GrilleMdl grille) {
        Random r = new Random();
        Point p = new Point(r.nextInt(10), r.nextInt(10));

        if(r.nextInt(2) == 0) {
            // Choix d'une bonne case non découverte
            for(List<Point> boat : grille.getBoats()) {
                for(Point point: boat) {
                    if(!grille.getDiscovered().contains(point)) {
                        return point;
                    }
                }
            }
        }

        // Sinon choix d'une case aléatoire
        while(grille.getDiscovered().contains(p)) {
            p = new Point(r.nextInt(10), r.nextInt(10));
        }

        return p;
    }
}
