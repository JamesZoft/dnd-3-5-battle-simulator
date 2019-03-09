package monstersims;

import simblocks.Attack;
import simblocks.Battle;
import simblocks.Mob;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainBebilith {

    private static int battlesWon = 0;
    private static long timetaken = 0L;

    public static void main(String[] args) {
        int rounds = 10000;
        IntStream.range(0, rounds).forEach(val -> {
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

            Battle battle = new Battle(Arrays.asList(player,  a));
            battle.runBattle();
            if (battle.isFightWon())
                battlesWon++;
//            timetaken += System.currentTimeMillis() - curtime;
//            System.out.println(timetaken);
        });
        System.out.println("Battles won: " + battlesWon);
    }
}
