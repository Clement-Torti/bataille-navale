package sample.model.IAStrategie;

import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.Random;

public class EasyIA extends IA {
    // Choix d'une case aléatoire non encore découverte
    @Override
    public Point choseCase(GrilleMdl grille) {
        Random r = new Random();
        Point p = new Point(r.nextInt(10), r.nextInt(10));

        while(grille.getDiscovered().contains(p)) {
            p = new Point(r.nextInt(10), r.nextInt(10));
        }

        return p;
    }
}
