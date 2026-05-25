/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.LadderPlayerData;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class zt
extends zm {
    private ayh var_ayh_a = new ArrayList();
    private ayf var_ayf_a;
    private Map<CharacterClass, ayh> cfr_renamed_8;
    ArrayList<LadderPlayerData> var_java_util_ArrayList_com_arenaofkings_packets_misc_LadderPlayerData__a;
    Array<zn> var_com_badlogic_gdx_utils_Array_zn__a;

    public zt(Engine engine, axm axm2, Stage stage) {
        super(engine, axm2, stage);
    }

    @Override
    public void void_a() {
        TextureAtlas textureAtlas = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        TextureAtlas textureAtlas2 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.je);
        TextureAtlas textureAtlas3 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i);
        this.var_ayh_a = new ayh(684, 922, textureAtlas, "ladder_main_frame", true);
        this.var_ayf_a = new ayf(0, 0, textureAtlas, "tournament_longview_row", "tournament_longview_row_hovered", true);
        this.var_ayh_a = new HashMap();
        this.var_ayh_a.put(CharacterClass.ASSASSIN, new ayh(0, 0, textureAtlas, "Assassin_square", true));
        this.var_ayh_a.put(CharacterClass.CHAMPION, new ayh(0, 0, textureAtlas, "Champion_square", true));
        this.var_ayh_a.put(CharacterClass.ELDER, new ayh(0, 0, textureAtlas, "Elder_square", true));
        this.var_ayh_a.put(CharacterClass.LICH, new ayh(0, 0, textureAtlas, "Lich_square", true));
        this.var_ayh_a.put(CharacterClass.MYSTIC, new ayh(0, 0, textureAtlas, "Mystic_square", true));
        this.var_ayh_a.put(CharacterClass.NIHILIST, new ayh(0, 0, textureAtlas, "Nihilist_square", true));
        this.var_ayh_a.put(CharacterClass.PALADIN, new ayh(0, 0, textureAtlas, "Paladin_square", true));
        this.var_ayh_a.put(CharacterClass.RANGER, new ayh(0, 0, textureAtlas, "Ranger_square", true));
        this.var_ayh_a.put(CharacterClass.SCHOLAR, new ayh(0, 0, textureAtlas, "Scholar_square", true));
        this.var_ayh_a.put(CharacterClass.WIZARD, new ayh(0, 0, textureAtlas, "Wizard_square", true));
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_ayh_a != false) {
            this.var_ayh_a.b(f2, engine);
            for (int i2 = 0; i2 < ((Array)((Object)this.var_ayh_a)).size; ++i2) {
                zn zn2 = (zn)((Array)((Object)this.var_ayh_a)).get(i2);
                zn2.b(f2, engine);
            }
        }
    }

    public void a(ArrayList<LadderPlayerData> arrayList) {
        if (arrayList != null) {
            this.var_ayh_a = arrayList;
            if (this.var_ayh_a == null) {
                this.var_ayh_a = new Array();
            } else {
                ((Array)((Object)this.var_ayh_a)).clear();
            }
            int n2 = 0;
            for (LadderPlayerData ladderPlayerData : arrayList) {
                zn zn2 = new zn(this, ladderPlayerData, this.var_ayf_a, (ayh)this.var_ayh_a.get((Object)ladderPlayerData.character_class), n2++);
                ((Array)((Object)this.var_ayh_a)).add(zn2);
            }
        }
    }

    @Override
    public void void_b() {
        this.var_ayh_a = (ayh)true;
    }

    @Override
    public void void_c() {
        this.var_ayh_a = (ayh)false;
    }
}

