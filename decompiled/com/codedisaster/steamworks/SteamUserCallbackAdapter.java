/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAuth;
import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUserCallback;

class SteamUserCallbackAdapter
extends SteamCallbackAdapter<SteamUserCallback> {
    SteamUserCallbackAdapter(SteamUserCallback steamUserCallback) {
        super(steamUserCallback);
    }

    void onValidateAuthTicket(long l2, int n2, long l3) {
        ((SteamUserCallback)this.callback).onValidateAuthTicket(new SteamID(l2), SteamAuth.AuthSessionResponse.byOrdinal(n2), new SteamID(l3));
    }

    void onMicroTxnAuthorization(int n2, long l2, boolean bl2) {
        ((SteamUserCallback)this.callback).onMicroTxnAuthorization(n2, l2, bl2);
    }

    void onEncryptedAppTicket(int n2) {
        ((SteamUserCallback)this.callback).onEncryptedAppTicket(SteamResult.byValue(n2));
    }
}

