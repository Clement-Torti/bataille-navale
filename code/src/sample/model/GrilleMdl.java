package sample.model;

import java.util.ArrayList;
import java.util.List;

public class GrilleMdl {

    private List<ArrayList<Point>> boats;
    private List<ArrayList<Point>> destroyedBoats;
    private List<Point> discovered;

    public GrilleMdl(List<ArrayList<Point>> boats) {
        this(boats, new ArrayList<ArrayList<Point>>(), new ArrayList<Point>());
    }

    public GrilleMdl(List<ArrayList<Point>> boats, List<ArrayList<Point>> destroyedBoats, List<Point> discovered) {
        this.boats = boats;
        this.destroyedBoats = destroyedBoats;
        this.discovered = discovered;
    }

    public List<ArrayList<Point>> getBoats() {
        return boats;
    }

    public List<ArrayList<Point>> getDestroyedBoats() {
        return destroyedBoats;
    }

    public List<Point> getDiscovered() {
        return discovered;
    }
}
