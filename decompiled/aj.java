/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class aj {
    private Map<ai, String> cfr_renamed_9 = new TreeMap<ai, String>();
    private Map<ak, String> b = new TreeMap<ak, String>();
    private bgf var_bgf_a = new bgf();

    public aj() {
        this.var_bgf_a.a(bco.d, bbe.b.var_bbe$b_a);
        this.d();
        this.a();
    }

    private void d() {
        for (ai enum_ : ai.values()) {
            this.cfr_renamed_9.put(enum_, enum_.a());
        }
        for (Enum enum_ : ak.values()) {
            this.b.put((ak)enum_, ((ak)enum_).a());
        }
    }

    public void a() {
        this.b();
        this.c();
    }

    public void b() {
        Map map = null;
        try {
            map = this.var_bgf_a.a(Paths.get("options.json", new String[0]).toFile(), TreeMap.class);
        }
        catch (bdb bdb2) {
            bdb2.printStackTrace();
        }
        catch (bfy bfy2) {
            bfy2.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("FILE NOT FOUND.");
            this.c();
        }
        catch (IOException iOException) {
            System.out.println("E caught");
            iOException.printStackTrace();
        }
        if (map != null) {
            for (Map.Entry object : map.entrySet()) {
                this.cfr_renamed_9.put(ai.valueOf((String)object.getKey()), (String)object.getValue());
            }
        }
        Object object = null;
        try {
            object = this.var_bgf_a.a(Paths.get("user.json", new String[0]).toFile(), TreeMap.class);
        }
        catch (bdb bdb3) {
            bdb3.printStackTrace();
        }
        catch (bfy bfy3) {
            bfy3.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("FILE NOT FOUND.");
            this.c();
        }
        catch (IOException iOException) {
            System.out.println("E caught");
            iOException.printStackTrace();
        }
        if (object != null) {
            for (Map.Entry entry : object.entrySet()) {
                this.b.put(ak.valueOf((String)entry.getKey()), (String)entry.getValue());
            }
        }
    }

    public void c() {
        try {
            this.var_bgf_a.bgh_b().a(Paths.get("options.json", new String[0]).toFile(), this.cfr_renamed_9);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            Engine.b("Failed to save options");
        }
        try {
            this.var_bgf_a.bgh_b().a(Paths.get("user.json", new String[0]).toFile(), this.b);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            Engine.b("Failed to save user");
        }
    }

    public void a(ai ai2, String string) {
        this.cfr_renamed_9.put(ai2, string);
        this.c();
    }

    public boolean boolean_a(ai ai2) {
        return Boolean.valueOf(this.cfr_renamed_9.get((Object)ai2));
    }

    public int int_a(ai ai2) {
        return Integer.valueOf(this.cfr_renamed_9.get((Object)ai2));
    }

    public String java_lang_String_a(ai ai2) {
        return this.cfr_renamed_9.get((Object)ai2);
    }

    public void a(ak ak2, String string) {
        this.b.put(ak2, string);
        this.c();
    }

    public boolean boolean_a(ak ak2) {
        return Boolean.valueOf(this.b.get((Object)ak2));
    }

    public String java_lang_String_a(ak ak2) {
        return this.b.get((Object)ak2);
    }
}

