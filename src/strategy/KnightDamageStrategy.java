package strategy;

import common.Constants;
import players.BasePlayer;

public final class KnightDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.KNIGHT_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - (int) (player.getCurrHP()
                * Constants.KNIGHT_HEALTH_DECREASE));
    }
}
