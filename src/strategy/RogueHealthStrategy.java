package strategy;

import common.Constants;
import players.BasePlayer;

public final class RogueHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.ROGUE_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + (int) (player.getCurrHP()
                * Constants.ROGUE_HEALTH_INCREASE));
    }
}
