import java.util.Arrays;

public class MainBlueDragon {

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
                    .setHealth(70)
                    .setInitiative(7)
                    .setNormalArmor(31)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(18, 2, 6, 11, Attack.AttackType.Normal)
//                            new Attack(18, 1, 8, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 8, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 6, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 6, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 8, 5, Attack.AttackType.Normal),
//                            new SpellAbilityAttack(0, 10, 8, 0, Attack.AttackType.Normal, 23, SpellAbilityAttack.SaveType.ref, false, 0, true)
                    ))
                    .setHealth(189)
                    .setInitiative(0)
                    .setNormalArmor(26)
                    .createMob();
            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(18, 2, 6, 11, Attack.AttackType.Normal)
//                            new Attack(18, 1, 8, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 8, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 6, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 6, 5, Attack.AttackType.Normal),
//                            new Attack(18, 1, 8, 5, Attack.AttackType.Normal),
//                            new SpellAbilityAttack(0, 10, 8, 0, Attack.AttackType.Normal, 23, SpellAbilityAttack.SaveType.ref, false, 0, true)
                    ))
                    .setHealth(189)
                    .setInitiative(0)
                    .setNormalArmor(26)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player, a, b));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
        }
        System.out.println("Battles won: " + battlesWon);
    }
}
