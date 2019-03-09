package simblocks;

public class SpellAbilityAttack extends Attack {


    public SpellAbilityAttack(int attackBonus, int damageDiceNumber, int damageDiceType, int damageBonus,
                              AttackType attackType, int saveDC, SaveType saveType, boolean stunsInsteadOfDamage,
                              int cooldownRounds, boolean hasCooldown) {
        super(attackBonus, damageDiceNumber, damageDiceType, damageBonus, attackType);
        this.saveDC = saveDC;
        this.saveType = saveType;
        this.stunsInsteadOfDamage = stunsInsteadOfDamage;
        this.cooldownRounds = cooldownRounds;
        this.hasCooldown = hasCooldown;
    }

    private int saveDC;
    private SaveType saveType;
    private boolean stunsInsteadOfDamage;
    private int cooldownRounds;
    private boolean hasCooldown;

    @Override
    public int rollAttack(Mob mobToAttack, AttackType attackType) {
        int saveBonus = switch (saveType) {
            case will ->  mobToAttack.getWillSave();
            case fort -> mobToAttack.getFortSave();
            case ref -> mobToAttack.getRefSave();
        };

        int damageRolled = rollDamage(mobToAttack, 0);
        boolean madeSavingThrow = DiceUtils.makeSavingThrow(saveDC, saveBonus);

        if (madeSavingThrow) {
            if (saveType.equals(SaveType.ref))
                damageRolled = damageRolled / 2;
            else
                damageRolled = 0;
        }

        if (hasCooldown) {
            if (cooldownRounds == 0) {
                cooldownRounds = rollCooldown();
                return damageRolled;
            } else {
                cooldownRounds--;
                return 0;
            }
        } else {
            return damageRolled;
        }
    }

    private int rollCooldown() {
        return DiceUtils.roll1dx(4);
    }

    public boolean isStunsInsteadOfDamage() {
        return stunsInsteadOfDamage;
    }

    public enum SaveType {
        will,
        fort,
        ref
    }
}
