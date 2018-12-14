package sample.model;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {


        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Point p = (Point) obj;

        return p.x == this.x && p.y == this.y;
    }
}
