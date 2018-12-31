package sample.model.Observer;

import sample.model.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<IObserver> observers = new ArrayList<IObserver>();
    protected boolean isPlayerTurn = true;
    protected int state = 0;
    protected Point coordinate;

    public void attach(IObserver o) {
        observers.add(o);
    }

    public boolean detach(IObserver o) {
        return observers.remove(o);
    }

    public void notifier() {
        System.out.println("call notifier");
        for (IObserver o: observers) {
            o.update();
        }
    }

    public boolean isPlayerTurn() { return isPlayerTurn; }
    public int getState() { return state; }
    public Point getCoordinate() { return coordinate; }
    public abstract List<Point> getBoat(Point p, boolean isPlayerGrid);

    public abstract void updatePartie(int x, int y);
}






















