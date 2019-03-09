package monstersims;

import simblocks.Attack;
import simblocks.Battle;
import simblocks.Mob;
import simblocks.SpellAbilityAttack;

import java.util.Arrays;

public class MainVrock {

    public static void main(String[] args) {
        int battlesWon = 0;
        for (int i = 0; i < 10000; i++) {
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
//                    .setDamageReduction(10)
                    .setFortSave(13)
                    .setRefSave(20)
                    .setWillSave(17)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                        new Attack(15, 2, 6, 6, Attack.AttackType.Normal),
                        new Attack(15, 2, 6, 6, Attack.AttackType.Normal),
                        new Attack(13, 1, 8, 3, Attack.AttackType.Normal),
                        new Attack(13, 1, 6, 3, Attack.AttackType.Normal),
                        new SpellAbilityAttack(1231233, 1, 8, 0, Attack.AttackType.Normal, 123123, SpellAbilityAttack.SaveType.fort, false, 3, true),
                        new Attack(123123, 1, 4, 0, Attack.AttackType.Normal)
                    ))
                    .setHealth(115)
                    .setInitiative(2)
                    .setDamageReduction(10)
                    .setNormalArmor(22)
                    .createMob();

            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(15, 2, 6, 6, Attack.AttackType.Normal),
                            new Attack(15, 2, 6, 6, Attack.AttackType.Normal),
                            new Attack(13, 1, 8, 3, Attack.AttackType.Normal),
                            new Attack(13, 1, 6, 3, Attack.AttackType.Normal),
                            new SpellAbilityAttack(1231233, 1, 8, 0, Attack.AttackType.Normal, 123123, SpellAbilityAttack.SaveType.fort, false, 3, true),
                            new Attack(123123, 1, 4, 0, Attack.AttackType.Normal)
                    ))
                    .setHealth(115)
                    .setInitiative(2)
                    .setDamageReduction(10)
                    .setNormalArmor(22)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player, a, b));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
        }
        System.out.println("Battles won: " + battlesWon);
    }
}
