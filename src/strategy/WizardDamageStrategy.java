package strategy;

import common.Constants;
import players.BasePlayer;

public class WizardDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.WIZARD_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - Math.round(player.getCurrHP() *
                Constants.WIZARD_HEALTH_DECREASE));
    }
}
