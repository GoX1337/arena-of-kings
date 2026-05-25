/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q {
    public List<s> a = Collections.synchronizedList(new ArrayList(100));

    public void a(String string) {
        if (this.a.size() == 100) {
            this.a.remove(0);
        }
        this.b(string);
    }

    private void b(String string) {
        s s2 = new s(string);
        this.a.add(s2);
        Engine.a(s2.toString());
    }

    public List<s> a() {
        return this.a;
    }
}

