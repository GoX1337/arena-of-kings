/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.client.chat;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.loginserver.PUB_PARTY_INVITE;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ItemLocale;
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public abstract class Chat
extends ayg
implements axr {
    public final Engine var_com_arenaofkings_client_core_Engine_a;
    protected axh var_axh_a;
    public TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    protected final int var_int_a;
    protected Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    protected Array<g> var_com_badlogic_gdx_utils_Array_g__a;
    protected int var_int_b;
    protected float var_float_a = 200.0f * ((float)Gdx.graphics.getWidth() / 1080.0f);
    protected int var_int_c;
    protected int var_int_d;
    protected BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a;
    protected BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_b;
    protected boolean var_boolean_a = true;
    GlyphLayout var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = new GlyphLayout();
    protected en var_en_a;
    protected fd var_fd_a;
    protected String var_java_lang_String_a;
    protected int var_int_e;
    protected int var_int_f;
    protected int var_int_g;
    protected int var_int_h;
    protected String var_java_lang_String_b = "";
    protected String var_java_lang_String_c = "";
    protected String var_java_lang_String_d = "";
    @Deprecated
    protected String var_java_lang_String_e = "";
    private String var_java_lang_String_f = "";
    private String var_java_lang_String_g = "";
    private String var_java_lang_String_h = "";
    private String i = "";
    private boolean var_boolean_d = false;
    protected Label.LabelStyle var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a;
    private azv var_azv_a = new azv(10000L, true);
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private ayh var_ayh_f;
    private ayh var_ayh_g;
    private ayh var_ayh_h;

    public Chat(Engine engine, axm axm2, BitmapFont bitmapFont, Skin skin, int n2, Stage stage, int n3, int n4, int n5, int n6, int n7, int n8) {
        super(n3, n4, n5, n6);
        Engine.a("Chat 1");
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_int_a = 100;
        this.var_int_c = n2 - n7;
        this.var_int_d = n2 - 1;
        this.var_com_arenaofkings_client_core_Engine_a = engine.var_java_lang_String_b;
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = bitmapFont;
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a.getData().markupEnabled = true;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a = new Label.LabelStyle(this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a, Color.WHITE);
        Engine.a("Chat 2");
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b = engine.m;
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = stage;
        this.var_axh_a = new axh("", skin);
        this.var_axh_a.c(8);
        this.var_axh_a.c(true);
        this.var_axh_a.void_a(n8);
        Engine.a("Chat 3");
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle(this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a());
        textFieldStyle.font = this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b;
        this.var_axh_a.a(textFieldStyle);
        Pixmap pixmap = new Pixmap(130, 25, Pixmap.Format.RGB888);
        pixmap.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        pixmap.fill();
        TextField.TextFieldStyle textFieldStyle2 = this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a();
        textFieldStyle2.background = new Image(new Texture(pixmap)).getDrawable();
        Engine.a("Chat 4");
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", engine.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(2000);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setWidth(350.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(730.0f, 625.0f);
        TextField.TextFieldStyle textFieldStyle3 = new TextField.TextFieldStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getStyle());
        textFieldStyle3.font = this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setStyle(textFieldStyle3);
        Engine.a("Chat 5");
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.var_ayh_a = new ayh(0, 0, textureAtlas, "MediumSubBadge-01", true, 0.6f, true);
        this.var_ayh_b = new ayh(0, 0, textureAtlas, "MediumSubBadge-02", true, 0.6f, true);
        this.var_ayh_c = new ayh(0, 0, textureAtlas, "MediumSubBadge-03", true, 0.6f, true);
        this.var_ayh_d = new ayh(0, 0, textureAtlas, "MediumSubBadge-04", true, 0.6f, true);
        this.var_ayh_e = new ayh(0, 0, textureAtlas, "MediumSubBadge-05", true, 0.6f, true);
        this.var_ayh_f = new ayh(0, 0, textureAtlas, "MediumSubBadge-06", true, 0.6f, true);
        this.var_ayh_g = new ayh(0, 0, textureAtlas, "PatreonBadge1", true, 0.6f, true);
        this.var_ayh_h = new ayh(0, 0, textureAtlas, "MediumSubBadge-02", true, 0.6f, true);
        Engine.a("Chat 6 - out");
    }

    @Deprecated
    protected void void_a() {
        if (ay.ay_a().gd_a().ev_a().a(1) != null) {
            en en2;
            this.var_axh_a.b("/1 ");
            this.var_en_a = en2 = ay.ay_a().gd_a().ev_a().a().getValueAt(1);
            this.var_fd_a = fd.e;
            this.a(this.var_com_arenaofkings_client_core_Engine_a, en2, "", 1);
        } else {
            en en3;
            ay.ay_a().gd_a().ev_a().void_a();
            this.var_axh_a.b("/p ");
            this.var_en_a = en3 = ay.ay_a().gd_a().ev_a().en_a();
            this.var_fd_a = fd.b;
            this.a(this.var_com_arenaofkings_client_core_Engine_a, en3, "", 0);
        }
    }

    protected abstract void void_b();

    public void void_c() {
        if (this.var_axh_a.java_lang_String_a().length() > 0) {
            if (this.var_axh_a.java_lang_String_a().startsWith("/invite ")) {
                if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                    wh wh2 = (wh)this.var_com_arenaofkings_client_core_Engine_a.axc_a().aya_a();
                    PUB_PARTY_INVITE pUB_PARTY_INVITE = new PUB_PARTY_INVITE(this.var_axh_a.java_lang_String_a(), wh2.yp_a().a());
                    this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_PARTY_INVITE);
                } else {
                    PUB_PARTY_INVITE pUB_PARTY_INVITE = new PUB_PARTY_INVITE(this.var_axh_a.java_lang_String_a(), 1);
                    this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_PARTY_INVITE);
                }
            } else {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE();
                pUB_MISC_CHAT_MESSAGE.setMessage(this.var_axh_a.java_lang_String_a());
                pUB_MISC_CHAT_MESSAGE.setChannel(ay.ay_a().gd_a().ev_a().b().java_lang_String_a());
                fd fd2 = ay.ay_a().gd_a().ev_a().b().fd_a();
                if (fd2 != null) {
                    switch (fd2) {
                        case e: {
                            pUB_MISC_CHAT_MESSAGE.setHeader(this.var_java_lang_String_b);
                            break;
                        }
                        case b: {
                            pUB_MISC_CHAT_MESSAGE.setHeader("/p ");
                            break;
                        }
                        case var_fd_a: {
                            pUB_MISC_CHAT_MESSAGE.setHeader("/s ");
                            break;
                        }
                        case c: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/w " + this.var_java_lang_String_d + " ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case d: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        default: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        }
                    }
                }
                this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_MISC_CHAT_MESSAGE);
                if (pUB_MISC_CHAT_MESSAGE.getMessage().equals("/assets")) {
                    this.var_com_arenaofkings_client_core_Engine_a.h();
                } else if (pUB_MISC_CHAT_MESSAGE.getMessage().equals("/sound low")) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(0.5f);
                    this.a("The volume is now 50%.");
                } else if (pUB_MISC_CHAT_MESSAGE.getMessage().equals("/sound mid")) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(0.75f);
                    this.a("The volume is now 75%.");
                } else if (pUB_MISC_CHAT_MESSAGE.getMessage().equals("/sound high")) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(1.0f);
                    this.a("The volume is now 100%.");
                } else if (!pUB_MISC_CHAT_MESSAGE.getMessage().equals("/quit") && pUB_MISC_CHAT_MESSAGE.getMessage().equals("/reloadui")) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_aj_a.b();
                    this.a("UI has been reloaded.");
                }
            }
            this.var_axh_a.b("");
        }
    }

    public void a(String string) {
        PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(string);
        pUB_MISC_CHAT_MESSAGE.channel = " ";
        this.a(pUB_MISC_CHAT_MESSAGE, " ", true);
    }

    /*
     * WARNING - void declaration
     */
    public void a(PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE, String string, boolean bl2) {
        block138: {
            void var22_44;
            ArrayList<d> arrayList;
            d d2;
            boolean bl3;
            en en2;
            Object object;
            block136: {
                block137: {
                    boolean list;
                    Object object2;
                    Object object3;
                    this.i();
                    if (bl2) {
                        pUB_MISC_CHAT_MESSAGE.channel = string;
                    }
                    if (this instanceof i) {
                        ((i)this).l();
                    }
                    object = this.var_com_arenaofkings_client_core_Engine_a;
                    en2 = null;
                    Engine.b("msg channel:" + pUB_MISC_CHAT_MESSAGE.channel);
                    Engine.b("msg channel a");
                    if (pUB_MISC_CHAT_MESSAGE.channel == null || pUB_MISC_CHAT_MESSAGE.channel != null && (pUB_MISC_CHAT_MESSAGE.channel.equals(" ") || pUB_MISC_CHAT_MESSAGE.header.equals(" "))) {
                        Engine.b("it's current channel");
                        en2 = ay.ay_a().gd_a().ev_a().b();
                    }
                    Engine.b("msg channel b");
                    if (en2 == null) {
                        Engine.b("msg channel c");
                        Engine.b("findChannel is null");
                        if (pUB_MISC_CHAT_MESSAGE.header != null && pUB_MISC_CHAT_MESSAGE.header.startsWith("/w ")) {
                            Engine.b("finding /w channel");
                            en2 = pUB_MISC_CHAT_MESSAGE.key != null ? ay.ay_a().gd_a().ev_a().en_a(pUB_MISC_CHAT_MESSAGE.key) : ay.ay_a().gd_a().ev_a().en_a(pUB_MISC_CHAT_MESSAGE.channel);
                            if (en2 == null) {
                                Engine.b("STILL NULL CHANNEL");
                                Engine.b("Details: " + pUB_MISC_CHAT_MESSAGE.channel + " " + pUB_MISC_CHAT_MESSAGE.key + " " + pUB_MISC_CHAT_MESSAGE.message);
                            }
                            if (this.var_en_a != en2 && this.var_azv_a.boolean_b()) {
                                this.var_azv_a.void_c();
                                this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.lc, 0.75f);
                            }
                            if (en2 == null) {
                                Engine.b("couldn't find it, creating it");
                                en2 = ay.ay_a().gd_a().ev_a().a(pUB_MISC_CHAT_MESSAGE.key, pUB_MISC_CHAT_MESSAGE.channel);
                                if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                                    we we2 = (we)this.var_com_arenaofkings_client_core_Engine_a.axc_a();
                                    en2.a(we2.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
                                }
                            } else {
                                Engine.b("channel has been found");
                            }
                        } else {
                            en2 = ay.ay_a().gd_a().ev_a().en_a(pUB_MISC_CHAT_MESSAGE.channel);
                        }
                    }
                    Engine.b("msg channel d");
                    if (en2 != null) {
                        Engine.b("msg channel e");
                        Engine.b("findChannel: " + en2.java_lang_String_a());
                        object = en2.a();
                        if (en2 != ay.ay_a().gd_a().ev_a().b()) {
                            en2.void_c();
                        }
                    } else {
                        return;
                    }
                    Engine.b("msg channel f");
                    Engine.b("Markup enabled?: " + this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b.getData().markupEnabled);
                    this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, pUB_MISC_CHAT_MESSAGE.message);
                    float f2 = this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width;
                    float f3 = this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.height;
                    Engine.b("Message " + pUB_MISC_CHAT_MESSAGE.message + " width: " + f2 + " height: " + f3 + " MESSAGE_MAX_WIDTH_PX: " + this.var_int_b);
                    boolean bl4 = false;
                    bl3 = false;
                    d2 = new d("", this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a, null, this.var_com_arenaofkings_client_core_Engine_a);
                    arrayList = new ArrayList<d>();
                    ArrayList<d> arrayList2 = new ArrayList<d>();
                    if (!(f2 > (float)this.var_int_b)) break block136;
                    int n2 = 0;
                    int n3 = 0;
                    boolean bl5 = true;
                    int n4 = 0;
                    boolean bl6 = false;
                    do {
                        if (bl5) {
                            ++n3;
                        }
                        if (pUB_MISC_CHAT_MESSAGE.itemData != null && !pUB_MISC_CHAT_MESSAGE.itemData.isEmpty()) {
                            for (ItemLocale itemLocale : pUB_MISC_CHAT_MESSAGE.itemData) {
                                if (pUB_MISC_CHAT_MESSAGE.message.length() < itemLocale.linkRight) {
                                    return;
                                }
                                if (n3 == itemLocale.linkLeft) {
                                    bl5 = false;
                                    if (d2.getText().length > 0 || pUB_MISC_CHAT_MESSAGE.message.substring(n4, n3).length() > 0) {
                                        d2.setText(pUB_MISC_CHAT_MESSAGE.message.substring(n4, n3));
                                        if (!arrayList.contains(d2)) {
                                            arrayList.add(d2);
                                        }
                                        Engine.b("Creating a new label for this link. Finalized Label text: " + d2.getText());
                                        d2 = new d("", this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a, null, this.var_com_arenaofkings_client_core_Engine_a);
                                        n4 = itemLocale.linkLeft;
                                    }
                                    Label.LabelStyle labelStyle = new Label.LabelStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a.font, Colors.get("RARITY_" + ItemRarity.getFormattedNameCommonIsPoor(ItemRarity.valueOf(itemLocale.itemData.itemRarity)).toUpperCase()));
                                    arrayList.add(new d(pUB_MISC_CHAT_MESSAGE.message.substring(itemLocale.linkLeft, itemLocale.linkRight), labelStyle, itemLocale.itemData, this.var_com_arenaofkings_client_core_Engine_a));
                                    bl3 = true;
                                    this.i = pUB_MISC_CHAT_MESSAGE.message.substring(n2, itemLocale.linkRight);
                                    this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a.font, this.i);
                                    n3 = itemLocale.linkRight;
                                    if (this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width < (float)this.var_int_b) {
                                        this.var_java_lang_String_f = pUB_MISC_CHAT_MESSAGE.message.substring(n2, n3);
                                        break;
                                    }
                                    bl6 = true;
                                    break;
                                }
                                bl5 = true;
                            }
                        }
                        if (pUB_MISC_CHAT_MESSAGE.message.length() < n3) {
                            return;
                        }
                        if (bl3) {
                            n4 = n3;
                            bl3 = false;
                            continue;
                        }
                        d2.setText(pUB_MISC_CHAT_MESSAGE.message.substring(n4, n3));
                        if (arrayList.contains(d2)) continue;
                        arrayList.add(d2);
                    } while (n3 < pUB_MISC_CHAT_MESSAGE.message.length());
                    int n5 = 0;
                    int n6 = 0;
                    boolean bl7 = true;
                    int n7 = -1;
                    boolean bl8 = false;
                    boolean bl9 = false;
                    ListIterator<d> listIterator = arrayList.listIterator();
                    int n8 = 0;
                    while (listIterator.hasNext()) {
                        object3 = (d)listIterator.next();
                        n6 += this.var_com_arenaofkings_client_core_Engine_a.a(((Label)object3).getText().toString(), ((Label)object3).getStyle().font);
                        if (((d)object3).fm_a() == null) {
                            object2 = azu.a(this.var_com_arenaofkings_client_core_Engine_a, ((Label)object3).getStyle().font, ((Label)object3).getText().toString(), this.var_int_b);
                            n7 = object2.size();
                            if (object2.size() >= 2) {
                                ((Label)object3).setText((CharSequence)object2.get(0));
                                d d3 = new d((String)object2.get(1), ((Label)object3).getStyle(), null, this.var_com_arenaofkings_client_core_Engine_a);
                                d3.a(true);
                                listIterator.add(d3);
                                list = true;
                            }
                            if (arrayList.size() >= 3 && n8 >= 1 && !((d)object3).boolean_a()) {
                                if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/p")) {
                                    ((Label)object3).setText("[AOK_PARTY]" + ((Label)object3).getText());
                                } else if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/s")) {
                                    ((Label)object3).setText("[AOK_SAY]" + ((Label)object3).getText());
                                }
                                if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/w")) {
                                    ((Label)object3).setText("[AOK_WHISPER]" + ((Label)object3).getText());
                                } else {
                                    ((Label)object3).setText("[AOK_CHANNEL]" + ((Label)object3).getText());
                                }
                            }
                        }
                        ++n8;
                    }
                    n6 = 0;
                    object3 = arrayList.iterator();
                    while (object3.hasNext()) {
                        object2 = (d)object3.next();
                        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor((Actor)object2);
                        if (((d)object2).fm_a() != null) {
                            ((Actor)object2).setPosition(168 + en2.int_b() + n5, 0.65f + (float)en2.int_c() - 9.0f - 240.0f);
                        } else {
                            ((Actor)object2).setPosition(168 + en2.int_b() + n5, en2.int_c() - 240);
                        }
                        if (bl7) {
                            n5 += this.var_com_arenaofkings_client_core_Engine_a.a(((Label)object2).getText().toString(), ((Label)object2).getStyle().font);
                        }
                        if (arrayList.size() > 1 && n6 + n5 > this.var_int_b && bl7) {
                            bl7 = false;
                            n6 = n5 = 0;
                            bl6 = true;
                        }
                        if (bl7) continue;
                        if (list) {
                            if (((d)object2).boolean_a()) {
                                object3.remove();
                                arrayList2.add((d)object2);
                                ((Actor)object2).setPosition(168 + en2.int_b() + n6, ((Actor)object2).getY() - 27.0f);
                                n6 += this.var_com_arenaofkings_client_core_Engine_a.a(((Label)object2).getText().toString(), ((Label)object2).getStyle().font);
                                if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/p")) {
                                    ((Label)object2).setText("[AOK_PARTY]" + ((Label)object2).getText());
                                } else if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/s")) {
                                    ((Label)object2).setText("[AOK_SAY]" + ((Label)object2).getText());
                                }
                                if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/w")) {
                                    ((Label)object2).setText("[AOK_WHISPER]" + ((Label)object2).getText());
                                } else {
                                    ((Label)object2).setText("[AOK_CHANNEL]" + ((Label)object2).getText());
                                }
                            } else {
                                ((Actor)object2).setPosition(168 + en2.int_b() + n5, ((Actor)object2).getY() - 0.0f);
                            }
                        } else {
                            ((Actor)object2).setPosition(168 + en2.int_b() + n5, ((Actor)object2).getY() - 21.0f);
                        }
                        n5 += this.var_com_arenaofkings_client_core_Engine_a.a(((Label)object2).getText().toString(), ((Label)object2).getStyle().font);
                    }
                    if (!list && !bl6) break block137;
                    for (int i2 = 0; i2 < this.var_int_a - 2; ++i2) {
                        if (i2 + 2 > this.var_int_a) continue;
                        ((Array)object).set(i2, (g)((Array)object).get(i2 + 2));
                    }
                    if (((g)((Array)object).get((int)this.var_int_c)).var_int_a != null && ((g)((Array)object).get((int)this.var_int_c)).var_int_a.size() > 0) {
                        for (d d4 : ((g)((Array)object).get((int)this.var_int_c)).var_int_a) {
                            d4.remove();
                        }
                    }
                    if (((g)((Array)object).get((int)(this.var_int_c - 1))).var_int_a != null && ((g)((Array)object).get((int)(this.var_int_c - 1))).var_int_a.size() > 0) {
                        for (d d5 : ((g)((Array)object).get((int)(this.var_int_c - 1))).var_int_a) {
                            d5.remove();
                        }
                    }
                    ((Array)object).set(this.var_int_a - 2, new g(this.var_java_lang_String_f, arrayList, g.a(), this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a));
                    ((Array)object).set(this.var_int_a - 1, new g(this.var_java_lang_String_h + this.var_java_lang_String_g, arrayList2, g.b(), this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a));
                    if (pUB_MISC_CHAT_MESSAGE.membershipMonths == 1) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_a;
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == 2) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_b;
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == 3) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_c;
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths >= 6 && pUB_MISC_CHAT_MESSAGE.membershipMonths < 12) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_d;
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths >= 12 && pUB_MISC_CHAT_MESSAGE.membershipMonths < 24) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_e;
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths >= 24) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_f;
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == -1) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_g;
                        System.out.println("Set patreon icon a");
                    } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == -2) {
                        ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_h;
                    }
                    if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                        for (Actor actor : this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors()) {
                            if (!(actor instanceof d)) continue;
                            ((d)actor).setY(actor.getY() + 41.0f);
                        }
                    } else if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                        for (int i3 = 0; i3 < ((Array)object).size; ++i3) {
                            if (((g)((Array)object).get((int)i3)).var_int_a == null || ((g)((Array)object).get((int)i3)).var_int_a.size() <= 0) continue;
                            for (d d6 : ((g)((Array)object).get((int)i3)).var_int_a) {
                                d6.setY(d6.getY() + 41.0f);
                            }
                        }
                    }
                    if (!t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) break block138;
                    for (Actor actor : this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors()) {
                        if (!(actor instanceof d) || !(actor.getY() > 335.0f)) continue;
                        actor.remove();
                    }
                    break block138;
                }
                for (int i4 = 0; i4 < this.var_int_a - 1; ++i4) {
                    if (i4 + 1 > this.var_int_a) continue;
                    ((Array)object).set(i4, (g)((Array)object).get(i4 + 1));
                }
                if (((g)((Array)object).get((int)this.var_int_c)).var_int_a != null && ((g)((Array)object).get((int)this.var_int_c)).var_int_a.size() > 0) {
                    for (d d7 : ((g)((Array)object).get((int)this.var_int_c)).var_int_a) {
                        d7.remove();
                    }
                }
                ((Array)object).set(this.var_int_a - 1, new g(this.var_java_lang_String_f, arrayList, g.a(), this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a));
                if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                    for (Actor actor : this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors()) {
                        if (!(actor instanceof d)) continue;
                        ((d)actor).setY(actor.getY() + 21.0f);
                    }
                } else if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                    for (int i5 = 0; i5 < ((Array)object).size; ++i5) {
                        if (((g)((Array)object).get((int)i5)).var_int_a == null || ((g)((Array)object).get((int)i5)).var_int_a.size() <= 0) continue;
                        for (d d8 : ((g)((Array)object).get((int)i5)).var_int_a) {
                            d8.setY(d8.getY() + 21.0f);
                        }
                    }
                }
                if (!t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) break block138;
                for (Actor actor : this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors()) {
                    if (!(actor instanceof d) || !(actor.getY() > 335.0f)) continue;
                    actor.remove();
                }
                break block138;
            }
            int n9 = 0;
            int n10 = 0;
            boolean bl10 = true;
            int n11 = 0;
            do {
                if (bl10) {
                    ++n10;
                }
                if (pUB_MISC_CHAT_MESSAGE.itemData != null && !pUB_MISC_CHAT_MESSAGE.itemData.isEmpty()) {
                    for (ItemLocale itemLocale : pUB_MISC_CHAT_MESSAGE.itemData) {
                        if (n10 == itemLocale.linkLeft) {
                            bl10 = false;
                            if (d2.getText().length > 0 || pUB_MISC_CHAT_MESSAGE.message.substring(n11, n10).length() > 0) {
                                d2.setText(pUB_MISC_CHAT_MESSAGE.message.substring(n11, n10));
                                if (!arrayList.contains(d2)) {
                                    arrayList.add(d2);
                                }
                                d2 = new d("", this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a, null, this.var_com_arenaofkings_client_core_Engine_a);
                                n11 = itemLocale.linkLeft;
                            }
                            System.out.println("Rarity");
                            if (itemLocale.itemData != null && itemLocale.itemData.itemRarity != null && itemLocale.itemData.itemRarity.length() > 0) {
                                Label.LabelStyle labelStyle = new Label.LabelStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a.font, Colors.get("RARITY_" + ItemRarity.getFormattedNameCommonIsPoor(ItemRarity.valueOf(itemLocale.itemData.itemRarity)).toUpperCase()));
                                arrayList.add(new d(pUB_MISC_CHAT_MESSAGE.message.substring(itemLocale.linkLeft, itemLocale.linkRight), labelStyle, itemLocale.itemData, this.var_com_arenaofkings_client_core_Engine_a));
                                bl3 = true;
                            }
                            if (pUB_MISC_CHAT_MESSAGE.message.length() < itemLocale.linkRight) {
                                return;
                            }
                            this.i = pUB_MISC_CHAT_MESSAGE.message.substring(n9, itemLocale.linkRight);
                            this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a.font, this.i);
                            n10 = itemLocale.linkRight;
                            if (!(this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width < (float)this.var_int_b)) break;
                            this.var_java_lang_String_f = pUB_MISC_CHAT_MESSAGE.message.substring(n9, n10);
                            break;
                        }
                        bl10 = true;
                    }
                }
                if (pUB_MISC_CHAT_MESSAGE.message.length() < n10) {
                    return;
                }
                this.var_java_lang_String_f = pUB_MISC_CHAT_MESSAGE.message.substring(n9, n10);
                this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a.font, this.var_java_lang_String_f);
                if (bl3) {
                    n11 = n10;
                    bl3 = false;
                    continue;
                }
                d2.setText(pUB_MISC_CHAT_MESSAGE.message.substring(n11, n10));
                if (arrayList.contains(d2)) continue;
                arrayList.add(d2);
            } while (this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width < (float)this.var_int_b && n10 < pUB_MISC_CHAT_MESSAGE.message.length());
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            ListIterator<d> listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                d d5 = (d)listIterator.next();
                n13 += this.var_com_arenaofkings_client_core_Engine_a.a(d5.getText().toString(), d5.getStyle().font);
                if (d5.fm_a() == null) {
                    List<String> i6 = azu.a(this.var_com_arenaofkings_client_core_Engine_a, d5.getStyle().font, d5.getText().toString(), this.var_int_b);
                    if (i6.size() == 2) {
                        d5.setText(i6.get(0));
                        listIterator.add(new d(i6.get(1), this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a, null, this.var_com_arenaofkings_client_core_Engine_a));
                    }
                    if (arrayList.size() >= 3 && n14 >= 1 && !d5.boolean_a()) {
                        if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/p")) {
                            d5.setText("[AOK_PARTY]" + d5.getText());
                        } else if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/s")) {
                            d5.setText("[AOK_SAY]" + d5.getText());
                        }
                        if (pUB_MISC_CHAT_MESSAGE.header.startsWith("/w")) {
                            d5.setText("[AOK_WHISPER]" + d5.getText());
                        } else {
                            d5.setText("[AOK_CHANNEL]" + d5.getText());
                        }
                    }
                }
                ++n14;
            }
            n13 = 0;
            for (d d9 : arrayList) {
                this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(d9);
                if (d9.fm_a() != null) {
                    d9.setPosition(168 + en2.int_b() + n12, 0.65f + (float)en2.int_c() - 9.0f - 240.0f);
                } else {
                    d9.setPosition(168 + en2.int_b() + n12, en2.int_c() - 240);
                }
                if (n13 + (n12 += this.var_com_arenaofkings_client_core_Engine_a.a(d9.getText().toString(), d9.getStyle().font)) <= this.var_int_b) continue;
                n13 = n12 = 0;
            }
            boolean i7 = false;
            while (var22_44 < this.var_int_a - 1) {
                if (var22_44 + true <= this.var_int_a) {
                    ((Array)object).set((int)var22_44, (g)((Array)object).get((int)(var22_44 + true)));
                }
                ++var22_44;
            }
            if (((g)((Array)object).get((int)this.var_int_c)).var_int_a != null && ((g)((Array)object).get((int)this.var_int_c)).var_int_a.size() > 0) {
                for (d d10 : ((g)((Array)object).get((int)this.var_int_c)).var_int_a) {
                    d10.remove();
                }
            }
            ((Array)object).set(this.var_int_a - 1, new g(this.var_java_lang_String_f, arrayList, g.a(), this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a));
            if (pUB_MISC_CHAT_MESSAGE.membershipMonths == 1) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_a;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == 2) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_b;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == 3) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_c;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths >= 6 && pUB_MISC_CHAT_MESSAGE.membershipMonths < 12) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_d;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths >= 12 && pUB_MISC_CHAT_MESSAGE.membershipMonths < 24) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_e;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths >= 24) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_f;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == -1) {
                System.out.println("Set patreon icon b");
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_g;
            } else if (pUB_MISC_CHAT_MESSAGE.membershipMonths == -2) {
                ((d)arrayList.get((int)0)).var_ayh_a = this.var_ayh_h;
            }
            if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                for (Actor actor : this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors()) {
                    if (!(actor instanceof d)) continue;
                    ((d)actor).setY(actor.getY() + 21.0f);
                }
            } else if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                void var22_48;
                boolean bl11 = false;
                while (var22_48 < ((Array)object).size) {
                    if (((g)((Array)object).get((int)var22_48)).var_int_a != null && ((g)((Array)object).get((int)var22_48)).var_int_a.size() > 0) {
                        for (d d11 : ((g)((Array)object).get((int)var22_48)).var_int_a) {
                            d11.setY(d11.getY() + 21.0f);
                        }
                    }
                    ++var22_48;
                }
            }
            if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                for (Actor actor : this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors()) {
                    if (!(actor instanceof d) || !(actor.getY() > 335.0f)) continue;
                    actor.remove();
                }
            }
        }
    }

    public void a(String string, BitmapFont bitmapFont) {
        PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", string);
        pUB_MISC_CHAT_MESSAGE.setChannel(" ");
        this.a(pUB_MISC_CHAT_MESSAGE, " ", true);
    }

    public void void_d() {
        Array<g> array = new Array<g>(((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size);
        for (int i2 = 0; i2 < Engine.var_int_a; ++i2) {
            array.add(new g("", g.a(), this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, this.var_com_arenaofkings_client_core_Engine_a));
        }
        Iterator iterator = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).iterator();
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            this.a(array, g2.var_java_lang_String_a, "", g2.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a);
        }
        this.var_com_arenaofkings_client_core_Engine_a.var_java_lang_String_b = this.var_com_arenaofkings_client_core_Engine_a = array;
    }

    public void a(Array<g> array, String string, String string2, BitmapFont bitmapFont) {
        Array<g> array2 = array;
        en en2 = ay.ay_a().gd_a().ev_a().en_a(string2);
        if (en2 != null) {
            array2 = en2.a();
            if (en2 != ay.ay_a().gd_a().ev_a().b()) {
                en2.void_c();
            }
        }
        Engine.b("safeMessageAdd 1 " + string);
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string);
        float f2 = this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width;
        float f3 = this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.height;
        if (f2 > (float)this.var_int_b) {
            int n2;
            int n3 = 0;
            int n4 = 1;
            do {
                this.var_java_lang_String_f = string.substring(n3, n4++);
                this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, this.var_java_lang_String_f);
                this.var_java_lang_String_g = string.substring(n4 - 1);
            } while (this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width < (float)this.var_int_b);
            for (n2 = 0; n2 < this.var_java_lang_String_f.length(); ++n2) {
                if (this.var_java_lang_String_f.charAt(n2) == '[') {
                    this.var_boolean_d = true;
                }
                if (this.var_boolean_d) {
                    this.var_java_lang_String_h = this.var_java_lang_String_h + this.var_java_lang_String_f.charAt(n2);
                }
                if (this.var_java_lang_String_f.charAt(n2) != ']') continue;
                this.var_boolean_d = false;
                break;
            }
            for (n2 = 0; n2 < this.var_int_a - 2; ++n2) {
                if (n2 == 0 || n2 == 1) {
                    array2.get((int)n2).var_java_lang_String_a = "";
                    continue;
                }
                if (n2 == 2 && array2.get((int)n2).var_int_a == array2.get((int)(n2 - 1)).var_int_a) {
                    array2.get((int)n2).var_java_lang_String_a = "";
                    continue;
                }
                if (n2 + 2 > this.var_int_a) continue;
                array2.set(n2, array2.get(n2 + 2));
            }
            array2.set(this.var_int_a - 2, new g(this.var_java_lang_String_f, g.a(), bitmapFont, this.var_com_arenaofkings_client_core_Engine_a));
            array2.set(this.var_int_a - 1, new g(this.var_java_lang_String_h + this.var_java_lang_String_g, g.b(), bitmapFont, this.var_com_arenaofkings_client_core_Engine_a));
        } else {
            for (int i2 = 0; i2 < this.var_int_a - 1; ++i2) {
                if (i2 == 0 || i2 == 1) {
                    array2.get((int)i2).var_java_lang_String_a = "";
                    continue;
                }
                if (i2 == 2 && array2.get((int)i2).var_int_a == array2.get((int)(i2 - 1)).var_int_a) {
                    array2.get((int)i2).var_java_lang_String_a = "";
                    continue;
                }
                if (i2 + 1 > this.var_int_a) continue;
                array2.set(i2, array2.get(i2 + 1));
            }
            array2.set(this.var_int_a - 1, new g(string, g.a(), bitmapFont, this.var_com_arenaofkings_client_core_Engine_a));
        }
        Engine.b("safeMessageAdd - out");
    }

    @Override
    public void a(float f2, Engine engine) {
        this.b(engine);
        if (ay.ay_a().gd_a().ev_a().b() != null) {
            ay.ay_a().gd_a().ev_a().b().d();
        }
        if (this.var_axh_a.java_lang_String_a().startsWith("/1 ")) {
            en en2 = ay.ay_a().gd_a().ev_a().a(1);
            if (en2 != null) {
                this.var_java_lang_String_b = "/1 ";
                this.void_e();
                this.var_fd_a = fd.e;
                this.a(engine, en2, "", 1);
            }
        } else if (this.var_axh_a.java_lang_String_a().startsWith("/2 ")) {
            en en3 = ay.ay_a().gd_a().ev_a().a(2);
            if (en3 != null) {
                this.var_java_lang_String_b = "/2 ";
                this.void_e();
                this.var_fd_a = fd.e;
                this.a(engine, en3, "", 2);
            }
        } else if (this.var_axh_a.java_lang_String_a().startsWith("/3 ")) {
            en en4 = ay.ay_a().gd_a().ev_a().a(3);
            if (en4 != null) {
                this.var_java_lang_String_b = "/3 ";
                this.void_e();
                this.var_fd_a = fd.e;
                this.a(engine, en4, "", 3);
            }
        } else if (this.var_axh_a.java_lang_String_a().startsWith("/4 ")) {
            en en5 = ay.ay_a().gd_a().ev_a().a(4);
            if (en5 != null) {
                this.var_java_lang_String_b = "/4 ";
                this.void_e();
                this.var_fd_a = fd.e;
                this.a(engine, en5, "", 4);
            }
        } else if (this.var_axh_a.java_lang_String_a().startsWith("/p ") || this.var_axh_a.java_lang_String_a().startsWith("/P ")) {
            this.var_java_lang_String_b = "/p ";
            this.void_e();
            en en6 = ay.ay_a().gd_a().ev_a().en_a("Game");
            this.var_fd_a = fd.b;
            this.a(engine, en6, "Party", -1);
        } else if (this.var_axh_a.java_lang_String_a().startsWith("/s ") || this.var_axh_a.java_lang_String_a().startsWith("/S ")) {
            if (t.a(we.class, engine)) {
                this.var_java_lang_String_b = "/p ";
                this.void_e();
                en en7 = ay.ay_a().gd_a().ev_a().en_a("Game");
                this.var_fd_a = fd.b;
                this.a(engine, en7, "Party", -1);
            } else {
                this.var_java_lang_String_b = "/s ";
                this.void_e();
                en en8 = ay.ay_a().gd_a().ev_a().en_a("Game");
                this.var_fd_a = fd.var_fd_a;
                this.a(engine, en8, "Say", -1);
            }
        } else if (this.var_axh_a.java_lang_String_a().startsWith("/w ") || this.var_axh_a.java_lang_String_a().startsWith("/W ")) {
            this.var_java_lang_String_b = "/w ";
            this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.J;
            this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.J;
            if (this.var_axh_a.java_lang_String_a().length() > 3) {
                String[] stringArray = this.var_axh_a.java_lang_String_a().split("\\s+");
                if (stringArray.length >= 2 && this.var_axh_a.java_lang_String_a().substring(3).contains(" ")) {
                    String string = this.var_axh_a.java_lang_String_a().substring(3, this.var_axh_a.java_lang_String_a().length());
                    this.var_java_lang_String_c = stringArray[1];
                    en en9 = ay.ay_a().gd_a().ev_a().b(this.var_java_lang_String_c);
                    Engine.b("Trying to find channel: " + this.var_java_lang_String_c);
                    if (en9 != null) {
                        Engine.b("found channel: " + en9.java_lang_String_a());
                        this.var_java_lang_String_d = "";
                        this.var_java_lang_String_e = "";
                        for (int i2 = 0; i2 < string.length(); ++i2) {
                            if (string.charAt(i2) == ' ') {
                                this.var_java_lang_String_e = this.var_java_lang_String_e + string.substring(i2 + 1);
                                break;
                            }
                            this.var_java_lang_String_d = this.var_java_lang_String_d + string.charAt(i2);
                        }
                        this.var_axh_a.b(this.var_java_lang_String_e);
                        Engine.b("DEBUG");
                        Engine.b("raw: " + string);
                        Engine.b("messageText: " + this.var_java_lang_String_c);
                        Engine.b("whisperName: " + this.var_java_lang_String_d);
                        Engine.b("setText: " + this.var_java_lang_String_e);
                        this.a(engine, en9, "-> " + en9.java_lang_String_b(), -1);
                    }
                } else {
                    this.var_java_lang_String_d = "";
                    for (int i3 = 0; i3 < this.var_java_lang_String_c.length() && this.var_java_lang_String_c.charAt(i3) != ' '; ++i3) {
                        this.var_java_lang_String_d = this.var_java_lang_String_d + this.var_java_lang_String_c.charAt(i3);
                    }
                    Engine.b("Set whisperName: " + this.var_java_lang_String_d);
                }
            }
        } else if (this.var_en_a != null) {
            switch (this.var_en_a.fd_a()) {
                case e: {
                    this.var_java_lang_String_b = "/" + this.var_en_a.int_a() + " ";
                    this.var_java_lang_String_d = "";
                    this.var_fd_a = fd.e;
                    this.a(engine, this.var_en_a, "", this.var_en_a.int_a());
                    break;
                }
                case d: {
                    if (this.var_axh_a.java_lang_String_a().toLowerCase(Locale.US).startsWith("/s ")) {
                        this.var_java_lang_String_b = "/s ";
                        this.void_e();
                        en en10 = ay.ay_a().gd_a().ev_a().en_a("Game");
                        this.var_fd_a = fd.var_fd_a;
                        this.a(engine, en10, "Say", -1);
                        break;
                    }
                    if (!this.var_axh_a.java_lang_String_a().toLowerCase(Locale.US).startsWith("/p ")) break;
                    this.var_java_lang_String_b = "/p ";
                    this.var_java_lang_String_d = "";
                    this.var_fd_a = fd.d;
                    this.a(engine, this.var_en_a, "Party", this.var_en_a.int_a());
                    break;
                }
                case b: {
                    this.var_java_lang_String_b = "/p ";
                    en en11 = ay.ay_a().gd_a().ev_a().en_a("Game");
                    this.var_fd_a = fd.b;
                    this.a(engine, en11, "Party", -1);
                    break;
                }
                case var_fd_a: {
                    this.var_java_lang_String_b = "/s ";
                    this.void_e();
                    en en12 = ay.ay_a().gd_a().ev_a().en_a("Game");
                    this.var_fd_a = fd.var_fd_a;
                    this.a(engine, en12, "Say", -1);
                    break;
                }
                case c: {
                    break;
                }
            }
        }
    }

    protected void void_e() {
        this.var_axh_a.b("/p ");
        this.var_java_lang_String_c = this.var_axh_a.java_lang_String_a().substring(3);
        this.var_java_lang_String_d = "";
        this.var_java_lang_String_e = "";
        this.var_axh_a.b(this.var_java_lang_String_c);
    }

    @Deprecated
    protected void a(Engine engine, en en2, String string, int n2) {
        if (en2 != null) {
            this.var_en_a = en2;
            this.var_fd_a = this.var_en_a.fd_a();
            ay.ay_a().gd_a().ev_a().b(this.var_en_a);
            switch (this.var_fd_a) {
                case e: {
                    if (n2 != -1) {
                        this.var_java_lang_String_a = "[" + n2 + ". " + this.var_en_a.java_lang_String_a() + "]:  ";
                        break;
                    }
                    if (!string.equals("")) {
                        this.var_java_lang_String_a = string + ":  ";
                        break;
                    }
                    this.var_java_lang_String_a = this.var_en_a.java_lang_String_a() + ":  ";
                    break;
                }
                case d: {
                    if (this.var_java_lang_String_b.equals("/s ") || this.var_java_lang_String_b.equals("/say ")) {
                        this.var_java_lang_String_a = "Say:  ";
                        break;
                    }
                    if (this.var_java_lang_String_b.equals("/s ") || this.var_java_lang_String_b.equals("/say ")) {
                        this.var_java_lang_String_a = "Party:  ";
                        break;
                    }
                    this.var_java_lang_String_a = "Party:  ";
                    break;
                }
                case b: {
                    this.var_java_lang_String_a = "Party:  ";
                    break;
                }
                case var_fd_a: {
                    this.var_java_lang_String_a = "Say:  ";
                    break;
                }
                case c: {
                    this.var_java_lang_String_a = "-> " + this.var_java_lang_String_d + ":  ";
                    break;
                }
            }
            this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, this.var_java_lang_String_a);
            if (this instanceof wg) {
                this.var_axh_a.setSize(655.0f - this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width, this.var_int_f);
            } else {
                this.var_axh_a.setSize((float)this.var_int_e - this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width, this.var_int_f);
            }
            this.var_axh_a.setPosition((float)this.var_int_g + this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width, this.var_int_h);
            switch (this.var_fd_a) {
                case d: {
                    if (this.var_java_lang_String_a.toLowerCase(Locale.US).startsWith("say:")) {
                        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.H;
                        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.H;
                        break;
                    }
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.I;
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.I;
                    break;
                }
                case e: {
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.N;
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.N;
                    break;
                }
                case var_fd_a: {
                    if (this.var_java_lang_String_a.toLowerCase(Locale.US).startsWith("say:")) {
                        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.H;
                        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.H;
                        break;
                    }
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.I;
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.I;
                    break;
                }
                case b: {
                    if (this.var_java_lang_String_a.toLowerCase(Locale.US).startsWith("say:")) {
                        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.H;
                        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.H;
                        break;
                    }
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.I;
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.I;
                    break;
                }
                case c: {
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = axe.J;
                    this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().focusedFontColor = axe.J;
                    break;
                }
            }
            this.var_axh_a.b(this.var_axh_a.java_lang_String_a().length());
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_axh_a.isVisible() && this.var_boolean_a && this.var_en_a != null) {
            switch (this.var_en_a.fd_a()) {
                case e: {
                    engine.a(this.var_java_lang_String_a, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, axe.N, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, Color.BLACK, (float)this.var_int_g, (float)(this.var_int_h + 18), 8, 0);
                    break;
                }
                case var_fd_a: {
                    engine.a(this.var_java_lang_String_a, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, axe.H, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, Color.BLACK, (float)this.var_int_g, (float)(this.var_int_h + 18), 8, 0);
                    break;
                }
                case b: {
                    engine.a(this.var_java_lang_String_a, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, axe.I, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, Color.BLACK, (float)this.var_int_g, (float)(this.var_int_h + 18), 8, 0);
                    break;
                }
                case c: {
                    engine.a(this.var_java_lang_String_a, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, axe.J, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, Color.BLACK, (float)this.var_int_g, (float)(this.var_int_h + 18), 8, 0);
                    break;
                }
                case d: {
                    if (this.var_java_lang_String_a.startsWith("Say")) {
                        engine.a(this.var_java_lang_String_a, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, axe.H, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, Color.BLACK, (float)this.var_int_g, (float)(this.var_int_h + 18), 8, 0);
                        break;
                    }
                    if (!this.var_java_lang_String_a.startsWith("Party")) break;
                    engine.a(this.var_java_lang_String_a, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, axe.I, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b, Color.BLACK, (float)this.var_int_g, (float)(this.var_int_h + 18), 8, 0);
                }
            }
        }
        this.var_axh_a.setColor(Color.WHITE);
    }

    public boolean boolean_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getKeyboardFocus() == this.var_axh_a;
    }

    @Override
    public void f() {
        if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return;
        }
        Engine.b("chat.onClick()");
        if (this.var_com_arenaofkings_client_core_Engine_a.boolean_b()) {
            return;
        }
        if (this.var_axh_a.isVisible() && this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getKeyboardFocus() == this.var_axh_a && this.var_axh_a.java_lang_String_a().length() > 0) {
            if (this.var_axh_a.java_lang_String_a().equals("/build")) {
                this.l();
                this.var_axh_a.b("");
                this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.setKeyboardFocus(null);
                return;
            }
            this.var_java_lang_String_c = this.var_axh_a.java_lang_String_a();
            fd fd2 = ay.ay_a().gd_a().ev_a().b().fd_a();
            if (this.var_axh_a.java_lang_String_a().startsWith("/w ") || this.var_axh_a.java_lang_String_a().startsWith("/W ")) {
                fd2 = fd.c;
                if (this.var_axh_a.java_lang_String_a().substring(3).contains(" ")) {
                    String string = this.var_axh_a.java_lang_String_a().substring(3);
                    this.var_java_lang_String_c = "";
                    this.var_java_lang_String_d = "";
                    this.var_java_lang_String_e = "";
                    for (int i2 = 0; i2 < string.length(); ++i2) {
                        Engine.b("step: " + i2 + " length: " + string.length() + " charAt: " + string.charAt(i2));
                        if (string.charAt(i2) == ' ') {
                            this.var_java_lang_String_c = this.var_java_lang_String_c + string.substring(i2 + 1);
                            break;
                        }
                        this.var_java_lang_String_d = this.var_java_lang_String_d + string.charAt(i2);
                    }
                    Engine.b("rawTxt: " + string + " messageText: " + this.var_java_lang_String_c + " whisperName: " + this.var_java_lang_String_d);
                }
            }
            Engine.b("messageText:" + this.var_java_lang_String_c + " whisperName: " + this.var_java_lang_String_d);
            if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                switch (fd2) {
                    case e: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case b: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/p ", this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case var_fd_a: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/s ", this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case c: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/w " + this.var_java_lang_String_d + " ", this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case d: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    default: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                }
            } else if (ay.ay_a().gd_a().ev_a().b() != null) {
                switch (fd2) {
                    case e: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case b: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/p ", this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case var_fd_a: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/s ", this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case c: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/w " + this.var_java_lang_String_d + " ", this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    case d: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                    default: {
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                        break;
                    }
                }
            } else {
                Engine.b("channel is null");
            }
            this.var_axh_a.b("");
        }
    }

    public void g() {
        Engine.b("chat.onEnterPressed()");
        if (this.var_com_arenaofkings_client_core_Engine_a.boolean_b()) {
            return;
        }
        Engine.b("onEnter 1");
        if (this.var_axh_a.isDisabled()) {
            this.var_axh_a.setDisabled(false);
        }
        if (this.var_axh_a.isVisible()) {
            Engine.b("onEnter 2");
            if (this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getKeyboardFocus() == this.var_axh_a && this.var_axh_a.java_lang_String_a().length() > 0) {
                Engine.b("onEnter 3");
                if (this.var_axh_a.java_lang_String_a().equals("/build")) {
                    this.l();
                    this.var_axh_a.b("");
                    this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.setKeyboardFocus(null);
                    return;
                }
                if (this.var_axh_a.java_lang_String_a().equals("/reloadui")) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_aj_a.b();
                    this.a("UI has been reloaded.");
                } else if (this.var_axh_a.java_lang_String_a().equals("/dc")) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_z_a.d();
                } else if (this.var_axh_a.java_lang_String_a().equals("/banbots")) {
                    System.out.println("Ban the bots");
                }
                Engine.b("onEnter 4");
                this.var_java_lang_String_c = this.var_axh_a.java_lang_String_a();
                fd fd2 = ay.ay_a().gd_a().ev_a().b().fd_a();
                if (this.var_axh_a.java_lang_String_a().startsWith("/w ") || this.var_axh_a.java_lang_String_a().startsWith("/W ")) {
                    fd2 = fd.c;
                    if (this.var_axh_a.java_lang_String_a().substring(3).contains(" ")) {
                        String string = this.var_axh_a.java_lang_String_a().substring(3);
                        this.var_java_lang_String_c = "";
                        this.var_java_lang_String_d = "";
                        this.var_java_lang_String_e = "";
                        for (int i2 = 0; i2 < string.length(); ++i2) {
                            Engine.b("step: " + i2 + " length: " + string.length() + " charAt: " + string.charAt(i2));
                            if (string.charAt(i2) == ' ') {
                                this.var_java_lang_String_c = this.var_java_lang_String_c + string.substring(i2 + 1);
                                break;
                            }
                            this.var_java_lang_String_d = this.var_java_lang_String_d + string.charAt(i2);
                        }
                        Engine.b("rawTxt: " + string + " messageText: " + this.var_java_lang_String_c + " whisperName: " + this.var_java_lang_String_d);
                    }
                }
                Engine.b("messageText:" + this.var_java_lang_String_c + " whisperName: " + this.var_java_lang_String_d);
                if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                    switch (fd2) {
                        case e: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case b: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/p ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case var_fd_a: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/s ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case c: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/w " + this.var_java_lang_String_d + " ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case d: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        default: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                    }
                } else if (ay.ay_a().gd_a().ev_a().b() != null) {
                    switch (fd2) {
                        case e: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case b: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/p ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case var_fd_a: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/s ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case c: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), "/w " + this.var_java_lang_String_d + " ", this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        case d: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                        default: {
                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE(ay.ay_a().gd_a().ev_a().b().java_lang_String_a(), this.var_java_lang_String_b, this.var_java_lang_String_c, this.var_axh_a.a()));
                            break;
                        }
                    }
                } else {
                    Engine.b("channel is null");
                }
                this.var_axh_a.b("");
                this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.setKeyboardFocus(null);
            } else if (this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getKeyboardFocus() == this.var_axh_a && this.var_axh_a.java_lang_String_a().length() == 0) {
                Engine.b("set kb focus null");
                this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.setKeyboardFocus(null);
            } else {
                Engine.b("set kb focus on");
                this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.setKeyboardFocus(this.var_axh_a);
            }
            Engine.b("onEnter 5");
        }
        Engine.b("onEnter 6");
    }

    private void l() {
        if (this.var_com_arenaofkings_client_core_Engine_a.boolean_b()) {
            return;
        }
        this.m();
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
        Label.LabelStyle labelStyle = new Label.LabelStyle(this.var_com_arenaofkings_client_core_Engine_a.j, Color.WHITE);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new b(this, "", this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(730.0f, 575.0f, 450.0f, 195.0f);
        if (!this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            this.var_com_arenaofkings_client_core_Engine_a.a(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    private void m() {
        String string = CharacterClass.simpleName(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
        String string2 = "";
        for (ui ui2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().ui_arr_a()) {
            String string3;
            if (ui2 == null || (string3 = h.a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a())).equals("null")) continue;
            string2 = string2 + ":" + string + "_" + string3 + ": ";
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText(string2);
    }

    public void h() {
        Engine.b("chat ScrollDown() top: " + this.var_int_c + " bottom: " + this.var_int_d);
        if (this.var_int_d < this.var_int_a - 1 && !this.var_en_a.a().get((int)(this.var_int_d + 1)).var_java_lang_String_a.equals("")) {
            System.out.println("Chat debug1");
            ++this.var_int_c;
            ++this.var_int_d;
            for (int i2 = 0; i2 < this.var_en_a.a().size; ++i2) {
                System.out.println("Chat debug2");
                g g2 = this.var_en_a.a().get(i2);
                for (d d2 : g2.a()) {
                    System.out.println("Chat debug3");
                    Engine.b("Label: " + d2.getText() + " index: " + i2 + " y: " + d2.getY());
                    if (i2 == this.var_int_c) {
                        d2.remove();
                    } else if (i2 == this.var_int_d) {
                        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(d2);
                    }
                    d2.setY(d2.getY() + 21.0f);
                }
            }
            System.out.println("Chat debug4");
        }
        System.out.println("Chat debug out");
    }

    public void i() {
        while (this.var_int_d != this.var_en_a.a().size - 1) {
            this.h();
        }
    }

    public void j() {
    }

    public void a(int n2) {
        this.var_int_b = n2;
    }

    public axh axh_a() {
        return this.var_axh_a;
    }

    public void k() {
        Object object;
        int n2;
        for (n2 = 0; n2 < Engine.var_int_a; ++n2) {
            object = this.var_com_arenaofkings_client_core_Engine_a.a().get(n2);
            ((PUB_MISC_CHAT_MESSAGE)object).chatHistoryHandle(this.var_com_arenaofkings_client_core_Engine_a);
        }
        for (n2 = 0; n2 < ay.ay_a().gd_a().ev_a().a().size; ++n2) {
            object = ay.ay_a().gd_a().ev_a().a().getValueAt(n2);
            ((en)object).d();
        }
    }
}

