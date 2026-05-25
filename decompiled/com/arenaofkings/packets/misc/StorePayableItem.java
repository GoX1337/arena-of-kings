/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

import com.arenaofkings.packets.misc.StoreItemContent;

public enum StorePayableItem implements StoreItemContent
{
    VILLAIN_COINS_500("vc1", 650, ajw.b, 1000),
    VILLAIN_COINS_1000("vc2", 1380, ajw.b, 1001),
    VILLAIN_COINS_2000("vc3", 2800, ajw.b, 1002),
    VILLAIN_COINS_3500("vc4", 5000, ajw.b, 1003),
    VILLAIN_COINS_5000("vc5", 7200, ajw.b, 1004),
    VILLAIN_COINS_10000("vc6", 15000, ajw.b, 1005),
    MEMBERSHIP_1("vc1", 0, ajw.b, 2000),
    MEMBERSHIP_2("vc3", 0, ajw.b, 2001),
    MEMBERSHIP_3("vc6", 0, ajw.b, 2002),
    GAME_STANDARD_EDITION("game1", 0, ajw.b, 3000),
    GAME_EPIC_EDITION("game2", 0, ajw.b, 3001),
    GAME_LEGENDARY_EDITION("game3", 0, ajw.b, 3002),
    GAME_STANDARD_TO_EPIC("standard_to_epic", 0, ajw.b, 3100),
    GAME_STANDARD_TO_LEGENDARY("standard_to_legendary", 0, ajw.b, 3101),
    GAME_EPIC_TO_LEGENDARY("epic_to_legendary", 0, ajw.b, 3102);

    private String content;
    private int vc;
    private ajw dependency;
    private aer skinData;
    private final int itemID;

    private StorePayableItem(String string2, int n3, ajw ajw2, int n4) {
        this.content = string2;
        this.vc = n3;
        this.dependency = ajw2;
        this.itemID = n4;
    }

    @Override
    public String getContent() {
        return this.toString();
    }

    @Override
    public String getPriceString() {
        return "";
    }

    public int getVc() {
        return this.vc;
    }

    @Override
    public ajw getScreenDependency() {
        return this.dependency;
    }

    public static String getCost(StorePayableItem storePayableItem) {
        switch (storePayableItem) {
            case VILLAIN_COINS_500: {
                return "$5";
            }
            case VILLAIN_COINS_1000: {
                return "$10";
            }
            case VILLAIN_COINS_2000: {
                return "$20";
            }
            case VILLAIN_COINS_3500: {
                return "$35";
            }
            case VILLAIN_COINS_5000: {
                return "$50";
            }
            case VILLAIN_COINS_10000: {
                return "$100";
            }
        }
        return "Unavailable";
    }

    public static int getAmount(StorePayableItem storePayableItem) {
        switch (storePayableItem) {
            case VILLAIN_COINS_500: {
                return 650;
            }
            case VILLAIN_COINS_1000: {
                return 1380;
            }
            case VILLAIN_COINS_2000: {
                return 2800;
            }
            case VILLAIN_COINS_3500: {
                return 5000;
            }
            case VILLAIN_COINS_5000: {
                return 7200;
            }
            case VILLAIN_COINS_10000: {
                return 15000;
            }
        }
        return 0;
    }

    @Override
    public yt getRarity() {
        return yt.d;
    }

    public int getItemID() {
        return this.itemID;
    }
}

