package strategy;

import common.Constants;
import players.BasePlayer;

public final class PyroHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.PYRO_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + (int) (player.getCurrHP()
                * Constants.PYRO_HEALTH_INCREASE));
    }
}
