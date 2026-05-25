/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_ERROR_REPORT;
import com.arenaofkings.packets.loginserver.PUB_LOGIN_EXISTING_ACCOUNT_REQUEST;
import com.arenaofkings.packets.misc.ErrorCode;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_SALT_RESPONSE
extends PublicPacket {
    public String salt;

    @Deprecated
    public PUB_LOGIN_SALT_RESPONSE() {
    }

    public PUB_LOGIN_SALT_RESPONSE(String string) {
        this.salt = string;
    }

    @Override
    public void handle(Engine engine) {
        System.out.println("Received a salt response");
        if (t.a(aes.class, engine)) {
            if (this.salt.equals("DNE")) {
                PUB_ERROR_REPORT pUB_ERROR_REPORT = new PUB_ERROR_REPORT(ErrorCode.INVALID_CREDENTIALS);
                pUB_ERROR_REPORT.handle(engine);
            } else {
                String string = axo.a(((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().getText(), this.salt);
                PUB_LOGIN_EXISTING_ACCOUNT_REQUEST pUB_LOGIN_EXISTING_ACCOUNT_REQUEST = new PUB_LOGIN_EXISTING_ACCOUNT_REQUEST(((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_a().getText(), string, ((aex)((aes)engine.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().getText(), engine.var_java_lang_String_e);
                engine.var_z_a.void_a(pUB_LOGIN_EXISTING_ACCOUNT_REQUEST);
                engine.var_com_arenaofkings_packets_loginserver_PUB_LOGIN_EXISTING_ACCOUNT_REQUEST_a = pUB_LOGIN_EXISTING_ACCOUNT_REQUEST;
            }
        }
    }
}

