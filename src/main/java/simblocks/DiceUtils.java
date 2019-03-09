package simblocks;

import java.security.SecureRandom;

public class DiceUtils {

    public static int roll1d20() {
        return new SecureRandom().nextInt(20) + 1;
    }

    public static boolean makeSavingThrow(int saveDC, int saveBonus) {
        return (roll1d20() + saveBonus) >= saveDC;
    }

    public static int roll1dx(int x) {
        return new SecureRandom().nextInt(x) + 1;
    }
}
