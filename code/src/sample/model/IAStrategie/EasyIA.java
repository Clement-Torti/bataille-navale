package sample.model.IAStrategie;

import sample.model.GrilleMdl;
import sample.model.Point;

import java.util.Random;

public class EasyIA extends IA {
    @Override
    public Point choseCase(GrilleMdl grille) {
        Random r = new Random();
        return new Point(r.nextInt(9), r.nextInt(9));
    }
}
