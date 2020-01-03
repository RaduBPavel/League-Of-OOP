package strategy;

import common.Constants;
import players.BasePlayer;

public class PyroHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.PYRO_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + Math.round(player.getCurrHP() *
                Constants.PYRO_HEALTH_INCREASE));
    }
}
