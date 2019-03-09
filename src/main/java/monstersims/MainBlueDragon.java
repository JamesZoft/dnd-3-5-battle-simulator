package monstersims;

import simblocks.Attack;
import simblocks.Battle;
import simblocks.Mob;

import java.util.Arrays;

public class MainBlueDragon {

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
                    .setDamageReduction(10)
                    .setFortSave(13)
                    .setRefSave(20)
                    .setWillSave(17)
                    .setRegenPerRound(5)
                    .createMob();
            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(18, 2, 6, 11, Attack.AttackType.Normal),
                            new simblocks.Attack(18, 1, 8, 5, simblocks.Attack.AttackType.Normal),
                            new simblocks.Attack(18, 1, 8, 5, simblocks.Attack.AttackType.Normal),
                            new simblocks.Attack(18, 1, 6, 5, simblocks.Attack.AttackType.Normal),
                            new simblocks.Attack(18, 1, 6, 5, simblocks.Attack.AttackType.Normal),
                            new simblocks.Attack(18, 1, 8, 5, simblocks.Attack.AttackType.Normal),
                            new simblocks.SpellAbilityAttack(0, 10, 8, 0, simblocks.Attack.AttackType.Normal, 23, simblocks.SpellAbilityAttack.SaveType.ref, false, 2, true)
                    ))
                    .setHealth(189)
                    .setInitiative(0)
                    .setNormalArmor(26)
                    .createMob();
            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(18, 2, 6, 11, Attack.AttackType.Normal)
//                            new simblocks.Attack(18, 1, 8, 5, simblocks.Attack.AttackType.Normal),
//                            new simblocks.Attack(18, 1, 8, 5, simblocks.Attack.AttackType.Normal),
//                            new simblocks.Attack(18, 1, 6, 5, simblocks.Attack.AttackType.Normal),
//                            new simblocks.Attack(18, 1, 6, 5, simblocks.Attack.AttackType.Normal),
//                            new simblocks.Attack(18, 1, 8, 5, simblocks.Attack.AttackType.Normal),
//                            new simblocks.SpellAbilityAttack(0, 10, 8, 0, simblocks.Attack.AttackType.Normal, 23, simblocks.SpellAbilityAttack.SaveType.ref, false, 0, true)
                    ))
                    .setHealth(189)
                    .setInitiative(0)
                    .setNormalArmor(26)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player, a));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
        }
        System.out.println("Battles won: " + battlesWon);
    }
}
