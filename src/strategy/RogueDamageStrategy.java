package strategy;

import common.Constants;
import players.BasePlayer;

public class RogueDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.ROGUE_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - Math.round(player.getCurrHP() *
                Constants.ROGUE_HEALTH_DECREASE));
    }
}
