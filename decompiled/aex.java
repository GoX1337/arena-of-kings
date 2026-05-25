/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_LOGIN_SALT_REQUEST;
import com.arenaofkings.packets.loginserver.PUB_MISC_PASSWORD_RESET;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import java.util.Objects;

public class aex
extends aya
implements Net.HttpResponseListener {
    protected TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    protected TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b;
    private da var_da_a;
    protected ayh var_ayh_a;
    protected ayh var_ayh_b;
    protected ayh var_ayh_c;
    protected ayc var_ayc_a;
    protected ayc var_ayc_b;
    private azv var_azv_a;
    private azv var_azv_b;
    private boolean var_boolean_a;
    private ayg var_ayg_a;
    private ayg var_ayg_b;
    private ayg var_ayg_c;
    protected ayf var_ayf_a;
    protected ayf var_ayf_b;
    protected ayf var_ayf_c;
    protected ayf var_ayf_d;
    protected ayf var_ayf_e;
    protected ayf var_ayf_f;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f = null;
    protected Dialog g = null;
    protected Dialog h = null;
    protected Dialog i = null;
    protected int var_int_a = 0;
    private azv var_azv_c = new azv(10000L, false);
    private ayg var_ayg_d;
    private boolean var_boolean_b;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d;
    TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e;
    private boolean var_boolean_c = false;
    private PUB_MISC_PASSWORD_RESET var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a = null;
    private boolean var_boolean_d = false;
    private boolean var_boolean_e = false;

    public aex(axm axm2, Engine engine) {
        super(axm2, engine);
    }

    @Override
    public void void_a() {
        this.var_azv_a = new azv(5000L, false);
        this.var_azv_b = new azv(50000L, false);
        this.t();
        this.s();
        this.u();
    }

    public void a(float f2) {
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).act(f2);
        this.q();
        this.p();
        this.var_ayg_c.b((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayg_d.b((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_boolean_e = false;
    }

    private void p() {
        if (Gdx.input.isKeyJustPressed(61)) {
            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b, true)) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.selectAll();
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.clearSelection();
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d);
                ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_baa_a.a(ajw.kC, 1.0f);
            } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
                if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e) {
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.selectAll();
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.clearSelection();
                    ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c);
                } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c) {
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.selectAll();
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.clearSelection();
                    ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e);
                } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e) {
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.selectAll();
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.clearSelection();
                    ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c);
                }
                ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_baa_a.a(ajw.kC, 1.0f);
            } else {
                if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b) {
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.selectAll();
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.clearSelection();
                    ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
                } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a) {
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.selectAll();
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.clearSelection();
                    ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
                } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b) {
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.selectAll();
                    this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.clearSelection();
                    ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
                }
                ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_baa_a.a(ajw.kC, 1.0f);
            }
        }
        if (Gdx.input.isKeyJustPressed(66)) {
            if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText().length() == 0 && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText().length() == 0) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.selectAll();
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.clearSelection();
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText().length() == 0) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.selectAll();
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.clearSelection();
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText().length() == 0) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.selectAll();
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.clearSelection();
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
            } else if (!(((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText().length() == 0 || this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText().length() == 0 || ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText().length() == 0 || this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText().length() == 0)) {
                this.var_ayc_b.void_a();
            }
        }
        if (Gdx.input.isKeyJustPressed(111) && !this.boolean_a()) {
            this.g();
            this.var_boolean_e = true;
        }
        if (Gdx.input.isKeyJustPressed(111) || Gdx.input.isKeyJustPressed(66)) {
            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d != null) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.remove();
                this.void_c();
            }
            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e != null) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.remove();
                this.void_c();
            }
            if (!this.var_boolean_e && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f != null) {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f.remove();
            }
        }
        if (Gdx.input.isKeyJustPressed(111) && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.remove();
            this.void_c();
        }
        if (Gdx.input.isKeyJustPressed(66)) {
            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b, true)) {
                this.b("confirm");
            } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
                this.a("confirm");
            }
        }
    }

    public void void_c() {
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
    }

    public void d() {
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
    }

    private void q() {
        if (this.var_boolean_a && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_b() && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_c()) {
            z z2 = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a;
            String string = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText();
            Objects.requireNonNull(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
            z2.void_a(new PUB_LOGIN_SALT_REQUEST(string, "2.0.0.0"));
            this.var_boolean_a = false;
            this.var_azv_a.void_c();
            this.var_azv_c.void_c();
        }
        if (this.var_azv_a.boolean_b() && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_a() || this.var_azv_b.boolean_b()) {
            this.var_azv_a.d();
            this.var_azv_b.d();
            this.var_boolean_a = false;
        }
        if (this.var_boolean_c && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_b() && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_c()) {
            ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.void_a(this.var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a);
            this.var_boolean_c = false;
        }
    }

    @Override
    public void a(float f2, azi azi2) {
        this.a(f2);
        azi2.begin();
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_da_a.com_badlogic_gdx_graphics_Color_a().a = 0.2f;
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, -30);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 170);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 690);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 890);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 1090);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 1290);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 1200);
        if (this.var_boolean_b && !this.boolean_a()) {
            ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).a("[RARITY_RARE]Forgot your password?", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_axy_c.a(), Color.BLACK, 957.0f, 455.0f, 1);
        } else {
            ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).a("[WHITE]Forgot your password?", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_axy_c.a(), Color.BLACK, 957.0f, 455.0f, 1);
        }
        if (this.var_boolean_d) {
            this.var_boolean_d = false;
            this.r();
        }
        azi2.end();
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).draw();
    }

    private void r() {
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setText("");
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new aey(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(750.0f, 425.0f, 450.0f, 250.0f);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
    }

    public void a(Object object) {
        if (object.equals("confirm")) {
            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.getText().length() >= 8 && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.getText().equals(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.getText())) {
                this.var_boolean_c = true;
                this.var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a = new PUB_MISC_PASSWORD_RESET();
                this.var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a.email = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.getText();
                this.var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a.returnCode = 1560;
            } else {
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setText("");
                this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setText("");
                this.r();
            }
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setText("");
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setText("");
        if (this.g != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.g, true)) {
            this.g.remove();
        }
    }

    private void s() {
        TextField textField = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b = new TextField("", textField.getStyle());
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPosition(819.0f, 520.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPasswordMode(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPasswordCharacter('*');
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setMaxLength(20);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setColor(Color.LIGHT_GRAY);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getStyle().fontColor = Color.WHITE;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getStyle().disabledFontColor = Color.GREEN;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", textField.getStyle());
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(819.0f, 583.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(15);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setColor(Color.WHITE);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getStyle().fontColor = Color.WHITE;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getStyle().disabledFontColor = Color.GREEN;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setBlinkTime(0.2f);
        if (((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_aj_a.boolean_a(ak.var_ak_a) && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_aj_a.java_lang_String_a(ak.b).length() > 0) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_aj_a.java_lang_String_a(ak.b));
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
        } else {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
        }
        if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c) {
            System.out.println("Focus is correct");
        }
        this.var_ayg_a = new afk(this, 770, 30, 894, 55);
        this.var_ayg_b = new afo(this, 1373, 30, 1418, 55);
        this.var_ayg_c = new afp(this, 1318, 260, 1672, 420);
    }

    private void t() {
        Engine.a("a");
        this.var_da_a = new da(ajw.jx, "Snow", 30, 0.02f, 0.0f, Animation.PlayMode.LOOP, 0, 0);
        this.var_da_a.a(((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jx));
        if (((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d) != null) {
            Engine.a("in good");
        } else {
            Engine.a("out bad");
        }
        this.var_ayh_c = new ayh(757, 330, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "login_main_frame", true);
        this.var_ayh_a = new ayh(785, 727, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "promo_banner", true);
        this.var_ayh_b = new ayh(185, 207, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "devupdate", true);
        this.var_ayc_a = new afq(this, 789, 370, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "login_register_free_account_default", "login_register_free_account_hovered", "login_register_free_account_grayed", true);
        this.var_ayc_b = new afr(this, 895, 463, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "login_login_default", "login_login_hovered", "login_login_grayed", true);
        this.var_ayf_a = new aft(this, 1565, 17, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "gamepedia_logo_default", "gamepedia_logo_hovered", true);
        this.var_ayf_b = new afu(this, 170, 270, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "discord_button_default", "discord_button_hovered", true);
        this.var_ayf_c = new afv(this, 1675, 17, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "facebook_button_default", "facebook_button_hovered", true);
        this.var_ayf_d = new aez(this, 240, 270, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "twitter_button_default", "twitter_button_hovered", true);
        this.var_ayf_e = new afa(this, 1785, 17, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "instagram_button_default", "instagram_button_hovered", true);
        this.var_ayf_f = new afb(this, 310, 270, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.d), "youtube_button_default", "youtube_button_hovered", true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setMaxLength(100);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setWidth(480.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setPosition(730.0f, 625.0f);
        Engine.b("login loadChat 7");
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.getStyle());
        textFieldStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).o;
        Engine.b("login loadChat 8");
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setStyle(textFieldStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setMaxLength(100);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setWidth(480.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setPosition(730.0f, 625.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setStyle(textFieldStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setPasswordMode(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setPasswordCharacter('*');
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setMaxLength(100);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setWidth(480.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setPosition(730.0f, 625.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setStyle(textFieldStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setPasswordMode(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setPasswordCharacter('*');
        this.var_ayg_d = new afc(this, 875, 440, 1020, 458);
    }

    public void b(Object object) {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.getText().length() > 0) {
            if (object.equals("confirm")) {
                this.var_boolean_c = true;
                this.var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a = new PUB_MISC_PASSWORD_RESET();
                this.var_com_arenaofkings_packets_loginserver_PUB_MISC_PASSWORD_RESET_a.email = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.getText();
            }
            this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setText("");
        }
    }

    @Override
    public void void_b() {
        super.void_b();
    }

    private void u() {
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
    }

    @Override
    public void handleHttpResponse(Net.HttpResponse httpResponse) {
        Engine.a("whoops");
    }

    public void e() {
        this.k();
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e = new afe(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setDisabled(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setDisabled(false);
    }

    public void f() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e = new aff(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setDisabled(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setDisabled(false);
    }

    public void g() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f = new afg(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f);
        }
    }

    public void h() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d = new afh(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setDisabled(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setDisabled(false);
    }

    public void i() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d = new afi(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    public void j() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d = new afj(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setDisabled(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setDisabled(false);
    }

    public void k() {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c.remove();
        }
    }

    public void l() {
        if (this.g != null) {
            this.g.remove();
        }
    }

    public void a(int n2) {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c != null) {
            ((Label)this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c.getContentTable().findActor("authenticationDialog")).setText("We're experiencing a high volume of users.\n              Your position in queue is [GREEN]" + n2 + "[].");
        }
    }

    @Override
    public void failed(Throwable throwable) {
        Engine.a("failed()");
    }

    @Override
    public void cancelled() {
        Engine.a("cancelled()");
    }

    public TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    }

    public TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_b() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b;
    }

    public void m() {
        this.var_boolean_d = true;
        if (this.g != null) {
            this.g.hide();
        }
    }

    public boolean boolean_a() {
        boolean bl2 = false;
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            bl2 = true;
        } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b, true)) {
            bl2 = true;
        } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c, true)) {
            bl2 = true;
        } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d, true)) {
            bl2 = true;
        } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e, true)) {
            bl2 = true;
        } else if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f, true)) {
            bl2 = true;
        } else if (this.g != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.g, true)) {
            bl2 = true;
        } else if (this.h != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.h, true)) {
            bl2 = true;
        } else if (this.i != null && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.i, true)) {
            bl2 = true;
        }
        return bl2;
    }

    public void n() {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.remove();
        }
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.h = new afl(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.h.align(1);
        this.h.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.h, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.h);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    public void o() {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.remove();
        }
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.remove();
        }
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.i = new afm(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.i.align(1);
        this.i.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.i, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.i);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    static /* synthetic */ TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a(aex aex2) {
        return aex2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e;
    }

    static /* synthetic */ boolean a(aex aex2, boolean bl2) {
        aex2.var_boolean_a = bl2;
        return aex2.var_boolean_a;
    }

    static /* synthetic */ azv azv_a(aex aex2) {
        return aex2.var_azv_a;
    }

    static /* synthetic */ azv azv_b(aex aex2) {
        return aex2.var_azv_b;
    }

    static /* synthetic */ boolean b(aex aex2, boolean bl2) {
        aex2.var_boolean_b = bl2;
        return aex2.var_boolean_b;
    }

    static /* synthetic */ TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_b(aex aex2) {
        return aex2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d;
    }
}

