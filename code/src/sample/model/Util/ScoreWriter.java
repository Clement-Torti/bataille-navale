package sample.model.Util;

import sample.model.Score;
import sample.model.Util.ScoreReader;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ScoreWriter {
    private String file;

    public ScoreWriter(String file) {
        this.file = file;
    }

    public void insertScore(Score score) {
        ScoreReader reader = new ScoreReader(file);
        List<Score> scores = reader.getScores();
        int pos = 0;
        int i = 0;

        while(score.compareTo(scores.get(i)) < 0) { i++; }

        score.setPos(i);
        scores.add(i, score);

        // Ajouter 1 à tous les scores d'après
        for(int j=i+1; j<scores.size(); j++) {
            scores.get(j).setPos(scores.get(j).getPos() + 1);
        }

        writeToFile(scores);
    }

    private void writeToFile(List<Score> scores) {
        try {
            File f = new File(file);
            FileWriter fw = new FileWriter(f);

            int i = 1;

            for(Score s: scores) {
                fw.write(String.format("%d//%s//%s//%d",i, s.getName(), s.getDuree(), s.getNbCoup()));
                fw.write(System.lineSeparator());
                i++;
            }
            fw.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
