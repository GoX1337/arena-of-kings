/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING;
import com.arenaofkings.packets.misc.Region;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ab {
    private final y var_y_a;
    private final int var_int_a = 5000;
    private final int var_int_b = 25000;
    private final azv var_azv_a;
    private azv var_azv_b;
    private volatile long var_long_a = System.nanoTime();
    private volatile long var_long_b = System.nanoTime();
    private volatile int var_int_c = 0;
    private volatile int d = 0;
    private List<Integer> var_java_util_List_java_lang_Integer__a;
    private final int e = 10;
    private int f = 0;
    private final PUB_GAME_PING var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a;
    private azv var_azv_c;
    private int g = 0;
    private int h = 0;

    public ab(y y2, PUB_GAME_PING pUB_GAME_PING) {
        this.var_y_a = new ArrayList();
        this.var_y_a = y2;
        this.var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a = pUB_GAME_PING;
        this.var_azv_a = new azv(5000L, true);
        this.var_azv_b = new azv(25000L, true);
    }

    public void a(Engine engine) {
        if (this.var_azv_c == null) {
            this.var_azv_c = new azv(300000L, true);
            this.g = (int)this.a("3.80.0.0");
            this.h = (int)this.a("3.64.0.0");
        } else if (this.var_azv_c.boolean_b() && (t.a(aes.class, engine) || t.a(we.class, engine))) {
            this.var_azv_c.void_c();
            this.g = (int)this.a("3.80.0.0");
            this.h = (int)this.a("3.64.0.0");
        }
    }

    public void void_a() {
        if (this.var_y_a != null && this.var_y_a.var_com_esotericsoftware_kryonet_Client_a != null && this.var_azv_a.boolean_b() && this.var_y_a.com_esotericsoftware_kryonet_Connection_a().isConnected()) {
            if (this.var_y_a instanceof y) {
                this.var_y_a.a(new PUB_GAME_PING());
                this.var_azv_b.void_c();
            }
            this.var_azv_a.void_c();
        }
        if (this.var_azv_b.boolean_b()) {
            // empty if block
        }
    }

    public void a(long l2) {
        this.var_long_b = l2;
        System.out.println("Start: " + this.var_long_a);
        System.out.println("End: " + this.var_long_b);
        this.var_int_c = (int)Math.floor(TimeUnit.NANOSECONDS.toMillis(this.var_long_b - this.var_long_a));
        if (this.var_y_a.isEmpty()) {
            for (int i2 = 0; i2 < 10; ++i2) {
                this.var_y_a.add(this.var_int_c);
            }
        }
        this.var_y_a.set(this.f++, this.var_int_c);
        if (this.f == this.var_y_a.size()) {
            this.f = 0;
        }
        this.d = 0;
        Iterator iterator = this.var_y_a.iterator();
        while (iterator.hasNext()) {
            Integer n2 = (Integer)iterator.next();
            this.d += n2.intValue();
        }
        this.d /= this.var_y_a.size();
        System.out.println("Ping: " + this.var_int_c);
    }

    public azv azv_a() {
        return this.var_azv_a;
    }

    public long a(String string) {
        long l2 = System.currentTimeMillis();
        try {
            boolean bl2 = InetAddress.getByName(string).isReachable(999);
            l2 = System.currentTimeMillis() - l2;
            if (bl2) {
                System.out.println("Pinged successfully: " + l2 + "ms");
            } else {
                System.out.println("Ping failed");
            }
        }
        catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (l2 > 999L) {
            l2 = 999L;
        }
        return l2;
    }

    public int int_a() {
        return this.g;
    }

    public int b() {
        return this.h;
    }

    public Region com_arenaofkings_packets_misc_Region_a() {
        if (this.g < this.h) {
            return Region.US_EAST;
        }
        return Region.EU_WEST;
    }
}

