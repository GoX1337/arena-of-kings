/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import org.java_websocket.WrappedByteChannel;

@Deprecated
public class AbstractWrappedByteChannel
implements WrappedByteChannel {
    private final ByteChannel channel;

    @Deprecated
    public AbstractWrappedByteChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    @Deprecated
    public AbstractWrappedByteChannel(WrappedByteChannel wrappedByteChannel) {
        this.channel = wrappedByteChannel;
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        return this.channel.read(byteBuffer);
    }

    @Override
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override
    public void close() {
        this.channel.close();
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        return this.channel.write(byteBuffer);
    }

    @Override
    public boolean isNeedWrite() {
        return this.channel instanceof WrappedByteChannel && ((WrappedByteChannel)this.channel).isNeedWrite();
    }

    @Override
    public void writeMore() {
        if (this.channel instanceof WrappedByteChannel) {
            ((WrappedByteChannel)this.channel).writeMore();
        }
    }

    @Override
    public boolean isNeedRead() {
        return this.channel instanceof WrappedByteChannel && ((WrappedByteChannel)this.channel).isNeedRead();
    }

    @Override
    public int readMore(ByteBuffer byteBuffer) {
        return this.channel instanceof WrappedByteChannel ? ((WrappedByteChannel)this.channel).readMore(byteBuffer) : 0;
    }

    @Override
    public boolean isBlocking() {
        if (this.channel instanceof SocketChannel) {
            return ((SocketChannel)this.channel).isBlocking();
        }
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel)this.channel).isBlocking();
        }
        return false;
    }
}

