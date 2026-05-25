/*
 * Decompiled with CFR 0.152.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class s {
    protected String a = "";
    protected String b = "";

    public s(String string) {
        this.b = string;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        simpleDateFormat.setTimeZone(timeZone);
        this.a = simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public String toString() {
        return "[" + this.a + "] `" + this.b + "`\n";
    }
}

