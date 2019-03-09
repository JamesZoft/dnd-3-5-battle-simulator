import java.util.Arrays;
import java.util.stream.IntStream;

public class MainMindFlayer {

    private static int battlesWon = 0;

    public static void main(String[] args) {
        IntStream.range(0, 10000).parallel().forEach(num -> {
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
                    .setWillSave(13)
                    .setFortSave(20)
                    .setRefSave(10)
                    .setNormalArmor(23)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new SpellAbilityAttack(0, 3, 4, 0, Attack.AttackType.Normal, 17, SpellAbilityAttack.SaveType.will, true, 0, false),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 10000, 10000),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 10000, 10000),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 10000, 10000),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 10000, 10000)
                    ))
                    .setHealth(44)
                    .setInitiative(6)
                    .setNormalArmor(15)
                    .createMob();
            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new SpellAbilityAttack(0, 3, 4, 0, Attack.AttackType.Normal, 17, SpellAbilityAttack.SaveType.will, true, 0, false),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 1, 10000),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 1, 10000),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 1, 10000),
                            new Attack(8, 4, 4, 1, Attack.AttackType.Normal, true, 1, 10000)
                    ))
                    .setHealth(44)
                    .setInitiative(6)
                    .setNormalArmor(15)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player, b, a));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
            });
        System.out.println("Battles won: " + battlesWon);
    }
}
