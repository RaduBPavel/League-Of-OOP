package strategy;

import common.Constants;
import players.BasePlayer;

public class WizardHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.WIZARD_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + Math.round(player.getCurrHP() *
                Constants.WIZARD_HEALTH_INCREASE));
    }
}
