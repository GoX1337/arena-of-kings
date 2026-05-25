/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.DsGetDC;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.LMAccess;
import com.sun.jna.platform.win32.Netapi32;
import com.sun.jna.platform.win32.Ole32Util;
import com.sun.jna.platform.win32.Secur32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;

public abstract class Netapi32Util {
    public static String getDCName() {
        return Netapi32Util.getDCName(null, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String getDCName(String string, String string2) {
        PointerByReference pointerByReference = new PointerByReference();
        try {
            int n2 = Netapi32.INSTANCE.NetGetDCName(string2, string, pointerByReference);
            if (0 != n2) {
                throw new Win32Exception(n2);
            }
            String string3 = pointerByReference.getValue().getWideString(0L);
            return string3;
        }
        finally {
            if (0 != Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
        }
    }

    public static int getJoinStatus() {
        return Netapi32Util.getJoinStatus(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int getJoinStatus(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int n2 = Netapi32.INSTANCE.NetGetJoinInformation(string, pointerByReference, intByReference);
            if (0 != n2) {
                throw new Win32Exception(n2);
            }
            int n3 = intByReference.getValue();
            return n3;
        }
        finally {
            int n4;
            if (pointerByReference.getPointer() != null && 0 != (n4 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String getDomainName(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int n2 = Netapi32.INSTANCE.NetGetJoinInformation(string, pointerByReference, intByReference);
            if (0 != n2) {
                throw new Win32Exception(n2);
            }
            String string2 = pointerByReference.getValue().getWideString(0L);
            return string2;
        }
        finally {
            int n3;
            if (pointerByReference.getPointer() != null && 0 != (n3 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static LocalGroup[] getLocalGroups() {
        return Netapi32Util.getLocalGroups(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static LocalGroup[] getLocalGroups(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        try {
            LocalGroup[] localGroupArray;
            int n2 = Netapi32.INSTANCE.NetLocalGroupEnum(string, 1, pointerByReference, -1, intByReference, intByReference2, null);
            if (0 != n2 || pointerByReference.getValue() == Pointer.NULL) {
                throw new Win32Exception(n2);
            }
            ArrayList<LocalGroup> arrayList = new ArrayList<LocalGroup>();
            if (intByReference.getValue() > 0) {
                LMAccess.LOCALGROUP_INFO_1[] lOCALGROUP_INFO_1Array;
                localGroupArray = new LMAccess.LOCALGROUP_INFO_1(pointerByReference.getValue());
                for (LMAccess.LOCALGROUP_INFO_1 lOCALGROUP_INFO_1 : lOCALGROUP_INFO_1Array = (LMAccess.LOCALGROUP_INFO_1[])localGroupArray.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    LocalGroup localGroup = new LocalGroup();
                    localGroup.name = lOCALGROUP_INFO_1.lgrui1_name;
                    localGroup.comment = lOCALGROUP_INFO_1.lgrui1_comment;
                    arrayList.add(localGroup);
                }
            }
            localGroupArray = arrayList.toArray(new LocalGroup[0]);
            return localGroupArray;
        }
        finally {
            int n3;
            if (pointerByReference.getValue() != Pointer.NULL && 0 != (n3 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static Group[] getGlobalGroups() {
        return Netapi32Util.getGlobalGroups(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Group[] getGlobalGroups(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        try {
            Group[] groupArray;
            int n2 = Netapi32.INSTANCE.NetGroupEnum(string, 1, pointerByReference, -1, intByReference, intByReference2, null);
            if (0 != n2 || pointerByReference.getValue() == Pointer.NULL) {
                throw new Win32Exception(n2);
            }
            ArrayList<LocalGroup> arrayList = new ArrayList<LocalGroup>();
            if (intByReference.getValue() > 0) {
                LMAccess.GROUP_INFO_1[] gROUP_INFO_1Array;
                groupArray = new LMAccess.GROUP_INFO_1(pointerByReference.getValue());
                for (LMAccess.GROUP_INFO_1 gROUP_INFO_1 : gROUP_INFO_1Array = (LMAccess.GROUP_INFO_1[])groupArray.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    LocalGroup localGroup = new LocalGroup();
                    localGroup.name = gROUP_INFO_1.grpi1_name;
                    localGroup.comment = gROUP_INFO_1.grpi1_comment;
                    arrayList.add(localGroup);
                }
            }
            groupArray = arrayList.toArray(new LocalGroup[0]);
            return groupArray;
        }
        finally {
            int n3;
            if (pointerByReference.getValue() != Pointer.NULL && 0 != (n3 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static User[] getUsers() {
        return Netapi32Util.getUsers(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static User[] getUsers(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        try {
            User[] userArray;
            int n2 = Netapi32.INSTANCE.NetUserEnum(string, 1, 0, pointerByReference, -1, intByReference, intByReference2, null);
            if (0 != n2 || pointerByReference.getValue() == Pointer.NULL) {
                throw new Win32Exception(n2);
            }
            ArrayList<User> arrayList = new ArrayList<User>();
            if (intByReference.getValue() > 0) {
                LMAccess.USER_INFO_1[] uSER_INFO_1Array;
                userArray = new LMAccess.USER_INFO_1(pointerByReference.getValue());
                for (LMAccess.USER_INFO_1 uSER_INFO_1 : uSER_INFO_1Array = (LMAccess.USER_INFO_1[])userArray.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    User user = new User();
                    if (uSER_INFO_1.usri1_name != null) {
                        user.name = uSER_INFO_1.usri1_name;
                    }
                    arrayList.add(user);
                }
            }
            userArray = arrayList.toArray(new User[0]);
            return userArray;
        }
        finally {
            int n3;
            if (pointerByReference.getValue() != Pointer.NULL && 0 != (n3 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static Group[] getCurrentUserLocalGroups() {
        return Netapi32Util.getUserLocalGroups(Secur32Util.getUserNameEx(2));
    }

    public static Group[] getUserLocalGroups(String string) {
        return Netapi32Util.getUserLocalGroups(string, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Group[] getUserLocalGroups(String string, String string2) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        try {
            Group[] groupArray;
            int n2 = Netapi32.INSTANCE.NetUserGetLocalGroups(string2, string, 0, 0, pointerByReference, -1, intByReference, intByReference2);
            if (n2 != 0) {
                throw new Win32Exception(n2);
            }
            ArrayList<LocalGroup> arrayList = new ArrayList<LocalGroup>();
            if (intByReference.getValue() > 0) {
                LMAccess.LOCALGROUP_USERS_INFO_0[] lOCALGROUP_USERS_INFO_0Array;
                groupArray = new LMAccess.LOCALGROUP_USERS_INFO_0(pointerByReference.getValue());
                for (LMAccess.LOCALGROUP_USERS_INFO_0 lOCALGROUP_USERS_INFO_0 : lOCALGROUP_USERS_INFO_0Array = (LMAccess.LOCALGROUP_USERS_INFO_0[])groupArray.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    LocalGroup localGroup = new LocalGroup();
                    if (lOCALGROUP_USERS_INFO_0.lgrui0_name != null) {
                        localGroup.name = lOCALGROUP_USERS_INFO_0.lgrui0_name;
                    }
                    arrayList.add(localGroup);
                }
            }
            groupArray = arrayList.toArray(new Group[0]);
            return groupArray;
        }
        finally {
            int n3;
            if (pointerByReference.getValue() != Pointer.NULL && 0 != (n3 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static Group[] getUserGroups(String string) {
        return Netapi32Util.getUserGroups(string, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Group[] getUserGroups(String string, String string2) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        try {
            Group[] groupArray;
            int n2 = Netapi32.INSTANCE.NetUserGetGroups(string2, string, 0, pointerByReference, -1, intByReference, intByReference2);
            if (n2 != 0) {
                throw new Win32Exception(n2);
            }
            ArrayList<Group> arrayList = new ArrayList<Group>();
            if (intByReference.getValue() > 0) {
                LMAccess.GROUP_USERS_INFO_0[] gROUP_USERS_INFO_0Array;
                groupArray = new LMAccess.GROUP_USERS_INFO_0(pointerByReference.getValue());
                for (LMAccess.GROUP_USERS_INFO_0 gROUP_USERS_INFO_0 : gROUP_USERS_INFO_0Array = (LMAccess.GROUP_USERS_INFO_0[])groupArray.com_sun_jna_Structure_arr_toArray(intByReference.getValue())) {
                    Group group = new Group();
                    if (gROUP_USERS_INFO_0.grui0_name != null) {
                        group.name = gROUP_USERS_INFO_0.grui0_name;
                    }
                    arrayList.add(group);
                }
            }
            groupArray = arrayList.toArray(new Group[0]);
            return groupArray;
        }
        finally {
            int n3;
            if (pointerByReference.getValue() != Pointer.NULL && 0 != (n3 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()))) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static DomainController getDC() {
        DsGetDC.PDOMAIN_CONTROLLER_INFO pDOMAIN_CONTROLLER_INFO = new DsGetDC.PDOMAIN_CONTROLLER_INFO();
        int n2 = Netapi32.INSTANCE.DsGetDcName(null, null, null, null, 0, pDOMAIN_CONTROLLER_INFO);
        if (0 != n2) {
            throw new Win32Exception(n2);
        }
        DomainController domainController = new DomainController();
        domainController.address = pDOMAIN_CONTROLLER_INFO.dci.DomainControllerAddress;
        domainController.addressType = pDOMAIN_CONTROLLER_INFO.dci.DomainControllerAddressType;
        domainController.clientSiteName = pDOMAIN_CONTROLLER_INFO.dci.ClientSiteName;
        domainController.dnsForestName = pDOMAIN_CONTROLLER_INFO.dci.DnsForestName;
        domainController.domainGuid = pDOMAIN_CONTROLLER_INFO.dci.DomainGuid;
        domainController.domainName = pDOMAIN_CONTROLLER_INFO.dci.DomainName;
        domainController.flags = pDOMAIN_CONTROLLER_INFO.dci.Flags;
        domainController.name = pDOMAIN_CONTROLLER_INFO.dci.DomainControllerName;
        n2 = Netapi32.INSTANCE.NetApiBufferFree(pDOMAIN_CONTROLLER_INFO.dci.getPointer());
        if (0 != n2) {
            throw new Win32Exception(n2);
        }
        return domainController;
    }

    public static DomainTrust[] getDomainTrusts() {
        return Netapi32Util.getDomainTrusts(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static DomainTrust[] getDomainTrusts(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        int n2 = Netapi32.INSTANCE.DsEnumerateDomainTrusts(string, 63, pointerByReference, intByReference);
        if (0 != n2) {
            throw new Win32Exception(n2);
        }
        try {
            DomainTrust[] domainTrustArray;
            ArrayList<DomainTrust> arrayList = new ArrayList<DomainTrust>(intByReference.getValue());
            if (intByReference.getValue() > 0) {
                DsGetDC.DS_DOMAIN_TRUSTS[] dS_DOMAIN_TRUSTSArray;
                domainTrustArray = new DsGetDC.DS_DOMAIN_TRUSTS(pointerByReference.getValue());
                for (DsGetDC.DS_DOMAIN_TRUSTS dS_DOMAIN_TRUSTS : dS_DOMAIN_TRUSTSArray = (DsGetDC.DS_DOMAIN_TRUSTS[])domainTrustArray.toArray(new DsGetDC.DS_DOMAIN_TRUSTS[intByReference.getValue()])) {
                    DomainTrust domainTrust = new DomainTrust();
                    if (dS_DOMAIN_TRUSTS.DnsDomainName != null) {
                        domainTrust.DnsDomainName = dS_DOMAIN_TRUSTS.DnsDomainName;
                    }
                    if (dS_DOMAIN_TRUSTS.NetbiosDomainName != null) {
                        domainTrust.NetbiosDomainName = dS_DOMAIN_TRUSTS.NetbiosDomainName;
                    }
                    domainTrust.DomainSid = dS_DOMAIN_TRUSTS.DomainSid;
                    if (dS_DOMAIN_TRUSTS.DomainSid != null) {
                        domainTrust.DomainSidString = Advapi32Util.convertSidToStringSid(dS_DOMAIN_TRUSTS.DomainSid);
                    }
                    domainTrust.DomainGuid = dS_DOMAIN_TRUSTS.DomainGuid;
                    if (dS_DOMAIN_TRUSTS.DomainGuid != null) {
                        domainTrust.DomainGuidString = Ole32Util.getStringFromGUID(dS_DOMAIN_TRUSTS.DomainGuid);
                    }
                    domainTrust.flags = dS_DOMAIN_TRUSTS.Flags;
                    arrayList.add(domainTrust);
                }
            }
            domainTrustArray = arrayList.toArray(new DomainTrust[0]);
            return domainTrustArray;
        }
        finally {
            n2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
            if (0 != n2) {
                throw new Win32Exception(n2);
            }
        }
    }

    public static UserInfo getUserInfo(String string) {
        return Netapi32Util.getUserInfo(string, Netapi32Util.getDCName());
    }

    public static UserInfo getUserInfo(String string, String string2) {
        PointerByReference pointerByReference = new PointerByReference();
        try {
            int n2 = Netapi32.INSTANCE.NetUserGetInfo(string2, string, 23, pointerByReference);
            if (n2 == 0) {
                LMAccess.USER_INFO_23 uSER_INFO_23 = new LMAccess.USER_INFO_23(pointerByReference.getValue());
                UserInfo userInfo = new UserInfo();
                userInfo.comment = uSER_INFO_23.usri23_comment;
                userInfo.flags = uSER_INFO_23.usri23_flags;
                userInfo.fullName = uSER_INFO_23.usri23_full_name;
                userInfo.name = uSER_INFO_23.usri23_name;
                if (uSER_INFO_23.usri23_user_sid != null) {
                    userInfo.sidString = Advapi32Util.convertSidToStringSid(uSER_INFO_23.usri23_user_sid);
                }
                userInfo.sid = uSER_INFO_23.usri23_user_sid;
                UserInfo userInfo2 = userInfo;
                return userInfo2;
            }
            throw new Win32Exception(n2);
        }
        finally {
            if (pointerByReference.getValue() != Pointer.NULL) {
                Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
            }
        }
    }

    public static class DomainTrust {
        public String NetbiosDomainName;
        public String DnsDomainName;
        public WinNT.PSID DomainSid;
        public String DomainSidString;
        public Guid.GUID DomainGuid;
        public String DomainGuidString;
        private int flags;

        public boolean isInForest() {
            return (this.flags & 1) != 0;
        }

        public boolean isOutbound() {
            return (this.flags & 2) != 0;
        }

        public boolean isRoot() {
            return (this.flags & 4) != 0;
        }

        public boolean isPrimary() {
            return (this.flags & 8) != 0;
        }

        public boolean isNativeMode() {
            return (this.flags & 0x10) != 0;
        }

        public boolean isInbound() {
            return (this.flags & 0x20) != 0;
        }
    }

    public static class DomainController {
        public String name;
        public String address;
        public int addressType;
        public Guid.GUID domainGuid;
        public String domainName;
        public String dnsForestName;
        public int flags;
        public String clientSiteName;
    }

    public static class LocalGroup
    extends Group {
        public String comment;
    }

    public static class UserInfo
    extends User {
        public String fullName;
        public String sidString;
        public WinNT.PSID sid;
        public int flags;
    }

    public static class User {
        public String name;
        public String comment;
    }

    public static class Group {
        public String name;
    }
}

