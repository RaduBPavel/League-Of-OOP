package common;

public final class Constants {
    // Base constants
    public static final int PYRO_STARTING_HP = 500;
    public static final int KNIGHT_STARTING_HP = 900;
    public static final int WIZARD_STARTING_HP = 400;
    public static final int ROGUE_STARTING_HP = 600;
    public static final int PYRO_LEVEL_HP = 50;
    public static final int KNIGHT_LEVEL_HP = 80;
    public static final int WIZARD_LEVEL_HP = 30;
    public static final int ROGUE_LEVEL_HP = 40;
    public static final int BASE_LEVEL_XP = 250;
    public static final int PER_LEVEL_XP = 50;
    public static final int BASE_LEVEL_UP_XP = 200;
    public static final int LEVEL_UP_XP_MILESTONE = 40;

    // Abilities constants
    // Pyromancer abilities
    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_LEVEL_DAMAGE = 50;
    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_LEVEL_DAMAGE = 20;
    public static final int IGNITE_BASE_OVERTIME_DAMAGE = 50;
    public static final int IGNITE_LEVEL_OVERTIME_DAMAGE = 30;
    public static final int IGNITE_OVERTIME_ROUNDS = 2;

    // Knight abilities
    public static final int EXECUTE_BASE_DAMAGE = 200;
    public static final int EXECUTE_LEVEL_DAMAGE = 30;
    public static final float EXECUTE_BASE_PERCENT = 0.2f;
    public static final float EXECUTE_LEVEL_PERCENT = 0.01f;
    public static final int SLAM_BASE_DAMAGE = 100;
    public static final int SLAM_LEVEL_DAMAGE = 40;
    public static final int SLAM_OVERTIME_ROUNDS = 1;

    // Wizard abilities
    public static final float DRAIN_BASE_PERCENT = 0.2f;
    public static final float DRAIN_LEVEL_PERCENT = 0.05f;
    public static final float DRAIN_HP_MODIFIER = 0.3f;
    public static final float DEFLECT_BASE_PERCENT = 0.35f;
    public static final float DEFLECT_LEVEL_PERCENT = 0.02f;

    // Rogue abilities
    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BACKSTAB_LEVEL_DAMAGE = 20;
    public static final float BACKSTAB_DAMAGE_MODIFIER = 1.5f;
    public static final int BACKSTAB_BONUS_COUNTER = 3;
    public static final int PARALYSIS_BASE_DAMAGE = 40;
    public static final int PARALYSIS_LEVEL_DAMAGE = 10;
    public static final int PARALYSIS_OVERTIME_ROUNDS = 3;
    public static final int PARALYSIS_EXTENDED_OVERTIME = 6;

    // Damage modifier constants
    // Land modifiers
    public static final float PYRO_VOLCANIC_MODIFIER = 0.25f;
    public static final float KNIGHT_LAND_MODIFIER = 0.15f;
    public static final float WIZARD_DESERT_MODIFIER = 0.10f;
    public static final float ROGUE_WOODS_MODIFIER = 0.15f;

    // Player specific modifiers
    // Pyromancer
    public static final float PYRO_VS_ROGUE_FIREBLAST_MODIFIER = -0.2f;
    public static final float PYRO_VS_KNIGHT_FIREBLAST_MODIFIER = 0.2f;
    public static final float PYRO_VS_PYRO_FIREBLAST_MODIFIER = -0.1f;
    public static final float PYRO_VS_WIZARD_FIREBLAST_MODIFIER = 0.05f;
    public static final float PYRO_VS_ROGUE_IGNITE_MODIFIER = -0.2f;
    public static final float PYRO_VS_KNIGHT_IGNITE_MODIFIER = 0.2f;
    public static final float PYRO_VS_PYRO_IGNITE_MODIFIER = -0.1f;
    public static final float PYRO_VS_WIZARD_IGNITE_MODIFIER = 0.05f;

    // Knight
    public static final float KNIGHT_VS_ROGUE_EXECUTE_MODIFIER = 0.15f;
    public static final float KNIGHT_VS_KNIGHT_EXECUTE_MODIFIER = 0.0f;
    public static final float KNIGHT_VS_PYRO_EXECUTE_MODIFIER = 0.1f;
    public static final float KNIGHT_VS_WIZARD_EXECUTE_MODIFIER = -0.2f;
    public static final float KNIGHT_VS_ROGUE_SLAM_MODIFIER = -0.2f;
    public static final float KNIGHT_VS_KNIGHT_SLAM_MODIFIER = 0.2f;
    public static final float KNIGHT_VS_PYRO_SLAM_MODIFIER = -0.1f;
    public static final float KNIGHT_VS_WIZARD_SLAM_MODIFIER = 0.05f;

    // Wizard
    public static final float WIZARD_VS_ROGUE_DRAIN_MODIFIER = -0.2f;
    public static final float WIZARD_VS_KNIGHT_DRAIN_MODIFIER = 0.2f;
    public static final float WIZARD_VS_PYRO_DRAIN_MODIFIER = -0.1f;
    public static final float WIZARD_VS_WIZARD_DRAIN_MODIFIER = 0.05f;
    public static final float WIZARD_VS_ROGUE_DEFLECT_MODIFIER = 0.2f;
    public static final float WIZARD_VS_KNIGHT_DEFLECT_MODIFIER = 0.4f;
    public static final float WIZARD_VS_PYRO_DEFLECT_MODIFIER = 0.3f;

    // Rogue
    public static final float ROGUE_VS_ROGUE_BACKSTAB_MODIFIER = 0.2f;
    public static final float ROGUE_VS_KNIGHT_BACKSTAB_MODIFIER = -0.1f;
    public static final float ROGUE_VS_PYRO_BACKSTAB_MODIFIER = 0.25f;
    public static final float ROGUE_VS_WIZARD_BACKSTAB_MODIFIER = 0.25f;
    public static final float ROGUE_VS_ROGUE_PARALYSIS_MODIFIER = -0.1f;
    public static final float ROGUE_VS_KNIGHT_PARALYSIS_MODIFIER = -0.2f;
    public static final float ROGUE_VS_PYRO_PARALYSIS_MODIFIER = 0.2f;
    public static final float ROGUE_VS_WIZARD_PARALYSIS_MODIFIER = 0.25f;
    private Constants() { }
}
