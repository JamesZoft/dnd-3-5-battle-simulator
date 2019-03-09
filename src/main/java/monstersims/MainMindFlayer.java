package monstersims;

import simblocks.Attack;
import simblocks.Battle;
import simblocks.Mob;
import simblocks.SpellAbilityAttack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainMindFlayer {

    private static int battlesWon = 0;

    public static void main(String[] args) {
        IntStream.range(0, 10000).parallel().forEach(num -> {
            Mob player = new Mob.Builder()
                    .setIsPlayer(true)
                    .setAttacks(Arrays.asList(
                            new Attack(19, 6, 6, 30, Attack.AttackType.Normal),
                            new Attack(14, 6, 6, 30, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(7)
                    .setNormalArmor(31)
                    .setTouchArmor(21)
                    .setRegenPerRound(5)
                    .setDamageReduction(10)
                    .setFortSave(13)
                    .setRefSave(20)
                    .setWillSave(17)
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
