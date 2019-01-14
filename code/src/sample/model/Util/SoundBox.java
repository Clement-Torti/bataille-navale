package sample.model.Util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundBox {
    private static MediaPlayer backgroundPlayer;
    private static MediaPlayer bruitagePlayer;

    public static void playDiscoverSound() {
        playBruitage("resources/audio/discoverSound.wav");
    }

    public static void playTouchedSound() {
        playBruitage("resources/audio/touchedSound.wav");
    }

    public static void playDestroyedSound() {
        playBruitage("resources/audio/destroyedSound.wav");
    }

    public static void playButtonClickSound() {
        playBruitage("resources/audio/bipSound.wav");
    }

    private static void playBruitage(String musicFile) {
        File f = new File(musicFile);
        Media sound = new Media(f.toURI().toString());

        bruitagePlayer = new MediaPlayer(sound);
        bruitagePlayer.setVolume(0.15);
        bruitagePlayer.play();

    }

    private static void playBackgroundMusic(String musicFile) {
        if(backgroundPlayer != null) { return; }
        File f = new File(musicFile);
        Media sound = new Media(f.toURI().toString());

        backgroundPlayer = new MediaPlayer(sound);
        backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundPlayer.setVolume(0.3);
        backgroundPlayer.play();

    }

    public static void playAccueilMusic() {
        playBackgroundMusic("resources/audio/accueilMusic.wav");
    }

    public static void playGameMusic() {
        playBackgroundMusic("resources/audio/backgroundMusic.wav");
    }

    public static void stopBackgroundMusic() {
        backgroundPlayer.stop();
        backgroundPlayer = null;
    }

}
