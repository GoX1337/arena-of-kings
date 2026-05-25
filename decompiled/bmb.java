/*
 * Decompiled with CFR 0.152.
 */
import java.beans.ConstructorProperties;
import java.beans.Transient;

public class bmb
extends bma {
    private final Class<?> a;

    public bmb() {
        Class clazz = Transient.class;
        clazz = ConstructorProperties.class;
        this.a = clazz;
    }

    @Override
    public Boolean a(bmg bmg2) {
        Transient transient_ = bmg2.a(Transient.class);
        if (transient_ != null) {
            return transient_.value();
        }
        return null;
    }

    @Override
    public Boolean b(bmg bmg2) {
        ConstructorProperties constructorProperties = bmg2.a(ConstructorProperties.class);
        if (constructorProperties != null) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override
    public bgj a(bmr bmr2) {
        ConstructorProperties constructorProperties;
        bms bms2 = bmr2.bms_a();
        if (bms2 != null && (constructorProperties = bms2.a(ConstructorProperties.class)) != null) {
            String[] stringArray = constructorProperties.value();
            int n2 = bmr2.int_a();
            if (n2 < stringArray.length) {
                return bgj.bgj_a(stringArray[n2]);
            }
        }
        return null;
    }
}

