package strategy;

import common.Constants;
import players.BasePlayer;

public final class PyroDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.PYRO_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - (int) (player.getCurrHP()
                * Constants.PYRO_HEALTH_DECREASE));
    }
}
