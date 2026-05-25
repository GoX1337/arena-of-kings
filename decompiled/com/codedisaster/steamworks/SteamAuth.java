/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public class SteamAuth {

    public static enum UserHasLicenseForAppResult {
        HasLicense,
        DoesNotHaveLicense,
        NoAuth;

        private static final UserHasLicenseForAppResult[] values;

        static UserHasLicenseForAppResult byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = UserHasLicenseForAppResult.values();
        }
    }

    public static enum AuthSessionResponse {
        OK,
        UserNotConnectedToSteam,
        NoLicenseOrExpired,
        VACBanned,
        LoggedInElseWhere,
        VACCheckTimedOut,
        AuthTicketCanceled,
        AuthTicketInvalidAlreadyUsed,
        AuthTicketInvalid,
        PublisherIssuedBan;

        private static final AuthSessionResponse[] values;

        static AuthSessionResponse byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = AuthSessionResponse.values();
        }
    }

    public static enum BeginAuthSessionResult {
        OK,
        InvalidTicket,
        DuplicateRequest,
        InvalidVersion,
        GameMismatch,
        ExpiredTicket;

        private static final BeginAuthSessionResult[] values;

        static BeginAuthSessionResult byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = BeginAuthSessionResult.values();
        }
    }
}

