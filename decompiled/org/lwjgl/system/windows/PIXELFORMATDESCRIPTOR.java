/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class PIXELFORMATDESCRIPTOR
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NSIZE;
    public static final int NVERSION;
    public static final int DWFLAGS;
    public static final int IPIXELTYPE;
    public static final int CCOLORBITS;
    public static final int CREDBITS;
    public static final int CREDSHIFT;
    public static final int CGREENBITS;
    public static final int CGREENSHIFT;
    public static final int CBLUEBITS;
    public static final int CBLUESHIFT;
    public static final int CALPHABITS;
    public static final int CALPHASHIFT;
    public static final int CACCUMBITS;
    public static final int CACCUMREDBITS;
    public static final int CACCUMGREENBITS;
    public static final int CACCUMBLUEBITS;
    public static final int CACCUMALPHABITS;
    public static final int CDEPTHBITS;
    public static final int CSTENCILBITS;
    public static final int CAUXBUFFERS;
    public static final int ILAYERTYPE;
    public static final int BRESERVED;
    public static final int DWLAYERMASK;
    public static final int DWVISIBLEMASK;
    public static final int DWDAMAGEMASK;

    public PIXELFORMATDESCRIPTOR(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), PIXELFORMATDESCRIPTOR.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="WORD")
    public short nSize() {
        return PIXELFORMATDESCRIPTOR.nnSize(this.address());
    }

    @NativeType(value="WORD")
    public short nVersion() {
        return PIXELFORMATDESCRIPTOR.nnVersion(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return PIXELFORMATDESCRIPTOR.ndwFlags(this.address());
    }

    @NativeType(value="BYTE")
    public byte iPixelType() {
        return PIXELFORMATDESCRIPTOR.niPixelType(this.address());
    }

    @NativeType(value="BYTE")
    public byte cColorBits() {
        return PIXELFORMATDESCRIPTOR.ncColorBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cRedBits() {
        return PIXELFORMATDESCRIPTOR.ncRedBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cRedShift() {
        return PIXELFORMATDESCRIPTOR.ncRedShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cGreenBits() {
        return PIXELFORMATDESCRIPTOR.ncGreenBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cGreenShift() {
        return PIXELFORMATDESCRIPTOR.ncGreenShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cBlueBits() {
        return PIXELFORMATDESCRIPTOR.ncBlueBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cBlueShift() {
        return PIXELFORMATDESCRIPTOR.ncBlueShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAlphaBits() {
        return PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAlphaShift() {
        return PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumRedBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumGreenBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumBlueBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumAlphaBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cDepthBits() {
        return PIXELFORMATDESCRIPTOR.ncDepthBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cStencilBits() {
        return PIXELFORMATDESCRIPTOR.ncStencilBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAuxBuffers() {
        return PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address());
    }

    @NativeType(value="BYTE")
    public byte iLayerType() {
        return PIXELFORMATDESCRIPTOR.niLayerType(this.address());
    }

    @NativeType(value="BYTE")
    public byte bReserved() {
        return PIXELFORMATDESCRIPTOR.nbReserved(this.address());
    }

    @NativeType(value="DWORD")
    public int dwLayerMask() {
        return PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address());
    }

    @NativeType(value="DWORD")
    public int dwVisibleMask() {
        return PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address());
    }

    @NativeType(value="DWORD")
    public int dwDamageMask() {
        return PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address());
    }

    public PIXELFORMATDESCRIPTOR nSize(@NativeType(value="WORD") short s2) {
        PIXELFORMATDESCRIPTOR.nnSize(this.address(), s2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR nVersion(@NativeType(value="WORD") short s2) {
        PIXELFORMATDESCRIPTOR.nnVersion(this.address(), s2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwFlags(@NativeType(value="DWORD") int n2) {
        PIXELFORMATDESCRIPTOR.ndwFlags(this.address(), n2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR iPixelType(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.niPixelType(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cColorBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncColorBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cRedBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncRedBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cRedShift(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncRedShift(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cGreenBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncGreenBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cGreenShift(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncGreenShift(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cBlueBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncBlueBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cBlueShift(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncBlueShift(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAlphaBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAlphaShift(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAccumBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumRedBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumGreenBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumBlueBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumAlphaBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cDepthBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncDepthBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cStencilBits(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncStencilBits(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAuxBuffers(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR iLayerType(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.niLayerType(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR bReserved(@NativeType(value="BYTE") byte by2) {
        PIXELFORMATDESCRIPTOR.nbReserved(this.address(), by2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwLayerMask(@NativeType(value="DWORD") int n2) {
        PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address(), n2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwVisibleMask(@NativeType(value="DWORD") int n2) {
        PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address(), n2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwDamageMask(@NativeType(value="DWORD") int n2) {
        PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address(), n2);
        return this;
    }

    public PIXELFORMATDESCRIPTOR set(short s2, short s3, int n2, byte by2, byte by3, byte by4, byte by5, byte by6, byte by7, byte by8, byte by9, byte by10, byte by11, byte by12, byte by13, byte by14, byte by15, byte by16, byte by17, byte by18, byte by19, byte by20, byte by21, int n3, int n4, int n5) {
        this.nSize(s2);
        this.nVersion(s3);
        this.dwFlags(n2);
        this.iPixelType(by2);
        this.cColorBits(by3);
        this.cRedBits(by4);
        this.cRedShift(by5);
        this.cGreenBits(by6);
        this.cGreenShift(by7);
        this.cBlueBits(by8);
        this.cBlueShift(by9);
        this.cAlphaBits(by10);
        this.cAlphaShift(by11);
        this.cAccumBits(by12);
        this.cAccumRedBits(by13);
        this.cAccumGreenBits(by14);
        this.cAccumBlueBits(by15);
        this.cAccumAlphaBits(by16);
        this.cDepthBits(by17);
        this.cStencilBits(by18);
        this.cAuxBuffers(by19);
        this.iLayerType(by20);
        this.bReserved(by21);
        this.dwLayerMask(n3);
        this.dwVisibleMask(n4);
        this.dwDamageMask(n5);
        return this;
    }

    public PIXELFORMATDESCRIPTOR set(PIXELFORMATDESCRIPTOR pIXELFORMATDESCRIPTOR) {
        MemoryUtil.memCopy(pIXELFORMATDESCRIPTOR.address(), this.address(), SIZEOF);
        return this;
    }

    public static PIXELFORMATDESCRIPTOR malloc() {
        return PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static PIXELFORMATDESCRIPTOR calloc() {
        return PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static PIXELFORMATDESCRIPTOR create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static PIXELFORMATDESCRIPTOR create(long l2) {
        return PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, l2);
    }

    @Nullable
    public static PIXELFORMATDESCRIPTOR createSafe(long l2) {
        return l2 == 0L ? null : PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, l2);
    }

    public static Buffer malloc(int n2) {
        return PIXELFORMATDESCRIPTOR.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(PIXELFORMATDESCRIPTOR.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return PIXELFORMATDESCRIPTOR.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = PIXELFORMATDESCRIPTOR.__create(n2, SIZEOF);
        return PIXELFORMATDESCRIPTOR.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return PIXELFORMATDESCRIPTOR.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : PIXELFORMATDESCRIPTOR.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR mallocStack() {
        return PIXELFORMATDESCRIPTOR.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR callocStack() {
        return PIXELFORMATDESCRIPTOR.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR mallocStack(MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.malloc(memoryStack);
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR callocStack(MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return PIXELFORMATDESCRIPTOR.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return PIXELFORMATDESCRIPTOR.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.calloc(n2, memoryStack);
    }

    public static PIXELFORMATDESCRIPTOR malloc(MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static PIXELFORMATDESCRIPTOR calloc(MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.wrap(PIXELFORMATDESCRIPTOR.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return PIXELFORMATDESCRIPTOR.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nnSize(long l2) {
        return UNSAFE.getShort(null, l2 + (long)NSIZE);
    }

    public static short nnVersion(long l2) {
        return UNSAFE.getShort(null, l2 + (long)NVERSION);
    }

    public static int ndwFlags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWFLAGS);
    }

    public static byte niPixelType(long l2) {
        return UNSAFE.getByte(null, l2 + (long)IPIXELTYPE);
    }

    public static byte ncColorBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CCOLORBITS);
    }

    public static byte ncRedBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CREDBITS);
    }

    public static byte ncRedShift(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CREDSHIFT);
    }

    public static byte ncGreenBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CGREENBITS);
    }

    public static byte ncGreenShift(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CGREENSHIFT);
    }

    public static byte ncBlueBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CBLUEBITS);
    }

    public static byte ncBlueShift(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CBLUESHIFT);
    }

    public static byte ncAlphaBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CALPHABITS);
    }

    public static byte ncAlphaShift(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CALPHASHIFT);
    }

    public static byte ncAccumBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CACCUMBITS);
    }

    public static byte ncAccumRedBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CACCUMREDBITS);
    }

    public static byte ncAccumGreenBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CACCUMGREENBITS);
    }

    public static byte ncAccumBlueBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CACCUMBLUEBITS);
    }

    public static byte ncAccumAlphaBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CACCUMALPHABITS);
    }

    public static byte ncDepthBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CDEPTHBITS);
    }

    public static byte ncStencilBits(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CSTENCILBITS);
    }

    public static byte ncAuxBuffers(long l2) {
        return UNSAFE.getByte(null, l2 + (long)CAUXBUFFERS);
    }

    public static byte niLayerType(long l2) {
        return UNSAFE.getByte(null, l2 + (long)ILAYERTYPE);
    }

    public static byte nbReserved(long l2) {
        return UNSAFE.getByte(null, l2 + (long)BRESERVED);
    }

    public static int ndwLayerMask(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWLAYERMASK);
    }

    public static int ndwVisibleMask(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWVISIBLEMASK);
    }

    public static int ndwDamageMask(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DWDAMAGEMASK);
    }

    public static void nnSize(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)NSIZE, s2);
    }

    public static void nnVersion(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)NVERSION, s2);
    }

    public static void ndwFlags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DWFLAGS, n2);
    }

    public static void niPixelType(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)IPIXELTYPE, by2);
    }

    public static void ncColorBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CCOLORBITS, by2);
    }

    public static void ncRedBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CREDBITS, by2);
    }

    public static void ncRedShift(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CREDSHIFT, by2);
    }

    public static void ncGreenBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CGREENBITS, by2);
    }

    public static void ncGreenShift(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CGREENSHIFT, by2);
    }

    public static void ncBlueBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CBLUEBITS, by2);
    }

    public static void ncBlueShift(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CBLUESHIFT, by2);
    }

    public static void ncAlphaBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CALPHABITS, by2);
    }

    public static void ncAlphaShift(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CALPHASHIFT, by2);
    }

    public static void ncAccumBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CACCUMBITS, by2);
    }

    public static void ncAccumRedBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CACCUMREDBITS, by2);
    }

    public static void ncAccumGreenBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CACCUMGREENBITS, by2);
    }

    public static void ncAccumBlueBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CACCUMBLUEBITS, by2);
    }

    public static void ncAccumAlphaBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CACCUMALPHABITS, by2);
    }

    public static void ncDepthBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CDEPTHBITS, by2);
    }

    public static void ncStencilBits(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CSTENCILBITS, by2);
    }

    public static void ncAuxBuffers(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)CAUXBUFFERS, by2);
    }

    public static void niLayerType(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)ILAYERTYPE, by2);
    }

    public static void nbReserved(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)BRESERVED, by2);
    }

    public static void ndwLayerMask(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DWLAYERMASK, n2);
    }

    public static void ndwVisibleMask(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DWVISIBLEMASK, n2);
    }

    public static void ndwDamageMask(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)DWDAMAGEMASK, n2);
    }

    static {
        Struct.Layout layout = PIXELFORMATDESCRIPTOR.__struct(PIXELFORMATDESCRIPTOR.__member(2), PIXELFORMATDESCRIPTOR.__member(2), PIXELFORMATDESCRIPTOR.__member(4), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(4), PIXELFORMATDESCRIPTOR.__member(4), PIXELFORMATDESCRIPTOR.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NSIZE = layout.offsetof(0);
        NVERSION = layout.offsetof(1);
        DWFLAGS = layout.offsetof(2);
        IPIXELTYPE = layout.offsetof(3);
        CCOLORBITS = layout.offsetof(4);
        CREDBITS = layout.offsetof(5);
        CREDSHIFT = layout.offsetof(6);
        CGREENBITS = layout.offsetof(7);
        CGREENSHIFT = layout.offsetof(8);
        CBLUEBITS = layout.offsetof(9);
        CBLUESHIFT = layout.offsetof(10);
        CALPHABITS = layout.offsetof(11);
        CALPHASHIFT = layout.offsetof(12);
        CACCUMBITS = layout.offsetof(13);
        CACCUMREDBITS = layout.offsetof(14);
        CACCUMGREENBITS = layout.offsetof(15);
        CACCUMBLUEBITS = layout.offsetof(16);
        CACCUMALPHABITS = layout.offsetof(17);
        CDEPTHBITS = layout.offsetof(18);
        CSTENCILBITS = layout.offsetof(19);
        CAUXBUFFERS = layout.offsetof(20);
        ILAYERTYPE = layout.offsetof(21);
        BRESERVED = layout.offsetof(22);
        DWLAYERMASK = layout.offsetof(23);
        DWVISIBLEMASK = layout.offsetof(24);
        DWDAMAGEMASK = layout.offsetof(25);
    }

    public static class Buffer
    extends StructBuffer<PIXELFORMATDESCRIPTOR, Buffer>
    implements NativeResource {
        private static final PIXELFORMATDESCRIPTOR ELEMENT_FACTORY = PIXELFORMATDESCRIPTOR.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l2, int n2) {
            super(l2, null, -1, 0, n2, n2);
        }

        Buffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
            super(l2, byteBuffer, n2, n3, n4, n5);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected PIXELFORMATDESCRIPTOR getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="WORD")
        public short nSize() {
            return PIXELFORMATDESCRIPTOR.nnSize(this.address());
        }

        @NativeType(value="WORD")
        public short nVersion() {
            return PIXELFORMATDESCRIPTOR.nnVersion(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return PIXELFORMATDESCRIPTOR.ndwFlags(this.address());
        }

        @NativeType(value="BYTE")
        public byte iPixelType() {
            return PIXELFORMATDESCRIPTOR.niPixelType(this.address());
        }

        @NativeType(value="BYTE")
        public byte cColorBits() {
            return PIXELFORMATDESCRIPTOR.ncColorBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cRedBits() {
            return PIXELFORMATDESCRIPTOR.ncRedBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cRedShift() {
            return PIXELFORMATDESCRIPTOR.ncRedShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cGreenBits() {
            return PIXELFORMATDESCRIPTOR.ncGreenBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cGreenShift() {
            return PIXELFORMATDESCRIPTOR.ncGreenShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cBlueBits() {
            return PIXELFORMATDESCRIPTOR.ncBlueBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cBlueShift() {
            return PIXELFORMATDESCRIPTOR.ncBlueShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAlphaBits() {
            return PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAlphaShift() {
            return PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumRedBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumGreenBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumBlueBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumAlphaBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cDepthBits() {
            return PIXELFORMATDESCRIPTOR.ncDepthBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cStencilBits() {
            return PIXELFORMATDESCRIPTOR.ncStencilBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAuxBuffers() {
            return PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address());
        }

        @NativeType(value="BYTE")
        public byte iLayerType() {
            return PIXELFORMATDESCRIPTOR.niLayerType(this.address());
        }

        @NativeType(value="BYTE")
        public byte bReserved() {
            return PIXELFORMATDESCRIPTOR.nbReserved(this.address());
        }

        @NativeType(value="DWORD")
        public int dwLayerMask() {
            return PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address());
        }

        @NativeType(value="DWORD")
        public int dwVisibleMask() {
            return PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address());
        }

        @NativeType(value="DWORD")
        public int dwDamageMask() {
            return PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address());
        }

        public Buffer nSize(@NativeType(value="WORD") short s2) {
            PIXELFORMATDESCRIPTOR.nnSize(this.address(), s2);
            return this;
        }

        public Buffer nVersion(@NativeType(value="WORD") short s2) {
            PIXELFORMATDESCRIPTOR.nnVersion(this.address(), s2);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int n2) {
            PIXELFORMATDESCRIPTOR.ndwFlags(this.address(), n2);
            return this;
        }

        public Buffer iPixelType(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.niPixelType(this.address(), by2);
            return this;
        }

        public Buffer cColorBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncColorBits(this.address(), by2);
            return this;
        }

        public Buffer cRedBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncRedBits(this.address(), by2);
            return this;
        }

        public Buffer cRedShift(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncRedShift(this.address(), by2);
            return this;
        }

        public Buffer cGreenBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncGreenBits(this.address(), by2);
            return this;
        }

        public Buffer cGreenShift(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncGreenShift(this.address(), by2);
            return this;
        }

        public Buffer cBlueBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncBlueBits(this.address(), by2);
            return this;
        }

        public Buffer cBlueShift(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncBlueShift(this.address(), by2);
            return this;
        }

        public Buffer cAlphaBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address(), by2);
            return this;
        }

        public Buffer cAlphaShift(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address(), by2);
            return this;
        }

        public Buffer cAccumBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAccumBits(this.address(), by2);
            return this;
        }

        public Buffer cAccumRedBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address(), by2);
            return this;
        }

        public Buffer cAccumGreenBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address(), by2);
            return this;
        }

        public Buffer cAccumBlueBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address(), by2);
            return this;
        }

        public Buffer cAccumAlphaBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address(), by2);
            return this;
        }

        public Buffer cDepthBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncDepthBits(this.address(), by2);
            return this;
        }

        public Buffer cStencilBits(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncStencilBits(this.address(), by2);
            return this;
        }

        public Buffer cAuxBuffers(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address(), by2);
            return this;
        }

        public Buffer iLayerType(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.niLayerType(this.address(), by2);
            return this;
        }

        public Buffer bReserved(@NativeType(value="BYTE") byte by2) {
            PIXELFORMATDESCRIPTOR.nbReserved(this.address(), by2);
            return this;
        }

        public Buffer dwLayerMask(@NativeType(value="DWORD") int n2) {
            PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address(), n2);
            return this;
        }

        public Buffer dwVisibleMask(@NativeType(value="DWORD") int n2) {
            PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address(), n2);
            return this;
        }

        public Buffer dwDamageMask(@NativeType(value="DWORD") int n2) {
            PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address(), n2);
            return this;
        }
    }
}

