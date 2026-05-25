/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ArmorRequirement;
import com.arenaofkings.packets.misc.items.ClassRequirement;
import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemArmorType;
import com.arenaofkings.packets.misc.items.ItemSlot;
import com.arenaofkings.packets.misc.items.LevelRequirement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class fp
extends Enum<fp> {
    public static final /* enum */ fp var_fp_a;
    public static final /* enum */ fp var_fp_b;
    public static final /* enum */ fp c;
    public static final /* enum */ fp d;
    public static final /* enum */ fp e;
    public static final /* enum */ fp f;
    public static final /* enum */ fp g;
    public static final /* enum */ fp h;
    public static final /* enum */ fp i;
    public static final /* enum */ fp j;
    public static final /* enum */ fp k;
    public static final /* enum */ fp l;
    public static final /* enum */ fp m;
    public static final /* enum */ fp n;
    public static final /* enum */ fp o;
    public static final /* enum */ fp p;
    public static final /* enum */ fp q;
    public static final /* enum */ fp r;
    public static final /* enum */ fp s;
    public static final /* enum */ fp t;
    public static final /* enum */ fp u;
    public static final /* enum */ fp v;
    public static final /* enum */ fp w;
    public static final /* enum */ fp x;
    public static final /* enum */ fp y;
    public static final /* enum */ fp z;
    public static final /* enum */ fp A;
    public static final /* enum */ fp B;
    public static final /* enum */ fp C;
    public static final /* enum */ fp D;
    public static final /* enum */ fp E;
    public static final /* enum */ fp F;
    public static final /* enum */ fp G;
    public static final /* enum */ fp H;
    public static final /* enum */ fp I;
    public static final /* enum */ fp J;
    public static final /* enum */ fp K;
    public static final /* enum */ fp L;
    public static final /* enum */ fp M;
    public static final /* enum */ fp N;
    public static final /* enum */ fp O;
    public static final /* enum */ fp P;
    public static final /* enum */ fp Q;
    public static final /* enum */ fp R;
    public static final /* enum */ fp S;
    public static final /* enum */ fp T;
    public static final /* enum */ fp U;
    public static final /* enum */ fp V;
    public static final /* enum */ fp W;
    public static final /* enum */ fp X;
    public static final /* enum */ fp Y;
    public static final /* enum */ fp Z;
    public static final /* enum */ fp aa;
    public static final /* enum */ fp ab;
    public static final /* enum */ fp ac;
    public static final /* enum */ fp ad;
    public static final /* enum */ fp ae;
    public static final /* enum */ fp af;
    public static final /* enum */ fp ag;
    public static final /* enum */ fp ah;
    public static final /* enum */ fp ai;
    public static final /* enum */ fp aj;
    public static final /* enum */ fp ak;
    public static final /* enum */ fp al;
    public static final /* enum */ fp am;
    public static final /* enum */ fp an;
    public static final /* enum */ fp ao;
    public static final /* enum */ fp ap;
    public static final /* enum */ fp aq;
    public static final /* enum */ fp ar;
    public static final /* enum */ fp as;
    public static final /* enum */ fp at;
    public static final /* enum */ fp au;
    public static final /* enum */ fp av;
    public static final /* enum */ fp aw;
    public static final /* enum */ fp ax;
    public static final /* enum */ fp ay;
    public static final /* enum */ fp az;
    public static final /* enum */ fp aA;
    public static final /* enum */ fp aB;
    public static final /* enum */ fp aC;
    public static final /* enum */ fp aD;
    public static final /* enum */ fp aE;
    public static final /* enum */ fp aF;
    public static final /* enum */ fp aG;
    public static final /* enum */ fp aH;
    public static final /* enum */ fp aI;
    public static final /* enum */ fp aJ;
    public static final /* enum */ fp aK;
    public static final /* enum */ fp aL;
    public static final /* enum */ fp aM;
    public static final /* enum */ fp aN;
    public static final /* enum */ fp aO;
    public static final /* enum */ fp aP;
    public static final /* enum */ fp aQ;
    public static final /* enum */ fp aR;
    public static final /* enum */ fp aS;
    public static final /* enum */ fp aT;
    public static final /* enum */ fp aU;
    public static final /* enum */ fp aV;
    public static final /* enum */ fp aW;
    public static final /* enum */ fp aX;
    public static final /* enum */ fp aY;
    public static final /* enum */ fp aZ;
    public static final /* enum */ fp ba;
    public static final /* enum */ fp bb;
    public static final /* enum */ fp bc;
    public static final /* enum */ fp bd;
    public static final /* enum */ fp be;
    public static final /* enum */ fp bf;
    public static final /* enum */ fp bg;
    public static final /* enum */ fp bh;
    public static final /* enum */ fp bi;
    public static final /* enum */ fp bj;
    public static final /* enum */ fp bk;
    public static final /* enum */ fp bl;
    public static final /* enum */ fp bm;
    public static final /* enum */ fp bn;
    public static final /* enum */ fp bo;
    public static final /* enum */ fp bp;
    public static final /* enum */ fp bq;
    public static final /* enum */ fp br;
    public static final /* enum */ fp bs;
    public static final /* enum */ fp bt;
    public static final /* enum */ fp bu;
    public static final /* enum */ fp bv;
    public static final /* enum */ fp bw;
    public static final /* enum */ fp bx;
    public static final /* enum */ fp by;
    public static final /* enum */ fp bz;
    public static final /* enum */ fp bA;
    public static final /* enum */ fp bB;
    public static final /* enum */ fp bC;
    public static final /* enum */ fp bD;
    public static final /* enum */ fp bE;
    public static final /* enum */ fp bF;
    public static final /* enum */ fp bG;
    public static final /* enum */ fp bH;
    public static final /* enum */ fp bI;
    public static final /* enum */ fp bJ;
    public static final /* enum */ fp bK;
    public static final /* enum */ fp bL;
    public static final /* enum */ fp bM;
    public static final /* enum */ fp bN;
    public static final /* enum */ fp bO;
    public static final /* enum */ fp bP;
    public static final /* enum */ fp bQ;
    public static final /* enum */ fp bR;
    public static final /* enum */ fp bS;
    public static final /* enum */ fp bT;
    public static final /* enum */ fp bU;
    public static final /* enum */ fp bV;
    public static final /* enum */ fp bW;
    public static final /* enum */ fp bX;
    public static final /* enum */ fp bY;
    public static final /* enum */ fp bZ;
    public static final /* enum */ fp ca;
    public static final /* enum */ fp cb;
    public static final /* enum */ fp cc;
    public static final /* enum */ fp cd;
    public static final /* enum */ fp ce;
    public static final /* enum */ fp cf;
    public static final /* enum */ fp cg;
    public static final /* enum */ fp ch;
    public static final /* enum */ fp ci;
    protected int var_int_a;
    protected String var_java_lang_String_a;
    protected ItemSlot var_com_arenaofkings_packets_misc_items_ItemSlot_a;
    protected List<EquippableRequirement> var_java_util_List_com_arenaofkings_packets_misc_items_EquippableRequirement__a;
    protected float var_float_a;
    protected String var_java_lang_String_b;
    private static final /* synthetic */ fp[] var_fp_arr_a;

    public static fp[] values() {
        return (fp[])var_fp_arr_a.clone();
    }

    public static fp valueOf(String string) {
        return Enum.valueOf(fp.class, string);
    }

    private fp(int n3, String string2, ItemSlot itemSlot, float f2, EquippableRequirement equippableRequirement) {
        this.var_fp_a = new ArrayList(3);
        this.var_float_a = -1.0f;
        this.var_int_a = n3;
        this.var_java_lang_String_a = string2;
        this.var_com_arenaofkings_packets_misc_items_ItemSlot_a = itemSlot;
        this.var_float_a = f2;
        if (equippableRequirement != null) {
            this.var_fp_a.add(equippableRequirement);
        }
        this.a(n3, itemSlot);
    }

    public void a(int n2, ItemSlot itemSlot) {
        LevelRequirement levelRequirement = new LevelRequirement(1);
        this.var_fp_a.add(levelRequirement);
    }

    private fp(int n3, String string2, ItemSlot itemSlot, float f2, String string3, EquippableRequirement ... equippableRequirementArray) {
        this.var_fp_a = new ArrayList(3);
        this.var_float_a = -1.0f;
        this.var_int_a = n3;
        this.var_java_lang_String_a = string2;
        this.var_com_arenaofkings_packets_misc_items_ItemSlot_a = itemSlot;
        this.var_float_a = f2;
        this.var_java_lang_String_b = string3;
        if (equippableRequirementArray != null) {
            for (EquippableRequirement equippableRequirement : equippableRequirementArray) {
                this.var_fp_a.add(equippableRequirement);
            }
        }
        this.a(n3, itemSlot);
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public static String a(fp fp2) {
        if (fp2 == var_fp_a || fp2 == var_fp_b || fp2 == c || fp2 == d || fp2 == e) {
            return "Dagger";
        }
        if (fp2 == f || fp2 == g || fp2 == h || fp2 == i || fp2 == j) {
            return "2H Sword";
        }
        if (fp2 == p || fp2 == q || fp2 == r || fp2 == s || fp2 == t) {
            return "1H Sword";
        }
        if (fp2 == u || fp2 == v || fp2 == w || fp2 == x || fp2 == y) {
            return "Wand";
        }
        if (fp2 == k || fp2 == l || fp2 == m || fp2 == n || fp2 == o) {
            return "Staff";
        }
        if (fp2 == z || fp2 == A || fp2 == B || fp2 == C || fp2 == D) {
            return "Libram";
        }
        if (fp2 == E || fp2 == F || fp2 == G || fp2 == H || fp2 == I) {
            return "Orb";
        }
        if (fp2 == J || fp2 == K || fp2 == L || fp2 == M || fp2 == N) {
            return "Wand";
        }
        if (fp2 == O || fp2 == P || fp2 == Q || fp2 == R || fp2 == S) {
            return "Bow";
        }
        if (fp2 == T || fp2 == U || fp2 == V || fp2 == W || fp2 == X) {
            return "Staff";
        }
        if (fp2 == Y || fp2 == Z || fp2 == aa || fp2 == ab) {
            return "Robe";
        }
        if (fp2 == ac || fp2 == ad || fp2 == ae || fp2 == af) {
            return "Vest";
        }
        if (fp2 == ag || fp2 == ah || fp2 == ai || fp2 == aj) {
            return "Cuirass";
        }
        if (fp2 == ak || fp2 == al || fp2 == am || fp2 == an) {
            return "Hood";
        }
        if (fp2 == ao || fp2 == ap || fp2 == aq || fp2 == ar) {
            return "Cowl";
        }
        if (fp2 == as || fp2 == at || fp2 == au || fp2 == av) {
            return "Armet";
        }
        if (fp2 == aw || fp2 == ax || fp2 == ay || fp2 == az) {
            return "Mantle";
        }
        if (fp2 == aA || fp2 == aB || fp2 == aC || fp2 == aD) {
            return "Shoulder";
        }
        if (fp2 == aE || fp2 == aF || fp2 == aG || fp2 == aH) {
            return "Pauldron";
        }
        if (fp2 == aI || fp2 == aJ || fp2 == aK || fp2 == aL) {
            return "Cape";
        }
        if (fp2 == aM || fp2 == aN || fp2 == aO || fp2 == aP || fp2 == aQ || fp2 == aR || fp2 == aS || fp2 == aT || fp2 == aU || fp2 == aV || fp2 == aW || fp2 == aX) {
            return "Bracers";
        }
        if (fp2 == aY || fp2 == aZ || fp2 == ba || fp2 == bb) {
            return "Mitts";
        }
        if (fp2 == bc || fp2 == bd || fp2 == be || fp2 == bf) {
            return "Gloves";
        }
        if (fp2 == bg || fp2 == bh || fp2 == bi || fp2 == bj) {
            return "Gauntlet";
        }
        if (fp2 == bk || fp2 == bl || fp2 == bm || fp2 == bn) {
            return "Bottom";
        }
        if (fp2 == bo || fp2 == bp || fp2 == bq || fp2 == br) {
            return "Leggings";
        }
        if (fp2 == bs || fp2 == bt || fp2 == bu || fp2 == bv) {
            return "Cuisse";
        }
        if (fp2 == bw || fp2 == bx || fp2 == by || fp2 == bz) {
            return "Boots";
        }
        if (fp2 == bA || fp2 == bB || fp2 == bC || fp2 == bD) {
            return "Boots";
        }
        if (fp2 == bE || fp2 == bF || fp2 == bG || fp2 == bH) {
            return "Greaves";
        }
        if (fp2 == bI || fp2 == bJ || fp2 == bK || fp2 == bL) {
            return "Amulet";
        }
        if (fp2 == bM || fp2 == bN || fp2 == bO || fp2 == bP) {
            return "Ring";
        }
        if (fp2 == bQ || fp2 == bR || fp2 == bS || fp2 == bT) {
            return "Trinket";
        }
        return "BUG REPORT THIS ITEM";
    }

    public int int_a() {
        return this.var_int_a;
    }

    public List<EquippableRequirement> a() {
        return this.var_fp_a;
    }

    public int int_b() {
        return 1;
    }

    public CharacterClass com_arenaofkings_packets_misc_CharacterClass_a() {
        Iterator iterator = this.var_fp_a.iterator();
        while (iterator.hasNext()) {
            EquippableRequirement equippableRequirement = (EquippableRequirement)iterator.next();
            if (!(equippableRequirement instanceof ClassRequirement)) continue;
            return ((ClassRequirement)equippableRequirement).getClassRequirement();
        }
        return null;
    }

    public ItemSlot com_arenaofkings_packets_misc_items_ItemSlot_a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemSlot_a;
    }

    public int a(int n2, fp fp2) {
        int n3 = 1;
        switch (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a) {
            case BACK: {
                n3 = 50;
                break;
            }
            case CHEST: {
                n3 = 50;
                break;
            }
            case FEET: {
                n3 = 50;
                break;
            }
            case HANDS: {
                n3 = 50;
                break;
            }
            case HEAD: {
                n3 = 50;
                break;
            }
            case LEGS: {
                n3 = 50;
                break;
            }
            case NECK: {
                n3 = 75;
                break;
            }
            case RING: {
                n3 = 75;
                break;
            }
            case SHOULDER: {
                n3 = 50;
                break;
            }
            case TRINKET: {
                n3 = 75;
                break;
            }
            case WEAPON: {
                n3 = 100;
                break;
            }
            case WRIST: {
                n3 = 50;
                break;
            }
        }
        if (fp2.var_int_a <= 1) {
            n3 = (int)((double)n3 + (double)n3 * 0.25);
        } else if (fp2.var_int_a == 2) {
            n3 = (int)((double)n3 + (double)n3 * 0.5);
        } else if (fp2.var_int_a == 3) {
            n3 = (int)((double)n3 + (double)n3 * 1.0);
        } else if (fp2.var_int_a == 4) {
            n3 = (int)((double)n3 + (double)n3 * 2.0);
        } else if (fp2.var_int_a >= 5) {
            n3 = (int)((double)n3 + (double)n3 * 2.5);
        }
        return n3;
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_b;
    }

    static {
        var_fp_a = new fp(1, "Dagger", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ASSASSIN));
        var_fp_b = new fp(2, "Curved Knive", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ASSASSIN));
        c = new fp(3, "Dragon's Tooth", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ASSASSIN));
        d = new fp(4, "Runed Blade", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ASSASSIN));
        e = new fp(5, "Golden Kris", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ASSASSIN));
        f = new fp(1, "Steel 2H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.CHAMPION));
        g = new fp(2, "Embossed 2H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.CHAMPION));
        h = new fp(3, "Ancient 2H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.CHAMPION));
        i = new fp(4, "Emerald 2H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.CHAMPION));
        j = new fp(5, "Divine 2H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.CHAMPION));
        k = new fp(1, "Togo Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ELDER));
        l = new fp(2, "Serpent Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ELDER));
        m = new fp(3, "Ancient Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ELDER));
        n = new fp(4, "Dragon Bone Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ELDER));
        o = new fp(5, "Earthliving Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.ELDER));
        p = new fp(1, "Broad 1H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.PALADIN));
        q = new fp(2, "Light 1H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.PALADIN));
        r = new fp(3, "Azure 1H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.PALADIN));
        s = new fp(4, "Royal 1H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.PALADIN));
        t = new fp(5, "Hero's 1H Sword", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.PALADIN));
        u = new fp(1, "Amethyst Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.LICH));
        v = new fp(2, "Shadow Scythe", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.LICH));
        w = new fp(3, "Abyssal Scythe", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.LICH));
        x = new fp(4, "Ghost Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.LICH));
        y = new fp(5, "Oblivion Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.LICH));
        z = new fp(1, "Libram I: Becoming", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.SCHOLAR));
        A = new fp(2, "Libram II: Sacrifices", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.SCHOLAR));
        B = new fp(3, "Libram III: Revelations", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.SCHOLAR));
        C = new fp(4, "Libram IV: Deliverance", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.SCHOLAR));
        D = new fp(5, "Libram V: Metempsychosis", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.SCHOLAR));
        E = new fp(1, "Orb of Stone", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.NIHILIST));
        F = new fp(2, "Orb of Life", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.NIHILIST));
        G = new fp(3, "Orb of Souls", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.NIHILIST));
        H = new fp(4, "Orb of Undeath", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.NIHILIST));
        I = new fp(5, "Orb of Cataclysm", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.NIHILIST));
        J = new fp(1, "Spiral Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.MYSTIC));
        K = new fp(2, "Kazaarian Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.MYSTIC));
        L = new fp(3, "Crescent Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.MYSTIC));
        M = new fp(4, "Eclipse Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.MYSTIC));
        N = new fp(5, "Stardust Wand", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.MYSTIC));
        O = new fp(1, "Short Bow", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.RANGER));
        P = new fp(2, "Maple Bow", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.RANGER));
        Q = new fp(3, "Skull Bow", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.RANGER));
        R = new fp(4, "Diamond Bow", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.RANGER));
        S = new fp(5, "Phoenix Bow", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.RANGER));
        T = new fp(1, "Apprentice Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.WIZARD));
        U = new fp(2, "Sapphire Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.WIZARD));
        V = new fp(3, "Archon Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.WIZARD));
        W = new fp(4, "Dragonheart Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.WIZARD));
        X = new fp(5, "Tempest Staff", ItemSlot.WEAPON, 0.2f, new ClassRequirement(CharacterClass.WIZARD));
        Y = new fp(1, "Quilted Robe", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        Z = new fp(2, "Magical Robe", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aa = new fp(3, "Spellweave Robe", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        ab = new fp(4, "Moonweave Robe", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        ac = new fp(1, "Rugged Vest", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        ad = new fp(2, "Embossed Vest", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        ae = new fp(3, "Combat Vest", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        af = new fp(4, "Dragonhide Vest", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        ag = new fp(1, "Steel Cuirass", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        ah = new fp(2, "Metallic Cuirass", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        ai = new fp(3, "Royal Cuirass", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aj = new fp(4, "Divine Cuirass", ItemSlot.CHEST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        ak = new fp(1, "Quilted Hood", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        al = new fp(2, "Magical Hood", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        am = new fp(3, "Spellweave Hood", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        an = new fp(4, "Moonweave Hood", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        ao = new fp(1, "Rugged Cowl", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        ap = new fp(2, "Embossed Cowl", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aq = new fp(3, "Combat Cowl", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        ar = new fp(4, "Dragonhide Cowl", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        as = new fp(1, "Steel Armet", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        at = new fp(2, "Metallic Armet", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        au = new fp(3, "Royal Armet", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        av = new fp(4, "Divine Armet", ItemSlot.HEAD, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aw = new fp(1, "Quilted Mantle", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        ax = new fp(2, "Magical Mantle", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        ay = new fp(3, "Spellweave Mantle", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        az = new fp(4, "Moonweave Mantle", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aA = new fp(1, "Rugged Shoulder", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aB = new fp(2, "Embossed Shoulder", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aC = new fp(3, "Combat Shoulder", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aD = new fp(4, "Dragonhide Shoulder", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aE = new fp(1, "Steel Pauldrons", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aF = new fp(2, "Metallic Pauldrons", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aG = new fp(3, "Royal Pauldrons", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aH = new fp(4, "Divine Pauldrons", ItemSlot.SHOULDER, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aI = new fp(1, "Tattered Cape", ItemSlot.BACK, 0.2f, "", new EquippableRequirement[0]);
        aJ = new fp(2, "Azure Cape", ItemSlot.BACK, 0.2f, "", new EquippableRequirement[0]);
        aK = new fp(3, "Saintly Cape", ItemSlot.BACK, 0.2f, "", new EquippableRequirement[0]);
        aL = new fp(4, "Royal Cape", ItemSlot.BACK, 0.2f, "", new EquippableRequirement[0]);
        aM = new fp(1, "Quilted Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aN = new fp(2, "Magical Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aO = new fp(3, "Spellweave Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aP = new fp(4, "Moonweave Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aQ = new fp(1, "Rugged Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aR = new fp(2, "Embossed Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aS = new fp(3, "Combat Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aT = new fp(4, "Dragonhide Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        aU = new fp(1, "Steel Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aV = new fp(2, "Metallic Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aW = new fp(3, "Royal Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aX = new fp(4, "Divine Bracers", ItemSlot.WRIST, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        aY = new fp(1, "Quilted Mitts", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        aZ = new fp(2, "Magical Mitts", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        ba = new fp(3, "Spellweave Mitts", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bb = new fp(4, "Moonweave Mitts", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bc = new fp(1, "Rugged Gloves", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bd = new fp(2, "Embossed Gloves", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        be = new fp(3, "Combat Gloves", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bf = new fp(4, "Dragonhide Gloves", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bg = new fp(1, "Steel Gauntlets", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bh = new fp(2, "Metallic Gauntlets", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bi = new fp(3, "Royal Gauntlets", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bj = new fp(4, "Divine Gauntlets", ItemSlot.HANDS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bk = new fp(1, "Quilted Robe Bottom", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bl = new fp(2, "Magical Robe Bottom", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bm = new fp(3, "Spellweave Robe Bottom", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bn = new fp(4, "Moonweave Robe Bottom", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bo = new fp(1, "Rugged Leggings", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bp = new fp(2, "Embossed Leggings", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bq = new fp(3, "Combat Leggings", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        br = new fp(4, "Dragonhide Leggings", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bs = new fp(1, "Steel Cuisse", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bt = new fp(2, "Metallic Cuisse", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bu = new fp(3, "Royal Cuisse", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bv = new fp(4, "Divine Cuisse", ItemSlot.LEGS, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bw = new fp(1, "Quilted Cloth Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bx = new fp(2, "Magical Cloth Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        by = new fp(3, "Spellweave Cloth Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bz = new fp(4, "Moonweave Cloth Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.CLOTH));
        bA = new fp(1, "Stitched Leather Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bB = new fp(2, "Embossed Leather Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bC = new fp(3, "Combat Leather Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bD = new fp(4, "Dragonhide Leather Boots", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.LEATHER));
        bE = new fp(1, "Steel Greaves", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bF = new fp(2, "Metallic Greaves", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bG = new fp(3, "Royal Greaves", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bH = new fp(4, "Divine Greaves", ItemSlot.FEET, 0.2f, new ArmorRequirement(ItemArmorType.PLATE));
        bI = new fp(1, "Dragonfire Amulet", ItemSlot.NECK, 0.2f, "", new EquippableRequirement[0]);
        bJ = new fp(2, "Ruby Amulet", ItemSlot.NECK, 0.2f, "", new EquippableRequirement[0]);
        bK = new fp(3, "Sapphire Amulet", ItemSlot.NECK, 0.2f, "", new EquippableRequirement[0]);
        bL = new fp(4, "Opal Amulet", ItemSlot.NECK, 0.2f, "", new EquippableRequirement[0]);
        bM = new fp(1, "Gold Ring", ItemSlot.RING, 0.2f, "", new EquippableRequirement[0]);
        bN = new fp(2, "Ruby Ring", ItemSlot.RING, 0.2f, "", new EquippableRequirement[0]);
        bO = new fp(3, "Sapphire Ring", ItemSlot.RING, 0.2f, "", new EquippableRequirement[0]);
        bP = new fp(4, "Emerald Ring", ItemSlot.RING, 0.2f, "", new EquippableRequirement[0]);
        bQ = new fp(1, "Inscribed Prism", ItemSlot.TRINKET, 0.2f, "", new EquippableRequirement[0]);
        bR = new fp(2, "Aether Relic", ItemSlot.TRINKET, 0.2f, "", new EquippableRequirement[0]);
        bS = new fp(3, "Mammoth Horn", ItemSlot.TRINKET, 0.2f, "", new EquippableRequirement[0]);
        bT = new fp(4, "Gilded Artifact", ItemSlot.TRINKET, 0.2f, "", new EquippableRequirement[0]);
        bU = new fp(1, "Membership Scroll (1 Month)", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        bV = new fp(2, "Membership Scroll (3 Months)", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        bW = new fp(3, "Membership Scroll (1 Year)", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        bX = new fp(1, "Essence of Corruption", ItemSlot.CONSUMABLE, 0.0f, "MISC_ESSENCE_1", new EquippableRequirement[0]);
        bY = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        bZ = new fp(1, "Winner's Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_2", new EquippableRequirement[0]);
        ca = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        cb = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        cc = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        cd = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        ce = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        cf = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        cg = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        ch = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        ci = new fp(1, "Satchel of Treasure", ItemSlot.CONSUMABLE, 0.0f, "MISC_BAG_1", new EquippableRequirement[0]);
        var_fp_arr_a = new fp[]{var_fp_a, var_fp_b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ, ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz, bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ, ca, cb, cc, cd, ce, cf, cg, ch, ci};
    }
}

