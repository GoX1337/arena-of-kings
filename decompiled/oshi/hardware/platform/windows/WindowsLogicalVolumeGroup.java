/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.VersionHelpers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.driver.windows.wmi.MSFTStorage;
import oshi.hardware.LogicalVolumeGroup;
import oshi.hardware.common.AbstractLogicalVolumeGroup;
import oshi.util.ParseUtil;
import oshi.util.platform.windows.WmiQueryHandler;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

final class WindowsLogicalVolumeGroup
extends AbstractLogicalVolumeGroup {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsLogicalVolumeGroup.class);
    private static final Pattern SP_OBJECT_ID = Pattern.compile(".*ObjectId=.*SP:(\\{.*\\}).*");
    private static final Pattern PD_OBJECT_ID = Pattern.compile(".*ObjectId=.*PD:(\\{.*\\}).*");
    private static final Pattern VD_OBJECT_ID = Pattern.compile(".*ObjectId=.*VD:(\\{.*\\})(\\{.*\\}).*");
    private static final boolean IS_WINDOWS8_OR_GREATER = VersionHelpers.IsWindows8OrGreater();

    WindowsLogicalVolumeGroup(String string, Map<String, Set<String>> map, Set<String> set) {
        super(string, map, set);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static List<LogicalVolumeGroup> getLogicalVolumeGroups() {
        if (!IS_WINDOWS8_OR_GREATER) {
            return Collections.emptyList();
        }
        WmiQueryHandler wmiQueryHandler = Objects.requireNonNull(WmiQueryHandler.createInstance());
        boolean bl2 = false;
        try {
            String string;
            Object object;
            Object object2;
            Object object3;
            bl2 = wmiQueryHandler.initCOM();
            WbemcliUtil.WmiResult<MSFTStorage.StoragePoolProperty> wmiResult = MSFTStorage.queryStoragePools(wmiQueryHandler);
            int n2 = wmiResult.getResultCount();
            if (n2 == 0) {
                List<LogicalVolumeGroup> list = Collections.emptyList();
                return list;
            }
            HashMap<Object, String> hashMap = new HashMap<Object, String>();
            WbemcliUtil.WmiResult<MSFTStorage.VirtualDiskProperty> wmiResult2 = MSFTStorage.queryVirtualDisks(wmiQueryHandler);
            n2 = wmiResult2.getResultCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                object3 = WmiUtil.getString(wmiResult2, MSFTStorage.VirtualDiskProperty.OBJECTID, i2);
                Matcher matcher = VD_OBJECT_ID.matcher((CharSequence)object3);
                if (matcher.matches()) {
                    object3 = matcher.group(2) + " " + matcher.group(1);
                }
                hashMap.put(object3, WmiUtil.getString(wmiResult2, MSFTStorage.VirtualDiskProperty.FRIENDLYNAME, i2));
            }
            HashMap<Object, Pair<String, String>> hashMap2 = new HashMap<Object, Pair<String, String>>();
            object3 = MSFTStorage.queryPhysicalDisks(wmiQueryHandler);
            n2 = ((WbemcliUtil.WmiResult)object3).getResultCount();
            for (int i3 = 0; i3 < n2; ++i3) {
                object2 = WmiUtil.getString(object3, MSFTStorage.PhysicalDiskProperty.OBJECTID, i3);
                Matcher matcher = PD_OBJECT_ID.matcher((CharSequence)object2);
                if (matcher.matches()) {
                    object2 = matcher.group(1);
                }
                hashMap2.put(object2, new Pair<String, String>(WmiUtil.getString(object3, MSFTStorage.PhysicalDiskProperty.FRIENDLYNAME, i3), WmiUtil.getString(object3, MSFTStorage.PhysicalDiskProperty.PHYSICALLOCATION, i3)));
            }
            HashMap<String, String> hashMap3 = new HashMap<String, String>();
            object2 = MSFTStorage.queryStoragePoolPhysicalDisks(wmiQueryHandler);
            n2 = ((WbemcliUtil.WmiResult)object2).getResultCount();
            for (int i4 = 0; i4 < n2; ++i4) {
                String string2 = WmiUtil.getRefString(object2, MSFTStorage.StoragePoolToPhysicalDiskProperty.STORAGEPOOL, i4);
                object = SP_OBJECT_ID.matcher(string2);
                if (((Matcher)object).matches()) {
                    string2 = ((Matcher)object).group(1);
                }
                if (((Matcher)(object = PD_OBJECT_ID.matcher(string = WmiUtil.getRefString(object2, MSFTStorage.StoragePoolToPhysicalDiskProperty.PHYSICALDISK, i4)))).matches()) {
                    string = ((Matcher)object).group(1);
                }
                hashMap3.put(string2 + " " + string, string);
            }
            ArrayList<LogicalVolumeGroup> arrayList = new ArrayList<LogicalVolumeGroup>();
            n2 = wmiResult.getResultCount();
            for (int i5 = 0; i5 < n2; ++i5) {
                Object object4;
                Object object5;
                Map.Entry entry2;
                object = WmiUtil.getString(wmiResult, MSFTStorage.StoragePoolProperty.FRIENDLYNAME, i5);
                string = WmiUtil.getString(wmiResult, MSFTStorage.StoragePoolProperty.OBJECTID, i5);
                Matcher matcher = SP_OBJECT_ID.matcher(string);
                if (matcher.matches()) {
                    string = matcher.group(1);
                }
                HashSet<String> hashSet = new HashSet<String>();
                for (Map.Entry entry2 : hashMap3.entrySet()) {
                    if (!((String)entry2.getKey()).contains(string) || (object5 = (Pair)hashMap2.get(object4 = (String)entry2.getValue())) == null) continue;
                    hashSet.add((String)((Pair)object5).getA() + " @ " + (String)((Pair)object5).getB());
                }
                HashMap hashMap4 = new HashMap();
                entry2 = hashMap.entrySet().iterator();
                while (entry2.hasNext()) {
                    object4 = (Map.Entry)entry2.next();
                    if (!((String)object4.getKey()).contains(string)) continue;
                    object5 = ParseUtil.whitespaces.split((CharSequence)object4.getKey())[0];
                    hashMap4.put((String)object4.getValue() + " " + (String)object5, hashSet);
                }
                arrayList.add(new WindowsLogicalVolumeGroup((String)object, hashMap4, hashSet));
            }
            ArrayList<LogicalVolumeGroup> arrayList2 = arrayList;
            return arrayList2;
        }
        catch (COMException cOMException) {
            LOG.warn("COM exception: {}", (Object)cOMException.getMessage());
            List<LogicalVolumeGroup> list = Collections.emptyList();
            return list;
        }
        finally {
            if (bl2) {
                wmiQueryHandler.unInitCOM();
            }
        }
    }
}

