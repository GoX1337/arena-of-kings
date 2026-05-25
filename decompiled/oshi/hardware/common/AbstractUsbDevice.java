/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import java.util.Collections;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.UsbDevice;

@Immutable
public abstract class AbstractUsbDevice
implements UsbDevice {
    private final String name;
    private final String vendor;
    private final String vendorId;
    private final String productId;
    private final String serialNumber;
    private final String uniqueDeviceId;
    private final List<UsbDevice> connectedDevices;

    public AbstractUsbDevice(String string, String string2, String string3, String string4, String string5, String string6, List<UsbDevice> list) {
        this.name = string;
        this.vendor = string2;
        this.vendorId = string3;
        this.productId = string4;
        this.serialNumber = string5;
        this.uniqueDeviceId = string6;
        this.connectedDevices = Collections.unmodifiableList(list);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getVendor() {
        return this.vendor;
    }

    @Override
    public String getVendorId() {
        return this.vendorId;
    }

    @Override
    public String getProductId() {
        return this.productId;
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public String getUniqueDeviceId() {
        return this.uniqueDeviceId;
    }

    @Override
    public List<UsbDevice> getConnectedDevices() {
        return this.connectedDevices;
    }

    @Override
    public int compareTo(UsbDevice usbDevice) {
        return this.getName().compareTo(usbDevice.getName());
    }

    public String toString() {
        return AbstractUsbDevice.indentUsb(this, 1);
    }

    private static String indentUsb(UsbDevice usbDevice, int n2) {
        String string = n2 > 4 ? String.format("%%%ds|-- ", n2 - 4) : String.format("%%%ds", n2);
        StringBuilder stringBuilder = new StringBuilder(String.format(string, ""));
        stringBuilder.append(usbDevice.getName());
        if (!usbDevice.getVendor().isEmpty()) {
            stringBuilder.append(" (").append(usbDevice.getVendor()).append(')');
        }
        if (!usbDevice.getSerialNumber().isEmpty()) {
            stringBuilder.append(" [s/n: ").append(usbDevice.getSerialNumber()).append(']');
        }
        for (UsbDevice usbDevice2 : usbDevice.getConnectedDevices()) {
            stringBuilder.append('\n').append(AbstractUsbDevice.indentUsb(usbDevice2, n2 + 4));
        }
        return stringBuilder.toString();
    }
}

