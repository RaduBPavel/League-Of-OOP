package strategy;

import common.Constants;
import players.BasePlayer;

public final class WizardDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.WIZARD_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - (int) (player.getCurrHP()
                * Constants.WIZARD_HEALTH_DECREASE));
    }
}
