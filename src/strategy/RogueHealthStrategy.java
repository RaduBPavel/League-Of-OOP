package strategy;

import common.Constants;
import players.BasePlayer;

public class RogueHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.ROGUE_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + Math.round(player.getCurrHP() *
                Constants.ROGUE_HEALTH_INCREASE));
    }
}
