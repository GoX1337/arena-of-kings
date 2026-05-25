/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.Display;
import oshi.hardware.common.AbstractDisplay;

@Immutable
final class MacDisplay
extends AbstractDisplay {
    private static final Logger LOG = LoggerFactory.getLogger(MacDisplay.class);

    MacDisplay(byte[] byArray) {
        super(byArray);
        LOG.debug("Initialized MacDisplay");
    }

    public static List<Display> getDisplays() {
        ArrayList<Display> arrayList = new ArrayList<Display>();
        IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices("IODisplayConnect");
        if (iOIterator != null) {
            CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("IODisplayEDID");
            IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
            while (iORegistryEntry != null) {
                IOKit.IORegistryEntry iORegistryEntry2 = iORegistryEntry.getChildEntry("IOService");
                if (iORegistryEntry2 != null) {
                    CoreFoundation.CFTypeRef cFTypeRef = iORegistryEntry2.createCFProperty(cFStringRef);
                    if (cFTypeRef != null) {
                        CoreFoundation.CFDataRef cFDataRef = new CoreFoundation.CFDataRef(cFTypeRef.getPointer());
                        int n2 = cFDataRef.getLength();
                        Pointer pointer = cFDataRef.getBytePtr();
                        arrayList.add(new MacDisplay(pointer.getByteArray(0L, n2)));
                        cFDataRef.release();
                    }
                    iORegistryEntry2.release();
                }
                iORegistryEntry.release();
                iORegistryEntry = iOIterator.next();
            }
            iOIterator.release();
            cFStringRef.release();
        }
        return arrayList;
    }
}

