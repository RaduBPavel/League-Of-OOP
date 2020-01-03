package strategy;

import common.Constants;
import players.BasePlayer;

public class PyroDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.PYRO_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - Math.round(player.getCurrHP() *
                Constants.PYRO_HEALTH_DECREASE));
    }
}
