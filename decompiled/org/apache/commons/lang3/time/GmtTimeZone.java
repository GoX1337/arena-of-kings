/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.util.Date;
import java.util.TimeZone;

class GmtTimeZone
extends TimeZone {
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    static final long serialVersionUID = 1L;
    private final int offset;
    private final String zoneId;

    GmtTimeZone(boolean bl2, int n2, int n3) {
        if (n2 >= 24) {
            throw new IllegalArgumentException(n2 + " hours out of range");
        }
        if (n3 >= 60) {
            throw new IllegalArgumentException(n3 + " minutes out of range");
        }
        int n4 = (n3 + n2 * 60) * 60000;
        this.offset = bl2 ? -n4 : n4;
        this.zoneId = GmtTimeZone.twoDigits(GmtTimeZone.twoDigits(new StringBuilder(9).append("GMT").append(bl2 ? (char)'-' : '+'), n2).append(':'), n3).toString();
    }

    private static StringBuilder twoDigits(StringBuilder stringBuilder, int n2) {
        return stringBuilder.append((char)(48 + n2 / 10)).append((char)(48 + n2 % 10));
    }

    @Override
    public int getOffset(int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.offset;
    }

    @Override
    public void setRawOffset(int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getRawOffset() {
        return this.offset;
    }

    @Override
    public String getID() {
        return this.zoneId;
    }

    @Override
    public boolean useDaylightTime() {
        return false;
    }

    @Override
    public boolean inDaylightTime(Date date) {
        return false;
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + ']';
    }

    public int hashCode() {
        return this.offset;
    }

    public boolean equals(Object object) {
        if (!(object instanceof GmtTimeZone)) {
            return false;
        }
        return this.zoneId == ((GmtTimeZone)object).zoneId;
    }
}

