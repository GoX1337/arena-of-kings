/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.player.me;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.shared.SharedAccountData;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ItemData;
import java.util.ArrayList;
import java.util.HashMap;

public class MyAccountData
extends SharedAccountData {
    private ArrayList<ej> characterEntities = new ArrayList();
    private final String account_name;

    public MyAccountData(Engine engine, String string, int n2, ArrayList<CharacterClass> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<String> arrayList5, ArrayList<String> arrayList6, ArrayList<String> arrayList7, ArrayList<String> arrayList8, ArrayList<String> arrayList9, ArrayList<String> arrayList10, ArrayList<Integer> arrayList11, ArrayList<Integer> arrayList12, ArrayList<String> arrayList13, ArrayList<String> arrayList14, ArrayList<String> arrayList15, ArrayList<String> arrayList16, ArrayList<Integer> arrayList17, ArrayList<Integer> arrayList18, ArrayList<Double> arrayList19, ArrayList<Double> arrayList20, ArrayList<Integer> arrayList21, ArrayList<Integer> arrayList22, ArrayList<Integer> arrayList23, ArrayList<Integer> arrayList24, ArrayList<Integer> arrayList25, ArrayList<Integer> arrayList26, ArrayList<Integer> arrayList27, ArrayList<Integer> arrayList28, int n3, HashMap<String, ArrayList<ItemData>> hashMap) {
        this.account_name = string;
        if (arrayList10.size() > 0 && arrayList10.size() == arrayList.size() && arrayList10.size() == arrayList17.size()) {
            for (int i2 = 0; i2 < arrayList10.size(); ++i2) {
                System.out.println("Load arena points: " + arrayList26.get(i2));
                this.characterEntities.add(new ej(engine, arrayList10.get(i2), arrayList.get(i2), arrayList2.get(i2), arrayList3.get(i2), arrayList4.get(i2), arrayList5.get(i2), arrayList6.get(i2), arrayList7.get(i2), arrayList8.get(i2), arrayList9.get(i2), arrayList11.get(i2), arrayList12.get(i2), arrayList13.get(i2), arrayList14.get(i2), arrayList15.get(i2), arrayList16.get(i2), arrayList17.get(i2), arrayList18.get(i2), arrayList19.get(i2).intValue(), arrayList20.get(i2).intValue(), arrayList21.get(i2), arrayList22.get(i2), arrayList23.get(i2), arrayList24.get(i2), arrayList25.get(i2), arrayList26.get(i2), arrayList27.get(i2), arrayList28.get(i2), hashMap.get(arrayList10.get(i2))));
            }
        } else {
            Engine.a("No character entities on this account");
        }
        if (this.characterEntities.size() > 0) {
            this.setActive_character_entity(this.characterEntities.get(0));
            this.active_character_entity.void_a(1);
        }
        Engine.a("Out of MyAccountData");
    }

    public ArrayList<ej> getCharacterEntities() {
        return this.characterEntities;
    }

    @Override
    public ej getActive_character_entity() {
        return (ej)this.active_character_entity;
    }

    public String getAccount_name() {
        return this.account_name;
    }
}

