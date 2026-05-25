/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class yp
extends yf {
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private ayf var_ayf_c;
    private int var_int_a = 1;
    private int var_int_b = 1;
    private int var_int_c = 1;
    private final yg var_yg_a;

    public yp(yg yg2, Stage stage, Engine engine, TextureAtlas textureAtlas) {
        super(402, 365, textureAtlas, "empty_panel");
        this.var_yg_a = yg2;
        this.var_ayf_a = new yq(this, 406, 387, textureAtlas, "training_panel_new_default", "training_panel_new_hovered", false, engine);
        this.var_ayf_b = new yr(this, 786, 387, textureAtlas, "play_panel_new_default", "play_panel_new_hovered", false, yg2, stage);
        this.var_ayf_c = new ys(this, 1165, 387, textureAtlas, "play_panel_new_default", "play_panel_new_hovered", true, yg2, stage);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayf_a.a(f2, engine);
        this.var_ayf_b.a(f2, engine);
        this.var_ayf_c.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_yg_a.var_boolean_a = false;
        if (((ayh)((Object)this.var_ayf_a)).boolean_b()) {
            this.a(f2, engine);
            super.b(f2, engine);
            this.var_ayf_a.b(f2, engine);
            this.var_ayf_b.b(f2, engine);
        }
    }

    public void a(Engine engine, ArenaTeamData arenaTeamData) {
        if (this.var_int_b == 1) {
            this.var_yg_a.void_d();
        } else if (this.var_int_b == 2) {
            this.var_yg_a.void_e();
        } else if (this.var_int_b == 3) {
            this.var_yg_a.f();
        }
        this.var_yg_a.var_boolean_a = true;
        this.var_yg_a.a(true);
        this.var_yg_a.a(arenaTeamData);
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
        this.var_ayf_a.a(true);
        this.var_ayf_b.a(true);
        this.var_ayf_c.a(true);
        System.out.println("Show called");
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
        this.var_ayf_a.a(false);
        this.var_ayf_b.a(false);
        this.var_ayf_c.a(false);
    }

    public void a(int n2) {
        this.var_int_b = n2;
    }

    public int a() {
        return this.var_int_c;
    }

    public void b(int n2) {
        this.var_int_c = n2;
    }

    static /* synthetic */ int a(yp yp2, int n2) {
        yp2.var_int_a = n2;
        return yp2.var_int_a;
    }

    static /* synthetic */ int b(yp yp2, int n2) {
        yp2.var_int_c = n2;
        return yp2.var_int_c;
    }
}

