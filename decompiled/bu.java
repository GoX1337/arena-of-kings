/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bu
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private int var_int_a;
    private int b;
    private ayh var_ayh_a;
    private boolean var_boolean_a = false;
    private ayg var_ayg_a;
    private List<bz> var_java_util_List_bz__a;
    private bz var_bz_a;
    private SelectBox<bz> var_com_badlogic_gdx_scenes_scene2d_ui_SelectBox_bz__a;
    private Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    private Array<bz> var_com_badlogic_gdx_utils_Array_bz__a;

    public bu(Engine engine, int n2, ArrayList<ItemData> arrayList) {
        Engine.b("stash 2.5");
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_int_a = 1053;
        this.b = 85;
        this.var_ayg_a = new bv(this, 1495, 930, 1525, 960);
        Engine.b("new Stash(). Number of tabs: " + n2);
        this.var_com_arenaofkings_client_core_Engine_a = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.var_com_arenaofkings_client_core_Engine_a.add(new bz(i2));
        }
        if (this.boolean_a(0)) {
            this.var_bz_a = (bz)this.var_com_arenaofkings_client_core_Engine_a.get(0);
        }
        for (ItemData itemData : arrayList) {
            Engine.b("Loading item: " + itemData);
            if (this.boolean_a(itemData.getStashTabIndex())) {
                bz bz2 = (bz)this.var_com_arenaofkings_client_core_Engine_a.get(itemData.getStashTabIndex());
                switch (itemData.getItemSlot()) {
                    case HEAD: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case SHOULDER: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case CHEST: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case HANDS: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case WRIST: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case LEGS: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case FEET: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case BACK: {
                        bz2.a(new fv(itemData), itemData.getItemPosition());
                        break;
                    }
                    case NECK: {
                        bz2.a(new fy(itemData), itemData.getItemPosition());
                        break;
                    }
                    case RING: {
                        bz2.a(new fy(itemData), itemData.getItemPosition());
                        break;
                    }
                    case TRINKET: {
                        bz2.a(new fy(itemData), itemData.getItemPosition());
                        break;
                    }
                    case WEAPON: {
                        bz2.a(new ga(itemData), itemData.getItemPosition());
                        break;
                    }
                    case CONSUMABLE: {
                        bz2.a(new fx(itemData), itemData.getItemPosition());
                        break;
                    }
                }
                continue;
            }
            Engine.b("ERROR doesn't have tab: ");
        }
        this.var_com_arenaofkings_client_core_Engine_a = new SelectBox(engine.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.a(engine);
    }

    public void a(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = new Array();
        Iterator iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
        while (iterator.hasNext()) {
            bz bz2 = (bz)iterator.next();
            ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(bz2);
        }
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setItems(this.var_com_arenaofkings_client_core_Engine_a);
        if (this.var_bz_a != null) {
            ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelected(this.var_bz_a);
        }
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setAlignment(1);
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getList().setAlignment(1);
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setWidth(100.0f);
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setColor(1.0f, 1.0f, 1.0f, 1.0f);
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getStyle().fontColor = Color.GREEN;
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).addCaptureListener(new bw(this));
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).addListener(new bx(this, engine));
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition(1090.0f, 930.0f);
    }

    public fm fm_a(int n2, int n3) {
        fm fm2 = null;
        if (this.boolean_a(n2)) {
            fm2 = ((bz)this.var_com_arenaofkings_client_core_Engine_a.get(n2)).fm_a(n3);
        }
        return fm2;
    }

    public boolean a(fm fm2) {
        for (int i2 = 0; i2 < this.var_com_arenaofkings_client_core_Engine_a.size(); ++i2) {
            bz bz2 = (bz)this.var_com_arenaofkings_client_core_Engine_a.get(i2);
            if (!bz2.boolean_a(fm2)) continue;
            Engine.b("Inserted new item " + fm2.java_lang_String_a());
            return true;
        }
        return false;
    }

    public void a(fm fm2, int n2, int n3) {
        fm2.c(n3);
        fm2.a(n2);
        fm2.b(ItemLocation.STASH);
        ((bz)this.var_com_arenaofkings_client_core_Engine_a.get(n3)).void_a(fm2);
    }

    public void void_a(int n2, int n3) {
        ((bz)this.var_com_arenaofkings_client_core_Engine_a.get(n3)).void_a(new ff(ItemLocation.STASH, n2));
    }

    public void a(axm axm2) {
        this.var_ayh_a = new ayh(this.var_int_a, this.b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "stash_window", true);
    }

    public void void_a() {
        if (!this.var_boolean_a && ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size > 0) {
            this.var_boolean_a = true;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jY);
            this.e();
        }
    }

    public void void_b() {
        if (!this.var_boolean_a && ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size > 0) {
            this.var_boolean_a = true;
            this.e();
        }
    }

    public void void_c() {
        if (this.var_boolean_a) {
            this.var_boolean_a = false;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jS);
            this.e();
        }
    }

    public void d() {
        if (this.var_boolean_a) {
            this.var_boolean_a = false;
            this.e();
        }
    }

    public void e() {
        if (this.boolean_a(0)) {
            this.var_bz_a = (bz)this.var_com_arenaofkings_client_core_Engine_a.get(0);
            ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelectedIndex(0);
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_a) {
            this.var_ayg_a.b(engine);
            this.var_ayh_a.b(f2, engine);
            if (this.var_bz_a != null) {
                this.var_bz_a.b(f2, engine);
            }
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_boolean_a && this.var_bz_a != null) {
            this.var_bz_a.c(f2, engine);
        }
    }

    public void d(float f2, Engine engine) {
        if (this.var_boolean_a && this.var_bz_a != null) {
            this.var_bz_a.d(f2, engine);
        }
    }

    public boolean boolean_b() {
        if (this.var_bz_a != null) {
            return this.var_bz_a.boolean_a();
        }
        return true;
    }

    public boolean boolean_c() {
        for (int i2 = 0; i2 < this.var_com_arenaofkings_client_core_Engine_a.size(); ++i2) {
            bz bz2 = (bz)this.var_com_arenaofkings_client_core_Engine_a.get(i2);
            if (bz2.boolean_a()) continue;
            return false;
        }
        return true;
    }

    public boolean boolean_a(int n2) {
        return n2 >= 0 && n2 < this.var_com_arenaofkings_client_core_Engine_a.size();
    }

    public bz bz_a() {
        return this.var_bz_a;
    }

    public List<bz> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public SelectBox<bz> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public void a(Stage stage) {
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = stage;
    }

    public void void_a(int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            bz bz2 = new bz(this.var_com_arenaofkings_client_core_Engine_a.size());
            this.var_com_arenaofkings_client_core_Engine_a.add(bz2);
        }
        this.a(this.var_com_arenaofkings_client_core_Engine_a);
    }

    static /* synthetic */ boolean boolean_a(bu bu2) {
        return bu2.var_boolean_a;
    }

    static /* synthetic */ bz a(bu bu2, bz bz2) {
        bu2.var_bz_a = bz2;
        return bu2.var_bz_a;
    }

    static /* synthetic */ SelectBox com_badlogic_gdx_scenes_scene2d_ui_SelectBox_a(bu bu2) {
        return bu2.var_com_arenaofkings_client_core_Engine_a;
    }
}

