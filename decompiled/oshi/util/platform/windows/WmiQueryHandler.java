/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.windows;

import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.WinNT;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.GlobalConfig;
import oshi.util.platform.windows.WmiUtil;

@ThreadSafe
public class WmiQueryHandler {
    private static final Logger LOG = LoggerFactory.getLogger(WmiQueryHandler.class);
    private static int globalTimeout = GlobalConfig.get("oshi.util.wmi.timeout", -1);
    protected int wmiTimeout = globalTimeout;
    protected final Set<String> failedWmiClassNames = new HashSet<String>();
    private int comThreading = 0;
    private boolean securityInitialized = false;
    private static final Class<?>[] EMPTY_CLASS_ARRAY;
    private static final Object[] EMPTY_OBJECT_ARRAY;
    private static Class<? extends WmiQueryHandler> customClass;

    public static synchronized WmiQueryHandler createInstance() {
        if (customClass == null) {
            return new WmiQueryHandler();
        }
        try {
            return customClass.getConstructor(EMPTY_CLASS_ARRAY).newInstance(EMPTY_OBJECT_ARRAY);
        }
        catch (NoSuchMethodException | SecurityException exception) {
            LOG.error("Failed to find or access a no-arg constructor for {}", (Object)customClass);
        }
        catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException exception) {
            LOG.error("Failed to create a new instance of {}", (Object)customClass);
        }
        return null;
    }

    public static synchronized void setInstanceClass(Class<? extends WmiQueryHandler> clazz) {
        customClass = clazz;
    }

    public <T extends Enum<T>> WbemcliUtil.WmiResult<T> queryWMI(WbemcliUtil.WmiQuery<T> wmiQuery) {
        return this.queryWMI(wmiQuery, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T extends Enum<T>> WbemcliUtil.WmiResult<T> queryWMI(WbemcliUtil.WmiQuery<T> wmiQuery, boolean bl2) {
        WbemcliUtil wbemcliUtil = WbemcliUtil.INSTANCE;
        Objects.requireNonNull(wbemcliUtil);
        WbemcliUtil.WmiResult<T> wmiResult = wbemcliUtil.new WbemcliUtil.WmiResult<T>(wmiQuery.getPropertyEnum());
        if (this.failedWmiClassNames.contains(wmiQuery.getWmiClassName())) {
            return wmiResult;
        }
        boolean bl3 = false;
        try {
            if (bl2) {
                bl3 = this.initCOM();
            }
            wmiResult = wmiQuery.execute(this.wmiTimeout);
        }
        catch (COMException cOMException) {
            if (!"ROOT\\OpenHardwareMonitor".equals(wmiQuery.getNameSpace())) {
                int n2 = cOMException.getHresult() == null ? -1 : cOMException.getHresult().intValue();
                switch (n2) {
                    case -2147217394: {
                        LOG.warn("COM exception: Invalid Namespace {}", (Object)wmiQuery.getNameSpace());
                        break;
                    }
                    case -2147217392: {
                        LOG.warn("COM exception: Invalid Class {}", (Object)wmiQuery.getWmiClassName());
                        break;
                    }
                    case -2147217385: {
                        LOG.warn("COM exception: Invalid Query: {}", (Object)WmiUtil.queryToString(wmiQuery));
                        break;
                    }
                    default: {
                        this.handleComException(wmiQuery, cOMException);
                    }
                }
                this.failedWmiClassNames.add(wmiQuery.getWmiClassName());
            }
        }
        catch (TimeoutException timeoutException) {
            LOG.warn("WMI query timed out after {} ms: {}", (Object)this.wmiTimeout, (Object)WmiUtil.queryToString(wmiQuery));
        }
        finally {
            if (bl3) {
                this.unInitCOM();
            }
        }
        return wmiResult;
    }

    protected void handleComException(WbemcliUtil.WmiQuery<?> wmiQuery, COMException cOMException) {
        LOG.warn("COM exception querying {}, which might not be on your system. Will not attempt to query it again. Error was {}: {}", wmiQuery.getWmiClassName(), cOMException.getHresult() == null ? null : Integer.valueOf(cOMException.getHresult().intValue()), cOMException.getMessage());
    }

    public boolean initCOM() {
        boolean bl2 = false;
        bl2 = this.initCOM(this.getComThreading());
        if (!bl2) {
            bl2 = this.initCOM(this.switchComThreading());
        }
        if (bl2 && !this.isSecurityInitialized()) {
            WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeSecurity(null, -1, null, null, 0, 3, null, 0, null);
            if (COMUtils.FAILED(hRESULT) && hRESULT.intValue() != -2147417831) {
                Ole32.INSTANCE.CoUninitialize();
                throw new COMException("Failed to initialize security.", hRESULT);
            }
            this.securityInitialized = true;
        }
        return bl2;
    }

    protected boolean initCOM(int n2) {
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeEx(null, n2);
        switch (hRESULT.intValue()) {
            case 0: 
            case 1: {
                return true;
            }
            case -2147417850: {
                return false;
            }
        }
        throw new COMException("Failed to initialize COM library.", hRESULT);
    }

    public void unInitCOM() {
        Ole32.INSTANCE.CoUninitialize();
    }

    public int getComThreading() {
        return this.comThreading;
    }

    public int switchComThreading() {
        this.comThreading = this.comThreading == 2 ? 0 : 2;
        return this.comThreading;
    }

    public boolean isSecurityInitialized() {
        return this.securityInitialized;
    }

    public int getWmiTimeout() {
        return this.wmiTimeout;
    }

    public void setWmiTimeout(int n2) {
        this.wmiTimeout = n2;
    }

    static {
        if (globalTimeout == 0 || globalTimeout < -1) {
            throw new GlobalConfig.PropertyException("oshi.util.wmi.timeout");
        }
        EMPTY_CLASS_ARRAY = new Class[0];
        EMPTY_OBJECT_ARRAY = new Object[0];
        customClass = null;
    }
}

