package simblocks;

import java.util.List;
import java.util.Objects;

public class Mob {

    private String name;
    private int health;

    private int fortSave;
    private int refSave;
    private int willSave;

    private int normalArmor;
    private int touchArmor;
    private int initiative;
    private int regenPerRound;
    private int damageReduction;

    private List<? extends Attack> attacks;
    private int grappleBonus;

    private boolean isPlayer;

    private int roundsStunned;

    private int rendEnablingRoundsHit;

    public Mob(String name, int health, int fortSave, int refSave, int willSave, int normalArmor, int touchArmor, int initiative, int regenPerRound, List<? extends Attack> attacks, int grappleBonus, int damageReduction, boolean isPlayer) {
        this.name = name;
        this.health = health;
        this.fortSave = fortSave;
        this.refSave = refSave;
        this.willSave = willSave;
        this.normalArmor = normalArmor;
        this.touchArmor = touchArmor;
        this.initiative = initiative;
        this.regenPerRound = regenPerRound;
        this.attacks = attacks;
        this.grappleBonus = grappleBonus;
        this.damageReduction = damageReduction;
        this.isPlayer = isPlayer;
    }

    public synchronized int getRendEnablingRoundsHit() {
        return rendEnablingRoundsHit;
    }

    public synchronized void setRendEnablingRoundsHit(int rendEnablingRoundsHit) {
        this.rendEnablingRoundsHit = rendEnablingRoundsHit;
    }

    public synchronized void addRendEnablingRoundsHit() {
        this.rendEnablingRoundsHit++;
    }

    public void setRoundsStunned(int roundsStunned) {
        this.roundsStunned = roundsStunned;
    }

    public int getRoundsStunned() {
        return roundsStunned;
    }

    public void addRoundsStunned(int rounds) {
        roundsStunned += rounds;
    }

    public void removeRoundsStunned(int rounds) {
        roundsStunned -= rounds;
        if (roundsStunned < 0)
            roundsStunned = 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFortSave() {
        return fortSave;
    }

    public void setFortSave(int fortSave) {
        this.fortSave = fortSave;
    }

    public int getRefSave() {
        return refSave;
    }

    public void setRefSave(int refSave) {
        this.refSave = refSave;
    }

    public int getWillSave() {
        return willSave;
    }

    public void setWillSave(int willSave) {
        this.willSave = willSave;
    }

    public int getNormalArmor() {
        return normalArmor;
    }

    public void setNormalArmor(int normalArmor) {
        this.normalArmor = normalArmor;
    }

    public int getTouchArmor() {
        return touchArmor;
    }

    public void setTouchArmor(int touchArmor) {
        this.touchArmor = touchArmor;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getRegenPerRound() {
        return regenPerRound;
    }

    public void setRegenPerRound(int regenPerRound) {
        this.regenPerRound = regenPerRound;
    }

    public List<? extends Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<? extends Attack> attacks) {
        this.attacks = attacks;
    }

    public int getGrappleBonus() {
        return grappleBonus;
    }

    public void setGrappleBonus(int grappleBonus) {
        this.grappleBonus = grappleBonus;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mob mob = (Mob) o;
        return health == mob.health &&
                fortSave == mob.fortSave &&
                refSave == mob.refSave &&
                willSave == mob.willSave &&
                normalArmor == mob.normalArmor &&
                touchArmor == mob.touchArmor &&
                initiative == mob.initiative &&
                regenPerRound == mob.regenPerRound &&
                damageReduction == mob.damageReduction &&
                grappleBonus == mob.grappleBonus &&
                isPlayer == mob.isPlayer &&
                name.equals(mob.name) &&
                attacks.equals(mob.attacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, fortSave, refSave, willSave, normalArmor, touchArmor, initiative, regenPerRound, damageReduction, attacks, grappleBonus, isPlayer);
    }

    public static final class Builder {
        private String name;
        private int health;
        private int fortSave;
        private int refSave;
        private int willSave;
        private int normalArmor;
        private int touchArmor;
        private int initiative;
        private int regenPerRound;
        private List<? extends Attack> attacks;
        private int grappleBonus;
        private boolean isPlayer;
        private int damageReduction;

        public Builder setIsPlayer(boolean isPlayer) {
            this.isPlayer = isPlayer;
            return this;
        }

        public Builder setDamageReduction(int damageReduction) {
            this.damageReduction = damageReduction;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setFortSave(int fortSave) {
            this.fortSave = fortSave;
            return this;
        }

        public Builder setRefSave(int refSave) {
            this.refSave = refSave;
            return this;
        }

        public Builder setWillSave(int willSave) {
            this.willSave = willSave;
            return this;
        }

        public Builder setNormalArmor(int normalArmor) {
            this.normalArmor = normalArmor;
            return this;
        }

        public Builder setTouchArmor(int touchArmor) {
            this.touchArmor = touchArmor;
            return this;
        }

        public Builder setInitiative(int initiative) {
            this.initiative = initiative;
            return this;
        }

        public Builder setRegenPerRound(int regenPerRound) {
            this.regenPerRound = regenPerRound;
            return this;
        }

        public Builder setAttacks(List<? extends Attack> attacks) {
            this.attacks = attacks;
            return this;
        }

        public Builder setGrappleBonus(int grappleBonus) {
            this.grappleBonus = grappleBonus;
            return this;
        }

        public Mob createMob() {
            return new Mob(name, health, fortSave, refSave, willSave, normalArmor, touchArmor, initiative, regenPerRound, attacks, grappleBonus, damageReduction, isPlayer);
        }
    }
}
