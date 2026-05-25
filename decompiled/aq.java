/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.friendly.FriendlyAccountData;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.ReadyStatus;
import com.badlogic.gdx.math.MathUtils;
import java.util.ArrayList;

public class aq
extends br {
    public aq(Engine engine, String string, int n2, CharacterClass characterClass, int n3, ProfileBackgrounds profileBackgrounds, String string2, String string3, String string4, int n4, int n5, int n6, int n7, ArrayList<String> arrayList, int n8, int n9) {
        Engine.a("new FriendlyPlayer(" + string + ", " + n2 + ", " + (Object)((Object)characterClass) + ", " + n3 + ", " + (Object)((Object)profileBackgrounds));
        this.a = new FriendlyAccountData(engine, string, n2, characterClass, n3, profileBackgrounds, string2, string3, string4, n4, n5, n6, n7, arrayList, n8, n9);
        this.a.getActive_character_entity().bd_a().a(ReadyStatus.RED);
        this.a = n6;
        this.a = new azv(1000 + MathUtils.random(500), true);
    }

    public aq(Engine engine, String string, int n2, String string2, int n3, int n4, int n5, int n6, int n7) {
        this.a = new FriendlyAccountData(engine, string, n2, string2, n3, n4, n5, n6, n7);
        this.a = new azv(1000 + MathUtils.random(500), true);
    }

    @Override
    public FriendlyAccountData com_arenaofkings_packets_gameserver_data_player_friendly_FriendlyAccountData_a() {
        return (FriendlyAccountData)this.a;
    }
}

