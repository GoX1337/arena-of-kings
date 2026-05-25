/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.ClassResolver;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.CuckooObjectMap;
import com.esotericsoftware.kryo.util.IdentityObjectIntMap;
import com.esotericsoftware.kryo.util.IntMap;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;

public class DefaultClassResolver
implements ClassResolver {
    public static final byte NAME = -1;
    protected Kryo kryo;
    protected final IntMap<Registration> idToRegistration = new IntMap();
    protected final CuckooObjectMap<Class, Registration> classToRegistration = new CuckooObjectMap();
    protected IdentityObjectIntMap<Class> classToNameId;
    protected IntMap<Class> nameIdToClass;
    protected ObjectMap<String, Class> nameToClass;
    protected int nextNameId;
    private int memoizedClassId = -1;
    private Registration memoizedClassIdValue;
    private Class memoizedClass;
    private Registration memoizedClassValue;

    @Override
    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override
    public Registration register(Registration registration) {
        this.memoizedClassId = -1;
        this.memoizedClass = null;
        if (registration == null) {
            throw new IllegalArgumentException("registration cannot be null.");
        }
        if (registration.getId() != -1) {
            if (Log.TRACE) {
                Log.trace("kryo", "Register class ID " + registration.getId() + ": " + Util.className(registration.getType()) + " (" + registration.getSerializer().getClass().getName() + ")");
            }
            this.idToRegistration.put(registration.getId(), registration);
        } else if (Log.TRACE) {
            Log.trace("kryo", "Register class name: " + Util.className(registration.getType()) + " (" + registration.getSerializer().getClass().getName() + ")");
        }
        this.classToRegistration.put(registration.getType(), registration);
        Class clazz = Util.getWrapperClass(registration.getType());
        if (clazz != registration.getType()) {
            this.classToRegistration.put(clazz, registration);
        }
        return registration;
    }

    @Override
    public Registration unregister(int n2) {
        Registration registration = this.idToRegistration.remove(n2);
        if (registration != null) {
            this.classToRegistration.remove(registration.getType());
            this.memoizedClassId = -1;
            this.memoizedClass = null;
            Class clazz = Util.getWrapperClass(registration.getType());
            if (clazz != registration.getType()) {
                this.classToRegistration.remove(clazz);
            }
        }
        return registration;
    }

    @Override
    public Registration registerImplicit(Class clazz) {
        return this.register(new Registration(clazz, this.kryo.getDefaultSerializer(clazz), -1));
    }

    @Override
    public Registration getRegistration(Class clazz) {
        if (clazz == this.memoizedClass) {
            return this.memoizedClassValue;
        }
        Registration registration = this.classToRegistration.get(clazz);
        if (registration != null) {
            this.memoizedClass = clazz;
            this.memoizedClassValue = registration;
        }
        return registration;
    }

    @Override
    public Registration getRegistration(int n2) {
        return this.idToRegistration.get(n2);
    }

    @Override
    public Registration writeClass(Output output, Class clazz) {
        if (clazz == null) {
            if (Log.TRACE || Log.DEBUG && this.kryo.getDepth() == 1) {
                Util.log("Write", null, output.position());
            }
            output.writeByte((byte)0);
            return null;
        }
        Registration registration = this.kryo.getRegistration(clazz);
        if (registration.getId() == -1) {
            this.writeName(output, clazz, registration);
        } else {
            if (Log.TRACE) {
                Log.trace("kryo", "Write class " + registration.getId() + ": " + Util.className(clazz) + Util.pos(output.position()));
            }
            output.writeVarInt(registration.getId() + 2, true);
        }
        return registration;
    }

    protected void writeName(Output output, Class clazz, Registration registration) {
        int n2;
        output.writeByte(1);
        if (this.classToNameId != null && (n2 = this.classToNameId.get(clazz, -1)) != -1) {
            if (Log.TRACE) {
                Log.trace("kryo", "Write class name reference " + n2 + ": " + Util.className(clazz) + Util.pos(output.position()));
            }
            output.writeVarInt(n2, true);
            return;
        }
        if (Log.TRACE) {
            Log.trace("kryo", "Write class name: " + Util.className(clazz) + Util.pos(output.position()));
        }
        n2 = this.nextNameId++;
        if (this.classToNameId == null) {
            this.classToNameId = new IdentityObjectIntMap();
        }
        this.classToNameId.put(clazz, n2);
        output.writeVarInt(n2, true);
        if (registration.isTypeNameAscii()) {
            output.writeAscii(clazz.getName());
        } else {
            output.writeString(clazz.getName());
        }
    }

    @Override
    public Registration readClass(Input input) {
        int n2 = input.readVarInt(true);
        switch (n2) {
            case 0: {
                if (Log.TRACE || Log.DEBUG && this.kryo.getDepth() == 1) {
                    Util.log("Read", null, input.position());
                }
                return null;
            }
            case 1: {
                return this.readName(input);
            }
        }
        if (n2 == this.memoizedClassId) {
            if (Log.TRACE) {
                Log.trace("kryo", "Read class " + (n2 - 2) + ": " + Util.className(this.memoizedClassIdValue.getType()) + Util.pos(input.position()));
            }
            return this.memoizedClassIdValue;
        }
        Registration registration = this.idToRegistration.get(n2 - 2);
        if (registration == null) {
            throw new KryoException("Encountered unregistered class ID: " + (n2 - 2));
        }
        if (Log.TRACE) {
            Log.trace("kryo", "Read class " + (n2 - 2) + ": " + Util.className(registration.getType()) + Util.pos(input.position()));
        }
        this.memoizedClassId = n2;
        this.memoizedClassIdValue = registration;
        return registration;
    }

    protected Registration readName(Input input) {
        Class clazz;
        int n2 = input.readVarInt(true);
        if (this.nameIdToClass == null) {
            this.nameIdToClass = new IntMap();
        }
        if ((clazz = this.nameIdToClass.get(n2)) == null) {
            String string = input.readString();
            clazz = this.getTypeByName(string);
            if (clazz == null) {
                try {
                    clazz = Class.forName(string, false, this.kryo.getClassLoader());
                }
                catch (ClassNotFoundException classNotFoundException) {
                    try {
                        clazz = Class.forName(string, false, Kryo.class.getClassLoader());
                    }
                    catch (ClassNotFoundException classNotFoundException2) {
                        throw new KryoException("Unable to find class: " + string, classNotFoundException);
                    }
                }
                if (this.nameToClass == null) {
                    this.nameToClass = new ObjectMap();
                }
                this.nameToClass.put(string, clazz);
            }
            this.nameIdToClass.put(n2, clazz);
            if (Log.TRACE) {
                Log.trace("kryo", "Read class name: " + string + Util.pos(input.position()));
            }
        } else if (Log.TRACE) {
            Log.trace("kryo", "Read class name reference " + n2 + ": " + Util.className(clazz) + Util.pos(input.position()));
        }
        return this.kryo.getRegistration(clazz);
    }

    protected Class getTypeByName(String string) {
        return this.nameToClass != null ? this.nameToClass.get(string) : null;
    }

    @Override
    public void reset() {
        if (!this.kryo.isRegistrationRequired()) {
            if (this.classToNameId != null) {
                this.classToNameId.clear(2048);
            }
            if (this.nameIdToClass != null) {
                this.nameIdToClass.clear();
            }
            this.nextNameId = 0;
        }
    }
}

