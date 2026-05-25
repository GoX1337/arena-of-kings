/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;

public enum PlayerAction {
    ATTACK_NORTH,
    ATTACK_EAST,
    ATTACK_SOUTH,
    ATTACK_WEST,
    ATTACK_NORTH_EAST,
    ATTACK_NORTH_WEST,
    ATTACK_SOUTH_EAST,
    ATTACK_SOUTH_WEST,
    ATTACK_RUN_NORTH,
    ATTACK_RUN_EAST,
    ATTACK_RUN_SOUTH,
    ATTACK_RUN_WEST,
    ATTACK_RUN_NORTH_EAST,
    ATTACK_RUN_NORTH_WEST,
    ATTACK_RUN_SOUTH_EAST,
    ATTACK_RUN_SOUTH_WEST,
    CAST_NORTH,
    CAST_EAST,
    CAST_SOUTH,
    CAST_WEST,
    CAST_NORTH_EAST,
    CAST_NORTH_WEST,
    CAST_SOUTH_EAST,
    CAST_SOUTH_WEST,
    CAST_RUN_NORTH,
    CAST_RUN_EAST,
    CAST_RUN_SOUTH,
    CAST_RUN_WEST,
    CAST_RUN_NORTH_EAST,
    CAST_RUN_NORTH_WEST,
    CAST_RUN_SOUTH_EAST,
    CAST_RUN_SOUTH_WEST,
    RUN_NORTH,
    RUN_EAST,
    RUN_SOUTH,
    RUN_WEST,
    RUN_NORTH_EAST,
    RUN_NORTH_WEST,
    RUN_SOUTH_EAST,
    RUN_SOUTH_WEST,
    IDLE_NORTH,
    IDLE_EAST,
    IDLE_SOUTH,
    IDLE_WEST,
    IDLE_NORTH_EAST,
    IDLE_NORTH_WEST,
    IDLE_SOUTH_EAST,
    IDLE_SOUTH_WEST,
    DEATH_NORTH,
    DEATH_EAST,
    DEATH_SOUTH,
    DEATH_WEST,
    DEATH_NORTH_EAST,
    DEATH_NORTH_WEST,
    DEATH_SOUTH_EAST,
    DEATH_SOUTH_WEST;


    public static PlayerAction findAction(cw cw2, int n2) {
        int n3 = n2 / 10000;
        switch (cw2) {
            case var_cw_a: {
                if (n3 == 0) {
                    return ATTACK_SOUTH;
                }
                if (n3 == 1) {
                    return ATTACK_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return ATTACK_EAST;
                }
                if (n3 == 3) {
                    return ATTACK_NORTH_EAST;
                }
                if (n3 == 4) {
                    return ATTACK_NORTH;
                }
                if (n3 == 5) {
                    return ATTACK_NORTH_WEST;
                }
                if (n3 == 6) {
                    return ATTACK_WEST;
                }
                if (n3 == 7) {
                    return ATTACK_SOUTH_WEST;
                }
            }
            case f: {
                if (n3 == 0) {
                    return ATTACK_RUN_SOUTH;
                }
                if (n3 == 1) {
                    return ATTACK_RUN_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return ATTACK_RUN_EAST;
                }
                if (n3 == 3) {
                    return ATTACK_RUN_NORTH_EAST;
                }
                if (n3 == 4) {
                    return ATTACK_RUN_NORTH;
                }
                if (n3 == 5) {
                    return ATTACK_RUN_NORTH_WEST;
                }
                if (n3 == 6) {
                    return ATTACK_RUN_WEST;
                }
                if (n3 == 7) {
                    return ATTACK_RUN_SOUTH_WEST;
                }
            }
            case b: {
                if (n3 == 0) {
                    return CAST_SOUTH;
                }
                if (n3 == 1) {
                    return CAST_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return CAST_EAST;
                }
                if (n3 == 3) {
                    return CAST_NORTH_EAST;
                }
                if (n3 == 4) {
                    return CAST_NORTH;
                }
                if (n3 == 5) {
                    return CAST_NORTH_WEST;
                }
                if (n3 == 6) {
                    return CAST_WEST;
                }
                if (n3 == 7) {
                    return CAST_SOUTH_WEST;
                }
            }
            case g: {
                if (n3 == 0) {
                    return CAST_RUN_SOUTH;
                }
                if (n3 == 1) {
                    return CAST_RUN_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return CAST_RUN_EAST;
                }
                if (n3 == 3) {
                    return CAST_RUN_NORTH_EAST;
                }
                if (n3 == 4) {
                    return CAST_RUN_NORTH;
                }
                if (n3 == 5) {
                    return CAST_RUN_NORTH_WEST;
                }
                if (n3 == 6) {
                    return CAST_RUN_WEST;
                }
                if (n3 == 7) {
                    return CAST_RUN_SOUTH_WEST;
                }
            }
            case c: {
                if (n3 == 0) {
                    return DEATH_SOUTH;
                }
                if (n3 == 1) {
                    return DEATH_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return DEATH_EAST;
                }
                if (n3 == 3) {
                    return DEATH_NORTH_EAST;
                }
                if (n3 == 4) {
                    return DEATH_NORTH;
                }
                if (n3 == 5) {
                    return DEATH_NORTH_WEST;
                }
                if (n3 == 6) {
                    return DEATH_WEST;
                }
                if (n3 == 7) {
                    return DEATH_SOUTH_WEST;
                }
            }
            case d: {
                if (n3 == 0) {
                    return IDLE_SOUTH;
                }
                if (n3 == 1) {
                    return IDLE_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return IDLE_EAST;
                }
                if (n3 == 3) {
                    return IDLE_NORTH_EAST;
                }
                if (n3 == 4) {
                    return IDLE_NORTH;
                }
                if (n3 == 5) {
                    return IDLE_NORTH_WEST;
                }
                if (n3 == 6) {
                    return IDLE_WEST;
                }
                if (n3 == 7) {
                    return IDLE_SOUTH_WEST;
                }
            }
            case e: {
                if (n3 == 0) {
                    return RUN_SOUTH;
                }
                if (n3 == 1) {
                    return RUN_SOUTH_EAST;
                }
                if (n3 == 2) {
                    return RUN_EAST;
                }
                if (n3 == 3) {
                    return RUN_NORTH_EAST;
                }
                if (n3 == 4) {
                    return RUN_NORTH;
                }
                if (n3 == 5) {
                    return RUN_NORTH_WEST;
                }
                if (n3 == 6) {
                    return RUN_WEST;
                }
                if (n3 != 7) break;
                return RUN_SOUTH_WEST;
            }
        }
        return IDLE_SOUTH;
    }

    public static PlayerAction getAction(cw cw2, Direction direction) {
        switch (cw2) {
            case var_cw_a: {
                switch (direction) {
                    case NORTH: {
                        return ATTACK_NORTH;
                    }
                    case EAST: {
                        return ATTACK_EAST;
                    }
                    case SOUTH: {
                        return ATTACK_SOUTH;
                    }
                    case WEST: {
                        return ATTACK_WEST;
                    }
                    case NORTH_EAST: {
                        return ATTACK_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return ATTACK_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return ATTACK_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return ATTACK_SOUTH_WEST;
                    }
                }
            }
            case b: {
                switch (direction) {
                    case NORTH: {
                        return CAST_NORTH;
                    }
                    case EAST: {
                        return CAST_EAST;
                    }
                    case SOUTH: {
                        return CAST_SOUTH;
                    }
                    case WEST: {
                        return CAST_WEST;
                    }
                    case NORTH_EAST: {
                        return CAST_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return CAST_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return CAST_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return CAST_SOUTH_WEST;
                    }
                }
            }
            case f: {
                switch (direction) {
                    case NORTH: {
                        return ATTACK_RUN_NORTH;
                    }
                    case EAST: {
                        return ATTACK_RUN_EAST;
                    }
                    case SOUTH: {
                        return ATTACK_RUN_SOUTH;
                    }
                    case WEST: {
                        return ATTACK_RUN_WEST;
                    }
                    case NORTH_EAST: {
                        return ATTACK_RUN_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return ATTACK_RUN_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return ATTACK_RUN_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return ATTACK_RUN_SOUTH_WEST;
                    }
                }
            }
            case g: {
                switch (direction) {
                    case NORTH: {
                        return CAST_RUN_NORTH;
                    }
                    case EAST: {
                        return CAST_RUN_EAST;
                    }
                    case SOUTH: {
                        return CAST_RUN_SOUTH;
                    }
                    case WEST: {
                        return CAST_RUN_WEST;
                    }
                    case NORTH_EAST: {
                        return CAST_RUN_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return CAST_RUN_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return CAST_RUN_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return CAST_RUN_SOUTH_WEST;
                    }
                }
            }
            case c: {
                switch (direction) {
                    case NORTH: {
                        return DEATH_NORTH;
                    }
                    case EAST: {
                        return DEATH_EAST;
                    }
                    case SOUTH: {
                        return DEATH_SOUTH;
                    }
                    case WEST: {
                        return DEATH_WEST;
                    }
                    case NORTH_EAST: {
                        return DEATH_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return DEATH_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return DEATH_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return DEATH_SOUTH_WEST;
                    }
                }
            }
            case d: {
                switch (direction) {
                    case NORTH: {
                        return IDLE_NORTH;
                    }
                    case EAST: {
                        return IDLE_EAST;
                    }
                    case SOUTH: {
                        return IDLE_SOUTH;
                    }
                    case WEST: {
                        return IDLE_WEST;
                    }
                    case NORTH_EAST: {
                        return IDLE_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return IDLE_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return IDLE_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return IDLE_SOUTH_WEST;
                    }
                }
            }
            case e: {
                switch (direction) {
                    case NORTH: {
                        return RUN_NORTH;
                    }
                    case EAST: {
                        return RUN_EAST;
                    }
                    case SOUTH: {
                        return RUN_SOUTH;
                    }
                    case WEST: {
                        return RUN_WEST;
                    }
                    case NORTH_EAST: {
                        return RUN_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return RUN_NORTH_WEST;
                    }
                    case SOUTH_EAST: {
                        return RUN_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return RUN_SOUTH_WEST;
                    }
                }
            }
        }
        Engine.a("[PlayerAction] action not found");
        return IDLE_SOUTH;
    }

    public static Direction getDirection(PlayerAction playerAction) {
        if (playerAction == ATTACK_NORTH || playerAction == RUN_NORTH || playerAction == ATTACK_RUN_NORTH || playerAction == CAST_RUN_NORTH || playerAction == IDLE_NORTH || playerAction == CAST_NORTH || playerAction == DEATH_NORTH) {
            return Direction.NORTH;
        }
        if (playerAction == ATTACK_SOUTH || playerAction == RUN_SOUTH || playerAction == ATTACK_RUN_SOUTH || playerAction == CAST_RUN_SOUTH || playerAction == IDLE_SOUTH || playerAction == CAST_SOUTH || playerAction == DEATH_SOUTH) {
            return Direction.SOUTH;
        }
        if (playerAction == ATTACK_EAST || playerAction == RUN_EAST || playerAction == ATTACK_RUN_EAST || playerAction == CAST_RUN_EAST || playerAction == IDLE_EAST || playerAction == CAST_EAST || playerAction == DEATH_EAST) {
            return Direction.EAST;
        }
        if (playerAction == ATTACK_WEST || playerAction == RUN_WEST || playerAction == ATTACK_RUN_WEST || playerAction == CAST_RUN_WEST || playerAction == IDLE_WEST || playerAction == CAST_WEST || playerAction == DEATH_WEST) {
            return Direction.WEST;
        }
        if (playerAction == ATTACK_NORTH_EAST || playerAction == RUN_NORTH_EAST || playerAction == ATTACK_RUN_NORTH_EAST || playerAction == CAST_RUN_NORTH_EAST || playerAction == IDLE_NORTH_EAST || playerAction == CAST_NORTH_EAST || playerAction == DEATH_NORTH_EAST) {
            return Direction.NORTH_EAST;
        }
        if (playerAction == ATTACK_NORTH_WEST || playerAction == RUN_NORTH_WEST || playerAction == ATTACK_RUN_NORTH_WEST || playerAction == CAST_RUN_NORTH_WEST || playerAction == IDLE_NORTH_WEST || playerAction == CAST_NORTH_WEST || playerAction == DEATH_NORTH_WEST) {
            return Direction.NORTH_WEST;
        }
        if (playerAction == ATTACK_SOUTH_EAST || playerAction == RUN_SOUTH_EAST || playerAction == ATTACK_RUN_SOUTH_EAST || playerAction == CAST_RUN_SOUTH_EAST || playerAction == IDLE_SOUTH_EAST || playerAction == CAST_SOUTH_EAST || playerAction == DEATH_SOUTH_EAST) {
            return Direction.SOUTH_EAST;
        }
        if (playerAction == ATTACK_SOUTH_WEST || playerAction == RUN_SOUTH_WEST || playerAction == ATTACK_RUN_SOUTH_WEST || playerAction == CAST_RUN_SOUTH_WEST || playerAction == IDLE_SOUTH_WEST || playerAction == CAST_SOUTH_WEST || playerAction == DEATH_SOUTH_WEST) {
            return Direction.SOUTH_WEST;
        }
        return Direction.NORTH;
    }

    public static boolean isIdle(PlayerAction playerAction) {
        return playerAction == IDLE_NORTH || playerAction == IDLE_NORTH_EAST || playerAction == IDLE_NORTH_WEST || playerAction == IDLE_EAST || playerAction == IDLE_WEST || playerAction == IDLE_SOUTH || playerAction == IDLE_SOUTH_EAST || playerAction == IDLE_SOUTH_WEST;
    }

    public static boolean isAttackOrCast(PlayerAction playerAction) {
        return playerAction == ATTACK_NORTH || playerAction == ATTACK_EAST || playerAction == ATTACK_SOUTH || playerAction == ATTACK_WEST || playerAction == ATTACK_NORTH_EAST || playerAction == ATTACK_NORTH_WEST || playerAction == ATTACK_SOUTH_EAST || playerAction == ATTACK_SOUTH_WEST || playerAction == CAST_NORTH || playerAction == CAST_EAST || playerAction == CAST_SOUTH || playerAction == CAST_WEST || playerAction == CAST_NORTH_EAST || playerAction == CAST_NORTH_WEST || playerAction == CAST_SOUTH_EAST || playerAction == CAST_SOUTH_WEST;
    }

    public static boolean isAttack(PlayerAction playerAction) {
        return playerAction == ATTACK_NORTH || playerAction == ATTACK_NORTH_EAST || playerAction == ATTACK_NORTH_WEST || playerAction == ATTACK_EAST || playerAction == ATTACK_WEST || playerAction == ATTACK_SOUTH || playerAction == ATTACK_SOUTH_EAST || playerAction == ATTACK_SOUTH_WEST;
    }

    public static boolean isCast(PlayerAction playerAction) {
        return playerAction == CAST_NORTH || playerAction == CAST_NORTH_EAST || playerAction == CAST_NORTH_WEST || playerAction == CAST_EAST || playerAction == CAST_WEST || playerAction == CAST_SOUTH || playerAction == CAST_SOUTH_EAST || playerAction == CAST_SOUTH_WEST;
    }

    public static boolean isAttackRun(PlayerAction playerAction) {
        return playerAction == ATTACK_RUN_NORTH || playerAction == ATTACK_RUN_NORTH_EAST || playerAction == ATTACK_RUN_NORTH_WEST || playerAction == ATTACK_RUN_EAST || playerAction == ATTACK_RUN_WEST || playerAction == ATTACK_RUN_SOUTH || playerAction == ATTACK_RUN_SOUTH_EAST || playerAction == ATTACK_RUN_SOUTH_WEST;
    }

    public static boolean isCastRun(PlayerAction playerAction) {
        return playerAction == CAST_RUN_NORTH || playerAction == CAST_RUN_NORTH_EAST || playerAction == CAST_RUN_NORTH_WEST || playerAction == CAST_RUN_EAST || playerAction == CAST_RUN_WEST || playerAction == CAST_RUN_SOUTH || playerAction == CAST_RUN_SOUTH_EAST || playerAction == CAST_RUN_SOUTH_WEST;
    }

    public static boolean isRun(PlayerAction playerAction) {
        return playerAction == RUN_NORTH || playerAction == RUN_NORTH_EAST || playerAction == RUN_NORTH_WEST || playerAction == RUN_EAST || playerAction == RUN_WEST || playerAction == RUN_SOUTH || playerAction == RUN_SOUTH_EAST || playerAction == RUN_SOUTH_WEST;
    }

    public static boolean isDeath(PlayerAction playerAction) {
        return playerAction == DEATH_NORTH || playerAction == DEATH_NORTH_EAST || playerAction == DEATH_NORTH_WEST || playerAction == DEATH_EAST || playerAction == DEATH_WEST || playerAction == DEATH_SOUTH || playerAction == DEATH_SOUTH_EAST || playerAction == DEATH_SOUTH_WEST;
    }

    public static boolean isSameDirectionRun(PlayerAction playerAction, PlayerAction playerAction2) {
        return !(PlayerAction.getDirection(playerAction) != PlayerAction.getDirection(playerAction2) || !PlayerAction.isRun(playerAction) && !PlayerAction.isAttackRun(playerAction) && !PlayerAction.isCastRun(playerAction) || !PlayerAction.isRun(playerAction2) && !PlayerAction.isAttackRun(playerAction2) && !PlayerAction.isCastRun(playerAction2));
    }

    public static PlayerAction changeDirection(PlayerAction playerAction, Direction direction) {
        PlayerAction playerAction2 = playerAction;
        switch (playerAction) {
            case IDLE_EAST: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_NORTH: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_NORTH_EAST: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_NORTH_WEST: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_SOUTH: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_SOUTH_EAST: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_SOUTH_WEST: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case IDLE_WEST: {
                playerAction2 = cw.a(cw.d, direction);
                break;
            }
            case ATTACK_EAST: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_NORTH: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_NORTH_EAST: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_NORTH_WEST: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_SOUTH: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_WEST: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_SOUTH_EAST: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_SOUTH_WEST: {
                playerAction2 = cw.a(cw.var_cw_a, direction);
                break;
            }
            case ATTACK_RUN_EAST: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_NORTH: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_NORTH_EAST: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_NORTH_WEST: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_SOUTH: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_SOUTH_EAST: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_SOUTH_WEST: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case ATTACK_RUN_WEST: {
                playerAction2 = cw.a(cw.f, direction);
                break;
            }
            case CAST_EAST: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_NORTH: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_NORTH_EAST: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_NORTH_WEST: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_SOUTH: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_SOUTH_EAST: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_SOUTH_WEST: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_WEST: {
                playerAction2 = cw.a(cw.b, direction);
                break;
            }
            case CAST_RUN_EAST: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_NORTH: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_NORTH_EAST: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_NORTH_WEST: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_SOUTH: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_SOUTH_EAST: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_SOUTH_WEST: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case CAST_RUN_WEST: {
                playerAction2 = cw.a(cw.g, direction);
                break;
            }
            case DEATH_EAST: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_NORTH: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_NORTH_EAST: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_NORTH_WEST: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_SOUTH: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_SOUTH_EAST: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_SOUTH_WEST: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case DEATH_WEST: {
                playerAction2 = cw.a(cw.c, direction);
                break;
            }
            case RUN_EAST: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_NORTH: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_NORTH_EAST: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_NORTH_WEST: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_SOUTH: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_SOUTH_EAST: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_SOUTH_WEST: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
            case RUN_WEST: {
                playerAction2 = cw.a(cw.e, direction);
                break;
            }
        }
        return playerAction2;
    }

    public static PlayerAction castRunToRun(PlayerAction playerAction) {
        PlayerAction playerAction2 = playerAction;
        switch (playerAction) {
            case CAST_RUN_NORTH: {
                playerAction2 = RUN_NORTH;
                break;
            }
            case CAST_RUN_SOUTH: {
                playerAction2 = RUN_SOUTH;
                break;
            }
            case CAST_RUN_EAST: {
                playerAction2 = RUN_EAST;
                break;
            }
            case CAST_RUN_WEST: {
                playerAction2 = RUN_WEST;
                break;
            }
            case CAST_RUN_NORTH_EAST: {
                playerAction2 = RUN_NORTH_EAST;
                break;
            }
            case CAST_RUN_NORTH_WEST: {
                playerAction2 = RUN_NORTH_WEST;
                break;
            }
            case CAST_RUN_SOUTH_EAST: {
                playerAction2 = RUN_SOUTH_EAST;
                break;
            }
            case CAST_RUN_SOUTH_WEST: {
                playerAction2 = RUN_SOUTH_WEST;
            }
        }
        return playerAction2;
    }

    public static PlayerAction attackRunToRun(PlayerAction playerAction) {
        PlayerAction playerAction2 = playerAction;
        switch (playerAction) {
            case ATTACK_RUN_NORTH: {
                playerAction2 = RUN_NORTH;
                break;
            }
            case ATTACK_RUN_SOUTH: {
                playerAction2 = RUN_SOUTH;
                break;
            }
            case ATTACK_RUN_EAST: {
                playerAction2 = RUN_EAST;
                break;
            }
            case ATTACK_RUN_WEST: {
                playerAction2 = RUN_WEST;
                break;
            }
            case ATTACK_RUN_NORTH_EAST: {
                playerAction2 = RUN_NORTH_EAST;
                break;
            }
            case ATTACK_RUN_NORTH_WEST: {
                playerAction2 = RUN_NORTH_WEST;
                break;
            }
            case ATTACK_RUN_SOUTH_EAST: {
                playerAction2 = RUN_SOUTH_EAST;
                break;
            }
            case ATTACK_RUN_SOUTH_WEST: {
                playerAction2 = RUN_SOUTH_WEST;
            }
        }
        return playerAction2;
    }
}

