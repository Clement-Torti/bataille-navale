package sample.model.Util;

import sample.model.Score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScoreReader {
    private String file;
    private final String separator = "//";

    public ScoreReader(String filePath) {
        this.file = filePath;
    }

    public List<Score> getScores() {
        List<Score> scores = new ArrayList<>();

        try {
            File f = new File(file);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;

            // Tant que l'on peut lire une ligne
            while((line = br.readLine()) != null) {
                scores.add(format(line));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return scores;

    }

    private Score format(String line) {
        String[] split = line.split("//");

        int pos= Integer.parseInt(split[0]);
        String name = split[1];
        String duree = split[2];
        int nbCoup = Integer.parseInt(split[3]);

        return new Score(pos, name, duree, nbCoup);
    }

}
