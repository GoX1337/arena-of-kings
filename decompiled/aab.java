/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.TournamentMatchData;
import com.arenaofkings.packets.loginserver.TournamentTeamData;
import com.arenaofkings.packets.misc.TournamentStatus;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class aab
implements axr {
    protected final aaf var_aaf_a = new ArrayList();
    protected final zz var_zz_a;
    protected ayh var_ayh_a;
    protected ayh var_ayh_b = new ArrayList();
    protected ayf var_ayf_a;
    protected ayh var_ayh_c;
    protected ayh d;
    protected int var_int_a;
    protected int var_int_b;
    protected int var_int_c;
    protected boolean var_boolean_a = false;
    protected ayg var_ayg_a;
    protected Date var_java_util_Date_a;
    protected String var_java_lang_String_a;
    protected List<TournamentTeamData> var_java_util_List_com_arenaofkings_packets_loginserver_TournamentTeamData__a;
    protected List<TournamentMatchData> var_java_util_List_com_arenaofkings_packets_loginserver_TournamentMatchData__b;
    protected boolean var_boolean_b = false;
    private aae var_aae_a;
    private boolean var_boolean_c = false;

    public aab(aaf aaf2, zz zz2, int n2, ayh ayh2, ayh ayh3, ayf ayf2, ayh ayh4, ayh ayh5) {
        this.var_aaf_a = aaf2;
        this.var_zz_a = zz2;
        this.var_int_c = n2;
        this.var_ayh_a = ayh2;
        this.var_ayh_b = ayh3;
        this.var_ayf_a = ayf2;
        this.var_ayh_c = ayh4;
        this.d = ayh5;
        this.var_aae_a = new aae(zz2, aaf2.a(), ayh4, 690, 532);
        this.void_a();
        this.var_ayg_a = new aac(this, this.var_int_a, this.var_int_b + 2, this.var_int_a + 828, this.var_int_b + 26, aaf2);
        this.var_java_util_Date_a = new Date();
        this.var_java_lang_String_a = this.var_java_lang_String_a + " UTC";
    }

    private void void_a() {
        this.var_int_a = 686;
        this.var_int_b = 805 - this.var_int_c * 28;
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayg_a.b(engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_boolean_a) {
            this.var_ayh_b.b(f2, engine, 685, 577);
            this.d.a(f2, engine);
            this.d.b(f2, engine);
            if (this.var_zz_a.java_lang_String_a().contains("Monthly")) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.l, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            }
            if (this.var_zz_a.java_lang_String_a().contains("Weekly")) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.k, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            }
            if (this.var_zz_a.java_lang_String_a().contains("Season")) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.m, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            } else {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            }
            engine.a("3v3 Premade Teams | Open ", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1095.0f, 728.0f, 8, 1);
            engine.a(this.var_java_lang_String_a, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1095.0f, 799.0f, 8, 1);
            switch (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()) {
                case CANCELED: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case ENDED: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case HIDDEN: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case IN_PROGRESS: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.ORANGE, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case REGISTRATION: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case UPCOMING: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
            }
        } else {
            this.var_ayf_a.a(f2, engine, this.var_int_a, this.var_int_b);
            if (this.var_int_c == 0) {
                // empty if block
            }
            engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.var_int_b + 18), 8, 1);
            engine.a(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a().name(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 341), (float)(this.var_int_b + 18), 1, 1);
            this.var_ayh_a.b(f2, engine, this.var_int_a + 474, this.var_int_b - 5);
            engine.a(this.java_lang_String_a(this.var_zz_a.java_util_Date_a().getTime()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 816), (float)(this.var_int_b + 18), 16, 1);
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_boolean_a) {
            this.a(f2, engine);
            this.var_ayh_b.b(f2, engine, 685, 577);
            this.d.a(f2, engine);
            this.d.b(f2, engine);
            if (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a() == TournamentStatus.REGISTRATION) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            } else if (this.var_zz_a.java_lang_String_a().contains("Monthly")) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.l, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            } else if (this.var_zz_a.java_lang_String_a().contains("Weekly")) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.k, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            } else if (this.var_zz_a.java_lang_String_a().contains("Season")) {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.m, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            } else {
                engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 890.0f, 857.0f, 1, 1);
            }
            engine.a("3v3 Premade Teams | Open ", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1095.0f, 728.0f, 8, 1);
            if (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a() == TournamentStatus.REGISTRATION) {
                engine.a(this.var_java_lang_String_a, engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, 1095.0f, 799.0f, 8, 1);
            } else {
                engine.a(this.var_java_lang_String_a, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1095.0f, 799.0f, 8, 1);
            }
            switch (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()) {
                case CANCELED: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case ENDED: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case HIDDEN: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case IN_PROGRESS: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.ORANGE, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case REGISTRATION: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
                case UPCOMING: {
                    engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1511.0f, 728.0f, 16, 1);
                    break;
                }
            }
            this.var_aae_a.b(f2, engine);
        }
    }

    public void d(float f2, Engine engine) {
        this.var_ayf_a.a((float)this.var_int_a, this.var_int_b);
        this.a(f2, engine);
        this.var_ayf_a.a(f2, engine, this.var_int_a, this.var_int_b);
        if (!this.var_boolean_c && this.var_ayf_a.boolean_b()) {
            Engine.b("play it");
            engine.var_baa_a.a(ajw.kK, 0.6f);
            this.var_boolean_c = true;
        } else if (!this.var_ayf_a.boolean_b()) {
            this.var_boolean_c = false;
            Engine.b("Don't play it");
        }
        if (this.var_int_c == 0) {
            // empty if block
        }
        if (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a() == TournamentStatus.REGISTRATION) {
            engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.var_int_b + 18), 8, 1);
        } else if (this.var_zz_a.java_lang_String_a().contains("Monthly")) {
            engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.l, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.var_int_b + 18), 8, 1);
        } else if (this.var_zz_a.java_lang_String_a().contains("Weekly")) {
            engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.k, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.var_int_b + 18), 8, 1);
        } else if (this.var_zz_a.java_lang_String_a().contains("Season")) {
            engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), axe.m, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.var_int_b + 18), 8, 1);
        } else {
            engine.a(this.var_zz_a.java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.var_int_b + 18), 8, 1);
        }
        switch (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()) {
            case CANCELED: {
                engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 346), (float)(this.var_int_b + 18), 1, 1);
                break;
            }
            case ENDED: {
                engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 346), (float)(this.var_int_b + 18), 1, 1);
                break;
            }
            case HIDDEN: {
                engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 346), (float)(this.var_int_b + 18), 1, 1);
                break;
            }
            case IN_PROGRESS: {
                engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.ORANGE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 346), (float)(this.var_int_b + 18), 1, 1);
                break;
            }
            case REGISTRATION: {
                engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 346), (float)(this.var_int_b + 18), 1, 1);
                break;
            }
            case UPCOMING: {
                engine.a(TournamentStatus.getFormattedName(this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a()), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 346), (float)(this.var_int_b + 18), 1, 1);
                break;
            }
        }
        this.var_ayh_a.b(f2, engine, this.var_int_a + 474, this.var_int_b - 5);
        if (this.var_zz_a.com_arenaofkings_packets_misc_TournamentStatus_a() == TournamentStatus.REGISTRATION) {
            engine.a(this.java_lang_String_a(this.var_zz_a.java_util_Date_a().getTime()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 816), (float)(this.var_int_b + 18), 16, 1);
        } else {
            engine.a(this.java_lang_String_a(this.var_zz_a.java_util_Date_a().getTime()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 816), (float)(this.var_int_b + 18), 16, 1);
        }
    }

    private int int_a() {
        Date date = new Date();
        int n2 = (int)((double)date.getTime() * 0.001);
        return n2;
    }

    public int int_a(long l2) {
        int n2 = (int)(l2 - (long)this.int_a());
        int n3 = (int)Math.floor(n2 / 86400);
        return n3;
    }

    public int b(long l2) {
        int n2 = (int)(l2 - (long)this.int_a());
        int n3 = (int)Math.floor((n2 %= 86400) / 3600);
        return n3;
    }

    public int c(long l2) {
        int n2 = (int)(l2 - (long)this.int_a());
        n2 %= 86400;
        int n3 = (int)Math.floor((n2 %= 3600) / 60);
        return n3;
    }

    public int d(long l2) {
        int n2 = (int)(l2 - (long)this.int_a());
        n2 %= 86400;
        n2 %= 3600;
        return n2 %= 60;
    }

    public String java_lang_String_a(long l2) {
        int n2 = (int)(l2 - (long)this.int_a());
        int n3 = (int)Math.floor(n2 / 86400);
        int n4 = (int)Math.floor((n2 %= 86400) / 3600);
        int n5 = (int)Math.floor((n2 %= 3600) / 60);
        n2 %= 60;
        if (n3 > 0) {
            return n3 + " days " + n4 + " hours " + n5 + " min " + n2 + " sec";
        }
        if (n4 > 0) {
            return n4 + " hours " + n5 + " min " + n2 + " sec";
        }
        if (n5 > 0) {
            return n5 + " min " + n2 + " sec";
        }
        if (n2 > 0) {
            return n2 + " sec";
        }
        return "Started";
    }

    public void a(List<TournamentMatchData> list) {
        this.var_ayh_b = list;
    }

    public zz zz_a() {
        return this.var_zz_a;
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }
}

