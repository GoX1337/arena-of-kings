/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import java.util.ArrayList;

public class agt
implements axr {
    private ayh var_ayh_a = new ArrayList();
    private ayh var_ayh_b = new ArrayList();
    private ahu var_ahu_a;
    private ahx var_ahx_a;
    private ahl var_ahl_a;
    private ArrayList<agx> var_java_util_ArrayList_agx__a;
    private ArrayList<aha> var_java_util_ArrayList_aha__b;
    private ArrayList<ahi> c = new ArrayList();
    private ahh var_ahh_a;
    private ahe var_ahe_a;
    private agw var_agw_a;

    public agt(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, CharacterClass characterClass) {
        this.var_ayh_a = new ayh(0, 0, textureAtlas, "bottom_bar_dark", true);
        this.var_ayh_b = new ayh(664, 0, textureAtlas, "bottom_chunk_dark", true);
        this.var_ahl_a = new ahl(textureAtlas, textureAtlas2, characterClass);
        this.var_ahu_a = new ahu(engine, textureAtlas, textureAtlas2, ay.ay_a(), true);
        this.var_ahx_a = new ahx(engine, textureAtlas, textureAtlas2, ay.ay_a());
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            Engine.a("adding a player, partySize=" + ay.ay_a().gf_a().a().values().size());
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1 && !engine.var_aj_a.boolean_a(ai.w)) {
                ((ArrayList)((Object)this.var_ayh_a)).add(new agx(engine, textureAtlas, textureAtlas2, br2, true));
            } else if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2 && !engine.var_aj_a.boolean_a(ai.z)) {
                ((ArrayList)((Object)this.var_ayh_a)).add(new agx(engine, textureAtlas, textureAtlas2, br2, true));
            } else if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 3 && !engine.var_aj_a.boolean_a(ai.C)) {
                ((ArrayList)((Object)this.var_ayh_a)).add(new agx(engine, textureAtlas, textureAtlas2, br2, true));
            }
            if (!engine.var_aj_a.boolean_a(ai.i)) continue;
            this.c.add(new ahi(engine, textureAtlas, textureAtlas2, br2));
        }
        for (br br2 : ay.ay_a().ge_a().a().values()) {
            Engine.a("adding a player, partySize=" + ay.ay_a().gf_a().a().values().size());
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1 && !engine.var_aj_a.boolean_a(ai.H)) {
                ((ArrayList)((Object)this.var_ayh_b)).add(new aha(engine, textureAtlas, textureAtlas2, br2));
                continue;
            }
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2 && !engine.var_aj_a.boolean_a(ai.K)) {
                ((ArrayList)((Object)this.var_ayh_b)).add(new aha(engine, textureAtlas, textureAtlas2, br2));
                continue;
            }
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() != 3 || engine.var_aj_a.boolean_a(ai.N)) continue;
            ((ArrayList)((Object)this.var_ayh_b)).add(new aha(engine, textureAtlas, textureAtlas2, br2));
        }
        this.var_ahh_a = new ahh(textureAtlas);
        this.var_ahe_a = new ahe(textureAtlas);
        switch (characterClass) {
            case ASSASSIN: {
                this.var_agw_a = new ahd(textureAtlas);
                break;
            }
            case ELDER: {
                this.var_agw_a = new ahf(textureAtlas);
                break;
            }
            case PALADIN: {
                this.var_agw_a = new ahf(textureAtlas);
                break;
            }
            case LICH: {
                this.var_agw_a = new ahf(textureAtlas);
                break;
            }
            case SCHOLAR: {
                this.var_agw_a = new ahf(textureAtlas);
                break;
            }
            case NIHILIST: {
                this.var_agw_a = new ahf(textureAtlas);
                break;
            }
            case MYSTIC: {
                this.var_agw_a = new ahf(textureAtlas);
                break;
            }
            case RANGER: {
                this.var_agw_a = new ahd(textureAtlas);
                break;
            }
            case CHAMPION: {
                this.var_agw_a = new ahg(textureAtlas);
                break;
            }
            case WIZARD: {
                this.var_agw_a = new ahf(textureAtlas);
            }
        }
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ahl_a.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (!ay.ay_a().gd_a().boolean_b()) {
            this.a(f2, engine);
            if (engine.var_aj_a.boolean_a(ai.Q)) {
                this.var_ayh_a.b(f2, engine);
            }
            if (engine.var_aj_a.boolean_a(ai.R)) {
                this.var_ayh_b.b(f2, engine);
            }
            this.var_ahu_a.b(f2, engine);
            this.var_ahx_a.b(f2, engine);
            Object object2 = ((ArrayList)((Object)this.var_ayh_a)).iterator();
            while (object2.hasNext()) {
                agx object3 = (agx)object2.next();
                object3.b(f2, engine);
            }
            for (ahi ahi2 : this.c) {
                ahi2.b(f2, engine);
            }
            object2 = ((ArrayList)((Object)this.var_ayh_b)).iterator();
            while (object2.hasNext()) {
                aha aha2 = (aha)object2.next();
                aha2.b(f2, engine);
            }
            this.var_ahh_a.b(f2, engine);
            this.var_ahe_a.b(f2, engine);
            this.var_agw_a.b(f2, engine);
            object2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getPriorityEffect();
            if (object2 != null && oq.a((oo)object2).a() <= oq.g.a()) {
                String string = Engine.a((float)((oo)object2).azv_a().int_b() / 1000.0f, 1);
                engine.a("* " + (Object)((Object)oq.a((oo)object2)) + " " + string + " *", engine.var_axy_f.a(), axe.y, engine.var_axy_f.a(), Color.BLACK, 960.0f, 240.0f, 1, 2);
                engine.a("[RED]* " + (Object)((Object)oq.a((oo)object2)) + "[] [ORANGE]" + string + "[] *", engine.var_axy_f.a(), Color.RED, engine.var_axy_f.a(), Color.BLACK, 960.0f, 240.0f, 1);
            }
        }
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().b(f2, engine);
    }

    public ahl a() {
        return this.var_ahl_a;
    }
}

