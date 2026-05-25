/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class bfs
extends bfq
implements Serializable {
    protected final bih var_bih_a;
    protected final bii var_bii_a;
    protected final bfr var_bfr_a;
    protected final int var_int_a;
    protected final bfd<bdj> var_bfd_bdj__a;
    protected final Class<?> var_java_lang_Class____a;
    protected transient bdc var_bdc_a;
    protected final bfv var_bfv_a;
    protected transient bue var_bue_a;
    protected transient buy var_buy_a;
    protected transient DateFormat var_java_text_DateFormat_a;
    protected transient bhj var_bhj_a;
    protected bur<bfw> var_bur_bfw__a;

    protected bfs(bii bii2, bih bih2) {
        if (bii2 == null) {
            throw new NullPointerException("Cannot pass null DeserializerFactory");
        }
        this.var_bii_a = bii2;
        if (bih2 == null) {
            bih2 = new bih();
        }
        this.var_bih_a = bih2;
        this.var_int_a = 0;
        this.var_bih_a = null;
        this.var_bfr_a = null;
        this.var_bfv_a = null;
        this.var_bih_a = null;
        this.var_bhj_a = null;
    }

    protected bfs(bfs bfs2, bfr bfr2, bdc bdc2, bfv bfv2) {
        this.var_bih_a = bfs2.var_bih_a;
        this.var_bii_a = bfs2.var_bii_a;
        this.var_bih_a = bdc2 == null ? null : bdc2.java_lang_Object_a();
        this.var_bfr_a = bfr2;
        this.var_int_a = bfr2.int_a();
        this.var_bih_a = bfr2.a();
        this.var_bdc_a = bdc2;
        this.var_bfv_a = bfv2;
        this.var_bhj_a = bfr2.bhj_a();
    }

    protected bfs(bfs bfs2, bfr bfr2) {
        this.var_bih_a = bfs2.var_bih_a;
        this.var_bii_a = bfs2.var_bii_a;
        this.var_bih_a = null;
        this.var_bfr_a = bfr2;
        this.var_int_a = bfr2.int_a();
        this.var_bih_a = null;
        this.var_bdc_a = null;
        this.var_bfv_a = null;
        this.var_bhj_a = null;
    }

    public bfr bfr_a() {
        return this.var_bfr_a;
    }

    public final Class<?> a() {
        return this.var_bih_a;
    }

    public final boolean boolean_a() {
        return this.var_bfr_a.c();
    }

    public final boolean a(bgd bgd2) {
        return this.var_bfr_a.a(bgd2);
    }

    public final bbk.d bbk$d_a(Class<?> clazz) {
        return this.var_bfr_a.bbk$d_a(clazz);
    }

    public final bfn bfn_a() {
        return this.var_bfr_a.bfn_a();
    }

    @Override
    public final btz btz_a() {
        return this.var_bfr_a.btz_a();
    }

    public bfw a(bfw bfw2, Class<?> clazz) {
        if (bfw2.boolean_a(clazz)) {
            return bfw2;
        }
        return this.bfr_a().btz_a().a(bfw2, clazz, false);
    }

    public Locale java_util_Locale_a() {
        return this.var_bfr_a.java_util_Locale_a();
    }

    public TimeZone java_util_TimeZone_a() {
        return this.var_bfr_a.java_util_TimeZone_a();
    }

    public final boolean a(bfu bfu2) {
        return (this.var_int_a & bfu2.int_a()) != 0;
    }

    public final boolean a(bdj bdj2) {
        return ((bfd)((Object)this.var_bih_a)).a(bdj2);
    }

    public final int int_a() {
        return this.var_int_a;
    }

    public final boolean a(int n2) {
        return (this.var_int_a & n2) != 0;
    }

    public final bdc bdc_a() {
        return this.var_bdc_a;
    }

    public final Object a(Object object, bfp bfp2, Object object2) {
        if (this.var_bfv_a == null) {
            this.a(buk.a(object), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", object));
        }
        return this.var_bfv_a.a(object, this, bfp2, object2);
    }

    public final bcq bcq_a() {
        return this.var_bfr_a.bcq_a();
    }

    public final bpo bpo_a() {
        return this.var_bfr_a.bpo_a();
    }

    public bha a(btq btq2, Class<?> clazz, bhe bhe2) {
        return this.var_bfr_a.a(btq2, clazz, bhe2);
    }

    public bha a(btq btq2, Class<?> clazz, bha bha2) {
        return this.var_bfr_a.a(btq2, clazz, bha2);
    }

    public final bfx<Object> a(bfw bfw2, bfp bfp2) {
        bfx<Object> bfx2 = this.var_bih_a.a(this, this.var_bii_a, bfw2);
        if (bfx2 != null) {
            bfx2 = this.b(bfx2, bfp2, bfw2);
        }
        return bfx2;
    }

    public final bfx<Object> a(bfw bfw2) {
        return this.var_bih_a.a(this, this.var_bii_a, bfw2);
    }

    public final bfx<Object> b(bfw bfw2) {
        bfx<Object> bfx2 = this.var_bih_a.a(this, this.var_bii_a, bfw2);
        if (bfx2 == null) {
            return null;
        }
        bfx2 = this.b(bfx2, null, bfw2);
        boc boc2 = this.var_bii_a.boc_a(this.var_bfr_a, bfw2);
        if (boc2 != null) {
            boc2 = boc2.a(null);
            return new bju(boc2, bfx2);
        }
        return bfx2;
    }

    public final bgc a(bfw bfw2, bfp bfp2) {
        bgc bgc2 = this.var_bih_a.a(this, this.var_bii_a, bfw2);
        if (bgc2 instanceof bic) {
            bgc2 = ((bic)((Object)bgc2)).a(this, bfp2);
        }
        return bgc2;
    }

    public abstract bjs a(Object var1, bck<?> var2, bcm var3);

    public final bfw bfw_a(Class<?> clazz) {
        return clazz == null ? null : this.var_bfr_a.bfw_a(clazz);
    }

    public Class<?> a(String string) {
        return this.btz_a().a(string);
    }

    public final buy buy_a() {
        buy buy2 = this.var_buy_a;
        if (buy2 == null) {
            buy2 = new buy();
        } else {
            this.var_buy_a = null;
        }
        return buy2;
    }

    public final void a(buy buy2) {
        if (this.var_buy_a == null || buy2.int_a() >= this.var_buy_a.int_a()) {
            this.var_buy_a = buy2;
        }
    }

    public final bue bue_a() {
        if (this.var_bue_a == null) {
            this.var_bue_a = new bue();
        }
        return this.var_bue_a;
    }

    public abstract bfx<Object> a(bmg var1, Object var2);

    public abstract bgc a(bmg var1, Object var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bfx<?> a(bfx<?> bfx2, bfp bfp2, bfw bfw2) {
        if (bfx2 instanceof bib) {
            this.var_bih_a = new bur<bfw>(bfw2, (bur<bfw>)((Object)this.var_bih_a));
            try {
                bfx2 = ((bib)((Object)bfx2)).a(this, bfp2);
            }
            finally {
                this.var_bih_a = ((bur)((Object)this.var_bih_a)).a();
            }
        }
        return bfx2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bfx<?> b(bfx<?> bfx2, bfp bfp2, bfw bfw2) {
        if (bfx2 instanceof bib) {
            this.var_bih_a = new bur<bfw>(bfw2, (bur<bfw>)((Object)this.var_bih_a));
            try {
                bfx2 = ((bib)((Object)bfx2)).a(this, bfp2);
            }
            finally {
                this.var_bih_a = ((bur)((Object)this.var_bih_a)).a();
            }
        }
        return bfx2;
    }

    public Date java_util_Date_a(String string) {
        try {
            DateFormat dateFormat = this.java_text_DateFormat_a();
            return dateFormat.parse(string);
        }
        catch (ParseException parseException) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", string, buk.java_lang_String_a(parseException)));
        }
    }

    public Calendar a(Date date) {
        Calendar calendar = Calendar.getInstance(this.java_util_TimeZone_a());
        calendar.setTime(date);
        return calendar;
    }

    public String a(bdc bdc2, bfx<?> bfx2, Class<?> clazz) {
        return (String)this.a(clazz, bdc2);
    }

    public boolean a(bdc bdc2, bfx<?> bfx2, Object object, String string) {
        for (Object object2 = this.var_bfr_a.a(); object2 != null; object2 = ((bur)object2).a()) {
            if (!((bur)object2).a().a(this, bdc2, bfx2, object, string)) continue;
            return true;
        }
        if (!this.a(bfu.e)) {
            bdc2.bdc_a();
            return true;
        }
        Collection<Object> collection = bfx2 == null ? null : (Collection<Object>)bfx2.a();
        throw blw.a(this.var_bdc_a, object, string, collection);
    }

    public Object a(Class<?> clazz, String string, String string2, Object ... objectArray) {
        string2 = this.java_lang_String_a(string2, objectArray);
        for (Object object = this.var_bfr_a.a(); object != null; object = ((bur)object).a()) {
            Object object2 = ((bur)object).a().a(this, clazz, string, string2);
            if (object2 == big.a) continue;
            if (object2 == null || clazz.isInstance(object2)) {
                return object2;
            }
            throw this.a(string, clazz, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", buk.b(clazz), buk.b(object2)));
        }
        throw this.a(clazz, string, string2);
    }

    public Object b(Class<?> clazz, String string, String string2, Object ... objectArray) {
        string2 = this.java_lang_String_a(string2, objectArray);
        for (Object object = this.var_bfr_a.a(); object != null; object = ((bur)object).a()) {
            Object object2 = ((bur)object).a().b(this, clazz, string, string2);
            if (object2 == big.a) continue;
            if (this.a(clazz, object2)) {
                return object2;
            }
            throw this.a(string, clazz, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", buk.b(clazz), buk.b(object2)));
        }
        throw this.a(string, clazz, string2);
    }

    public Object a(Class<?> clazz, Number number, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        for (Object object = this.var_bfr_a.a(); object != null; object = ((bur)object).a()) {
            Object object2 = ((bur)object).a().a(this, clazz, number, string);
            if (object2 == big.a) continue;
            if (this.a(clazz, object2)) {
                return object2;
            }
            throw this.a(number, clazz, this.java_lang_String_a("DeserializationProblemHandler.handleWeirdNumberValue() for type %s returned value of type %s", buk.b(clazz), buk.b(object2)));
        }
        throw this.a(number, clazz, string);
    }

    public Object a(bfw bfw2, Object object, bdc bdc2) {
        Object t2 = bfw2.a();
        for (Object object2 = this.var_bfr_a.a(); object2 != null; object2 = ((bur)object2).a()) {
            Object object3 = ((bur)object2).a().a(this, bfw2, object, bdc2);
            if (object3 == big.a) continue;
            if (object3 == null || ((Class)t2).isInstance(object3)) {
                return object3;
            }
            throw bfy.a(bdc2, this.java_lang_String_a("DeserializationProblemHandler.handleWeirdNativeValue() for type %s returned value of type %s", buk.b(bfw2), buk.b(object3)));
        }
        throw this.a(object, (Class<?>)t2);
    }

    public Object a(Class<?> clazz, bir bir2, bdc bdc2, String string, Object ... objectArray) {
        if (bdc2 == null) {
            bdc2 = this.bdc_a();
        }
        string = this.java_lang_String_a(string, objectArray);
        for (Object object = this.var_bfr_a.a(); object != null; object = ((bur)object).a()) {
            Object object2 = ((bur)object).a().a(this, clazz, bir2, bdc2, string);
            if (object2 == big.a) continue;
            if (this.a(clazz, object2)) {
                return object2;
            }
            this.b(this.bfw_a(clazz), String.format("DeserializationProblemHandler.handleMissingInstantiator() for type %s returned value of type %s", buk.b(clazz), buk.b(object2)));
        }
        if (bir2 == null) {
            string = String.format("Cannot construct instance of %s: %s", buk.java_lang_String_b(clazz), string);
            return this.a(clazz, string);
        }
        if (!bir2.boolean_a()) {
            string = String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", buk.java_lang_String_b(clazz), string);
            return this.a(clazz, string);
        }
        string = String.format("Cannot construct instance of %s (although at least one Creator exists): %s", buk.java_lang_String_b(clazz), string);
        return this.a(clazz, string, new Object[0]);
    }

    public Object a(Class<?> clazz, Object object, Throwable throwable) {
        for (Object object2 = this.var_bfr_a.a(); object2 != null; object2 = ((bur)object2).a()) {
            Object object3 = ((bur)object2).a().a(this, clazz, object, throwable);
            if (object3 == big.a) continue;
            if (this.a(clazz, object3)) {
                return object3;
            }
            this.b(this.bfw_a(clazz), String.format("DeserializationProblemHandler.handleInstantiationProblem() for type %s returned value of type %s", buk.b(clazz), buk.c(object3)));
        }
        buk.c(throwable);
        if (!this.a(bfu.p)) {
            buk.java_lang_Throwable_b(throwable);
        }
        throw this.a(clazz, throwable);
    }

    public Object a(Class<?> clazz, bdc bdc2) {
        return this.a(this.bfw_a(clazz), bdc2.bdf_c(), bdc2, null, new Object[0]);
    }

    public Object a(Class<?> clazz, bdf bdf2, bdc bdc2, String string, Object ... objectArray) {
        return this.a(this.bfw_a(clazz), bdf2, bdc2, string, objectArray);
    }

    public Object a(bfw bfw2, bdc bdc2) {
        return this.a(bfw2, bdc2.bdf_c(), bdc2, null, new Object[0]);
    }

    public Object a(bfw bfw2, bdf bdf2, bdc bdc2, String string, Object ... objectArray) {
        Object object;
        string = this.java_lang_String_a(string, objectArray);
        for (Object object2 = this.var_bfr_a.a(); object2 != null; object2 = ((bur)object2).a()) {
            object = ((bur)object2).a().a(this, bfw2, bdf2, bdc2, string);
            if (object == big.a) continue;
            if (this.a((Class<?>)bfw2.a(), object)) {
                return object;
            }
            this.b(bfw2, String.format("DeserializationProblemHandler.handleUnexpectedToken() for type %s returned value of type %s", buk.a(bfw2), buk.c(object)));
        }
        if (string == null) {
            object = buk.a(bfw2);
            string = bdf2 == null ? String.format("Unexpected end-of-input when trying read value of type %s", object) : String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", new Object[]{object, this.a(bdf2), bdf2});
        }
        if (bdf2 != null && bdf2.d()) {
            bdc2.java_lang_String_e();
        }
        this.a(bfw2, string, new Object[0]);
        return null;
    }

    public bfw a(bfw bfw2, String string, boe boe2, String string2) {
        for (Object object = this.var_bfr_a.a(); object != null; object = ((bur)object).a()) {
            bfw bfw3 = ((bur)object).a().a(this, bfw2, string, boe2, string2);
            if (bfw3 == null) continue;
            if (bfw3.boolean_a(Void.class)) {
                return null;
            }
            if (bfw3.b((Class<?>)bfw2.a())) {
                return bfw3;
            }
            throw this.a(bfw2, string, "problem handler tried to resolve into non-subtype: " + buk.a(bfw3));
        }
        if (!this.a(bfu.h)) {
            return null;
        }
        throw this.a(bfw2, string, string2);
    }

    public bfw a(bfw bfw2, boe boe2, String string) {
        for (Object object = this.var_bfr_a.a(); object != null; object = ((bur)object).a()) {
            bfw bfw3 = ((bur)object).a().a(this, bfw2, boe2, string);
            if (bfw3 == null) continue;
            if (bfw3.boolean_a(Void.class)) {
                return null;
            }
            if (bfw3.b((Class<?>)bfw2.a())) {
                return bfw3;
            }
            throw this.a(bfw2, (String)null, "problem handler tried to resolve into non-subtype: " + buk.a(bfw3));
        }
        throw this.a(bfw2, string);
    }

    public void a(bfx<?> bfx2) {
        if (!this.a(bgd.D)) {
            bfw bfw2 = this.bfw_a((Class<?>)bfx2.a());
            String string = String.format("Invalid configuration: values of type %s cannot be merged", buk.a(bfw2));
            throw blq.a(this.bdc_a(), string, bfw2);
        }
    }

    protected boolean a(Class<?> clazz, Object object) {
        if (object == null || clazz.isInstance(object)) {
            return true;
        }
        return clazz.isPrimitive() && buk.b(clazz).isInstance(object);
    }

    public void a(bfx<?> bfx2, bdf bdf2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw this.a(this.bdc_a(), (Class<?>)bfx2.a(), bdf2, string);
    }

    public void a(bfw bfw2, bdf bdf2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw this.a(this.bdc_a(), bfw2, bdf2, string);
    }

    public void a(Class<?> clazz, bdf bdf2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw this.a(this.bdc_a(), clazz, bdf2, string);
    }

    public <T> T a(bjl bjl2, Object object) {
        String string = String.format("No Object Id found for an instance of %s, to assign to property '%s'", buk.c(object), bjl2.var_bgj_a);
        return this.a(bjl2.var_bio_a, string, new Object[0]);
    }

    public <T> T a(bfx<?> bfx2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw blu.a(this.bdc_a(), bfx2.a(), string);
    }

    public <T> T a(Class<?> clazz, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw blu.a(this.bdc_a(), clazz, string);
    }

    public <T> T a(bfw bfw2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw blu.a(this.bdc_a(), bfw2, string);
    }

    public <T> T a(bfp bfp2, String string, Object ... objectArray) {
        bmn bmn2;
        string = this.java_lang_String_a(string, objectArray);
        bfw bfw2 = bfp2 == null ? null : bfp2.bfw_a();
        blu blu2 = blu.a(this.bdc_a(), bfw2, string);
        if (bfp2 != null && (bmn2 = bfp2.bmn_a()) != null) {
            blu2.a(bmn2.b(), bfp2.java_lang_String_a());
        }
        throw blu2;
    }

    public <T> T c(Class<?> clazz, String string, String string2, Object ... objectArray) {
        string2 = this.java_lang_String_a(string2, objectArray);
        blu blu2 = blu.a(this.bdc_a(), clazz, string2);
        if (string != null) {
            blu2.a(clazz, string);
        }
        throw blu2;
    }

    public <T> T a(bfw bfw2, String string, String string2, Object ... objectArray) {
        return this.c((Class<?>)bfw2.a(), string, string2, objectArray);
    }

    public <T> T a(bfx<?> bfx2, Class<?> clazz, Object object, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        blr blr2 = blr.a(this.bdc_a(), string, object, clazz);
        throw blr2;
    }

    public <T> T a(Class<?> clazz, bdc bdc2, bdf bdf2) {
        throw blu.a(bdc2, clazz, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", new Object[]{bdf2, buk.java_lang_String_b(clazz)}));
    }

    public <T> T a(bfo bfo2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        String string2 = buk.java_lang_String_b(bfo2.a());
        string = String.format("Invalid type definition for type %s: %s", string2, string);
        throw blq.a(this.var_bdc_a, string, bfo2, null);
    }

    public <T> T a(bfo bfo2, bmx bmx2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        String string2 = buk.a(bmx2);
        String string3 = buk.java_lang_String_b(bfo2.a());
        string = String.format("Invalid definition for property %s (of type %s): %s", string2, string3, string);
        throw blq.a(this.var_bdc_a, string, bfo2, bmx2);
    }

    @Override
    public <T> T b(bfw bfw2, String string) {
        throw blq.a(this.var_bdc_a, string, bfw2);
    }

    public bfy a(bdc bdc2, bfw bfw2, bdf bdf2, String string) {
        String string2 = String.format("Unexpected token (%s), expected %s", new Object[]{bdc2.bdf_c(), bdf2});
        string2 = this.a(string2, string);
        return blu.a(bdc2, bfw2, string2);
    }

    public bfy a(bdc bdc2, Class<?> clazz, bdf bdf2, String string) {
        String string2 = String.format("Unexpected token (%s), expected %s", new Object[]{bdc2.bdf_c(), bdf2});
        string2 = this.a(string2, string);
        return blu.a(bdc2, clazz, string2);
    }

    public bfy a(Class<?> clazz, String string, String string2) {
        return blr.a(this.var_bdc_a, String.format("Cannot deserialize Map key of type %s from String %s: %s", buk.java_lang_String_b(clazz), this.b(string), string2), string, clazz);
    }

    public bfy a(String string, Class<?> clazz, String string2) {
        String string3 = String.format("Cannot deserialize value of type %s from String %s: %s", buk.java_lang_String_b(clazz), this.b(string), string2);
        return blr.a(this.var_bdc_a, string3, string, clazz);
    }

    public bfy a(Number number, Class<?> clazz, String string) {
        return blr.a(this.var_bdc_a, String.format("Cannot deserialize value of type %s from number %s: %s", buk.java_lang_String_b(clazz), String.valueOf(number), string), number, clazz);
    }

    public bfy a(Object object, Class<?> clazz) {
        return blr.a(this.var_bdc_a, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", buk.java_lang_String_b(clazz), buk.c(object)), object, clazz);
    }

    public bfy a(Class<?> clazz, Throwable throwable) {
        String string;
        if (throwable == null) {
            string = "N/A";
        } else {
            string = buk.java_lang_String_a(throwable);
            if (string == null) {
                string = buk.java_lang_String_b(throwable.getClass());
            }
        }
        String string2 = String.format("Cannot construct instance of %s, problem: %s", buk.java_lang_String_b(clazz), string);
        return blx.a(this.var_bdc_a, string2, this.bfw_a(clazz), throwable);
    }

    @Override
    public bfy a(bfw bfw2, String string, String string2) {
        String string3 = String.format("Could not resolve type id '%s' as a subtype of %s", string, buk.a(bfw2));
        return blt.a(this.var_bdc_a, this.a(string3, string2), bfw2, string);
    }

    public bfy a(bfw bfw2, String string) {
        String string2 = String.format("Could not resolve subtype of %s", bfw2);
        return blt.a(this.var_bdc_a, this.a(string2, string), bfw2, null);
    }

    protected DateFormat java_text_DateFormat_a() {
        if (this.var_java_text_DateFormat_a != null) {
            return this.var_java_text_DateFormat_a;
        }
        DateFormat dateFormat = this.var_bfr_a.java_text_DateFormat_a();
        this.var_java_text_DateFormat_a = dateFormat = (DateFormat)dateFormat.clone();
        return dateFormat;
    }

    protected String a(bdf bdf2) {
        if (bdf2 != null) {
            switch (bdf2) {
                case var_bdf_b: 
                case var_bdf_c: 
                case f: {
                    return "Object value";
                }
                case var_bdf_d: 
                case var_bdf_e: {
                    return "Array value";
                }
                case l: 
                case k: {
                    return "Boolean value";
                }
                case g: {
                    return "Embedded Object";
                }
                case j: {
                    return "Floating-point value";
                }
                case i: {
                    return "Integer value";
                }
                case h: {
                    return "String value";
                }
                case m: {
                    return "Null value";
                }
            }
            return "[Unavailable value]";
        }
        return "<end of input>";
    }
}

