package sample.model.IAStrategie;

import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.List;
import java.util.Random;

import static java.lang.Integer.max;
import static java.lang.Math.min;

public class MediumIA extends IA {
    // Tire au hasard jusqu'à trouver un bateau, s'acharne dessus ensuite
    @Override
    public Point choseCase(GrilleMdl grille) {
        Random r = new Random();
        Point p = new Point(r.nextInt(10), r.nextInt(10));;
        int trouve = 0;

        // Vérifier si tous les bateaux sont coulés
        for(List<Point> boat: grille.getTouchedBoats()) {
            for(List<Point> destroyedBoat: grille.getDestroyedBoats()) {
                if(boat.containsAll(destroyedBoat)) {
                    trouve = 1;
                    break;
                }
            }

            if(trouve == 1) { trouve = 0; continue;}

            // Pour toutes les cases, chercher une case autour non découverte
            for(Point point: boat) {
                if(!grille.getDiscovered().contains(new Point(point.x, max(point.y - 1, 0))) ) {
                    return new Point(point.x, max(point.y - 1, 0));

                } else if(!grille.getDiscovered().contains(new Point(min(point.x+1, 9), max(point.y - 1, 0)))) {
                    return new Point(min(point.x+1, 9), max(point.y - 1, 0));

                } else if(!grille.getDiscovered().contains(new Point(min(point.x+1, 9), point.y))) {
                    return new Point(min(point.x+1, 9), point.y);

                } else if(!grille.getDiscovered().contains(new Point(min(point.x+1, 9), min(point.y + 1, 9)))) {
                    return new Point(min(point.x+1, 9), min(point.y + 1, 9));

                } else if(!grille.getDiscovered().contains(new Point(point.x, min(point.y + 1, 9)))) {
                    return new Point(point.x, min(point.y + 1, 9));

                } else if(!grille.getDiscovered().contains(new Point(max(point.x-1, 0), min(point.y + 1, 9)))) {
                    return new Point(max(point.x-1, 0), min(point.y + 1, 9));

                } else if(!grille.getDiscovered().contains(new Point(max(point.x-1, 0), point.y))) {
                    return new Point(max(point.x-1, 0), point.y);

                } else if(!grille.getDiscovered().contains(new Point(max(point.x, 0), max(point.y - 1, 0)))) {
                    return new Point(max(point.x, 0), max(point.y - 1, 0));
                }
            }
        }


        while(grille.getDiscovered().contains(p)) {
            p = new Point(r.nextInt(10), r.nextInt(10));
        }


        return p;
    }
}
