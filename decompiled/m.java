/*
 * Decompiled with CFR 0.152.
 */
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class m {
    public static String a() {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
        CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();
        ComputerSystem computerSystem = hardwareAbstractionLayer.getComputerSystem();
        String string = operatingSystem.getManufacturer();
        String string2 = computerSystem.getSerialNumber() + "#" + computerSystem.getHardwareUUID() + "#" + computerSystem.getManufacturer() + "#" + computerSystem.getModel();
        String string3 = centralProcessor.getProcessorIdentifier().getIdentifier();
        String string4 = "";
        for (GraphicsCard object2 : hardwareAbstractionLayer.getGraphicsCards()) {
            string4 = string4 + object2.getName() + "#" + object2.getDeviceId() + "#" + object2.getVendor() + "#" + object2.getVersionInfo();
        }
        int n2 = centralProcessor.getLogicalProcessorCount();
        String string5 = "#";
        return string + string5 + string2 + string5 + string3 + string5 + n2 + string5 + string4;
    }
}

