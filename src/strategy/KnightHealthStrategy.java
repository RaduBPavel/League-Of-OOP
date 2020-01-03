package strategy;

import common.Constants;
import players.BasePlayer;

public class KnightHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.KNIGHT_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + Math.round(player.getCurrHP() *
                Constants.KNIGHT_HEALTH_INCREASE));
    }
}
