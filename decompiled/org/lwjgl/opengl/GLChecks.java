/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.EXTDirectStateAccess;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41;
import org.lwjgl.opengl.GL45;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.APIUtil;

final class GLChecks {
    private GLChecks() {
    }

    static int typeToBytes(int n2) {
        switch (n2) {
            case 5120: 
            case 5121: {
                return 1;
            }
            case 5122: 
            case 5123: 
            case 5127: 
            case 5131: {
                return 2;
            }
            case 5128: {
                return 3;
            }
            case 5124: 
            case 5125: 
            case 5126: 
            case 5129: 
            case 5132: {
                return 4;
            }
            case 5130: 
            case 5134: 
            case 5135: {
                return 8;
            }
        }
        throw new IllegalArgumentException(APIUtil.apiUnknownToken("Unsupported OpenGL type", n2));
    }

    static int typeToByteShift(int n2) {
        switch (n2) {
            case 5120: 
            case 5121: {
                return 0;
            }
            case 5122: 
            case 5123: 
            case 5127: 
            case 5131: {
                return 1;
            }
            case 5124: 
            case 5125: 
            case 5126: 
            case 5129: 
            case 5132: {
                return 2;
            }
            case 5130: 
            case 5134: 
            case 5135: {
                return 3;
            }
        }
        throw new IllegalArgumentException(APIUtil.apiUnknownToken("Unsupported OpenGL type", n2));
    }

    static int getTexLevelParameteri(int n2, int n3, int n4, int n5) {
        GLCapabilities gLCapabilities = GL.getCapabilities();
        if (gLCapabilities.OpenGL45) {
            return GL45.glGetTextureLevelParameteri(n2, n4, n5);
        }
        if (gLCapabilities.GL_ARB_direct_state_access) {
            return ARBDirectStateAccess.glGetTextureLevelParameteri(n2, n4, n5);
        }
        if (gLCapabilities.GL_EXT_direct_state_access) {
            return EXTDirectStateAccess.glGetTextureLevelParameteriEXT(n2, n3, n4, n5);
        }
        return GL41.glGetTexLevelParameteri(n3, n4, n5);
    }
}

