/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.ArrayReflection;

public class ParallelArray {
    Array<Channel> arrays = new Array(false, 2, Channel.class);
    public int capacity;
    public int size;

    public ParallelArray(int n2) {
        this.capacity = n2;
        this.size = 0;
    }

    public <T extends Channel> T addChannel(ChannelDescriptor channelDescriptor) {
        return this.addChannel(channelDescriptor, null);
    }

    public <T extends Channel> T addChannel(ChannelDescriptor channelDescriptor, ChannelInitializer<T> channelInitializer) {
        T t2 = this.getChannel(channelDescriptor);
        if (t2 == null) {
            t2 = this.allocateChannel(channelDescriptor);
            if (channelInitializer != null) {
                channelInitializer.init(t2);
            }
            this.arrays.add((Channel)t2);
        }
        return t2;
    }

    private <T extends Channel> T allocateChannel(ChannelDescriptor channelDescriptor) {
        if (channelDescriptor.type == Float.TYPE) {
            return (T)new FloatChannel(channelDescriptor.id, channelDescriptor.count, this.capacity);
        }
        if (channelDescriptor.type == Integer.TYPE) {
            return (T)new IntChannel(channelDescriptor.id, channelDescriptor.count, this.capacity);
        }
        return (T)new ObjectChannel(channelDescriptor.id, channelDescriptor.count, this.capacity, channelDescriptor.type);
    }

    public <T> void removeArray(int n2) {
        this.arrays.removeIndex(this.findIndex(n2));
    }

    private int findIndex(int n2) {
        for (int i2 = 0; i2 < this.arrays.size; ++i2) {
            Channel channel = ((Channel[])this.arrays.items)[i2];
            if (channel.id != n2) continue;
            return i2;
        }
        return -1;
    }

    public void addElement(Object ... objectArray) {
        if (this.size == this.capacity) {
            throw new GdxRuntimeException("Capacity reached, cannot add other elements");
        }
        int n2 = 0;
        for (Channel channel : this.arrays) {
            channel.add(n2, objectArray);
            n2 += channel.strideSize;
        }
        ++this.size;
    }

    public void removeElement(int n2) {
        int n3 = this.size - 1;
        for (Channel channel : this.arrays) {
            channel.swap(n2, n3);
        }
        this.size = n3;
    }

    public <T extends Channel> T getChannel(ChannelDescriptor channelDescriptor) {
        for (Channel channel : this.arrays) {
            if (channel.id != channelDescriptor.id) continue;
            return (T)channel;
        }
        return null;
    }

    public void clear() {
        this.arrays.clear();
        this.size = 0;
    }

    public void setCapacity(int n2) {
        if (this.capacity != n2) {
            for (Channel channel : this.arrays) {
                channel.setCapacity(n2);
            }
            this.capacity = n2;
        }
    }

    public class ObjectChannel<T>
    extends Channel {
        Class<T> componentType;
        public T[] data;

        public ObjectChannel(int n2, int n3, int n4, Class<T> clazz) {
            super(n2, ArrayReflection.newInstance(clazz, n4 * n3), n3);
            this.componentType = clazz;
            this.data = (Object[])((Channel)this).data;
        }

        @Override
        public void add(int n2, Object ... objectArray) {
            int n3 = this.strideSize * ParallelArray.this.size;
            int n4 = n3 + this.strideSize;
            int n5 = 0;
            while (n3 < n4) {
                this.data[n3] = objectArray[n5];
                ++n3;
                ++n5;
            }
        }

        @Override
        public void swap(int n2, int n3) {
            n2 = this.strideSize * n2;
            n3 = this.strideSize * n3;
            int n4 = n2 + this.strideSize;
            while (n2 < n4) {
                T t2 = this.data[n2];
                this.data[n2] = this.data[n3];
                this.data[n3] = t2;
                ++n2;
                ++n3;
            }
        }

        @Override
        public void setCapacity(int n2) {
            Object[] objectArray = (Object[])ArrayReflection.newInstance(this.componentType, this.strideSize * n2);
            System.arraycopy(this.data, 0, objectArray, 0, Math.min(this.data.length, objectArray.length));
            this.data = objectArray;
            ((Channel)this).data = objectArray;
        }
    }

    public class IntChannel
    extends Channel {
        public int[] data;

        public IntChannel(int n2, int n3, int n4) {
            super(n2, new int[n4 * n3], n3);
            this.data = (int[])((Channel)this).data;
        }

        @Override
        public void add(int n2, Object ... objectArray) {
            int n3 = this.strideSize * ParallelArray.this.size;
            int n4 = n3 + this.strideSize;
            int n5 = 0;
            while (n3 < n4) {
                this.data[n3] = (Integer)objectArray[n5];
                ++n3;
                ++n5;
            }
        }

        @Override
        public void swap(int n2, int n3) {
            n2 = this.strideSize * n2;
            n3 = this.strideSize * n3;
            int n4 = n2 + this.strideSize;
            while (n2 < n4) {
                int n5 = this.data[n2];
                this.data[n2] = this.data[n3];
                this.data[n3] = n5;
                ++n2;
                ++n3;
            }
        }

        @Override
        public void setCapacity(int n2) {
            int[] nArray = new int[this.strideSize * n2];
            System.arraycopy(this.data, 0, nArray, 0, Math.min(this.data.length, nArray.length));
            this.data = nArray;
            ((Channel)this).data = nArray;
        }
    }

    public class FloatChannel
    extends Channel {
        public float[] data;

        public FloatChannel(int n2, int n3, int n4) {
            super(n2, new float[n4 * n3], n3);
            this.data = (float[])((Channel)this).data;
        }

        @Override
        public void add(int n2, Object ... objectArray) {
            int n3 = this.strideSize * ParallelArray.this.size;
            int n4 = n3 + this.strideSize;
            int n5 = 0;
            while (n3 < n4) {
                this.data[n3] = ((Float)objectArray[n5]).floatValue();
                ++n3;
                ++n5;
            }
        }

        @Override
        public void swap(int n2, int n3) {
            n2 = this.strideSize * n2;
            n3 = this.strideSize * n3;
            int n4 = n2 + this.strideSize;
            while (n2 < n4) {
                float f2 = this.data[n2];
                this.data[n2] = this.data[n3];
                this.data[n3] = f2;
                ++n2;
                ++n3;
            }
        }

        @Override
        public void setCapacity(int n2) {
            float[] fArray = new float[this.strideSize * n2];
            System.arraycopy(this.data, 0, fArray, 0, Math.min(this.data.length, fArray.length));
            this.data = fArray;
            ((Channel)this).data = fArray;
        }
    }

    public static interface ChannelInitializer<T extends Channel> {
        public void init(T var1);
    }

    public abstract class Channel {
        public int id;
        public Object data;
        public int strideSize;

        public Channel(int n2, Object object, int n3) {
            this.id = n2;
            this.strideSize = n3;
            this.data = object;
        }

        public abstract void add(int var1, Object ... var2);

        public abstract void swap(int var1, int var2);

        protected abstract void setCapacity(int var1);
    }

    public static class ChannelDescriptor {
        public int id;
        public Class<?> type;
        public int count;

        public ChannelDescriptor(int n2, Class<?> clazz, int n3) {
            this.id = n2;
            this.type = clazz;
            this.count = n3;
        }
    }
}

