import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Battle {

    private List<Mob> mobs;

    private boolean fightWon;

    public Battle(List<Mob> mobs) {
        this.mobs = new ArrayList<>(mobs);
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    public void runBattle() {
        mobs.sort(Comparator.comparing(Mob::getInitiative));

        final Mob player = mobs.stream().filter(Mob::isPlayer).findAny().orElseThrow(() -> new IllegalStateException("There needs to be a player mob!"));
        Optional<Mob> mobBeingAttackedByPlayerOpt = mobs.stream().filter(Predicate.not(Mob::isPlayer)).findAny();

        while (player.getHealth() > 0 && mobs.size() > 1) {
            if (mobBeingAttackedByPlayerOpt.isPresent()) {
                if (mobBeingAttackedByPlayerOpt.get().getHealth() < 0) {
                    mobs.remove(mobBeingAttackedByPlayerOpt.get());
                    mobBeingAttackedByPlayerOpt = mobs.stream().filter(Predicate.not(Mob::isPlayer)).filter(mob -> mob.getHealth() >= 0).findAny();
                }
            }

            mobBeingAttackedByPlayerOpt.ifPresent(mobBeingAttackedByPlayer ->
                mobs.forEach(mob -> {
                    if (mob.getRoundsStunned() == 0) {
                        if (mob.isPlayer()) {
                            player.getAttacks().forEach(attack -> {
                                int damage = attack.rollAttack(mobBeingAttackedByPlayer, attack.getAttackType());
                                if (attack instanceof SpellAbilityAttack && ((SpellAbilityAttack) attack).isStunsInsteadOfDamage())
                                    mobBeingAttackedByPlayer.addRoundsStunned(damage);
                                else
                                    mobBeingAttackedByPlayer.takeDamage(damage);
                            });
                        } else {
                            mob.setRendEnablingRoundsHit(0);
                            mob.getAttacks().forEach(attack -> {
                                int damage = attack.rollAttack(player, attack.getAttackType());

                                if (damage > 0 && attack.isDoesRend()) {
                                    mob.addRendEnablingRoundsHit();
                                    if (mob.getRendEnablingRoundsHit() == 4)
                                        player.takeDamage(attack.rollRend());
                                }

                                if (attack instanceof SpellAbilityAttack && ((SpellAbilityAttack) attack).isStunsInsteadOfDamage())
                                    player.addRoundsStunned(damage);
                                else
                                    player.takeDamage(damage);
                            });
                        }
                    }
                    mob.removeRoundsStunned(1);
                }
            ));

            mobs.forEach(mob -> {
                if (mob.getRegenPerRound() > 0)
                    mob.setHealth(mob.getHealth() + mob.getRegenPerRound());
            });
        }

        fightWon = player.getHealth() > 0;
    }

    public boolean isFightWon() {
        return fightWon;
    }
}
