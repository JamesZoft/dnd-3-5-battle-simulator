package monstersims;

import simblocks.Attack;
import simblocks.Battle;
import simblocks.Mob;


import java.util.Arrays;

public class MainTrolls {

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

            Mob aa = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob bb = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob cc = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob dd = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob ee = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob ff = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();



            Mob a = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob b = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob c = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob d = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob e = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();
            Mob f = new Mob.Builder()
                    .setAttacks(Arrays.asList(
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(9, 1, 6, 6, Attack.AttackType.Normal, true, 6, 2),
                            new Attack(4, 1, 6, 3, Attack.AttackType.Normal)
                    ))
                    .setHealth(63)
                    .setInitiative(2)
                    .setNormalArmor(16)
                    .setRegenPerRound(5)
                    .createMob();

            Battle battle = new Battle(Arrays.asList(player,  a, b, c, d, e, f));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
        }
        System.out.println("Battles won: " + battlesWon);
    }
}
