package strategy;

import common.Constants;
import players.BasePlayer;

public final class RogueDamageStrategy implements DamageStrategy {
    @Override
    public void applyDamageStrategy(final BasePlayer player) {
        player.setBaseModifier(player.getBaseModifier() + Constants.ROGUE_DAMAGE_INCREASE);
        player.setCurrHP(player.getCurrHP() - (int) (player.getCurrHP()
                * Constants.ROGUE_HEALTH_DECREASE));
    }
}
