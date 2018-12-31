package sample.model;

public class Score implements Comparable {


    private int pos;
    private String name;
    private String duree;
    private int nbCoup;

    public Score(String name, String duree, int nbCoup) {
        this(0, name, duree, nbCoup);
    }

    public Score(int pos, String name, String duree, int nbCoup) {
        this.pos = pos;
        this.name = name;
        this.duree = duree;
        this.nbCoup = nbCoup;
    }

    public void setPos(int pos) { this.pos = pos;}

    public String getName() {
        return name;
    }

    public String getDuree() {
        return duree;
    }

    public int getNbCoup() {
        return nbCoup;
    }

    public int getPos() {
        return pos;
    }


    @Override
    public String toString() {
        return pos + "    " + name + "    " + duree + "    " + nbCoup + " coups.";
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) return 0;

        Score score = (Score) o;

        return score.getNbCoup() - this.getNbCoup();
    }
}
