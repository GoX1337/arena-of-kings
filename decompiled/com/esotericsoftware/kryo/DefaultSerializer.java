/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface DefaultSerializer {
    public Class<? extends Serializer> value() default Serializer.class;

    public Class<? extends SerializerFactory> serializerFactory() default SerializerFactory.ReflectionSerializerFactory.class;
}

