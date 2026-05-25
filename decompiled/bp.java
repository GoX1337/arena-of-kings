/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.requests.input.JAVA_16_GFX_CL$61892;
import com.badlogic.gdx.utils.IntMap;

public class bp {
    private final bb var_bb_a = new IntMap();
    protected IntMap<JAVA_16_GFX_CL$61892> var_com_badlogic_gdx_utils_IntMap_com_arenaofkings_packets_gameserver_requests_input_JAVA_16_GFX_CL$61892__a;
    private int var_int_a = 1;

    public bp(bb bb2) {
        this.var_bb_a = bb2;
    }

    public void a(JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$61892) {
        this.var_bb_a.d(jAVA_16_GFX_CL$61892.$40());
        this.var_bb_a.e(jAVA_16_GFX_CL$61892.$50());
    }

    public int a() {
        return this.var_int_a++;
    }
}

