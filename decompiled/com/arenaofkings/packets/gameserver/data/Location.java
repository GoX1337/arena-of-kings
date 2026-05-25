/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.Target;

public class Location {
    private HitCircle hitCircle;
    private LocationType locationType;
    private Target target;

    public Location() {
    }

    public Location(float f2, float f3) {
        this.hitCircle = new HitCircle(f2, f3, 0);
    }

    public Location(Target target) {
        this.target = target;
    }

    public void initHitCircle(Engine engine) {
        ui ui2 = this.target.getTargetableSpell(engine);
        if (ui2 != null) {
            this.hitCircle = ui2.hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a();
            Engine.a("setting the hitCircle");
            Engine.a("hitcircle: " + ui2.hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a());
        } else {
            Engine.a("SPELL WASNT FOUND");
        }
    }

    public HitCircle getHitCircle() {
        return this.hitCircle;
    }

    public Target getTarget() {
        return this.target;
    }

    public float getX() {
        br br2;
        if ((this.target == null || this.target.getPlayer() == null) && this.hitCircle != null) {
            return this.hitCircle.getX();
        }
        if (this.target != null && (br2 = this.target.getPlayer()) != null) {
            float f2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
            return f2;
        }
        Engine.a("[WARNING] getX() in Location may not be what is desired - returning 0");
        return 0.0f;
    }

    public float getY() {
        br br2;
        if ((this.target == null || this.target.getPlayer() == null) && this.hitCircle != null) {
            return this.hitCircle.getY();
        }
        if (this.target != null && (br2 = this.target.getPlayer()) != null) {
            float f2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
            return f2;
        }
        Engine.a("[WARNING] getY() in Location may not be what is desired - returning 0");
        return 0.0f;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setX(float f2) {
        this.hitCircle.setX(f2);
    }

    public void setY(float f2) {
        this.hitCircle.setY(f2);
    }

    public void setPosition(float f2, float f3) {
        this.hitCircle.setPosition(f2, f3);
    }

    public String toString() {
        return "Location [hitCircle=" + this.hitCircle + ", target=" + this.target + "]";
    }
}

