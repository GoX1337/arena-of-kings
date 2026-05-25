/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;

public class bcw
extends bdl
implements Serializable {
    protected static final int var_int_a;
    protected static final int var_int_b;
    protected static final int c;
    public static final bdi var_bdi_a;
    protected final transient bes var_bes_a = bes.bes_a();
    protected final transient ber var_ber_a = ber.ber_a();
    protected int d = var_int_a;
    protected int e = var_int_b;
    protected int f = c;
    protected bdg var_bdg_a;
    protected bdu var_bdu_a;
    protected bdw var_bdw_a;
    protected bec var_bec_a;
    protected bdi var_bdi_b = var_bdi_a;
    protected int g;
    protected final char var_char_a;

    public bcw() {
        this(null);
    }

    public bcw(bdg bdg2) {
        this.var_bdg_a = bdg2;
        this.var_char_a = (char)34;
    }

    public boolean boolean_a() {
        return false;
    }

    public String java_lang_String_a() {
        if (this.getClass() == bcw.class) {
            return "JSON";
        }
        return null;
    }

    public bcw a(bdg bdg2) {
        this.var_bdg_a = bdg2;
        return this;
    }

    public bdg bdg_a() {
        return this.var_bdg_a;
    }

    public bdc a(File file) {
        bdv bdv2 = this.a((Object)file, true);
        FileInputStream fileInputStream = new FileInputStream(file);
        return this.bdc_a(this.java_io_InputStream_a(fileInputStream, bdv2), bdv2);
    }

    public bcy a(Writer writer) {
        bdv bdv2 = this.a((Object)writer, false);
        return this.bcy_a(this.java_io_Writer_a(writer, bdv2), bdv2);
    }

    public bcy a(File file, bcv bcv2) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bdv bdv2 = this.a((Object)fileOutputStream, true);
        bdv2.a(bcv2);
        if (bcv2 == bcv.var_bcv_a) {
            return this.bcy_a(this.java_io_OutputStream_a(fileOutputStream, bdv2), bdv2);
        }
        Writer writer = this.a(fileOutputStream, bcv2, bdv2);
        return this.bcy_a(this.java_io_Writer_a(writer, bdv2), bdv2);
    }

    protected bdc bdc_a(InputStream inputStream, bdv bdv2) {
        return new beh(bdv2, inputStream).a(this.e, this.var_bdg_a, this.var_ber_a, this.var_bes_a, this.d);
    }

    protected bcy bcy_a(Writer writer, bdv bdv2) {
        bdi bdi2;
        beq beq2 = new beq(bdv2, this.f, this.var_bdg_a, writer, this.var_char_a);
        if (this.g > 0) {
            beq2.bcy_b(this.g);
        }
        if (this.var_bdu_a != null) {
            beq2.a(this.var_bdu_a);
        }
        if ((bdi2 = this.var_bdi_b) != var_bdi_a) {
            beq2.bcy_a(bdi2);
        }
        return beq2;
    }

    protected bcy bcy_a(OutputStream outputStream, bdv bdv2) {
        bdi bdi2;
        beo beo2 = new beo(bdv2, this.f, this.var_bdg_a, outputStream, this.var_char_a);
        if (this.g > 0) {
            beo2.bcy_b(this.g);
        }
        if (this.var_bdu_a != null) {
            beo2.a(this.var_bdu_a);
        }
        if ((bdi2 = this.var_bdi_b) != var_bdi_a) {
            beo2.bcy_a(bdi2);
        }
        return beo2;
    }

    protected Writer a(OutputStream outputStream, bcv bcv2, bdv bdv2) {
        if (bcv2 == bcv.var_bcv_a) {
            return new beg(bdv2, outputStream);
        }
        return new OutputStreamWriter(outputStream, bcv2.java_lang_String_a());
    }

    protected final InputStream java_io_InputStream_a(InputStream inputStream, bdv bdv2) {
        InputStream inputStream2;
        if (this.var_bdw_a != null && (inputStream2 = this.var_bdw_a.a(bdv2, inputStream)) != null) {
            return inputStream2;
        }
        return inputStream;
    }

    protected final OutputStream java_io_OutputStream_a(OutputStream outputStream, bdv bdv2) {
        OutputStream outputStream2;
        if (this.var_bec_a != null && (outputStream2 = this.var_bec_a.a(bdv2, outputStream)) != null) {
            return outputStream2;
        }
        return outputStream;
    }

    protected final Writer java_io_Writer_a(Writer writer, bdv bdv2) {
        Writer writer2;
        if (this.var_bec_a != null && (writer2 = this.var_bec_a.a(bdv2, writer)) != null) {
            return writer2;
        }
        return writer;
    }

    public bev bev_a() {
        if (bcw$a.d.a(this.d)) {
            return bew.a();
        }
        return new bev();
    }

    protected bdv a(Object object, boolean bl2) {
        return new bdv(this.bev_a(), object, bl2);
    }

    static {
        var_int_a = bcw$a.int_a();
        var_int_b = bdc.a.int_a();
        c = bcy.a.int_a();
        var_bdi_a = bez.var_bee_b;
    }

    public static final class a
    extends Enum<a>
    implements bfc {
        public static final /* enum */ a var_bcw$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        private final boolean var_boolean_a;
        private static final /* synthetic */ a[] var_bcw$a_arr_a;

        public static a[] values() {
            return (a[])var_bcw$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        public static int int_a() {
            int n2 = 0;
            for (a a2 : bcw$a.values()) {
                if (!a2.boolean_a()) continue;
                n2 |= a2.b();
            }
            return n2;
        }

        private a(boolean bl2) {
            this.var_boolean_a = bl2;
        }

        @Override
        public boolean boolean_a() {
            return this.var_boolean_a;
        }

        public boolean a(int n2) {
            return (n2 & this.b()) != 0;
        }

        @Override
        public int b() {
            return 1 << this.ordinal();
        }

        static {
            var_bcw$a_a = new a(true);
            b = new a(true);
            c = new a(true);
            d = new a(true);
            var_bcw$a_arr_a = new a[]{var_bcw$a_a, b, c, d};
        }
    }
}

