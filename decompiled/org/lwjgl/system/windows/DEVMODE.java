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
import org.lwjgl.system.windows.POINTL;

public class DEVMODE
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DMDEVICENAME;
    public static final int DMSPECVERSION;
    public static final int DMDRIVERVERSION;
    public static final int DMSIZE;
    public static final int DMDRIVEREXTRA;
    public static final int DMFIELDS;
    public static final int DMORIENTATION;
    public static final int DMPAPERSIZE;
    public static final int DMPAPERLENGTH;
    public static final int DMPAPERWIDTH;
    public static final int DMSCALE;
    public static final int DMCOPIES;
    public static final int DMDEFAULTSOURCE;
    public static final int DMPRINTQUALITY;
    public static final int DMPOSITION;
    public static final int DMDISPLAYORIENTATION;
    public static final int DMDISPLAYFIXEDOUTPUT;
    public static final int DMCOLOR;
    public static final int DMDUPLEX;
    public static final int DMYRESOLUTION;
    public static final int DMTTOPTION;
    public static final int DMCOLLATE;
    public static final int DMFORMNAME;
    public static final int DMLOGPIXELS;
    public static final int DMBITSPERPEL;
    public static final int DMPELSWIDTH;
    public static final int DMPELSHEIGHT;
    public static final int DMDISPLAYFLAGS;
    public static final int DMNUP;
    public static final int DMDISPLAYFREQUENCY;
    public static final int DMICMMETHOD;
    public static final int DMICMINTENT;
    public static final int DMMEDIATYPE;
    public static final int DMDITHERTYPE;
    public static final int DMRESERVED1;
    public static final int DMRESERVED2;
    public static final int DMPANNINGWIDTH;
    public static final int DMPANNINGHEIGHT;

    public DEVMODE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), DEVMODE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer dmDeviceName() {
        return DEVMODE.ndmDeviceName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String dmDeviceNameString() {
        return DEVMODE.ndmDeviceNameString(this.address());
    }

    @NativeType(value="WORD")
    public short dmSpecVersion() {
        return DEVMODE.ndmSpecVersion(this.address());
    }

    @NativeType(value="WORD")
    public short dmDriverVersion() {
        return DEVMODE.ndmDriverVersion(this.address());
    }

    @NativeType(value="WORD")
    public short dmSize() {
        return DEVMODE.ndmSize(this.address());
    }

    @NativeType(value="WORD")
    public short dmDriverExtra() {
        return DEVMODE.ndmDriverExtra(this.address());
    }

    @NativeType(value="DWORD")
    public int dmFields() {
        return DEVMODE.ndmFields(this.address());
    }

    public short dmOrientation() {
        return DEVMODE.ndmOrientation(this.address());
    }

    public short dmPaperSize() {
        return DEVMODE.ndmPaperSize(this.address());
    }

    public short dmPaperLength() {
        return DEVMODE.ndmPaperLength(this.address());
    }

    public short dmPaperWidth() {
        return DEVMODE.ndmPaperWidth(this.address());
    }

    public short dmScale() {
        return DEVMODE.ndmScale(this.address());
    }

    public short dmCopies() {
        return DEVMODE.ndmCopies(this.address());
    }

    public short dmDefaultSource() {
        return DEVMODE.ndmDefaultSource(this.address());
    }

    public short dmPrintQuality() {
        return DEVMODE.ndmPrintQuality(this.address());
    }

    public POINTL dmPosition() {
        return DEVMODE.ndmPosition(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayOrientation() {
        return DEVMODE.ndmDisplayOrientation(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFixedOutput() {
        return DEVMODE.ndmDisplayFixedOutput(this.address());
    }

    public short dmColor() {
        return DEVMODE.ndmColor(this.address());
    }

    public short dmDuplex() {
        return DEVMODE.ndmDuplex(this.address());
    }

    public short dmYResolution() {
        return DEVMODE.ndmYResolution(this.address());
    }

    public short dmTTOption() {
        return DEVMODE.ndmTTOption(this.address());
    }

    public short dmCollate() {
        return DEVMODE.ndmCollate(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer dmFormName() {
        return DEVMODE.ndmFormName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String dmFormNameString() {
        return DEVMODE.ndmFormNameString(this.address());
    }

    @NativeType(value="WORD")
    public short dmLogPixels() {
        return DEVMODE.ndmLogPixels(this.address());
    }

    @NativeType(value="DWORD")
    public int dmBitsPerPel() {
        return DEVMODE.ndmBitsPerPel(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPelsWidth() {
        return DEVMODE.ndmPelsWidth(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPelsHeight() {
        return DEVMODE.ndmPelsHeight(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFlags() {
        return DEVMODE.ndmDisplayFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int dmNup() {
        return DEVMODE.ndmNup(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFrequency() {
        return DEVMODE.ndmDisplayFrequency(this.address());
    }

    @NativeType(value="DWORD")
    public int dmICMMethod() {
        return DEVMODE.ndmICMMethod(this.address());
    }

    @NativeType(value="DWORD")
    public int dmICMIntent() {
        return DEVMODE.ndmICMIntent(this.address());
    }

    @NativeType(value="DWORD")
    public int dmMediaType() {
        return DEVMODE.ndmMediaType(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDitherType() {
        return DEVMODE.ndmDitherType(this.address());
    }

    @NativeType(value="DWORD")
    public int dmReserved1() {
        return DEVMODE.ndmReserved1(this.address());
    }

    @NativeType(value="DWORD")
    public int dmReserved2() {
        return DEVMODE.ndmReserved2(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPanningWidth() {
        return DEVMODE.ndmPanningWidth(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPanningHeight() {
        return DEVMODE.ndmPanningHeight(this.address());
    }

    public DEVMODE dmSpecVersion(@NativeType(value="WORD") short s2) {
        DEVMODE.ndmSpecVersion(this.address(), s2);
        return this;
    }

    public DEVMODE dmSize(@NativeType(value="WORD") short s2) {
        DEVMODE.ndmSize(this.address(), s2);
        return this;
    }

    public DEVMODE dmDriverExtra(@NativeType(value="WORD") short s2) {
        DEVMODE.ndmDriverExtra(this.address(), s2);
        return this;
    }

    public DEVMODE set(DEVMODE dEVMODE) {
        MemoryUtil.memCopy(dEVMODE.address(), this.address(), SIZEOF);
        return this;
    }

    public static DEVMODE malloc() {
        return DEVMODE.wrap(DEVMODE.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static DEVMODE calloc() {
        return DEVMODE.wrap(DEVMODE.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static DEVMODE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return DEVMODE.wrap(DEVMODE.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static DEVMODE create(long l2) {
        return DEVMODE.wrap(DEVMODE.class, l2);
    }

    @Nullable
    public static DEVMODE createSafe(long l2) {
        return l2 == 0L ? null : DEVMODE.wrap(DEVMODE.class, l2);
    }

    public static Buffer malloc(int n2) {
        return DEVMODE.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(DEVMODE.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return DEVMODE.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = DEVMODE.__create(n2, SIZEOF);
        return DEVMODE.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return DEVMODE.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : DEVMODE.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static DEVMODE mallocStack() {
        return DEVMODE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DEVMODE callocStack() {
        return DEVMODE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DEVMODE mallocStack(MemoryStack memoryStack) {
        return DEVMODE.malloc(memoryStack);
    }

    @Deprecated
    public static DEVMODE callocStack(MemoryStack memoryStack) {
        return DEVMODE.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return DEVMODE.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return DEVMODE.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return DEVMODE.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return DEVMODE.calloc(n2, memoryStack);
    }

    public static DEVMODE malloc(MemoryStack memoryStack) {
        return DEVMODE.wrap(DEVMODE.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static DEVMODE calloc(MemoryStack memoryStack) {
        return DEVMODE.wrap(DEVMODE.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return DEVMODE.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return DEVMODE.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer ndmDeviceName(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DMDEVICENAME, 64);
    }

    public static String ndmDeviceNameString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)DMDEVICENAME);
    }

    public static short ndmSpecVersion(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMSPECVERSION);
    }

    public static short ndmDriverVersion(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMDRIVERVERSION);
    }

    public static short ndmSize(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMSIZE);
    }

    public static short ndmDriverExtra(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMDRIVEREXTRA);
    }

    public static int ndmFields(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMFIELDS);
    }

    public static short ndmOrientation(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMORIENTATION);
    }

    public static short ndmPaperSize(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMPAPERSIZE);
    }

    public static short ndmPaperLength(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMPAPERLENGTH);
    }

    public static short ndmPaperWidth(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMPAPERWIDTH);
    }

    public static short ndmScale(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMSCALE);
    }

    public static short ndmCopies(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMCOPIES);
    }

    public static short ndmDefaultSource(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMDEFAULTSOURCE);
    }

    public static short ndmPrintQuality(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMPRINTQUALITY);
    }

    public static POINTL ndmPosition(long l2) {
        return POINTL.create(l2 + (long)DMPOSITION);
    }

    public static int ndmDisplayOrientation(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMDISPLAYORIENTATION);
    }

    public static int ndmDisplayFixedOutput(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMDISPLAYFIXEDOUTPUT);
    }

    public static short ndmColor(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMCOLOR);
    }

    public static short ndmDuplex(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMDUPLEX);
    }

    public static short ndmYResolution(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMYRESOLUTION);
    }

    public static short ndmTTOption(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMTTOPTION);
    }

    public static short ndmCollate(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMCOLLATE);
    }

    public static ByteBuffer ndmFormName(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DMFORMNAME, 64);
    }

    public static String ndmFormNameString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)DMFORMNAME);
    }

    public static short ndmLogPixels(long l2) {
        return UNSAFE.getShort(null, l2 + (long)DMLOGPIXELS);
    }

    public static int ndmBitsPerPel(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMBITSPERPEL);
    }

    public static int ndmPelsWidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMPELSWIDTH);
    }

    public static int ndmPelsHeight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMPELSHEIGHT);
    }

    public static int ndmDisplayFlags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMDISPLAYFLAGS);
    }

    public static int ndmNup(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMNUP);
    }

    public static int ndmDisplayFrequency(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMDISPLAYFREQUENCY);
    }

    public static int ndmICMMethod(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMICMMETHOD);
    }

    public static int ndmICMIntent(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMICMINTENT);
    }

    public static int ndmMediaType(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMMEDIATYPE);
    }

    public static int ndmDitherType(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMDITHERTYPE);
    }

    public static int ndmReserved1(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMRESERVED1);
    }

    public static int ndmReserved2(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMRESERVED2);
    }

    public static int ndmPanningWidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMPANNINGWIDTH);
    }

    public static int ndmPanningHeight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)DMPANNINGHEIGHT);
    }

    public static void ndmSpecVersion(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)DMSPECVERSION, s2);
    }

    public static void ndmSize(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)DMSIZE, s2);
    }

    public static void ndmDriverExtra(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)DMDRIVEREXTRA, s2);
    }

    static {
        Struct.Layout layout = DEVMODE.__struct(DEVMODE.__array(2, 32), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(4), DEVMODE.__union(DEVMODE.__struct(DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2)), DEVMODE.__struct(DEVMODE.__member(POINTL.SIZEOF, POINTL.ALIGNOF), DEVMODE.__member(4), DEVMODE.__member(4))), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__array(2, 32), DEVMODE.__member(2), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__union(DEVMODE.__member(4), DEVMODE.__member(4)), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        DMDEVICENAME = layout.offsetof(0);
        DMSPECVERSION = layout.offsetof(1);
        DMDRIVERVERSION = layout.offsetof(2);
        DMSIZE = layout.offsetof(3);
        DMDRIVEREXTRA = layout.offsetof(4);
        DMFIELDS = layout.offsetof(5);
        DMORIENTATION = layout.offsetof(8);
        DMPAPERSIZE = layout.offsetof(9);
        DMPAPERLENGTH = layout.offsetof(10);
        DMPAPERWIDTH = layout.offsetof(11);
        DMSCALE = layout.offsetof(12);
        DMCOPIES = layout.offsetof(13);
        DMDEFAULTSOURCE = layout.offsetof(14);
        DMPRINTQUALITY = layout.offsetof(15);
        DMPOSITION = layout.offsetof(17);
        DMDISPLAYORIENTATION = layout.offsetof(18);
        DMDISPLAYFIXEDOUTPUT = layout.offsetof(19);
        DMCOLOR = layout.offsetof(20);
        DMDUPLEX = layout.offsetof(21);
        DMYRESOLUTION = layout.offsetof(22);
        DMTTOPTION = layout.offsetof(23);
        DMCOLLATE = layout.offsetof(24);
        DMFORMNAME = layout.offsetof(25);
        DMLOGPIXELS = layout.offsetof(26);
        DMBITSPERPEL = layout.offsetof(27);
        DMPELSWIDTH = layout.offsetof(28);
        DMPELSHEIGHT = layout.offsetof(29);
        DMDISPLAYFLAGS = layout.offsetof(31);
        DMNUP = layout.offsetof(32);
        DMDISPLAYFREQUENCY = layout.offsetof(33);
        DMICMMETHOD = layout.offsetof(34);
        DMICMINTENT = layout.offsetof(35);
        DMMEDIATYPE = layout.offsetof(36);
        DMDITHERTYPE = layout.offsetof(37);
        DMRESERVED1 = layout.offsetof(38);
        DMRESERVED2 = layout.offsetof(39);
        DMPANNINGWIDTH = layout.offsetof(40);
        DMPANNINGHEIGHT = layout.offsetof(41);
    }

    public static class Buffer
    extends StructBuffer<DEVMODE, Buffer>
    implements NativeResource {
        private static final DEVMODE ELEMENT_FACTORY = DEVMODE.create(-1L);

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
        protected DEVMODE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer dmDeviceName() {
            return DEVMODE.ndmDeviceName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String dmDeviceNameString() {
            return DEVMODE.ndmDeviceNameString(this.address());
        }

        @NativeType(value="WORD")
        public short dmSpecVersion() {
            return DEVMODE.ndmSpecVersion(this.address());
        }

        @NativeType(value="WORD")
        public short dmDriverVersion() {
            return DEVMODE.ndmDriverVersion(this.address());
        }

        @NativeType(value="WORD")
        public short dmSize() {
            return DEVMODE.ndmSize(this.address());
        }

        @NativeType(value="WORD")
        public short dmDriverExtra() {
            return DEVMODE.ndmDriverExtra(this.address());
        }

        @NativeType(value="DWORD")
        public int dmFields() {
            return DEVMODE.ndmFields(this.address());
        }

        public short dmOrientation() {
            return DEVMODE.ndmOrientation(this.address());
        }

        public short dmPaperSize() {
            return DEVMODE.ndmPaperSize(this.address());
        }

        public short dmPaperLength() {
            return DEVMODE.ndmPaperLength(this.address());
        }

        public short dmPaperWidth() {
            return DEVMODE.ndmPaperWidth(this.address());
        }

        public short dmScale() {
            return DEVMODE.ndmScale(this.address());
        }

        public short dmCopies() {
            return DEVMODE.ndmCopies(this.address());
        }

        public short dmDefaultSource() {
            return DEVMODE.ndmDefaultSource(this.address());
        }

        public short dmPrintQuality() {
            return DEVMODE.ndmPrintQuality(this.address());
        }

        public POINTL dmPosition() {
            return DEVMODE.ndmPosition(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayOrientation() {
            return DEVMODE.ndmDisplayOrientation(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFixedOutput() {
            return DEVMODE.ndmDisplayFixedOutput(this.address());
        }

        public short dmColor() {
            return DEVMODE.ndmColor(this.address());
        }

        public short dmDuplex() {
            return DEVMODE.ndmDuplex(this.address());
        }

        public short dmYResolution() {
            return DEVMODE.ndmYResolution(this.address());
        }

        public short dmTTOption() {
            return DEVMODE.ndmTTOption(this.address());
        }

        public short dmCollate() {
            return DEVMODE.ndmCollate(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer dmFormName() {
            return DEVMODE.ndmFormName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String dmFormNameString() {
            return DEVMODE.ndmFormNameString(this.address());
        }

        @NativeType(value="WORD")
        public short dmLogPixels() {
            return DEVMODE.ndmLogPixels(this.address());
        }

        @NativeType(value="DWORD")
        public int dmBitsPerPel() {
            return DEVMODE.ndmBitsPerPel(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPelsWidth() {
            return DEVMODE.ndmPelsWidth(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPelsHeight() {
            return DEVMODE.ndmPelsHeight(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFlags() {
            return DEVMODE.ndmDisplayFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int dmNup() {
            return DEVMODE.ndmNup(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFrequency() {
            return DEVMODE.ndmDisplayFrequency(this.address());
        }

        @NativeType(value="DWORD")
        public int dmICMMethod() {
            return DEVMODE.ndmICMMethod(this.address());
        }

        @NativeType(value="DWORD")
        public int dmICMIntent() {
            return DEVMODE.ndmICMIntent(this.address());
        }

        @NativeType(value="DWORD")
        public int dmMediaType() {
            return DEVMODE.ndmMediaType(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDitherType() {
            return DEVMODE.ndmDitherType(this.address());
        }

        @NativeType(value="DWORD")
        public int dmReserved1() {
            return DEVMODE.ndmReserved1(this.address());
        }

        @NativeType(value="DWORD")
        public int dmReserved2() {
            return DEVMODE.ndmReserved2(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPanningWidth() {
            return DEVMODE.ndmPanningWidth(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPanningHeight() {
            return DEVMODE.ndmPanningHeight(this.address());
        }

        public Buffer dmSpecVersion(@NativeType(value="WORD") short s2) {
            DEVMODE.ndmSpecVersion(this.address(), s2);
            return this;
        }

        public Buffer dmSize(@NativeType(value="WORD") short s2) {
            DEVMODE.ndmSize(this.address(), s2);
            return this;
        }

        public Buffer dmDriverExtra(@NativeType(value="WORD") short s2) {
            DEVMODE.ndmDriverExtra(this.address(), s2);
            return this;
        }
    }
}

