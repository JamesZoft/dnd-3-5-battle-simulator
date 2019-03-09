import java.util.Arrays;

public class MainFireGiant {

    public static void main(String[] args) {
        int battlesWon = 0;
        for (int i = 0; i < 10000; i++) {
            Mob player = new Mob.Builder()
                    .setIsPlayer(true)
                    .setAttacks(Arrays.asList(
                            new Attack(15, 6, 6, 14, Attack.AttackType.Normal),
                            new Attack(15, 4, 6, 14, Attack.AttackType.Normal),
                            new Attack(15, 4, 8, 9, Attack.AttackType.Normal),
                            new Attack(10, 4, 8, 9, Attack.AttackType.Normal)
                    ))
                    .setHealth(141)
                    .setInitiative(7)
                    .setNormalArmor(31)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(20, 3, 6, 15, Attack.AttackType.Normal),
                            new Attack(15, 3, 6, 15, Attack.AttackType.Normal),
                            new Attack(10, 3, 6, 15, Attack.AttackType.Normal)
                    ))
                    .setHealth(142)
                    .setInitiative(-1)
                    .setNormalArmor(23)
                    .createMob();
            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(20, 3, 6, 15, Attack.AttackType.Normal),
                            new Attack(15, 3, 6, 15, Attack.AttackType.Normal),
                            new Attack(10, 3, 6, 15, Attack.AttackType.Normal)
                    ))
                    .setHealth(142)
                    .setInitiative(-1)
                    .setNormalArmor(23)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player,  a, b));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
        }
        System.out.println("Battles won: " + battlesWon);
    }
}
