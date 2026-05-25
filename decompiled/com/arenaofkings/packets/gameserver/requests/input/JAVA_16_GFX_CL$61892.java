/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.misc.PublicPacket;

public class JAVA_16_GFX_CL$61892
extends PublicPacket {
    protected float $w;
    protected float $f40;
    protected int c;
    protected String d;
    protected Direction ee;
    protected PlayerAction f;

    public JAVA_16_GFX_CL$61892() {
    }

    public JAVA_16_GFX_CL$61892(int n2, int n3, int n4) {
        this.c = n2;
        this.$w = n3;
        this.$f40 = n4;
    }

    public JAVA_16_GFX_CL$61892(int n2, int n3, int n4, Direction direction) {
        this.c = n2;
        this.$w = n3;
        this.$f40 = n4;
        this.ee = direction;
    }

    public void sc(String string) {
        this.d = string;
    }

    public Direction gnd() {
        return this.ee;
    }

    public PlayerAction gnp() {
        return this.f;
    }

    public int gs() {
        return this.c;
    }

    public float $40() {
        return this.$w;
    }

    public float $50() {
        return this.$f40;
    }

    public String gc() {
        return this.d;
    }

    public void $2ls(Direction direction) {
        this.ee = direction;
    }

    public void $2x(PlayerAction playerAction) {
        this.f = playerAction;
    }

    public void lk(int n2) {
        this.$w = n2;
    }

    public void tn(int n2) {
        this.$f40 = n2;
    }

    public void setValues(int n2, int n3, int n4) {
        this.c = n2;
        this.$w = n3;
        this.$f40 = n4;
    }

    public void setSEQUENCE_NUMBER(int n2) {
        this.c = n2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

