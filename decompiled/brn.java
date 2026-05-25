/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class brn
extends bqb
implements Serializable {
    protected final but a;

    public brn(bqb bqb2, but but2) {
        super(bqb2);
        this.a = but2;
    }

    protected brn(brn brn2, but but2, bee bee2) {
        super((bqb)brn2, bee2);
        this.a = but2;
    }

    @Override
    public brn a(but but2) {
        String string = ((bee)((Object)this.a)).java_lang_String_a();
        String string2 = but2.a(string);
        but2 = but.a(but2, this.a);
        return this.a(but2, new bee(string2));
    }

    protected brn a(but but2, bee bee2) {
        return new brn(this, but2, bee2);
    }

    @Override
    public void void_a(Object object, bcy bcy2, bgo bgo2) {
        Class<?> clazz;
        but but2;
        Object object2 = this.a(object);
        if (object2 == null) {
            return;
        }
        Object object3 = this.a;
        if (object3 == null && (object3 = ((bre)((Object)(but2 = this.a))).a(clazz = object2.getClass())) == null) {
            object3 = this.a((bre)((Object)but2), clazz, bgo2);
        }
        if (this.b != null && (a == this.b ? ((bgb)object3).a(bgo2, object2) : this.b.equals(object2))) {
            return;
        }
        if (object2 == object && this.a(object, bcy2, bgo2, (bgb<?>)object3)) {
            return;
        }
        if (!((bgb)object3).b()) {
            bcy2.void_a((bdi)((Object)this.a));
        }
        if (this.a == null) {
            ((bgb)object3).a(object2, bcy2, bgo2);
        } else {
            ((bgb)object3).a((Object)object2, bcy2, bgo2, (bog)((Object)this.a));
        }
    }

    @Override
    public void a(bgb<Object> bgb2) {
        if (bgb2 != null) {
            but but2 = this.a;
            if (bgb2.b() && bgb2 instanceof bro) {
                but2 = but.a(but2, ((bro)bgb2).a);
            }
            bgb2 = bgb2.a(but2);
        }
        super.a(bgb2);
    }

    @Override
    protected bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
        bgb<Object> bgb2;
        Object object;
        if (this.c != null) {
            object = bgo2.a(this.c, clazz);
            bgb2 = bgo2.a((bfw)object, (bfp)this);
        } else {
            bgb2 = bgo2.a(clazz, (bfp)this);
        }
        object = this.a;
        if (bgb2.b() && bgb2 instanceof bro) {
            object = but.a((but)object, ((bro)bgb2).a);
        }
        bgb2 = bgb2.a((but)object);
        this.a = ((bre)((Object)this.a)).bre_a(clazz, bgb2);
        return bgb2;
    }
}

