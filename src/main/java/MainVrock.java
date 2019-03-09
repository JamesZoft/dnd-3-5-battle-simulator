import java.util.Arrays;

public class MainVrock {

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
                    .setNormalArmor(23)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                        new Attack(19, 2, 6, 9, Attack.AttackType.Normal),
                        new Attack(14, 2, 4, 4, Attack.AttackType.Normal),
                        new Attack(14, 2, 4, 4, Attack.AttackType.Normal)
                    ))
                    .setHealth(115)
                    .setInitiative(2)
                    .setDamageReduction(10)
                    .setNormalArmor(22)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player, a));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
        }
        System.out.println("Battles won: " + battlesWon);
    }
}
