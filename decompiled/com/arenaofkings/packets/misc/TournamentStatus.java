/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum TournamentStatus {
    HIDDEN,
    UPCOMING,
    REGISTRATION,
    IN_PROGRESS,
    ENDED,
    CANCELED;


    public static String getFormattedName(TournamentStatus tournamentStatus) {
        switch (tournamentStatus) {
            case CANCELED: {
                return "Canceled";
            }
            case ENDED: {
                return "Ended";
            }
            case HIDDEN: {
                return "Hidden";
            }
            case IN_PROGRESS: {
                return "In Progress";
            }
            case REGISTRATION: {
                return "Registering!";
            }
            case UPCOMING: {
                return "Upcoming";
            }
        }
        return "INVALID";
    }
}

