package monstersims;

import simblocks.Attack;
import simblocks.Battle;
import simblocks.Mob;


import java.util.Arrays;

public class MainFireGiant {

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
