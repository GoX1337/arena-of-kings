/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

public class ItemLink {
    public int linkLeft;
    public int linkRight;
    public fm item;
    public String name;

    public ItemLink() {
    }

    public ItemLink(int n2, int n3, fm fm2) {
        this.linkLeft = n2;
        this.linkRight = n3;
        this.item = fm2;
        this.name = "[]";
        if (this.item != null) {
            this.name = "[" + this.item.java_lang_String_a() + "]";
        }
    }

    public void shift(int n2) {
        this.linkLeft -= n2;
        this.linkRight -= n2;
    }

    public String toString() {
        return "ItemLink [linkLeft=" + this.linkLeft + ", linkRight=" + this.linkRight + ", item=" + this.item + ", name=" + this.name + "]";
    }
}

