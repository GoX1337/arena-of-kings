/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum TutorialStage {
    tutorialGreeting1_WELCOME,
    tutorialGreeting_CLASS_INTRO,
    tutorialGreeting2_MOVE,
    tutorialGreeting3_SPELLS,
    tutorialGreeting4_TARGETING,
    tutorialGreeting5_USE_ABILITY,
    WALK_TO_PORTAL_4,
    WALK_TO_PORTAL_5,
    TARGET_ENEMY_6,
    BASIC_ATTACK_7,
    KILL_DUMMY,
    DONE;


    public static TutorialStage next(TutorialStage tutorialStage) {
        switch (tutorialStage) {
            case tutorialGreeting1_WELCOME: {
                return tutorialGreeting2_MOVE;
            }
            case tutorialGreeting2_MOVE: {
                return tutorialGreeting3_SPELLS;
            }
            case tutorialGreeting3_SPELLS: {
                return tutorialGreeting_CLASS_INTRO;
            }
            case tutorialGreeting_CLASS_INTRO: {
                return tutorialGreeting4_TARGETING;
            }
            case tutorialGreeting4_TARGETING: {
                return tutorialGreeting5_USE_ABILITY;
            }
            case tutorialGreeting5_USE_ABILITY: {
                return WALK_TO_PORTAL_4;
            }
            case WALK_TO_PORTAL_4: {
                return WALK_TO_PORTAL_5;
            }
            case WALK_TO_PORTAL_5: {
                return TARGET_ENEMY_6;
            }
            case TARGET_ENEMY_6: {
                return BASIC_ATTACK_7;
            }
            case BASIC_ATTACK_7: {
                return KILL_DUMMY;
            }
            case KILL_DUMMY: {
                return DONE;
            }
        }
        return DONE;
    }
}

