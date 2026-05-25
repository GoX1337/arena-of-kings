/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.packets.gameserver.data.ScoreboardItem;
import com.badlogic.gdx.utils.Array;

public class ScoreboardUpdate
implements Comparable<ScoreboardUpdate> {
    private String player_name;
    private int score;
    private Array<ScoreboardItem> damage = new Array();
    private Array<ScoreboardItem> healing = new Array();
    private Array<ScoreboardItem> tanked = new Array();
    private Array<ScoreboardItem> control = new Array();
    public int newRating;
    public int ratingChange;
    public boolean victory;

    public ScoreboardUpdate() {
    }

    public ScoreboardUpdate(String string) {
        this.player_name = string;
    }

    public Array<ScoreboardItem> getControl() {
        return this.control;
    }

    public Array<ScoreboardItem> getDamage() {
        return this.damage;
    }

    public Array<ScoreboardItem> getHealing() {
        return this.healing;
    }

    public String getPlayer_name() {
        return this.player_name;
    }

    public int getScore() {
        return this.score;
    }

    public Array<ScoreboardItem> getTanked() {
        return this.tanked;
    }

    @Override
    public int compareTo(ScoreboardUpdate scoreboardUpdate) {
        if (scoreboardUpdate.score >= this.score) {
            return 1;
        }
        return -1;
    }
}

