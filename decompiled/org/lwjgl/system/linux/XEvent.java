/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.XAnyEvent;
import org.lwjgl.system.linux.XButtonEvent;
import org.lwjgl.system.linux.XCirculateEvent;
import org.lwjgl.system.linux.XCirculateRequestEvent;
import org.lwjgl.system.linux.XClientMessageEvent;
import org.lwjgl.system.linux.XColormapEvent;
import org.lwjgl.system.linux.XConfigureEvent;
import org.lwjgl.system.linux.XConfigureRequestEvent;
import org.lwjgl.system.linux.XCreateWindowEvent;
import org.lwjgl.system.linux.XCrossingEvent;
import org.lwjgl.system.linux.XDestroyWindowEvent;
import org.lwjgl.system.linux.XErrorEvent;
import org.lwjgl.system.linux.XExposeEvent;
import org.lwjgl.system.linux.XFocusChangeEvent;
import org.lwjgl.system.linux.XGenericEvent;
import org.lwjgl.system.linux.XGenericEventCookie;
import org.lwjgl.system.linux.XGraphicsExposeEvent;
import org.lwjgl.system.linux.XGravityEvent;
import org.lwjgl.system.linux.XKeyEvent;
import org.lwjgl.system.linux.XKeymapEvent;
import org.lwjgl.system.linux.XMapEvent;
import org.lwjgl.system.linux.XMapRequestEvent;
import org.lwjgl.system.linux.XMappingEvent;
import org.lwjgl.system.linux.XMotionEvent;
import org.lwjgl.system.linux.XNoExposeEvent;
import org.lwjgl.system.linux.XPropertyEvent;
import org.lwjgl.system.linux.XReparentEvent;
import org.lwjgl.system.linux.XResizeRequestEvent;
import org.lwjgl.system.linux.XSelectionClearEvent;
import org.lwjgl.system.linux.XSelectionEvent;
import org.lwjgl.system.linux.XSelectionRequestEvent;
import org.lwjgl.system.linux.XUnmapEvent;
import org.lwjgl.system.linux.XVisibilityEvent;

public class XEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int XANY;
    public static final int XKEY;
    public static final int XBUTTON;
    public static final int XMOTION;
    public static final int XCROSSING;
    public static final int XFOCUS;
    public static final int XEXPOSE;
    public static final int XGRAPHICSEXPOSE;
    public static final int XNOEXPOSE;
    public static final int XVISIBILITY;
    public static final int XCREATEWINDOW;
    public static final int XDESTROYWINDOW;
    public static final int XUNMAP;
    public static final int XMAP;
    public static final int XMAPREQUEST;
    public static final int XREPARENT;
    public static final int XCONFIGURE;
    public static final int XGRAVITY;
    public static final int XRESIZEREQUEST;
    public static final int XCONFIGUREREQUEST;
    public static final int XCIRCULATE;
    public static final int XCIRCULATEREQUEST;
    public static final int XPROPERTY;
    public static final int XSELECTIONCLEAR;
    public static final int XSELECTIONREQUEST;
    public static final int XSELECTION;
    public static final int XCOLORMAP;
    public static final int XCLIENT;
    public static final int XMAPPING;
    public static final int XERROR;
    public static final int XKEYMAP;
    public static final int XGENERIC;
    public static final int XCOOKIE;

    public XEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XEvent.ntype(this.address());
    }

    public XAnyEvent xany() {
        return XEvent.nxany(this.address());
    }

    public XKeyEvent xkey() {
        return XEvent.nxkey(this.address());
    }

    public XButtonEvent xbutton() {
        return XEvent.nxbutton(this.address());
    }

    public XMotionEvent xmotion() {
        return XEvent.nxmotion(this.address());
    }

    public XCrossingEvent xcrossing() {
        return XEvent.nxcrossing(this.address());
    }

    public XFocusChangeEvent xfocus() {
        return XEvent.nxfocus(this.address());
    }

    public XExposeEvent xexpose() {
        return XEvent.nxexpose(this.address());
    }

    public XGraphicsExposeEvent xgraphicsexpose() {
        return XEvent.nxgraphicsexpose(this.address());
    }

    public XNoExposeEvent xnoexpose() {
        return XEvent.nxnoexpose(this.address());
    }

    public XVisibilityEvent xvisibility() {
        return XEvent.nxvisibility(this.address());
    }

    public XCreateWindowEvent xcreatewindow() {
        return XEvent.nxcreatewindow(this.address());
    }

    public XDestroyWindowEvent xdestroywindow() {
        return XEvent.nxdestroywindow(this.address());
    }

    public XUnmapEvent xunmap() {
        return XEvent.nxunmap(this.address());
    }

    public XMapEvent xmap() {
        return XEvent.nxmap(this.address());
    }

    public XMapRequestEvent xmaprequest() {
        return XEvent.nxmaprequest(this.address());
    }

    public XReparentEvent xreparent() {
        return XEvent.nxreparent(this.address());
    }

    public XConfigureEvent xconfigure() {
        return XEvent.nxconfigure(this.address());
    }

    public XGravityEvent xgravity() {
        return XEvent.nxgravity(this.address());
    }

    public XResizeRequestEvent xresizerequest() {
        return XEvent.nxresizerequest(this.address());
    }

    public XConfigureRequestEvent xconfigurerequest() {
        return XEvent.nxconfigurerequest(this.address());
    }

    public XCirculateEvent xcirculate() {
        return XEvent.nxcirculate(this.address());
    }

    public XCirculateRequestEvent xcirculaterequest() {
        return XEvent.nxcirculaterequest(this.address());
    }

    public XPropertyEvent xproperty() {
        return XEvent.nxproperty(this.address());
    }

    public XSelectionClearEvent xselectionclear() {
        return XEvent.nxselectionclear(this.address());
    }

    public XSelectionRequestEvent xselectionrequest() {
        return XEvent.nxselectionrequest(this.address());
    }

    public XSelectionEvent xselection() {
        return XEvent.nxselection(this.address());
    }

    public XColormapEvent xcolormap() {
        return XEvent.nxcolormap(this.address());
    }

    public XClientMessageEvent xclient() {
        return XEvent.nxclient(this.address());
    }

    public XMappingEvent xmapping() {
        return XEvent.nxmapping(this.address());
    }

    public XErrorEvent xerror() {
        return XEvent.nxerror(this.address());
    }

    public XKeymapEvent xkeymap() {
        return XEvent.nxkeymap(this.address());
    }

    public XGenericEvent xgeneric() {
        return XEvent.nxgeneric(this.address());
    }

    public XGenericEventCookie xcookie() {
        return XEvent.nxcookie(this.address());
    }

    public static XEvent malloc() {
        return XEvent.wrap(XEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XEvent calloc() {
        return XEvent.wrap(XEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return XEvent.wrap(XEvent.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XEvent create(long l2) {
        return XEvent.wrap(XEvent.class, l2);
    }

    @Nullable
    public static XEvent createSafe(long l2) {
        return l2 == 0L ? null : XEvent.wrap(XEvent.class, l2);
    }

    public static Buffer malloc(int n2) {
        return XEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XEvent.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return XEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = XEvent.__create(n2, SIZEOF);
        return XEvent.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return XEvent.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XEvent.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static XEvent mallocStack() {
        return XEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XEvent callocStack() {
        return XEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XEvent mallocStack(MemoryStack memoryStack) {
        return XEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XEvent callocStack(MemoryStack memoryStack) {
        return XEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return XEvent.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return XEvent.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return XEvent.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return XEvent.calloc(n2, memoryStack);
    }

    public static XEvent malloc(MemoryStack memoryStack) {
        return XEvent.wrap(XEvent.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XEvent calloc(MemoryStack memoryStack) {
        return XEvent.wrap(XEvent.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return XEvent.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return XEvent.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ntype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TYPE);
    }

    public static XAnyEvent nxany(long l2) {
        return XAnyEvent.create(l2 + (long)XANY);
    }

    public static XKeyEvent nxkey(long l2) {
        return XKeyEvent.create(l2 + (long)XKEY);
    }

    public static XButtonEvent nxbutton(long l2) {
        return XButtonEvent.create(l2 + (long)XBUTTON);
    }

    public static XMotionEvent nxmotion(long l2) {
        return XMotionEvent.create(l2 + (long)XMOTION);
    }

    public static XCrossingEvent nxcrossing(long l2) {
        return XCrossingEvent.create(l2 + (long)XCROSSING);
    }

    public static XFocusChangeEvent nxfocus(long l2) {
        return XFocusChangeEvent.create(l2 + (long)XFOCUS);
    }

    public static XExposeEvent nxexpose(long l2) {
        return XExposeEvent.create(l2 + (long)XEXPOSE);
    }

    public static XGraphicsExposeEvent nxgraphicsexpose(long l2) {
        return XGraphicsExposeEvent.create(l2 + (long)XGRAPHICSEXPOSE);
    }

    public static XNoExposeEvent nxnoexpose(long l2) {
        return XNoExposeEvent.create(l2 + (long)XNOEXPOSE);
    }

    public static XVisibilityEvent nxvisibility(long l2) {
        return XVisibilityEvent.create(l2 + (long)XVISIBILITY);
    }

    public static XCreateWindowEvent nxcreatewindow(long l2) {
        return XCreateWindowEvent.create(l2 + (long)XCREATEWINDOW);
    }

    public static XDestroyWindowEvent nxdestroywindow(long l2) {
        return XDestroyWindowEvent.create(l2 + (long)XDESTROYWINDOW);
    }

    public static XUnmapEvent nxunmap(long l2) {
        return XUnmapEvent.create(l2 + (long)XUNMAP);
    }

    public static XMapEvent nxmap(long l2) {
        return XMapEvent.create(l2 + (long)XMAP);
    }

    public static XMapRequestEvent nxmaprequest(long l2) {
        return XMapRequestEvent.create(l2 + (long)XMAPREQUEST);
    }

    public static XReparentEvent nxreparent(long l2) {
        return XReparentEvent.create(l2 + (long)XREPARENT);
    }

    public static XConfigureEvent nxconfigure(long l2) {
        return XConfigureEvent.create(l2 + (long)XCONFIGURE);
    }

    public static XGravityEvent nxgravity(long l2) {
        return XGravityEvent.create(l2 + (long)XGRAVITY);
    }

    public static XResizeRequestEvent nxresizerequest(long l2) {
        return XResizeRequestEvent.create(l2 + (long)XRESIZEREQUEST);
    }

    public static XConfigureRequestEvent nxconfigurerequest(long l2) {
        return XConfigureRequestEvent.create(l2 + (long)XCONFIGUREREQUEST);
    }

    public static XCirculateEvent nxcirculate(long l2) {
        return XCirculateEvent.create(l2 + (long)XCIRCULATE);
    }

    public static XCirculateRequestEvent nxcirculaterequest(long l2) {
        return XCirculateRequestEvent.create(l2 + (long)XCIRCULATEREQUEST);
    }

    public static XPropertyEvent nxproperty(long l2) {
        return XPropertyEvent.create(l2 + (long)XPROPERTY);
    }

    public static XSelectionClearEvent nxselectionclear(long l2) {
        return XSelectionClearEvent.create(l2 + (long)XSELECTIONCLEAR);
    }

    public static XSelectionRequestEvent nxselectionrequest(long l2) {
        return XSelectionRequestEvent.create(l2 + (long)XSELECTIONREQUEST);
    }

    public static XSelectionEvent nxselection(long l2) {
        return XSelectionEvent.create(l2 + (long)XSELECTION);
    }

    public static XColormapEvent nxcolormap(long l2) {
        return XColormapEvent.create(l2 + (long)XCOLORMAP);
    }

    public static XClientMessageEvent nxclient(long l2) {
        return XClientMessageEvent.create(l2 + (long)XCLIENT);
    }

    public static XMappingEvent nxmapping(long l2) {
        return XMappingEvent.create(l2 + (long)XMAPPING);
    }

    public static XErrorEvent nxerror(long l2) {
        return XErrorEvent.create(l2 + (long)XERROR);
    }

    public static XKeymapEvent nxkeymap(long l2) {
        return XKeymapEvent.create(l2 + (long)XKEYMAP);
    }

    public static XGenericEvent nxgeneric(long l2) {
        return XGenericEvent.create(l2 + (long)XGENERIC);
    }

    public static XGenericEventCookie nxcookie(long l2) {
        return XGenericEventCookie.create(l2 + (long)XCOOKIE);
    }

    static {
        Struct.Layout layout = XEvent.__union(XEvent.__member(4), XEvent.__member(XAnyEvent.SIZEOF, XAnyEvent.ALIGNOF), XEvent.__member(XKeyEvent.SIZEOF, XKeyEvent.ALIGNOF), XEvent.__member(XButtonEvent.SIZEOF, XButtonEvent.ALIGNOF), XEvent.__member(XMotionEvent.SIZEOF, XMotionEvent.ALIGNOF), XEvent.__member(XCrossingEvent.SIZEOF, XCrossingEvent.ALIGNOF), XEvent.__member(XFocusChangeEvent.SIZEOF, XFocusChangeEvent.ALIGNOF), XEvent.__member(XExposeEvent.SIZEOF, XExposeEvent.ALIGNOF), XEvent.__member(XGraphicsExposeEvent.SIZEOF, XGraphicsExposeEvent.ALIGNOF), XEvent.__member(XNoExposeEvent.SIZEOF, XNoExposeEvent.ALIGNOF), XEvent.__member(XVisibilityEvent.SIZEOF, XVisibilityEvent.ALIGNOF), XEvent.__member(XCreateWindowEvent.SIZEOF, XCreateWindowEvent.ALIGNOF), XEvent.__member(XDestroyWindowEvent.SIZEOF, XDestroyWindowEvent.ALIGNOF), XEvent.__member(XUnmapEvent.SIZEOF, XUnmapEvent.ALIGNOF), XEvent.__member(XMapEvent.SIZEOF, XMapEvent.ALIGNOF), XEvent.__member(XMapRequestEvent.SIZEOF, XMapRequestEvent.ALIGNOF), XEvent.__member(XReparentEvent.SIZEOF, XReparentEvent.ALIGNOF), XEvent.__member(XConfigureEvent.SIZEOF, XConfigureEvent.ALIGNOF), XEvent.__member(XGravityEvent.SIZEOF, XGravityEvent.ALIGNOF), XEvent.__member(XResizeRequestEvent.SIZEOF, XResizeRequestEvent.ALIGNOF), XEvent.__member(XConfigureRequestEvent.SIZEOF, XConfigureRequestEvent.ALIGNOF), XEvent.__member(XCirculateEvent.SIZEOF, XCirculateEvent.ALIGNOF), XEvent.__member(XCirculateRequestEvent.SIZEOF, XCirculateRequestEvent.ALIGNOF), XEvent.__member(XPropertyEvent.SIZEOF, XPropertyEvent.ALIGNOF), XEvent.__member(XSelectionClearEvent.SIZEOF, XSelectionClearEvent.ALIGNOF), XEvent.__member(XSelectionRequestEvent.SIZEOF, XSelectionRequestEvent.ALIGNOF), XEvent.__member(XSelectionEvent.SIZEOF, XSelectionEvent.ALIGNOF), XEvent.__member(XColormapEvent.SIZEOF, XColormapEvent.ALIGNOF), XEvent.__member(XClientMessageEvent.SIZEOF, XClientMessageEvent.ALIGNOF), XEvent.__member(XMappingEvent.SIZEOF, XMappingEvent.ALIGNOF), XEvent.__member(XErrorEvent.SIZEOF, XErrorEvent.ALIGNOF), XEvent.__member(XKeymapEvent.SIZEOF, XKeymapEvent.ALIGNOF), XEvent.__member(XGenericEvent.SIZEOF, XGenericEvent.ALIGNOF), XEvent.__member(XGenericEventCookie.SIZEOF, XGenericEventCookie.ALIGNOF), XEvent.__padding(24, CLONG_SIZE, true));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        XANY = layout.offsetof(1);
        XKEY = layout.offsetof(2);
        XBUTTON = layout.offsetof(3);
        XMOTION = layout.offsetof(4);
        XCROSSING = layout.offsetof(5);
        XFOCUS = layout.offsetof(6);
        XEXPOSE = layout.offsetof(7);
        XGRAPHICSEXPOSE = layout.offsetof(8);
        XNOEXPOSE = layout.offsetof(9);
        XVISIBILITY = layout.offsetof(10);
        XCREATEWINDOW = layout.offsetof(11);
        XDESTROYWINDOW = layout.offsetof(12);
        XUNMAP = layout.offsetof(13);
        XMAP = layout.offsetof(14);
        XMAPREQUEST = layout.offsetof(15);
        XREPARENT = layout.offsetof(16);
        XCONFIGURE = layout.offsetof(17);
        XGRAVITY = layout.offsetof(18);
        XRESIZEREQUEST = layout.offsetof(19);
        XCONFIGUREREQUEST = layout.offsetof(20);
        XCIRCULATE = layout.offsetof(21);
        XCIRCULATEREQUEST = layout.offsetof(22);
        XPROPERTY = layout.offsetof(23);
        XSELECTIONCLEAR = layout.offsetof(24);
        XSELECTIONREQUEST = layout.offsetof(25);
        XSELECTION = layout.offsetof(26);
        XCOLORMAP = layout.offsetof(27);
        XCLIENT = layout.offsetof(28);
        XMAPPING = layout.offsetof(29);
        XERROR = layout.offsetof(30);
        XKEYMAP = layout.offsetof(31);
        XGENERIC = layout.offsetof(32);
        XCOOKIE = layout.offsetof(33);
    }

    public static class Buffer
    extends StructBuffer<XEvent, Buffer>
    implements NativeResource {
        private static final XEvent ELEMENT_FACTORY = XEvent.create(-1L);

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
        protected XEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XEvent.ntype(this.address());
        }

        public XAnyEvent xany() {
            return XEvent.nxany(this.address());
        }

        public XKeyEvent xkey() {
            return XEvent.nxkey(this.address());
        }

        public XButtonEvent xbutton() {
            return XEvent.nxbutton(this.address());
        }

        public XMotionEvent xmotion() {
            return XEvent.nxmotion(this.address());
        }

        public XCrossingEvent xcrossing() {
            return XEvent.nxcrossing(this.address());
        }

        public XFocusChangeEvent xfocus() {
            return XEvent.nxfocus(this.address());
        }

        public XExposeEvent xexpose() {
            return XEvent.nxexpose(this.address());
        }

        public XGraphicsExposeEvent xgraphicsexpose() {
            return XEvent.nxgraphicsexpose(this.address());
        }

        public XNoExposeEvent xnoexpose() {
            return XEvent.nxnoexpose(this.address());
        }

        public XVisibilityEvent xvisibility() {
            return XEvent.nxvisibility(this.address());
        }

        public XCreateWindowEvent xcreatewindow() {
            return XEvent.nxcreatewindow(this.address());
        }

        public XDestroyWindowEvent xdestroywindow() {
            return XEvent.nxdestroywindow(this.address());
        }

        public XUnmapEvent xunmap() {
            return XEvent.nxunmap(this.address());
        }

        public XMapEvent xmap() {
            return XEvent.nxmap(this.address());
        }

        public XMapRequestEvent xmaprequest() {
            return XEvent.nxmaprequest(this.address());
        }

        public XReparentEvent xreparent() {
            return XEvent.nxreparent(this.address());
        }

        public XConfigureEvent xconfigure() {
            return XEvent.nxconfigure(this.address());
        }

        public XGravityEvent xgravity() {
            return XEvent.nxgravity(this.address());
        }

        public XResizeRequestEvent xresizerequest() {
            return XEvent.nxresizerequest(this.address());
        }

        public XConfigureRequestEvent xconfigurerequest() {
            return XEvent.nxconfigurerequest(this.address());
        }

        public XCirculateEvent xcirculate() {
            return XEvent.nxcirculate(this.address());
        }

        public XCirculateRequestEvent xcirculaterequest() {
            return XEvent.nxcirculaterequest(this.address());
        }

        public XPropertyEvent xproperty() {
            return XEvent.nxproperty(this.address());
        }

        public XSelectionClearEvent xselectionclear() {
            return XEvent.nxselectionclear(this.address());
        }

        public XSelectionRequestEvent xselectionrequest() {
            return XEvent.nxselectionrequest(this.address());
        }

        public XSelectionEvent xselection() {
            return XEvent.nxselection(this.address());
        }

        public XColormapEvent xcolormap() {
            return XEvent.nxcolormap(this.address());
        }

        public XClientMessageEvent xclient() {
            return XEvent.nxclient(this.address());
        }

        public XMappingEvent xmapping() {
            return XEvent.nxmapping(this.address());
        }

        public XErrorEvent xerror() {
            return XEvent.nxerror(this.address());
        }

        public XKeymapEvent xkeymap() {
            return XEvent.nxkeymap(this.address());
        }

        public XGenericEvent xgeneric() {
            return XEvent.nxgeneric(this.address());
        }

        public XGenericEventCookie xcookie() {
            return XEvent.nxcookie(this.address());
        }
    }
}

