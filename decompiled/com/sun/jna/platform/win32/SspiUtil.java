/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.platform.win32.Sspi;

public class SspiUtil {

    public static class ManagedSecBufferDesc
    extends Sspi.SecBufferDesc {
        private final Sspi.SecBuffer[] secBuffers;

        public ManagedSecBufferDesc(int n2, byte[] byArray) {
            this.secBuffers = new Sspi.SecBuffer[]{new Sspi.SecBuffer(n2, byArray)};
            this.pBuffers = this.secBuffers[0].getPointer();
            this.cBuffers = this.secBuffers.length;
        }

        public ManagedSecBufferDesc(int n2, int n3) {
            this.secBuffers = new Sspi.SecBuffer[]{new Sspi.SecBuffer(n2, n3)};
            this.pBuffers = this.secBuffers[0].getPointer();
            this.cBuffers = this.secBuffers.length;
        }

        public ManagedSecBufferDesc(int n2) {
            this.cBuffers = n2;
            this.secBuffers = (Sspi.SecBuffer[])new Sspi.SecBuffer().com_sun_jna_Structure_arr_toArray(n2);
            this.pBuffers = this.secBuffers[0].getPointer();
            this.cBuffers = this.secBuffers.length;
        }

        public Sspi.SecBuffer getBuffer(int n2) {
            return this.secBuffers[n2];
        }

        @Override
        public void write() {
            for (Sspi.SecBuffer secBuffer : this.secBuffers) {
                secBuffer.write();
            }
            this.writeField("ulVersion");
            this.writeField("pBuffers");
            this.writeField("cBuffers");
        }

        @Override
        public void read() {
            for (Sspi.SecBuffer secBuffer : this.secBuffers) {
                secBuffer.read();
            }
        }
    }
}

