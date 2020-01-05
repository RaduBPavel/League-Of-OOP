package strategy;

import common.Constants;
import players.BasePlayer;

public final class WizardHealthStrategy implements HealthStrategy {
    @Override
    public void applyHealthStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() - Constants.WIZARD_DAMAGE_DECREASE);
        player.setCurrHP(player.getCurrHP() + (int) (player.getCurrHP()
                * Constants.WIZARD_HEALTH_INCREASE));
    }
}
