package sample.model.IAStrategie;

import sample.model.Difficulty;

public class IAFactory {
    public static IA createIA(Difficulty d) {
        switch(d) {
            case EASY:
                return new EasyIA();
            case MEDIUM:
                return new MediumIA();
            case HARD:
                return new HardIA();
            default:
                return new MediumIA();

        }

    }
}
