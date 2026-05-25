/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.PlayerAction;

public class ps
extends pe {
    private float var_float_e = 0.0f;
    private boolean var_boolean_e = true;

    public ps(Engine engine) {
        super(engine, EffectList.Windstorm);
        this.b(1.0f);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_float_e += f2;
        if ((double)this.var_float_e >= 0.05 || this.var_boolean_e) {
            Direction direction;
            this.var_float_e = 0.0f;
            this.var_boolean_e = false;
            switch (this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a()) {
                case NORTH: {
                    direction = Direction.NORTH_EAST;
                    break;
                }
                case NORTH_EAST: {
                    direction = Direction.EAST;
                    break;
                }
                case EAST: {
                    direction = Direction.SOUTH_EAST;
                    break;
                }
                case SOUTH_EAST: {
                    direction = Direction.SOUTH;
                    break;
                }
                case SOUTH: {
                    direction = Direction.SOUTH_WEST;
                    break;
                }
                case SOUTH_WEST: {
                    direction = Direction.WEST;
                    break;
                }
                case WEST: {
                    direction = Direction.NORTH_WEST;
                    break;
                }
                case NORTH_WEST: {
                    direction = Direction.NORTH;
                    break;
                }
                default: {
                    direction = this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a();
                }
            }
            this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(PlayerAction.IDLE_NORTH);
            this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(direction);
        }
    }
}

