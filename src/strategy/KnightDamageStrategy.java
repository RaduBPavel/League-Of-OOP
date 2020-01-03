package strategy;

import common.Constants;
import players.BasePlayer;

public class KnightDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.KNIGHT_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - Math.round(player.getCurrHP() *
                Constants.KNIGHT_HEALTH_DECREASE));
    }
}
