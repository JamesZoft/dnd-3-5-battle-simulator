import java.util.Arrays;
import java.util.stream.IntStream;

public class MainBebilith {

    private static int battlesWon = 0;
    private static long timetaken = 0L;

    public static void main(String[] args) {
        double rounds = 10000.0;
        IntStream.rangeClosed(0, (int)rounds).forEach(val -> {
//            long curtime = System.currentTimeMillis();
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
                    .setNormalArmor(23)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(19, 2, 6, 9, Attack.AttackType.Normal),
                            new Attack(14, 2, 4, 4, Attack.AttackType.Normal),
                            new Attack(14, 2, 4, 4, Attack.AttackType.Normal)
                    ))
                    .setHealth(150)
                    .setInitiative(5)
                    .setDamageReduction(10)
                    .setNormalArmor(22)
                    .createMob();

            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(19, 2, 6, 9, Attack.AttackType.Normal),
                            new Attack(14, 2, 4, 4, Attack.AttackType.Normal),
                            new Attack(14, 2, 4, 4, Attack.AttackType.Normal)
                    ))
                    .setHealth(150)
                    .setInitiative(5)
                    .setDamageReduction(10)
                    .setNormalArmor(22)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player, b, a));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
//            timetaken += System.currentTimeMillis() - curtime;
//            System.out.println(timetaken);
        });
        System.out.println("Battles won: " + battlesWon);
        System.out.println(timetaken);
        System.out.println("Average battle time: " + (timetaken / rounds));
    }
}
