package simblocks;

import java.security.SecureRandom;
import java.util.Objects;

public class Attack {

    private int attackBonus;
    private int damageDiceNumber;
    private int damageDiceType;
    private int damageBonus;
    private int criticalThreatMin;
    private int critModifier;
    private AttackType attackType;
    private boolean doesRend;
    private int rendDice;
    private int rendDiceNumber;

    public Attack(int attackBonus, int damageDiceNumber, int damageDiceType, int damageBonus, AttackType attackType,
                  boolean doesRend, int rendDice, int rendDiceNumber) {
        this.attackBonus = attackBonus;
        this.damageDiceNumber = damageDiceNumber;
        this.damageDiceType = damageDiceType;
        this.damageBonus = damageBonus;
        this.attackType = attackType;
        this.doesRend = doesRend;
        this.rendDice = rendDice;
        this.rendDiceNumber = rendDiceNumber;
    }

    public Attack(int attackBonus, int damageDiceNumber, int damageDiceType, int damageBonus, AttackType attackType) {
        this.attackBonus = attackBonus;
        this.damageDiceNumber = damageDiceNumber;
        this.damageDiceType = damageDiceType;
        this.damageBonus = damageBonus;
        this.attackType = attackType;
    }

    public int rollAttack(Mob mobToAttack, AttackType attackType) {
        switch (attackType) {
            case Touch: return rollNormalAttack(mobToAttack.getTouchArmor(), mobToAttack);
            default: return rollNormalAttack(mobToAttack.getNormalArmor(), mobToAttack);
        }
    }

    private int rollNormalAttack(int armorToBeat, Mob mobToAttack) {
        int diceRoll = DiceUtils.roll1d20();
        if (((diceRoll + attackBonus) >= armorToBeat || diceRoll == 20) && diceRoll != 1) {
            return rollDamage(mobToAttack, diceRoll);
        }
        return 0;
    }

    protected int rollDamage(Mob mobToAttack, int diceRollMade) {
        int damage = ((new SecureRandom().nextInt(damageDiceType - 1) + 1) * damageDiceNumber) + damageBonus;
        if (criticalThreatMin > 0 && critModifier > 0 && diceRollMade > criticalThreatMin) {
            damage = damage * critModifier;
        }
        return damage - mobToAttack.getDamageReduction();
    }

    public int rollRend() {
        return DiceUtils.roll1dx(rendDice) * rendDiceNumber;
    }

    public boolean isDoesRend() {
        return doesRend;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDamageDiceNumber() {
        return damageDiceNumber;
    }

    public void setDamageDiceNumber(int damageDiceNumber) {
        this.damageDiceNumber = damageDiceNumber;
    }

    public int getDamageDiceType() {
        return damageDiceType;
    }

    public void setDamageDiceType(int damageDiceType) {
        this.damageDiceType = damageDiceType;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    public int getCriticalThreatMin() {
        return criticalThreatMin;
    }

    public void setCriticalThreatMin(int criticalThreatMin) {
        this.criticalThreatMin = criticalThreatMin;
    }

    public int getCritModifier() {
        return critModifier;
    }

    public void setCritModifier(int critModifier) {
        this.critModifier = critModifier;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attack attack = (Attack) o;
        return attackBonus == attack.attackBonus &&
                damageDiceNumber == attack.damageDiceNumber &&
                damageDiceType == attack.damageDiceType &&
                damageBonus == attack.damageBonus &&
                criticalThreatMin == attack.criticalThreatMin &&
                critModifier == attack.critModifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attackBonus, damageDiceNumber, damageDiceType, damageBonus, criticalThreatMin, critModifier);
    }

    public enum AttackType {
        Normal,
        Touch,
        Ranged
    }
}
