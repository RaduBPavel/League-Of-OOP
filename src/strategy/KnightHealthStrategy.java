package strategy;

import common.Constants;
import players.BasePlayer;

public final class KnightHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.KNIGHT_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + (int) (player.getCurrHP()
                * Constants.KNIGHT_HEALTH_INCREASE));
    }
}
