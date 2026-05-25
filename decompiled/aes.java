/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_LOGIN_ACCOUNT_INIT;
import com.arenaofkings.packets.misc.PartyRole;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public class aes
extends axc {
    private afw var_afw_a;
    private final float d = 0.006f;
    public static boolean var_boolean_a;
    public static boolean var_boolean_b;
    int var_int_a = 0;
    float var_float_a = 0.0f;
    int var_int_b = 0;
    float var_float_b = 0.0f;
    float c = 0.0f;
    private Date var_java_util_Date_a = new Date();
    Graphics.Monitor var_com_badlogic_gdx_Graphics$Monitor_a;
    Graphics.DisplayMode var_com_badlogic_gdx_Graphics$DisplayMode_a;
    Label var_com_badlogic_gdx_scenes_scene2d_ui_Label_a;
    Label.LabelStyle var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private PUB_LOGIN_ACCOUNT_INIT var_com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a = null;
    private boolean f = false;
    private azv var_azv_a = new azv(1000L, true);

    public aes(Engine engine, ayl ayl2) {
        super(engine, ayl2);
        this.var_com_badlogic_gdx_Graphics$Monitor_a = Gdx.graphics.getMonitor();
        this.var_com_badlogic_gdx_Graphics$DisplayMode_a = Gdx.graphics.getDisplayMode(this.var_com_badlogic_gdx_Graphics$Monitor_a);
        engine.d();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a = new Label.LabelStyle(engine.j, Color.GREEN);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label_a = new Label((CharSequence)"[Cloak of the Wolf]", this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label_a.addListener(new aet(this));
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label_a.setPosition(200.0f, 200.0f);
    }

    @Override
    public void show() {
        try {
            SteamAPI.loadLibraries();
            if (!SteamAPI.init()) {
                System.out.println("Failed to init steam");
                SteamAPI.printDebugInfo(System.err);
            }
        }
        catch (SteamException steamException) {
            // empty catch block
        }
        ((Engine)((Object)this.var_afw_a)).void_b();
        ((Engine)((Object)this.var_afw_a)).n();
        ay.ay_a().void_a();
        ay.ay_a().gf_a().a((Engine)((Object)this.var_afw_a), false);
        ay.ay_a().ge_a().a((Engine)((Object)this.var_afw_a), false);
        ay.ay_a().a(PartyRole.NONE);
        ((Engine)((Object)this.var_afw_a)).var_boolean_a = true;
        Engine.a("monitor: " + Gdx.graphics.getWidth() + "," + Gdx.graphics.getHeight());
        this.var_afw_a = new afw(((Engine)((Object)this.var_afw_a)).var_com_badlogic_gdx_assets_AssetManager_a);
        this.var_afw_a = new aex((axm)((Object)this.var_afw_a), (Engine)((Object)this.var_afw_a));
        if (this.var_afw_a != null && ((afz)((Object)this.var_afw_a)).var_boolean_a) {
            this.a(((afz)((Object)this.var_afw_a)).var_java_lang_String_a, ((afz)((Object)this.var_afw_a)).var_int_a, ((afz)((Object)this.var_afw_a)).b);
        }
        this.b();
        if (((aex)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_ui_TextField_a().getText().length() > 0) {
            ((aex)((Object)this.var_afw_a)).d();
        }
    }

    private void b() {
        ((Array)((Object)this.var_afw_a)).add(this.var_afw_a);
        ((Array)((Object)this.var_afw_a)).add(((aex)((Object)this.var_afw_a)).var_ayh_b);
        ((Array)((Object)this.var_afw_a)).add(((aex)((Object)this.var_afw_a)).var_ayh_c);
        ((Array)((Object)this.var_afw_a)).add(((aex)((Object)this.var_afw_a)).var_ayc_a);
        ((Array)((Object)this.var_afw_a)).add(((aex)((Object)this.var_afw_a)).var_ayc_b);
    }

    @Override
    public void render(float f2) {
        ((Engine)((Object)this.var_afw_a)).var_azi_a.setColor(Color.WHITE);
        if (!this.f && this.var_azv_a.boolean_b()) {
            Engine.b("PLAY TRYING");
            this.f = true;
        }
        if (Gdx.input.isKeyJustPressed(66) && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.isVisible()) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.remove();
            ((aex)((Object)this.var_afw_a)).void_c();
        }
        this.a(((Engine)((Object)this.var_afw_a)).var_azi_a);
        ((Engine)((Object)this.var_afw_a)).a(((Engine)((Object)this.var_afw_a)).var_azi_a);
        if (!var_boolean_b) {
            var_boolean_b = true;
            this.void_c();
        } else {
            if (((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().a + 0.006f < 1.0f) {
                float f3 = ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().a + 0.006f;
                ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().setColor(((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().r, ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().g, ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().b, f3);
                if (((aex)((Object)this.var_afw_a)).var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getColor().a + 0.024f < 1.0f) {
                    ((aex)((Object)this.var_afw_a)).var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(f3 * 4.0f);
                }
                if (((aex)((Object)this.var_afw_a)).var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getColor().a + 0.024f < 1.0f) {
                    ((aex)((Object)this.var_afw_a)).var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(f3 * 4.0f);
                }
                if (((aex)((Object)this.var_afw_a)).var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().getColor().a + 0.024f < 1.0f) {
                    ((aex)((Object)this.var_afw_a)).var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(f3 * 4.0f);
                }
                if (((aex)((Object)this.var_afw_a)).var_ayc_a.com_badlogic_gdx_graphics_g2d_Sprite_b().getColor().a + 0.024f < 1.0f) {
                    ((aex)((Object)this.var_afw_a)).var_ayc_a.b(f3 * 4.0f);
                }
                if (((aex)((Object)this.var_afw_a)).var_ayc_b.com_badlogic_gdx_graphics_g2d_Sprite_b().getColor().a + 0.024f < 1.0f) {
                    ((aex)((Object)this.var_afw_a)).var_ayc_b.b(f3 * 4.0f);
                }
                if (var_boolean_a) {
                    this.var_afw_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(f3);
                } else {
                    this.var_afw_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                }
            } else {
                ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().setColor(((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().r, ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().g, ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().b, 1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_a.b(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_b.b(1.0f);
                this.var_afw_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
            }
            if (((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().a >= 0.994f) {
                var_boolean_a = false;
                ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().setColor(((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().r, ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().g, ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().b, 1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_a.b(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_b.b(1.0f);
                this.var_afw_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
            }
            Gdx.input.setInputProcessor(((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c());
            ((Engine)((Object)this.var_afw_a)).var_azi_a.c(f2, (Array<axr>)((Object)this.var_afw_a));
            ((Engine)((Object)this.var_afw_a)).var_azi_a.a(f2, (Array<axr>)((Object)this.var_afw_a));
            this.var_afw_a.a(f2, ((Engine)((Object)this.var_afw_a)).var_azi_a);
            ((Engine)((Object)this.var_afw_a)).l();
            ((Engine)((Object)this.var_afw_a)).var_azi_a.begin();
            this.void_a();
            ((Engine)((Object)this.var_afw_a)).var_azi_a.end();
        }
        this.b(((Engine)((Object)this.var_afw_a)).var_azi_a);
        ((Engine)((Object)this.var_afw_a)).e();
    }

    private void void_c() {
        if (var_boolean_b) {
            if (var_boolean_a) {
                ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().a = 0.0f;
                ((aex)((Object)this.var_afw_a)).var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_a.b(0.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_b.b(0.0f);
                this.var_afw_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.0f);
            } else {
                ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getRoot().getColor().a = 1.0f;
                ((aex)((Object)this.var_afw_a)).var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_a.b(1.0f);
                ((aex)((Object)this.var_afw_a)).var_ayc_b.b(1.0f);
                this.var_afw_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(1.0f);
            }
        }
    }

    public void void_a() {
        if (Gdx.graphics.getFramesPerSecond() >= 70) {
            ((Engine)((Object)this.var_afw_a)).a("[WHITE]FPS:[] [GREEN]" + Gdx.graphics.getFramesPerSecond() + "[]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        } else if (Gdx.graphics.getFramesPerSecond() >= 50) {
            ((Engine)((Object)this.var_afw_a)).a("[WHITE]FPS:[] [LIME]" + Gdx.graphics.getFramesPerSecond() + "[]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        } else if (Gdx.graphics.getFramesPerSecond() >= 40) {
            ((Engine)((Object)this.var_afw_a)).a("[WHITE]FPS:[] [ORANGE]" + Gdx.graphics.getFramesPerSecond() + "[]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        } else {
            ((Engine)((Object)this.var_afw_a)).a("[WHITE]FPS:[] [RED]" + Gdx.graphics.getFramesPerSecond() + " UNPLAYABLE![]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        }
        StringBuilder stringBuilder = new StringBuilder().append("[WHITE]Version:[] [RARITY_LEGENDARY]");
        Objects.requireNonNull(this.var_afw_a);
        ((Engine)((Object)this.var_afw_a)).a(stringBuilder.append("2.0.0.0").append("[]").toString(), ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 30.0f, 8);
        ((Engine)((Object)this.var_afw_a)).var_axy_c.a().setColor(Color.WHITE);
        switch (((Engine)((Object)this.var_afw_a)).var_z_a.w_a()) {
            case b: {
                ((Engine)((Object)this.var_afw_a)).a("[WHITE]Server Status: [RED]Offline[]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 50.0f, 8);
                break;
            }
            case var_w_a: {
                ((Engine)((Object)this.var_afw_a)).a("[WHITE]Server Status: [GREEN]Online[]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 50.0f, 8);
                break;
            }
            case c: {
                ((Engine)((Object)this.var_afw_a)).a("[WHITE]Server Status: [YELLOW]Connecting[]", ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_afw_a)).var_axy_c.a(), Color.BLACK, 10.0f, 50.0f, 8);
                break;
            }
        }
        ((Engine)((Object)this.var_afw_a)).var_axy_c.a().draw(((Engine)((Object)this.var_afw_a)).var_azi_a, ((Engine)((Object)this.var_afw_a)).var_java_lang_String_f, 102.0f, 705.0f, 0, ((Engine)((Object)this.var_afw_a)).var_java_lang_String_f.length(), 450.0f, 8, true);
        ZoneId zoneId = ZoneId.of("UTC");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(2021, 12, 17, 17, 0, 0, 0, zoneId);
        LocalDateTime localDateTime2 = LocalDateTime.from(zonedDateTime);
        long l2 = localDateTime2.until(zonedDateTime2, ChronoUnit.YEARS);
        localDateTime2 = localDateTime2.plusYears(l2);
        long l3 = localDateTime2.until(zonedDateTime2, ChronoUnit.MONTHS);
        localDateTime2 = localDateTime2.plusMonths(l3);
        long l4 = localDateTime2.until(zonedDateTime2, ChronoUnit.DAYS);
        localDateTime2 = localDateTime2.plusDays(l4);
        long l5 = localDateTime2.until(zonedDateTime2, ChronoUnit.HOURS);
        localDateTime2 = localDateTime2.plusHours(l5);
        long l6 = localDateTime2.until(zonedDateTime2, ChronoUnit.MINUTES);
        localDateTime2 = localDateTime2.plusMinutes(l6);
        long l7 = localDateTime2.until(zonedDateTime2, ChronoUnit.SECONDS);
        if (l4 < 0L) {
            l4 = 0L;
        }
        if (l5 < 0L) {
            l5 = 0L;
        }
        if (l6 < 0L) {
            l6 = 0L;
        }
        if (l7 < 0L) {
            l7 = 0L;
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public void a(String string, int n2, boolean bl2) {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_afw_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_afw_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new aeu(this, "", ((Engine)((Object)this.var_afw_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, bl2, n2, string, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(735.0f, 450.0f, 450.0f, 205.0f);
        if (!((aya)((Object)this.var_afw_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            ((aya)((Object)this.var_afw_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    @Override
    public void resize(int n2, int n3) {
        Engine.b("resize() called with " + n2 + "," + n3);
        super.resize(n2, n3);
        ((aya)((Object)this.var_afw_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getViewport().update(n2, n3, false);
        this.var_com_badlogic_gdx_Graphics$Monitor_a = Gdx.graphics.getMonitor();
        this.var_com_badlogic_gdx_Graphics$DisplayMode_a = Gdx.graphics.getDisplayMode(this.var_com_badlogic_gdx_Graphics$Monitor_a);
        Engine.b("resize out");
    }

    @Override
    public void resume() {
        System.out.println("RESUME");
        super.resume();
    }

    @Override
    public void pause() {
        System.out.println("PAUSED");
        super.pause();
    }

    public void a(PUB_LOGIN_ACCOUNT_INIT pUB_LOGIN_ACCOUNT_INIT) {
        this.var_com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a = pUB_LOGIN_ACCOUNT_INIT;
    }

    public PUB_LOGIN_ACCOUNT_INIT com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a() {
        return this.var_com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a;
    }

    static {
        var_boolean_a = true;
        var_boolean_b = false;
    }
}

