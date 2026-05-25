/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum RelationshipStatus {
    NONE(-1),
    PENDING(0),
    ACCEPTED(1),
    DECLINED(2),
    IGNORED(3);

    private final int code;

    private RelationshipStatus(int n3) {
        this.code = n3;
    }

    public int getCode() {
        return this.code;
    }

    public static RelationshipStatus valueOf(int n2) {
        switch (n2) {
            case -1: {
                return NONE;
            }
            case 0: {
                return PENDING;
            }
            case 1: {
                return ACCEPTED;
            }
            case 2: {
                return DECLINED;
            }
            case 3: {
                return IGNORED;
            }
        }
        return NONE;
    }
}

