/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bgr {
    public Class<? extends bfx> a() default bfx.a.class;

    public Class<? extends bfx> b() default bfx.a.class;

    public Class<? extends bgc> c() default bgc.a.class;

    public Class<?> d() default Void.class;

    public Class<? extends bum> e() default bum.a.class;

    public Class<? extends bum> f() default bum.a.class;

    public Class<?> g() default Void.class;

    public Class<?> h() default Void.class;

    public Class<?> i() default Void.class;
}

