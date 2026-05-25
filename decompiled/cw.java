/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.PlayerAction;

public final class cw
extends Enum<cw> {
    public static final /* enum */ cw var_cw_a;
    public static final /* enum */ cw b;
    public static final /* enum */ cw c;
    public static final /* enum */ cw d;
    public static final /* enum */ cw e;
    public static final /* enum */ cw f;
    public static final /* enum */ cw g;
    private static final /* synthetic */ cw[] var_cw_arr_a;

    public static cw[] values() {
        return (cw[])var_cw_arr_a.clone();
    }

    public static cw valueOf(String string) {
        return Enum.valueOf(cw.class, string);
    }

    public static cw a(PlayerAction playerAction) {
        switch (playerAction) {
            case ATTACK_EAST: {
                return var_cw_a;
            }
            case ATTACK_NORTH: {
                return var_cw_a;
            }
            case ATTACK_NORTH_EAST: {
                return var_cw_a;
            }
            case ATTACK_NORTH_WEST: {
                return var_cw_a;
            }
            case ATTACK_RUN_EAST: {
                return f;
            }
            case ATTACK_RUN_NORTH: {
                return f;
            }
            case ATTACK_RUN_NORTH_EAST: {
                return f;
            }
            case ATTACK_RUN_NORTH_WEST: {
                return f;
            }
            case ATTACK_RUN_SOUTH: {
                return f;
            }
            case ATTACK_RUN_SOUTH_EAST: {
                return f;
            }
            case ATTACK_RUN_SOUTH_WEST: {
                return f;
            }
            case ATTACK_RUN_WEST: {
                return f;
            }
            case ATTACK_SOUTH: {
                return var_cw_a;
            }
            case ATTACK_SOUTH_EAST: {
                return var_cw_a;
            }
            case ATTACK_SOUTH_WEST: {
                return var_cw_a;
            }
            case ATTACK_WEST: {
                return var_cw_a;
            }
            case CAST_EAST: {
                return b;
            }
            case CAST_NORTH: {
                return b;
            }
            case CAST_NORTH_EAST: {
                return b;
            }
            case CAST_NORTH_WEST: {
                return b;
            }
            case CAST_RUN_EAST: {
                return g;
            }
            case CAST_RUN_NORTH: {
                return g;
            }
            case CAST_RUN_NORTH_EAST: {
                return g;
            }
            case CAST_RUN_NORTH_WEST: {
                return g;
            }
            case CAST_RUN_SOUTH: {
                return g;
            }
            case CAST_RUN_SOUTH_EAST: {
                return g;
            }
            case CAST_RUN_SOUTH_WEST: {
                return g;
            }
            case CAST_RUN_WEST: {
                return g;
            }
            case CAST_SOUTH: {
                return b;
            }
            case CAST_SOUTH_EAST: {
                return b;
            }
            case CAST_SOUTH_WEST: {
                return b;
            }
            case CAST_WEST: {
                return b;
            }
            case DEATH_EAST: {
                return c;
            }
            case DEATH_NORTH: {
                return c;
            }
            case DEATH_NORTH_EAST: {
                return c;
            }
            case DEATH_NORTH_WEST: {
                return c;
            }
            case DEATH_SOUTH: {
                return c;
            }
            case DEATH_SOUTH_EAST: {
                return c;
            }
            case DEATH_SOUTH_WEST: {
                return c;
            }
            case DEATH_WEST: {
                return c;
            }
            case IDLE_EAST: {
                return d;
            }
            case IDLE_NORTH: {
                return d;
            }
            case IDLE_NORTH_EAST: {
                return d;
            }
            case IDLE_NORTH_WEST: {
                return d;
            }
            case IDLE_SOUTH: {
                return d;
            }
            case IDLE_SOUTH_EAST: {
                return d;
            }
            case IDLE_SOUTH_WEST: {
                return d;
            }
            case IDLE_WEST: {
                return d;
            }
            case RUN_EAST: {
                return e;
            }
            case RUN_NORTH: {
                return e;
            }
            case RUN_NORTH_EAST: {
                return e;
            }
            case RUN_NORTH_WEST: {
                return e;
            }
            case RUN_SOUTH: {
                return e;
            }
            case RUN_SOUTH_EAST: {
                return e;
            }
            case RUN_SOUTH_WEST: {
                return e;
            }
            case RUN_WEST: {
                return e;
            }
        }
        return d;
    }

    public static PlayerAction a(cw cw2, Direction direction) {
        switch (cw2) {
            case var_cw_a: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.ATTACK_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.ATTACK_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.ATTACK_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.ATTACK_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.ATTACK_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.ATTACK_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.ATTACK_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.ATTACK_WEST;
                    }
                }
                break;
            }
            case b: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.CAST_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.CAST_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.CAST_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.CAST_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.CAST_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.CAST_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.CAST_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.CAST_WEST;
                    }
                }
                break;
            }
            case c: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.DEATH_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.DEATH_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.DEATH_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.DEATH_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.DEATH_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.DEATH_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.DEATH_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.DEATH_WEST;
                    }
                }
                break;
            }
            case d: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.IDLE_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.IDLE_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.IDLE_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.IDLE_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.IDLE_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.IDLE_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.IDLE_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.IDLE_WEST;
                    }
                }
                break;
            }
            case e: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.RUN_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.RUN_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.RUN_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.RUN_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.RUN_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.RUN_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.RUN_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.RUN_WEST;
                    }
                }
                break;
            }
            case f: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.ATTACK_RUN_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.ATTACK_RUN_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.ATTACK_RUN_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.ATTACK_RUN_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.ATTACK_RUN_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.ATTACK_RUN_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.ATTACK_RUN_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.ATTACK_RUN_WEST;
                    }
                }
                break;
            }
            case g: {
                switch (direction) {
                    case NORTH: {
                        return PlayerAction.CAST_RUN_NORTH;
                    }
                    case EAST: {
                        return PlayerAction.CAST_RUN_EAST;
                    }
                    case NORTH_EAST: {
                        return PlayerAction.CAST_RUN_NORTH_EAST;
                    }
                    case NORTH_WEST: {
                        return PlayerAction.CAST_RUN_NORTH_WEST;
                    }
                    case SOUTH: {
                        return PlayerAction.CAST_RUN_SOUTH;
                    }
                    case SOUTH_EAST: {
                        return PlayerAction.CAST_RUN_SOUTH_EAST;
                    }
                    case SOUTH_WEST: {
                        return PlayerAction.CAST_RUN_SOUTH_WEST;
                    }
                    case WEST: {
                        return PlayerAction.CAST_RUN_WEST;
                    }
                }
            }
        }
        return PlayerAction.IDLE_NORTH;
    }

    static {
        var_cw_a = new cw();
        b = new cw();
        c = new cw();
        d = new cw();
        e = new cw();
        f = new cw();
        g = new cw();
        var_cw_arr_a = new cw[]{var_cw_a, b, c, d, e, f, g};
    }
}

