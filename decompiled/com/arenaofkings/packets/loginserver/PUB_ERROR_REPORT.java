/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ErrorCode;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ERROR_REPORT
extends PublicPacket {
    private ErrorCode ERROR_CODE;
    private int queueRemaining;

    public PUB_ERROR_REPORT() {
    }

    public PUB_ERROR_REPORT(ErrorCode errorCode) {
        this.ERROR_CODE = errorCode;
    }

    public PUB_ERROR_REPORT(ErrorCode errorCode, int n2) {
        this.ERROR_CODE = errorCode;
        this.queueRemaining = n2;
    }

    @Override
    public void handle(Engine engine) {
        Engine.a("[ERROR_REPORT] Received Error Code = '" + (Object)((Object)this.ERROR_CODE) + "'");
        if (t.a(aes.class, engine)) {
            ((aex)((aes)engine.axc_a()).aya_a()).k();
        }
        switch (this.ERROR_CODE) {
            case INVALID_CREDENTIALS: {
                engine.var_baa_a.a(ajw.kG, 0.6f);
                if (!t.a(aes.class, engine)) break;
                ((aex)((aes)engine.axc_a()).aya_a()).e();
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_a().setDisabled(false);
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setDisabled(false);
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setText("");
                break;
            }
            case BANNED: {
                engine.var_baa_a.a(ajw.kG, 0.6f);
                if (!t.a(aes.class, engine)) break;
                ((aex)((aes)engine.axc_a()).aya_a()).f();
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_a().setDisabled(false);
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setDisabled(false);
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setText("");
                break;
            }
            case INVALID_CHARACTER_NAME: {
                if (!t.a(vj.class, engine)) break;
                ((vl)((vj)engine.axc_a()).aya_a()).axh_a().b("");
                engine.var_baa_a.a(ajw.kG, 0.5f);
                ((vl)((vj)engine.axc_a()).aya_a()).void_c();
                break;
            }
            case INVALID_IN_GAME_CURRENTLY: {
                if (t.a(aes.class, engine)) {
                    ((aex)((aes)engine.axc_a()).aya_a()).l();
                    ((aex)((aes)engine.axc_a()).aya_a()).j();
                    ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setText("");
                    break;
                }
            }
            case VERSION_MISMATCH: {
                ((aex)((aes)engine.axc_a()).aya_a()).i();
                break;
            }
            case INVALID_ACCESS: {
                if (!t.a(aes.class, engine)) break;
                ((aex)((aes)engine.axc_a()).aya_a()).h();
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_a().setDisabled(false);
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setDisabled(false);
                ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setText("");
                break;
            }
            case REGISTRATION_SUCCESS: {
                if (!t.a(um.class, engine)) break;
                ((up)((um)engine.axc_a()).aya_a()).void_c();
                break;
            }
            case INVALID_EMAIL: {
                if (!t.a(um.class, engine)) break;
                ((up)((um)engine.axc_a()).aya_a()).d();
                break;
            }
            case RESET_PW_UNKNOWN_EMAIL: {
                ((aex)((aes)engine.axc_a()).aya_a()).n();
                break;
            }
            case RESET_PW_VALID_EMAIL: {
                ((aex)((aes)engine.axc_a()).aya_a()).o();
                break;
            }
        }
    }
}

