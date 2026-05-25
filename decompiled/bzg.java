/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class bzg
implements Serializable,
Logger {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    public String getName() {
        return this.name;
    }

    protected Object readResolve() {
        return LoggerFactory.getLogger(this.getName());
    }
}

